package app.controller;

import app.model.InvoiceHeader;
import app.model.InvoiceLine;
import app.view.AppFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener, ListSelectionListener
{
    private final AppFrame frame;
    public Controller(AppFrame frame) 
    {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        
        switch (e.getActionCommand())
        {
            case "Create New Invoice" -> newInvoice();
            
            case "Delete Invoice" -> deleteInvoice();
                
            case "Cancel" -> cancelItem();
            
            case "Save" -> saveItem();
            
            case "Load File" -> loadFile(null, null);
            
            case "Save File" -> saveFiles();         
        }
    }

    private void newInvoice()
    {
        
    }

    private void deleteInvoice() 
    {
      frame.removeSelectedRowInInvTable();
    }

    private void cancelItem() 
    {  
        System.exit(0);
    }

    private void saveItem() 
    {
        
    }
    
    public void loadFile(String headerFilePath, String itemsFilePath) {
        File invoiceHeader = null;
        File itemsHeader = null;
        if (headerFilePath == null && itemsFilePath == null) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                invoiceHeader = fc.getSelectedFile();
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemsHeader = fc.getSelectedFile();
                }
            }
        } else {
            invoiceHeader = new File(headerFilePath);
            itemsHeader = new File(itemsFilePath);
        }

        if (invoiceHeader != null && itemsHeader != null) {
            try {

                List<String> headerLinesList = Files.lines(Paths.get(invoiceHeader.getAbsolutePath())).collect(Collectors.toList());

                List<String> itemLinesList = Files.lines(Paths.get(itemsHeader.getAbsolutePath())).collect(Collectors.toList());

                frame.getInvoices().clear();
                frame.getInvoiceItems().clear();

                // ex : 1 , 12-11-2022 , Ali
                for (String headerLineList : headerLinesList) {
                    String[] line = headerLineList.split(",");
                    String invoiceNumb = line[0];
                    String invDate = line[1];
                    String invCustName = line[2];
                    int invoiceNumbCast = Integer.parseInt(invoiceNumb);
                    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date invDateCaset = newFormat.parse(invDate);
                    InvoiceHeader invoice = new InvoiceHeader(invoiceNumbCast, invDateCaset, invCustName);
                    // getInvoicesMethod
                    frame.getInvoices().add(invoice);
                    
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
                    for (InvoiceHeader item : frame.getInvoices()) {
                        if (item.getNum()== invoiceNumber) {
                            item.getItems().add(items);
                        }
                    }
                    frame.getInvoiceItems().add(items);
                    frame.addDatainInvitemsTable();
                }
                frame.addDataInInvoiceTable();

                //ex:  1 , mobile , 3200 , 1 
            } catch (IOException | NumberFormatException | ParseException e) {

            }
        }
    }

    private void saveFiles() 
    {
        
    }      
    
    @Override
    public void valueChanged(ListSelectionEvent event) {

         int selectedInvoice = -1;
         if (frame.getInvTable().getSelectedRowCount() > 0) {
            selectedInvoice = (int) frame.getInvTable().getValueAt(frame.getInvTable().getSelectedRow(), 0);
                System.out.print(selectedInvoice);
        }
        if (selectedInvoice != -1) {
            
            ArrayList<InvoiceLine> result = frame.getInvoiceItems();
            frame.getInvNumberLabel().setText(frame.getInvTable().getValueAt(frame.getInvTable().getSelectedRow(), 0).toString());
            frame.getInvDateField().setText(frame.getInvTable().getValueAt(frame.getInvTable().getSelectedRow(), 1).toString());
            frame.getCustNameField().setText(frame.getInvTable().getValueAt(frame.getInvTable().getSelectedRow(), 2).toString());
            frame.gettotalLabel().setText(frame.getInvTable().getValueAt(frame.getInvTable().getSelectedRow(), 3).toString());
            DefaultTableModel model = (DefaultTableModel) frame.getInvItemTable().getModel();
            model.setRowCount(0);
            for (InvoiceLine item : result) {
              
                if (item.getInvNumber()== selectedInvoice) {
                    Object rowData[] = new Object[5];
                    rowData[0] = item.getInvNumber();
                    rowData[1] = item.getName();
                    rowData[2] = item.getPrice();
                    rowData[3] = item.getCount();
                    rowData[4] = item.getPrice();
                    model.addRow(rowData);
                }

            }
        } else {
            frame.getInvNumberLabel().setText("");
            frame.getInvDateField().setText("");
            frame.getCustNameField().setText("");
            frame.gettotalLabel().setText("");

        }

    }
}
