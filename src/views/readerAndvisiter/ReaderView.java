/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.readerAndvisiter;

import controller.Lib.PublisherController;
import controller.Lib.GroupBookController;
import controller.ReaderController;
import controller.Lib.CategoryController;
import controller.BookController;
import model.ReaderModel;
import controller.TicketController;
import model.BookModel;
import model.GroupBookModel;
import model.TicketModel;
import model.PublisherModel;
import model.CategoryModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Home;

public class ReaderView extends javax.swing.JFrame {
    
    DefaultTableModel tableModel1;
    DefaultTableModel tableModel2;

    BookController bookController = new BookController();
    GroupBookController groupBookController = new GroupBookController();
    CategoryController categoryController = new CategoryController();
    PublisherController publisherController = new PublisherController();
    TicketController ticketController = new TicketController();
    ReaderController readerController = new ReaderController();

    List<BookModel> bookList1 = bookController.findAll();
    List<GroupBookModel> groupBookList = groupBookController.findAll();
    List<CategoryModel> categoryList = categoryController.findAll();
    List<PublisherModel> publisherList = publisherController.findAll();
    List<TicketModel> ticketList = new ArrayList<>();

    public ReaderView(int Name) {
        initComponents();
        setLocationRelativeTo(null);
        jLabel6.setText(String.valueOf(ticketController.ReaderID(Name)));
        NameReader.setText(readerController.NameByReaderID(ticketController.ReaderID(Name)));
        ReaderModel r = readerController.findReader(Name);
        Book.setText(String.valueOf(r.getMaxBook() - r.getBookBorrow()));
        Date.setText(String.valueOf(readerController.DateReader(Name)));
        tableModel1 = (DefaultTableModel) jTable1.getModel();
        tableModel2 = (DefaultTableModel) jTable2.getModel();
        showBook1();
        showBook2();
    }

    public ReaderView() {
    };
    
    // bảng 1 bên dưới 
    private void showBook1() {
        tableModel1.setRowCount(0);

        bookList1.forEach((book) -> {
            tableModel1.addRow(new Object[]{tableModel1.getRowCount() + 1, book.getBookName(),
                categoryController.CateName(book.getCateID()), groupBookController.FindGroupBookName(book.getGroupBookID()), publisherController.PubName(book.getPubID()),
                book.getCount(), book.getDate()});
        });
    }

    // bảng 2 bên trên
    private void showBook2() {
        ticketList = ticketController.findReaderID(Integer.parseInt(jLabel6.getText()));
        tableModel2.setRowCount(0);
        ticketList.forEach((TicketModel Ticket) -> {
            tableModel2.addRow(new Object[]{bookController.BookNameByReaderID(Ticket.getBookID()),
                Ticket.getDateBorrow(), Ticket.getStatusTicket()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        NameReader = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Book = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FindBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Đọc giả");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Stt", "Tên sách", "Tên thể loại", "Tên nhóm", "Tên nxb", "Số lượng còn lại", "Số ngày cho mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Tên đọc giả");

        NameReader.setText("jLabel3");

        jLabel4.setText("Số sách có thể mượn");

        jLabel5.setText("Thời hạn thẻ (ngày)");

        Book.setText("jLabel3");

        Date.setText("jLabel3");

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Mượn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrow(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Trở lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sách", "Số ngày mượn còn lại", "Trang thai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("Mã đọc giả");

        jLabel6.setText("jLabel6");

        FindBook.setBackground(new java.awt.Color(153, 255, 204));
        FindBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        FindBook.setText("Tìm");
        FindBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Book)
                                    .addComponent(jLabel6)
                                    .addComponent(NameReader)
                                    .addComponent(Date)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(79, 79, 79)
                        .addComponent(FindBook)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NameReader))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Book))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(FindBook)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // mượn sách 
    private void btnBorrow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrow
        Date date = new Date(); // your date 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            BookModel std = bookList1.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Ban co muon muon khong?");
            System.out.println("option:" + option);
            if (option == 0) {
                TicketModel t;
                t = new TicketModel(Integer.parseInt(jLabel6.getText()), std.getBookID(), 0, sqlDate);
                ticketController.AddTicket(t);
                showBook2();
            }
    }//GEN-LAST:event_btnBorrow
    }
    private void btnBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack
        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack

    // tìm kiếm sách 
    private void btnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch
        String input = JOptionPane.showInputDialog(this, "Nhap ten sach");
        if (input != null && input.length() > 0) {
            bookList1 = bookController.findBookName(input);
            tableModel1.setRowCount(0);
            bookList1.forEach((book) -> {
                tableModel1.addRow(new Object[]{tableModel1.getRowCount() + 1, book.getBookName(),
                    groupBookController.FindGroupBookName(book.getGroupBookID()), categoryController.CateName(book.getCateID()), publisherController.PubName(book.getPubID()), book.getAuthor(),
                     book.getCount(), book.getDate()});
            });
        } else {
            showBook1();
        }
    }//GEN-LAST:event_btnSearch

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
            java.util.logging.Logger.getLogger(ReaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Book;
    private javax.swing.JLabel Date;
    private javax.swing.JButton FindBook;
    private javax.swing.JLabel NameReader;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
