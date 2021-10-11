/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.staff;

import controller.Check;
import controller.ReaderController;
import model.ReaderModel;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ReaderManage extends javax.swing.JFrame {

    ReaderController readerController = new ReaderController();
    DefaultTableModel tableModel;
    List<ReaderModel> readerList = readerController.findAll();

    public ReaderManage() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) jTable2.getModel();
        showReader();
    }

    // hiển thị thông tin trên table
    private void showReader() {
        readerList = readerController.findAll();
        tableModel.setRowCount(0);

        readerList.forEach((ReaderModel Reader) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Reader.getNameAcc(), Reader.getReaderID(),
                Reader.getDateReader(), (Reader.getMaxBook() - Reader.getBookBorrow()), Reader.getRemain(), getStatus(Reader.getStatusReader())});
        });

    }

    private String getStatus(int i) {
        if (i == 1) {
            return "Kích hoạt";
        } else {
            return "Không kích hoạt";
        }
    }

    private int getStatusbyS(String i) {
        if ("Kích hoạt".equals(i)) {
            return 1;
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNameAcc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassAcc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNameUser = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDateTicket = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStatusReader = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        FindReader = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý đọc giả");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý đọc giả");

        jLabel2.setText("Tên tài khoản");

        txtNameAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameAccActionPerformed(evt);
            }
        });

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Tên đọc Giả");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setText("Thời hạn thẻ");

        txtDateTicket.setText("Gia hạn");
        txtDateTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaHan(evt);
            }
        });

        jLabel7.setText("Trạng thái thẻ");

        txtStatusReader.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Không kích hoạt", " " }));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd(evt);
            }
        });

        jLabel8.setText("Số điện thoại");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Tài khoản", "Mã đọc giả ", "Ngày đăng kí ", "Số sách có thể mượn", "Số ngày còn lại", "Trạng thái "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua(evt);
            }
        });

        Update.setBackground(new java.awt.Color(255, 255, 153));
        Update.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Update.setText("Cập nhật");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate(evt);
            }
        });

        FindReader.setBackground(new java.awt.Color(204, 204, 255));
        FindReader.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        FindReader.setText("Tìm");
        FindReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Tải tại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setText("Trở lại");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jButton4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPassAcc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(txtNameAcc, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(FindReader)
                                        .addGap(83, 83, 83)
                                        .addComponent(jButton2)
                                        .addGap(74, 74, 74)
                                        .addComponent(jButton3)
                                        .addGap(84, 84, 84)
                                        .addComponent(jButton5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(Update)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStatusReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDateTicket)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNameAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update)
                    .addComponent(jLabel6)
                    .addComponent(txtDateTicket))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtStatusReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(FindReader)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameAccActionPerformed

    // button thêm mới reader 
    private void btnAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd
        if (Check.checkEmail(txtEmail.getText()) && Check.checkPhoneNum(txtPhone.getText()) && readerController.findReader(Integer.parseInt(txtNameAcc.getText())).getReaderID() == 0) {
            java.util.Date date = new java.util.Date(); // your date
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            int NameAcc = Integer.parseInt(txtNameAcc.getText());
            String PassAcc = txtPassAcc.getText();
            String NameUser = txtNameUser.getText();
            String Email = txtEmail.getText();
            String Phone = txtPhone.getText();
            ReaderModel readerModel = new ReaderModel(NameAcc, PassAcc, 5, 0, sqlDate, 1, NameUser, Email, Phone, 15);
            readerController.addReader(readerModel);
            JOptionPane.showMessageDialog(null, "Them  thanh cong");
            showReader();
        } else {
            JOptionPane.showMessageDialog(null, "Thong tin khong hop le !");
        }
    }//GEN-LAST:event_btnAdd

    private void btnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch
        String input1 = JOptionPane.showInputDialog(this, "Nhap Ten tai khoan");

        if (!"".equals(input1) && input1.length() > 0) {
            int input = Integer.parseInt(input1);
            readerList = readerController.findReaderID(input);
            tableModel.setRowCount(0);

            readerList.forEach((Reader) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Reader.getNameAcc(), Reader.getReaderID(),
                    Reader.getDateReader(), (Reader.getMaxBook() - Reader.getBookBorrow()), getStatus(Reader.getStatusReader())});
            });
        } else {
            showReader();
        }
    }//GEN-LAST:event_btnSearch

    private void btnDel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel
        int selectedIndex = jTable2.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            ReaderModel std = readerList.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Ban co muon xoa khong ?");
            System.out.println("option:" + option);
            if (option == 0) {
                readerController.delete(std.getNameAcc());
                showReader();
            }
        }
    }//GEN-LAST:event_btnDel
    int IDR = 0;
    int old_remain = 0;
    private void btnSua(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua
        int selectedIndex = jTable2.getSelectedRow();
        if (selectedIndex >= 0) {
            ReaderModel std = readerList.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Ban co muon sua khong ?");
            System.out.println("option:" + option);
            if (option == 0) {
                txtNameAcc.setText(String.valueOf(std.getNameAcc()));
                txtPassAcc.setText(String.valueOf(std.getPassAcc()));
                txtNameUser.setText(std.NameUser);
                txtEmail.setText(std.getEmail());
                txtPhone.setText(std.PhoneNum);
                txtStatusReader.setSelectedItem(getStatus(std.getStatusReader()));
                IDR = std.getReaderID();
                old_remain = std.getRemain();
            }
        }
    }//GEN-LAST:event_btnSua

    // button update
    private void btnUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate
        if (!(Check.checkEmail(txtEmail.getText()) && Check.checkPhoneNum(txtPhone.getText()))) {
            JOptionPane.showMessageDialog(null, "Sua that bai");
        } else {
            ReaderModel std = new ReaderModel();
            std.setPassAcc(txtPassAcc.getText());
            std.setNameUser(txtNameUser.getText());
            std.setPhoneNum(txtPhone.getText());
            std.setEmail(txtEmail.getText());
            std.setStatusReader(getStatusbyS(txtStatusReader.getSelectedItem().toString()));
            System.out.println("" + getStatusbyS(txtStatusReader.getSelectedItem().toString()));
            std.setReaderID(IDR);
            readerController.Update(std);

            JOptionPane.showMessageDialog(null, "Sua  thanh cong");
            showReader();
        }
    }//GEN-LAST:event_btnUpdate

    // button reset
    private void btnReset(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset
        txtNameAcc.setText("");
        txtPassAcc.setText("");
        txtNameUser.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtStatusReader.setSelectedItem(getStatus(1));
    }//GEN-LAST:event_btnReset

    // button gia hạn thẻ 
    private void btnGiaHan(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaHan
        ReaderModel std = new ReaderModel();
        std.setRemain(old_remain + 15);
        std.setReaderID(IDR);
        readerController.Date(std);
        JOptionPane.showMessageDialog(null, "Gia han thanh cong");
        showReader();
    }//GEN-LAST:event_btnGiaHan

    private void btnBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack
        new StaffManageView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack

    public static void main() {
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
            java.util.logging.Logger.getLogger(ReaderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReaderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReaderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReaderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FindReader;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton txtDateTicket;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNameAcc;
    private javax.swing.JTextField txtNameUser;
    private javax.swing.JTextField txtPassAcc;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JComboBox<String> txtStatusReader;
    // End of variables declaration//GEN-END:variables
}
