/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.staff;

import controller.ReaderController;
import controller.BookController;
import model.ReaderModel;
import controller.TicketController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import model.BookModel;
import model.TicketModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// them, sua , xoa ticket
public class TicketManage extends javax.swing.JFrame {

    ReaderController readerController = new ReaderController();
    BookController bookController = new BookController();
    TicketController ticketController = new TicketController();
    DefaultTableModel tableModel;
    List<TicketModel> ticketList = new ArrayList<>();
    List<BookModel> bookList1 = new ArrayList<>();

    public TicketManage() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) jTable1.getModel();
        showTicket();
    }

    // hiển thị danh sách ticket lên table 
    private void showTicket() {
        bookList1 = bookController.findAll();
        ticketList = ticketController.findAll();
        tableModel.setRowCount(0);
        ticketList.forEach((TicketModel Ticket) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, bookController.BookNameByReaderID(Ticket.getBookID()),
                readerController.NameByReaderID(Ticket.getReaderID()), Ticket.getStatusTicket1(), Ticket.getDateBorrow()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí phiếu mượn");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lí phiếu mượn");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Mượn sách");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrow(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setText("Trở lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stt", "Tên sách", "Tên đọc giả", "Trạng thái", "Ngày mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Trả sách");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSach(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setText("In Phiếu mượn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTicket(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton2)
                                .addGap(39, 39, 39)
                                .addComponent(jButton4)
                                .addGap(47, 47, 47)
                                .addComponent(jButton3))
                            .addComponent(jLabel1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button mượn sách 
    private void btnBorrow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrow
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            TicketModel std = ticketList.get(selectedIndex);
            int id = std.getTicketID();
            int name_acc = ticketController.NameAcc(std.getReaderID());
            ReaderModel readerModel = readerController.findReaderbyID(std.getReaderID());
            BookModel bookModel = bookController.findBookByID(std.getBookID());
            if (readerController.checkDateReader(name_acc) == 1) {

                if (readerModel.getMaxBook() - readerModel.getBookBorrow() > 0) {
                    if (bookModel.getCount() > 0) {

                        if (std.getStatusTicket() == 0) {

                            int option = JOptionPane.showConfirmDialog(this, "Ban co muon kich hoat khong ?");
                            System.out.println("option:" + option);
                            if (option == 0) {
                                int new_borrow = readerModel.getBookBorrow() + 1;
                                readerModel.setBookBorrow(new_borrow);
                                //  r.setMaxBook(r.getMaxBook());
                                readerController.Borrow(readerModel);

                                int new_count = (int) bookModel.getCount() - 1;
                                bookModel.setCount(new_count);
                                bookController.UpdateCount(bookModel);

                                Date date = new Date(); // your date 
                                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                                std.setDateBorrow(sqlDate);
                                std.setStatusTicket(1);
                                ticketController.Update(std);
  
                                JOptionPane.showMessageDialog(this, "Muon thanh cong");
                                showTicket();
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "sach da duoc muon");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "sach da het");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ban da muon toi da so luong sach");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Khong hop le");
            }

        }
    }//GEN-LAST:event_btnBorrow

    // button trả sách 
    private void btnTraSach(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSach
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            TicketModel std = ticketList.get(selectedIndex);
            int id = std.getTicketID();
            ReaderModel r = readerController.findReaderbyID(std.getReaderID());
            BookModel b1 = bookController.findBookByID(std.getBookID());
            if (std.getStatusTicket() == 1) {
                int option = JOptionPane.showConfirmDialog(this, "Ban co muon tra khong ?");
                System.out.println("option:" + option);
                if (option == 0) {

                    //  System.out.println(""+std.getDateBorrow());
                    int new_borrow = r.getBookBorrow() - 1;
                    r.setBookBorrow(new_borrow);
                    r.setMaxBook(r.getMaxBook() - ticketController.checkDateTicket(std));
                    readerController.Borrow(r);

                    int new_count = b1.getCount() + 1;
                    b1.setCount(new_count);
                    bookController.UpdateCount(b1);
                    System.out.println("" + std.getBookID());

                    ticketController.delete(id);

                    JOptionPane.showConfirmDialog(this, "Tra thanh cong");
                    showTicket();
                }
            } else {
                JOptionPane.showConfirmDialog(this, "Khong hop le");
            }
        }
    }//GEN-LAST:event_btnTraSach

    // button trở về 
    private void btnBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack
        new StaffManageView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack

    // button Tìm kiếm 
    private void btnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch
        String input = JOptionPane.showInputDialog(this, "Nhap ma doc gia");
        if (input != null && input.length() > 0) {
            int input_int = Integer.parseInt(input);
            ticketList = ticketController.findReaderID(input_int);
            tableModel.setRowCount(0);
            ticketList.forEach((TicketModel Ticket) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, bookController.BookNameByReaderID(Ticket.getBookID()),
                    readerController.NameByReaderID(Ticket.getReaderID()), Ticket.getStatusTicket()});
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Khong tim thay ma doc gia");
        }

    }//GEN-LAST:event_btnSearch

    // in phiếu mượn 
    private void btnPrintTicket(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTicket
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            TicketModel std = ticketList.get(selectedIndex);
            int id = std.getTicketID();
            int Name_acc = ticketController.NameAcc(std.getReaderID());
            JFileChooser fcs = new JFileChooser();
            String path = "";
            if (fcs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                // lấy đường dẫn path
                path = fcs.getSelectedFile().getAbsolutePath();
             
                System.out.println(ticketController.inPhieuMuon(std, path));
                if (ticketController.inPhieuMuon(std, path)) {
                    JOptionPane.showMessageDialog(null, "In phiếu thành công !");
                    try {
                        Desktop.getDesktop().open(new File(path + ".pdf"));
                    } catch (IOException ex) {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "In phiếu không thành công !");
                }

            }
        }
    }//GEN-LAST:event_btnPrintTicket



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
            java.util.logging.Logger.getLogger(TicketManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
