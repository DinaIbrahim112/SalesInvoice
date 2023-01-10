package app.model;

import app.controller.Controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Dina.Ibrahim
 */
public class FileOperations {

    public ArrayList<InvoiceLine> invoiceLines;
    public ArrayList<InvoiceHeader> invoiceHeaders;

    public FileOperations() {
        this.invoiceLines = new ArrayList<InvoiceLine>();
        this.invoiceHeaders = new ArrayList<InvoiceHeader>();
    }

    public void ReadFile(String invoiceHeaderFilePath, String itemsHeaderFilePath) {

        try {
            if (invoiceHeaderFilePath != null && itemsHeaderFilePath != null && !invoiceHeaderFilePath.isEmpty() && !itemsHeaderFilePath.isEmpty()) {

                File invoiceHeader = new File(invoiceHeaderFilePath);
                File itemsHeader = new File(itemsHeaderFilePath);
                if (invoiceHeader.exists() && itemsHeader.exists()) {
                    if (invoiceHeaderFilePath.contains(".csv") && itemsHeaderFilePath.contains(".csv")) {
                        List<String> headerLinesList = Files.lines(Paths.get(invoiceHeader.getAbsolutePath())).collect(Collectors.toList());
                        List<String> itemLinesList = Files.lines(Paths.get(itemsHeader.getAbsolutePath())).collect(Collectors.toList());

                        invoiceHeaders.clear();
                        invoiceLines.clear();

                        // ex : 1 , 12-11-2022 , Ali
                        for (String headerLineList : headerLinesList) {
                            String[] line = headerLineList.split(",");
                            String invoiceNumb = line[0];
                            String invDate = line[1];
                            String invCustName = line[2];
                            int invoiceNumbCast = Integer.parseInt(invoiceNumb);
                            SimpleDateFormat newFormat = new SimpleDateFormat("DD/MM/YYYY");
                            Date invDateCaset=new Date();
                            try {
                                invDateCaset = newFormat.parse(invDate);
                            } catch(ParseException e){
                                System.out.println("Wrong date format");
                            }
                            InvoiceHeader invoice = new InvoiceHeader(invoiceNumbCast, invDateCaset, invCustName);
                            // getInvoicesMethod
                            invoiceHeaders.add(invoice);

                        }

                        // filter items related to the selected invoices
                        for (String itemLineList : itemLinesList) {
                            String[] line = itemLineList.split(",");
                            int invoiceNumber = Integer.parseInt(line[0]);
                            String itemName = line[1];
                            double itemPrice = Double.parseDouble(line[2]);
                            int itemCount = Integer.parseInt(line[3]);
                            //getInvoiceperNumberMethod
                            InvoiceLine items = new InvoiceLine(invoiceNumber, itemName, (int) itemPrice, itemCount);
                            for (InvoiceHeader item : invoiceHeaders) {
                                if (item.getNum() == invoiceNumber) {
                                    item.getItems().add(items);
                                }
                            }
                            invoiceLines.add(items);
                        }
                    } else {
                        System.out.println("Wrong file format");
                    }
                } else {
                    System.out.println("File not found");
                }
            }
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void WriteFile(String invoiceHeaderFilePath, String itemsHeaderFilePath) {

        try {
            File fileInvoice = new File(invoiceHeaderFilePath);
            File fileItems = new File(itemsHeaderFilePath);

            if (!fileInvoice.exists()) {
                fileInvoice.createNewFile();
            }

            if (!fileItems.exists()) {
                fileItems.createNewFile();
            }
            FileWriter writer1 = new FileWriter(fileInvoice.getAbsoluteFile());
            BufferedWriter buffer1 = new BufferedWriter(writer1);

            for (int row = 0; row < invoiceHeaders.size(); row++) {
                buffer1.write(invoiceHeaders.get(row).getNum() + " ");
                buffer1.write(invoiceHeaders.get(row).getName() + " ");
                buffer1.write(invoiceHeaders.get(row).getDate() + " ");
                buffer1.write("\n---------\n");
            }

            buffer1.close();
            writer1.close();

            FileWriter writer2 = new FileWriter(fileItems.getAbsoluteFile());
            BufferedWriter buffer2 = new BufferedWriter(writer2);

            for (int row = 0; row < invoiceLines.size(); row++) {
                buffer2.write(invoiceLines.get(row).getInvNumber() + " ");
                buffer2.write(invoiceLines.get(row).getName() + " ");
                buffer2.write(invoiceLines.get(row).getPrice() + " ");
                buffer2.write(invoiceLines.get(row).getCount() + " ");
                buffer2.write("\n---------\n");
            }

            buffer2.close();
            writer2.close();

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
