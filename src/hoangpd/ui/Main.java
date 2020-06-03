/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangpd.ui;

import hoangpd.daos.ItemDAO;
import hoangpd.daos.SupplierDAO;
import hoangpd.dtos.ItemDTO;
import hoangpd.dtos.SupplierDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phamduchoang
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     *
     * @throws java.lang.Exception
     */
    public Main() throws Exception {
        initComponents();
        View();
        chkSupColloborating.setEnabled(false);

    }

    private boolean validAddSup() {
        String supCode = txtSupCode.getText().trim();
        String supName = txtSupName.getText().trim();
        String supAddress = txtSupAddress.getText().trim();

        if (supCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Supplier code is required");
            txtSupCode.requestFocus();
            return false;
        }
        if (supCode.length() > 5) {
            JOptionPane.showMessageDialog(this, "Supplier code length is 1 to 5 characters");
            txtSupCode.requestFocus();
            return false;
        }
        if (supName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Supplier name is required");
            txtSupName.requestFocus();
            return false;
        }
        if (supCode.length() > 100) {
            JOptionPane.showMessageDialog(this, "Supplier name length is 1 to 100 characters");
            txtSupName.requestFocus();
            return false;
        }
        if (supAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Supplier address is required");
            txtSupAddress.requestFocus();
            return false;
        }
        if (supCode.length() > 200) {
            JOptionPane.showMessageDialog(this, "Supplier address length is 1 to 200 characters");
            txtSupAddress.requestFocus();
            return false;
        }

        return true;

    }

    private void View() throws Exception {
        DefaultTableModel supplierModel = new DefaultTableModel();
        DefaultTableModel itemModel = new DefaultTableModel();
        supplierModel.addColumn("Code");
        supplierModel.addColumn("Name");
        supplierModel.addColumn("Address");

        itemModel.addColumn("Code");
        itemModel.addColumn("Name");
        itemModel.addColumn("Supplier");
        itemModel.addColumn("Unit");
        itemModel.addColumn("Price");
        itemModel.addColumn("Supply");
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        ArrayList<ItemDTO> itemList = new ArrayList<>();

        ItemDAO item = new ItemDAO();
        SupplierDAO supplier = new SupplierDAO();
        supplierList = supplier.getAllSupplier();
        itemList = item.getAllItem();

        for (ItemDTO itemDTO : itemList) {
            itemModel.addRow(itemDTO.toArrayObj());

        }
        for (SupplierDTO supplierDTO : supplierList) {
            supplierModel.addRow(supplierDTO.toArrayObject());
        }
        tblSuplier.setModel(supplierModel);
        tblItem.setModel(itemModel);
        for (SupplierDTO supplierDTO : supplierList) {
            cbItemSuplier.addItem(supplierDTO.getSupCode() + " - " + supplierDTO.getSupName());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Item = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSuplier = new javax.swing.JTable();
        txtSupCode = new javax.swing.JTextField();
        txtSupName = new javax.swing.JTextField();
        txtSupAddress = new javax.swing.JTextField();
        chkSupColloborating = new javax.swing.JCheckBox();
        btnSupAddNew = new javax.swing.JButton();
        btnSupSave = new javax.swing.JButton();
        btnSupDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        cbItemSuplier = new javax.swing.JComboBox<>();
        txtItemUnit = new javax.swing.JTextField();
        txtItemPrice = new javax.swing.JTextField();
        chkItemSupplying = new javax.swing.JCheckBox();
        btnIteamAddNew = new javax.swing.JButton();
        btnItemSave = new javax.swing.JButton();
        btnItemDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSuplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuplierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSuplier);

        btnSupAddNew.setText("Add New");
        btnSupAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupAddNewActionPerformed(evt);
            }
        });

        btnSupSave.setText("Save");
        btnSupSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupSaveActionPerformed(evt);
            }
        });

        btnSupDelete.setText("Delete");
        btnSupDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Code");

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Colloborating");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSupCode)
                            .addComponent(txtSupName)
                            .addComponent(txtSupAddress)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkSupColloborating)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSupAddNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSupSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnSupDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtSupCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2))
                            .addComponent(txtSupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSupAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(chkSupColloborating))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSupAddNew)
                            .addComponent(btnSupSave)
                            .addComponent(btnSupDelete)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        Item.addTab("Suplier", jPanel1);

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblItem);

        jLabel5.setText("Item Code");

        jLabel6.setText("Item Name");

        jLabel7.setText("Supplier");

        jLabel8.setText("Unit");

        jLabel9.setText("Price");

        jLabel10.setText("Supplying");

        btnIteamAddNew.setText("Add New");
        btnIteamAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIteamAddNewActionPerformed(evt);
            }
        });

        btnItemSave.setText("Save");
        btnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemSaveActionPerformed(evt);
            }
        });

        btnItemDelete.setText("Delete");
        btnItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtItemName))
                                    .addComponent(txtItemCode)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(chkItemSupplying)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbItemSuplier, 0, 181, Short.MAX_VALUE)
                                    .addComponent(txtItemPrice)
                                    .addComponent(txtItemUnit))))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIteamAddNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnItemSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnItemDelete))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbItemSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(chkItemSupplying))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIteamAddNew)
                    .addComponent(btnItemSave)
                    .addComponent(btnItemDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Item.addTab("Item", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Item)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuplierMouseClicked
        // TODO add your handling code here:
        int indexRow = tblSuplier.getSelectedRow();
        txtSupCode.setText(tblSuplier.getValueAt(indexRow, 0).toString());
        txtSupName.setText(tblSuplier.getValueAt(indexRow, 1).toString());
        txtSupAddress.setText(tblSuplier.getValueAt(indexRow, 2).toString());
        SupplierDAO supplier = new SupplierDAO();
        ArrayList<SupplierDTO> supplierList;
        try {
            supplierList = supplier.getAllSupplier();
            chkSupColloborating.setSelected(supplierList.get(indexRow).isColloborating());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tblSuplierMouseClicked


    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
        // TODO add your handling code here:
        int indexRow = tblItem.getSelectedRow();
        txtItemCode.setText(tblItem.getValueAt(indexRow, 0).toString());
        txtItemName.setText(tblItem.getValueAt(indexRow, 1).toString());

        txtItemUnit.setText(tblItem.getValueAt(indexRow, 3).toString());
        txtItemPrice.setText(tblItem.getValueAt(indexRow, 4).toString());
        chkItemSupplying.setSelected(tblItem.getValueAt(indexRow, 5).toString().equals("true"));
        for (int i = 0; i < cbItemSuplier.getMaximumRowCount(); i++) {

            if (cbItemSuplier.getItemAt(i) != null) {
                if (cbItemSuplier.getItemAt(i).contains(tblItem.getValueAt(indexRow, 2).toString())) {

                    cbItemSuplier.setSelectedIndex(i);
                }
            }
        }

    }//GEN-LAST:event_tblItemMouseClicked

    private void btnIteamAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIteamAddNewActionPerformed
        // TODO add your handling code here:
        txtItemCode.setText("");
        txtItemName.setText("");
        txtItemPrice.setText("");
        txtItemUnit.setText("");
        cbItemSuplier.setSelectedIndex(0);
        chkItemSupplying.setSelected(false);
    }//GEN-LAST:event_btnIteamAddNewActionPerformed

    private void btnSupAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupAddNewActionPerformed
        // TODO add your handling code here:
        txtSupCode.setText("");
        txtSupName.setText("");
        txtSupAddress.setText("");
        chkSupColloborating.setSelected(true);

    }//GEN-LAST:event_btnSupAddNewActionPerformed

    private void btnSupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupSaveActionPerformed
        // TODO add your handling code here:
        String supCode = txtSupCode.getText().trim();
        String supName = txtSupName.getText().trim();
        String supAddress = txtSupAddress.getText().trim();
        boolean colloborating = chkSupColloborating.isSelected();
        SupplierDTO newSup = new SupplierDTO(supCode, supName, supAddress, colloborating);
        SupplierDAO supplier = new SupplierDAO();

        try {
            if (supplier.supCodeIsExist(supCode)) {
                //new

                if (validAddSup()) {
                    boolean result;
                    int dialog = JOptionPane.showConfirmDialog(this, "Are you sure?");
                    if (dialog == JOptionPane.YES_OPTION) {
                        result = supplier.addNewSupplier(newSup);
                        if (result) {
                            JOptionPane.showMessageDialog(this, "Add supplier successful");
                            View();
                            btnSupAddNewActionPerformed(evt);
                        } else {
                            System.out.println("Please try again");
                        }

                    }
                }
            } else {
                //update

                int dialog = JOptionPane.showConfirmDialog(this, "Are you sure update");
                if (dialog == JOptionPane.YES_OPTION) {
                    if (supplier.updateSupplier(newSup)) {
                        JOptionPane.showMessageDialog(this, "Update successful");
                        View();
                        btnSupAddNewActionPerformed(evt);
                    } else {
                        JOptionPane.showMessageDialog(this, "Please try again");
                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSupSaveActionPerformed

    private void btnSupDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupDeleteActionPerformed
        // TODO add your handling code here:
        String supCode = txtSupCode.getText().trim();
        SupplierDAO supplierDao = new SupplierDAO();

        int dialog = JOptionPane.showConfirmDialog(this, "Do you want delete");
        if (dialog == JOptionPane.YES_OPTION) {
            try {
                if (supplierDao.validDeleteSup(supCode)) {
                    if (supplierDao.deleteSup(supCode)) {
                        JOptionPane.showMessageDialog(this, "Delete succsessful");
                        View();
                        btnSupAddNewActionPerformed(evt);
                    } else {
                        JOptionPane.showMessageDialog(this, "Supplier code does not exist");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "The supplier has more than 1 product so it cannot be deleted");
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnSupDeleteActionPerformed

    private void btnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemSaveActionPerformed
        // TODO add your handling code here:
        String itemCode = txtItemCode.getText().trim();
        String itemName = txtItemName.getText().trim();
        String supCode = cbItemSuplier.getSelectedItem().toString().trim().split("-")[0];
        String itemUnit = txtItemUnit.getText().trim();
        String itemPrice = txtItemPrice.getText().trim();
        boolean itemSupplying = chkItemSupplying.isSelected();
        ItemDTO newItem = new ItemDTO(itemCode, itemName, supCode, itemUnit, itemPrice, itemSupplying);
        ItemDAO itemDao = new ItemDAO();
        try {
            if (itemDao.itemCodeIsExist(itemCode)) {
                //new
                if (validAddItem()) {
                    boolean result;
                    int dialog = JOptionPane.showConfirmDialog(this, "Are you sure?");
                    if (dialog == JOptionPane.YES_OPTION) {
                        result = itemDao.addNewItem(newItem);
                        if (result) {
                            JOptionPane.showMessageDialog(this, "Add item successful");
                            View();
                            btnIteamAddNewActionPerformed(evt);

                        } else {
                            System.out.println("Please try again");
                        }

                    }

                }
            } else {
                //update

                int dialog = JOptionPane.showConfirmDialog(this, "Are you sure update");
                if (dialog == JOptionPane.YES_OPTION) {
                    if (itemDao.updateItem(newItem)) {
                        JOptionPane.showMessageDialog(this, "Update successful");
                        View();
                        btnIteamAddNewActionPerformed(evt);
                    } else {
                        JOptionPane.showMessageDialog(this, "Please try again");
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnItemSaveActionPerformed

    private void btnItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemDeleteActionPerformed
        // TODO add your handling code here:
        String itemCode = txtItemCode.getText().trim();
        ItemDAO item = new ItemDAO();
        int dialog = JOptionPane.showConfirmDialog(this, "Are you sure delete");
        if (dialog == JOptionPane.YES_OPTION) {
            try {
                if (item.deleteItem(itemCode)) {
                    JOptionPane.showMessageDialog(this, "Delete successful");
                    View();
                    btnIteamAddNewActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Item code does not exist");
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnItemDeleteActionPerformed
    private boolean validAddItem() {
        String itemCode = txtItemCode.getText().trim();
        String itemName = txtItemName.getText().trim();
        String itemUnit = txtItemUnit.getText().trim();
        String itemPrice = txtItemPrice.getText().trim();

        

        if (itemCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item code is required");
            txtItemCode.requestFocus();
            return false;
        }
        if (itemCode.length() > 5) {
            JOptionPane.showMessageDialog(this, "Item code length is 1 to 5 characters");
            txtItemCode.requestFocus();
            return false;
        }
        if (itemName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item name is required");
            txtItemName.requestFocus();
            return false;
        }
        if (itemName.length() > 100) {
            JOptionPane.showMessageDialog(this, "Item name length is 1 to 100 characters");
            txtItemName.requestFocus();
            return false;
        }
        if (itemUnit.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Unit is required");
            txtItemUnit.requestFocus();
            return false;
        }
        if (itemUnit.length() > 10) {
            JOptionPane.showMessageDialog(this, "Item Unit length is 1 to 10 characters");
            txtItemUnit.requestFocus();
            return false;
        }
        if (itemPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is required");
            txtItemPrice.requestFocus();
            return false;
        }
        try {
           Integer.parseInt(itemPrice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price is a number");
            txtItemPrice.setText("");
            txtItemPrice.requestFocus();
            return false;
        }
        return true;

    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Item;
    private javax.swing.JButton btnIteamAddNew;
    private javax.swing.JButton btnItemDelete;
    private javax.swing.JButton btnItemSave;
    private javax.swing.JButton btnSupAddNew;
    private javax.swing.JButton btnSupDelete;
    private javax.swing.JButton btnSupSave;
    private javax.swing.JComboBox<String> cbItemSuplier;
    private javax.swing.JCheckBox chkItemSupplying;
    private javax.swing.JCheckBox chkSupColloborating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblSuplier;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemUnit;
    private javax.swing.JTextField txtSupAddress;
    private javax.swing.JTextField txtSupCode;
    private javax.swing.JTextField txtSupName;
    // End of variables declaration//GEN-END:variables
}
