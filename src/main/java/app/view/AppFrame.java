/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.controller.Controller;
import app.model.InvoiceHeader;
import app.model.InvoiceLine;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class AppFrame extends javax.swing.JFrame {
        CreateNewInvoices newInvoice = new CreateNewInvoices(this);

    public AppFrame() {
        controller = new Controller(this);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderTBL = new javax.swing.JTable();
        CreateNewInvoiceBTN = new javax.swing.JButton();
        CreateNewInvoiceBTN.addActionListener(controller);
        DeleteInvoiceBTN = new javax.swing.JButton();
        DeleteInvoiceBTN.addActionListener(controller);
        InvoiceNumber = new javax.swing.JLabel();
        InvoiceDate = new javax.swing.JLabel();
        CustomerName = new javax.swing.JLabel();
        TotalInvoice = new javax.swing.JLabel();
        InvoiceNameText = new javax.swing.JLabel();
        InvoiceTotalText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemsTBL = new javax.swing.JTable();
        SaveBTN = new javax.swing.JButton();
        SaveBTN.addActionListener(controller);
        CancelBTN = new javax.swing.JButton();
        CancelBTN.addActionListener(controller);
        jScrollPane3 = new javax.swing.JScrollPane();
        InvoiceDateText = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        CustomerNameText = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadFile = new javax.swing.JMenuItem();
        LoadFile.addActionListener(controller);
        SaveFile = new javax.swing.JMenuItem();
        SaveFile.addActionListener(controller);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeaderTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ));
        jScrollPane1.setViewportView(HeaderTBL);

        CreateNewInvoiceBTN.setText("Create New Invoice");
        CreateNewInvoiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewInvoiceBTNActionPerformed(evt);
            }
        });

        DeleteInvoiceBTN.setText("Delete Invoice");

        InvoiceNumber.setText("Invoice Number");

        InvoiceDate.setText("Invoice Date");

        CustomerName.setText("Customer Name");

        TotalInvoice.setText("Invoice Total");

        InvoiceNameText.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                InvoiceNameTextAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        InvoiceTotalText.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                InvoiceTotalTextAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        ItemsTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        jScrollPane2.setViewportView(ItemsTBL);

        SaveBTN.setText("Save");

        CancelBTN.setText("Cancel");
        CancelBTN.setToolTipText("");
        CancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBTNActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(InvoiceDateText);

        jScrollPane4.setViewportView(CustomerNameText);

        jMenu1.setText("File");

        LoadFile.setText("Load File");
        LoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileActionPerformed(evt);
            }
        });
        jMenu1.add(LoadFile);

        SaveFile.setText("Save File");
        SaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileActionPerformed(evt);
            }
        });
        jMenu1.add(SaveFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InvoiceNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(InvoiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TotalInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InvoiceNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InvoiceTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(CreateNewInvoiceBTN)
                .addGap(62, 62, 62)
                .addComponent(DeleteInvoiceBTN)
                .addGap(91, 91, 91)
                .addComponent(SaveBTN)
                .addGap(82, 82, 82)
                .addComponent(CancelBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceNumber)
                            .addComponent(InvoiceNameText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InvoiceDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalInvoice)
                            .addComponent(InvoiceTotalText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBTN)
                    .addComponent(CancelBTN)
                    .addComponent(DeleteInvoiceBTN)
                    .addComponent(CreateNewInvoiceBTN))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateNewInvoiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewInvoiceBTNActionPerformed
        newInvoice.setVisible(true);
        newInvoice.pack();
        newInvoice.setLocationRelativeTo(null);
        newInvoice.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_CreateNewInvoiceBTNActionPerformed

    private void CancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelBTNActionPerformed

    private void LoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileActionPerformed
       
    }//GEN-LAST:event_LoadFileActionPerformed

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed

        try {
            File fileInvoice = new File("/Scoolarship/Sales Invoice Generator/InvoiceHeaders.csv");
            File fileItems = new File("/Scoolarship/Sales Invoice Generator/InvoiceLines.csv");

            if (!fileInvoice.exists()) {
                fileInvoice.createNewFile();
            }

            if (!fileItems.exists()) {
                fileItems.createNewFile();
            }
            FileWriter writer1 = new FileWriter(fileInvoice.getAbsoluteFile());
            BufferedWriter buffer1 = new BufferedWriter(writer1);

            for (int row = 0; row < HeaderTBL.getRowCount(); row++) {
                for (int col = 0; col < HeaderTBL.getColumnCount(); col++) {
                    buffer1.write((String) HeaderTBL.getValueAt(row, col).toString() + " ");
                }
                buffer1.write("\n---------\n");
            }

            buffer1.close();
            writer1.close();

            FileWriter writer2 = new FileWriter(fileItems.getAbsoluteFile());
            BufferedWriter buffer2 = new BufferedWriter(writer2);

            for (int row = 0; row < ItemsTBL.getRowCount(); row++) {
                for (int col = 0; col < ItemsTBL.getColumnCount(); col++) {
                    buffer2.write((String) ItemsTBL.getValueAt(row, col).toString() + " ");
                }
                buffer2.write("\n---------\n");
            }

            buffer2.close();
            writer2.close();

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_SaveFileActionPerformed

    private void InvoiceNameTextAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_InvoiceNameTextAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoiceNameTextAncestorAdded

    private void InvoiceTotalTextAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_InvoiceTotalTextAncestorAdded
    }//GEN-LAST:event_InvoiceTotalTextAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBTN;
    private javax.swing.JButton CreateNewInvoiceBTN;
    private javax.swing.JLabel CustomerName;
    private javax.swing.JTextPane CustomerNameText;
    private javax.swing.JButton DeleteInvoiceBTN;
    private javax.swing.JTable HeaderTBL;
    private javax.swing.JLabel InvoiceDate;
    private javax.swing.JTextPane InvoiceDateText;
    private javax.swing.JLabel InvoiceNameText;
    private javax.swing.JLabel InvoiceNumber;
    private javax.swing.JLabel InvoiceTotalText;
    private javax.swing.JTable ItemsTBL;
    private javax.swing.JMenuItem LoadFile;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JMenuItem SaveFile;
    private javax.swing.JLabel TotalInvoice;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
    private Controller controller;
    private ArrayList<InvoiceHeader> invoices;
    private ArrayList<InvoiceLine> invoiceItems;    
   public ArrayList<InvoiceHeader> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }
    public ArrayList<InvoiceLine> getInvoiceItems() {
        if (invoiceItems == null) {
            invoiceItems = new ArrayList<>();
        }
        return invoiceItems;
    }   
    public void removeSelectedRowInInvTable() {
        int selectedInvoice = -1;
        if (HeaderTBL.getSelectedRowCount() > 0) {
            selectedInvoice = (int) getInvTable().getValueAt(getInvTable().getSelectedRow(), 0);
        }
        if (selectedInvoice != -1) {
            int ItemIndex = 0;
            ArrayList<InvoiceLine> deletedInvoiceItem = new ArrayList<InvoiceLine>();
            for (InvoiceHeader invoice : getInvoices()) {
                if (selectedInvoice == invoice.getNum()) {
                    getInvoices().remove(ItemIndex);
                    for (int i = 0; i < getInvoiceItems().size(); i++) {
                        if (selectedInvoice == getInvoiceItems().get(i).getInvNumber()) {
                            deletedInvoiceItem.add(getInvoiceItems().get(i));
                        }
                    }
                    for (InvoiceLine invItem : deletedInvoiceItem) {
                        getInvoiceItems().remove((InvoiceLine) invItem);
                    }
                    break;
                }
                ItemIndex++;
            }
            addDatainInvitemsTable();
            addDataInInvoiceTable();
            // remove selected row from the model
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Please select your invoice");
        }

    }   
    public void addDataInInvoiceTable() {
        DefaultTableModel model = (DefaultTableModel) getInvTable().getModel();
        model.setRowCount(0);
        ArrayList<InvoiceHeader> myInvoices = getInvoices();
        Object rowData[] = new Object[4];
        for (int i = 0; i < myInvoices.size(); i++) {
            rowData[0] = myInvoices.get(i).getNum();
            rowData[1] = myInvoices.get(i).getDate();
            rowData[2] = myInvoices.get(i).getName();
            rowData[3] = myInvoices.get(i).getTotal();
            model.addRow(rowData);
        }
    }
     public void addDatainInvitemsTable() {
        int selectedInvoice = -1;
        if (HeaderTBL.getSelectedRowCount() > 0) {
            selectedInvoice = (int) getInvTable().getValueAt(getInvTable().getSelectedRow(), 0);
        }
        DefaultTableModel model = (DefaultTableModel) ItemsTBL.getModel();
        model.setRowCount(0);
        ArrayList<InvoiceLine> myInvoiceItems = getInvoiceItems();
        Object rowData[] = new Object[5];
        for (int i = 0; i < myInvoiceItems.size(); i++) {
            if (selectedInvoice != -1) {
                if (myInvoiceItems.get(i).getInvNumber() == selectedInvoice) {
                    rowData[0] = myInvoiceItems.get(i).getInvNumber();
                    rowData[1] = myInvoiceItems.get(i).getName();
                    rowData[2] = myInvoiceItems.get(i).getPrice();
                    rowData[3] = myInvoiceItems.get(i).getCount();
                    rowData[4] = myInvoiceItems.get(i).getTotal();
                    model.addRow(rowData);
                }

            } else {
                rowData[0] = myInvoiceItems.get(i).getInvNumber();
                rowData[1] = myInvoiceItems.get(i).getName();
                rowData[2] = myInvoiceItems.get(i).getPrice();
                rowData[3] = myInvoiceItems.get(i).getCount();
                rowData[4] = myInvoiceItems.get(i).getTotal();
                model.addRow(rowData);
            }
        }

    }
    public JTable getInvTable() {
        return HeaderTBL;
    } 
    public JTable getInvItemTable() {
        return ItemsTBL;
    }
    public JLabel getInvNumberLabel() {
        return InvoiceNameText;
    }
    public JTextPane getInvDateField() {
        return InvoiceDateText;
    }
    public JTextPane getCustNameField() {
        return CustomerNameText;
    }
    public JLabel gettotalLabel() {
        return InvoiceTotalText;
    }   
    public void setIvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }
    public int getSelectedInvoiceNumber() {
        return (int) HeaderTBL.getValueAt(HeaderTBL.getSelectedRow(), 0);
    }
    }
   
