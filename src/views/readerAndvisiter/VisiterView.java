/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.readerAndvisiter;

import controller.Lib.PublisherController;
import controller.Lib.GroupBookController;
import controller.Lib.CategoryController;
import controller.BookController;
import controller.VisiterController;
import model.BookModel;
import model.GroupBookModel;
import model.PublisherModel;
import model.CategoryModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Home;

public class VisiterView extends javax.swing.JFrame {
    
    BookController bookController = new BookController();
    PublisherController publisherController = new PublisherController();
    CategoryController categoryController = new CategoryController();
    GroupBookController groupBookController = new GroupBookController();
    VisiterController visiterController = new VisiterController();
    DefaultTableModel tableModel;
    List<BookModel> bookList = visiterController.getBookList();
    List<GroupBookModel> groupBookList = visiterController.getGroupBookList();
    List<CategoryModel> categoryList = visiterController.getCategoryList();
    List<PublisherModel> publisherList = visiterController.getPublisherList();
    
    public VisiterView() {
        initComponents();
        setLocationRelativeTo(null);
        combobox1();//Bộ sách
        combobox2();//Nhà xuất bản
        combobox3();//Thể Loại
        tableModel=(DefaultTableModel) jTable1.getModel();
        showBook();
    }

        private void showBook() {
        tableModel.setRowCount(0);
        bookList.forEach((Book) -> {
            tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, Book.getBookName(), 
                groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()),Book.getAuthor()
                    ,Book.getMaxNum(),Book.getDate()});
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        FindBook = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Loc1 = new javax.swing.JButton();
        Loc2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        Loc3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khách ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "BookID", "Tên Sách", "Nhóm", "Thể Loại", "Nhà xuất bản", "Tác Giả", "Số Lượng", "Số ngày được mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        FindBook.setBackground(new java.awt.Color(153, 255, 204));
        FindBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        FindBook.setText("Tìm");
        FindBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Tên bộ sách");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Loc1.setBackground(new java.awt.Color(204, 204, 255));
        Loc1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Loc1.setText("Lọc");
        Loc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loc1ActionPerformed(evt);
            }
        });

        Loc2.setBackground(new java.awt.Color(204, 204, 255));
        Loc2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Loc2.setText("Lọc");
        Loc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loc2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Tên nxb");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        Loc3.setBackground(new java.awt.Color(204, 204, 255));
        Loc3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Loc3.setText("Lọc");
        Loc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loc3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Thể loại");

        Back.setBackground(new java.awt.Color(204, 204, 255));
        Back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Back.setText("Trở lại");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Khách");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Loc3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Loc2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(Loc1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(FindBook)
                                .addGap(226, 226, 226)
                                .addComponent(Back)))
                        .addGap(0, 566, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(497, 497, 497)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Loc1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Loc2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Loc3)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FindBook)
                    .addComponent(Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // tìm kiếm theo tên
    private void btnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch
        String input = JOptionPane.showInputDialog(this,"Nhap ten sach");
        if(input!=null&&input.length()>0){
            bookList = bookController.findBookName(input);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()),Book.getAuthor()
                    ,Book.getCount(),Book.getDate()});
        });
        }else{
            showBook();
        }
    }//GEN-LAST:event_btnSearch

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    // lọc theo GroupBook
    private void Loc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc1ActionPerformed
        String Group = jComboBox1.getSelectedItem().toString();
        int group_ID = groupBookController.FindGroupBookID(Group);
        if(group_ID!=0&&group_ID>0){
            bookList = groupBookController.findByGroupBook(group_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()),Book.getAuthor()
                    ,Book.getCount(),Book.getDate()});
        });
        }else{
            showBook();
        }
    }//GEN-LAST:event_Loc1ActionPerformed

    // lọc theo Publish
    private void Loc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc2ActionPerformed
        String PubName=jComboBox2.getSelectedItem().toString();
        int pub_ID= publisherController.PubID(PubName);
        if(pub_ID!=0&&pub_ID>0){
            bookList=publisherController.findByPub(pub_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()),Book.getAuthor()
                    ,Book.getCount(),Book.getDate()});
        });
        }else{
            showBook();
        }
    }//GEN-LAST:event_Loc2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // lọc theo Category 
    private void Loc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc3ActionPerformed
        String Cate_Name=jComboBox3.getSelectedItem().toString();
        int cate_ID = categoryController.CateID(Cate_Name);
        if(cate_ID!=0&&cate_ID>0){
            bookList = categoryController.findByCate(cate_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[] {tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()),Book.getAuthor()
                    ,Book.getCount(),Book.getDate()});
        });
        }else{
            showBook();
        }
    }//GEN-LAST:event_Loc3ActionPerformed

    private void btnBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack
        Home BM=new Home();
        BM.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack
private void combobox1() {
    jComboBox1.addItem("--Chọn nhóm sách--");
    groupBookList.stream().map(groupBook -> groupBook.getGroupBookName()).forEachOrdered(name -> {
        jComboBox1.addItem(name);
        });
}
private void combobox2(){
    jComboBox2.addItem("   ---Chọn NXB----");
    publisherList.stream().map(pub -> pub.getPubName()).forEachOrdered(name -> {
        jComboBox2.addItem(name);
        });
}
private void combobox3(){
    jComboBox3.addItem("----Chọn thể loại----");
    int size = categoryList.size();
    for (int i = 0; i < size; i++) {
        String name = categoryList.get(i).getCateName();
        jComboBox3.addItem(name);
        
    }
}


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
            java.util.logging.Logger.getLogger(VisiterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisiterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisiterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisiterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Visiter().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VisiterView().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton FindBook;
    private javax.swing.JButton Loc1;
    private javax.swing.JButton Loc2;
    private javax.swing.JButton Loc3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
