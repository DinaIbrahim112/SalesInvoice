
package app.view;

import app.controller.Controller;
import app.model.InvoiceHeader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateNewInvoices extends javax.swing.JFrame {

    AppFrame appFrame ;
    Controller controller;
    // Variables declaration - do not modify                     
    private javax.swing.JButton createInvoice;
    private javax.swing.JTextField custName;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;

   public CreateNewInvoices(AppFrame frame) {
       this.appFrame = frame;
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        custName = new javax.swing.JTextField();
        createInvoice = new javax.swing.JButton();
        createInvoice.addActionListener(controller);
        dateTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create new Invoice");

        jLabel2.setText("Date");

        jLabel3.setText("Customer name");

        custName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameActionPerformed(evt);
            }
        });

        createInvoice.setText("Create");
        createInvoice.setActionCommand("Add New Invoice");
        createInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(custName, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(dateTxt))
                                .addGap(55, 55, 55)
                                .addComponent(createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createInvoice))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addContainerGap(149, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceActionPerformed
        // TODO add your handling code here:

        int maxId = 0;
        for (InvoiceHeader item : appFrame.getInvoices()) {
            if (item.getNum()> maxId) {
                maxId = item.getNum();
            }
        }
       InvoiceHeader invoice = new InvoiceHeader(maxId + 1, getDateTxt() , getCustname());
       custName.setText("");
       dateTxt.setText("");
       appFrame.getInvoices().add(invoice);
       appFrame.addDataInInvoiceTable();
       this.dispose();

    }//GEN-LAST:event_createInvoiceActionPerformed
    // End of variables declaration                   

    private void custNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custNameActionPerformed

    public String getCustname() {
        return custName.getText();
    }

    public Date getDateTxt() {
        try {
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            return newFormat.parse(dateTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(CreateNewInvoices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }



}
