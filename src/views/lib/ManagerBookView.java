/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.lib;

import controller.Lib.PublisherController;
import controller.Lib.GroupBookController;
import controller.Lib.CategoryController;
import controller.BookController;
import model.BookModel;
import model.GroupBookModel;
import model.PublisherModel;
import model.CategoryModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

// view Thêm sách, xoa, sua, cap nhat
public class ManagerBookView extends javax.swing.JFrame {

    BookController bookController = new BookController();
    GroupBookController groupBookController = new GroupBookController();
    CategoryController categoryController = new CategoryController();
    PublisherController publisherController = new PublisherController();

    DefaultTableModel tableModel;
    List<BookModel> bookList = new ArrayList<>();
    List<GroupBookModel> groupBookList = groupBookController.findAll();
    List<CategoryModel> categoryList = categoryController.findAll();
    List<PublisherModel> publisherList = publisherController.findAll();

    public ManagerBookView() {
        initComponents();
        setLocationRelativeTo(null);
        combobox1();//Bộ sách
        combobox2();//Nhà xuất bản
        combobox3();//Thể Loại
        tableModel = (DefaultTableModel) jTable1.getModel();
        showBook();
    }

    // hiển thị danh sách Book ra table 
    private void showBook() {
        bookList = bookController.findAll();
        tableModel.setRowCount(0);

        bookList.forEach((Book) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Book.getBookName(),
                groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()), Book.getAuthor(),
                Book.getMaxNum(), Book.getDate()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextBookName = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextAuthor = new javax.swing.JTextField();
        AddBook = new javax.swing.JButton();
        jSpinnerCount = new javax.swing.JSpinner();
        jSpinnerDateBorrow = new javax.swing.JSpinner();
        Back = new javax.swing.JButton();
        DelBook = new javax.swing.JButton();
        Loc3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        FindBook = new javax.swing.JButton();
        Loc2 = new javax.swing.JButton();
        Loc1 = new javax.swing.JButton();
        UpdateBook = new javax.swing.JButton();
        UpdateFinal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sách ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tên sách");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Tên bộ sách");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Tên nxb");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Thể loại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Tên Tác Giả");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Số ngày cho mượn");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Số lượng");

        jTextBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBookNameActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        AddBook.setBackground(new java.awt.Color(153, 255, 0));
        AddBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        AddBook.setText("Thêm");
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd(evt);
            }
        });

        jSpinnerCount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        jSpinnerDateBorrow.setModel(new javax.swing.SpinnerNumberModel(1, 0, 10, 1));

        Back.setBackground(new java.awt.Color(204, 204, 255));
        Back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Back.setText("Trở lại");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack(evt);
            }
        });

        DelBook.setBackground(new java.awt.Color(255, 153, 51));
        DelBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DelBook.setText("Xóa");
        DelBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel(evt);
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Quản lý sách");

        FindBook.setBackground(new java.awt.Color(153, 255, 204));
        FindBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        FindBook.setText("Tìm");
        FindBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch(evt);
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

        Loc1.setBackground(new java.awt.Color(204, 204, 255));
        Loc1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Loc1.setText("Lọc");
        Loc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loc1ActionPerformed(evt);
            }
        });

        UpdateBook.setBackground(new java.awt.Color(204, 204, 255));
        UpdateBook.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        UpdateBook.setText("Sửa");
        UpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua(evt);
            }
        });

        UpdateFinal.setBackground(new java.awt.Color(255, 204, 204));
        UpdateFinal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        UpdateFinal.setText("Cập nhật");
        UpdateFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Tải lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Loc3)
                                    .addComponent(Loc2)
                                    .addComponent(Loc1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(jTextBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(UpdateFinal)
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinnerDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddBook)
                        .addGap(72, 72, 72)
                        .addComponent(DelBook)
                        .addGap(81, 81, 81)
                        .addComponent(FindBook)
                        .addGap(90, 90, 90)
                        .addComponent(UpdateBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(64, 64, 64)))
                .addComponent(Back)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(UpdateFinal))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Loc1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Loc2)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Loc3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelBook)
                    .addComponent(AddBook)
                    .addComponent(Back)
                    .addComponent(FindBook)
                    .addComponent(UpdateBook)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBookNameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd
        // lấy dữ liệu từ View -> Model
        int groupBookId = groupBookController.FindGroupBookID(jComboBox1.getSelectedItem().toString());
        int pubBookId = publisherController.PubID(jComboBox2.getSelectedItem().toString());
        int cateBookId = categoryController.CateID(jComboBox3.getSelectedItem().toString());
        String bookName = jTextBookName.getText();
        String bookAuthor = jTextAuthor.getText();
        int bookCount = (int) jSpinnerCount.getValue();
        int bookBorrow = (int) jSpinnerDateBorrow.getValue();
        BookModel book = new BookModel(bookName, groupBookId, pubBookId, cateBookId, bookAuthor,
                bookCount, bookCount, bookBorrow);

        // query DB để thêm sách 
        if (bookController.addBook(book)) {
            JOptionPane.showMessageDialog(null, "Them sach thanh cong");
        } else {
            JOptionPane.showMessageDialog(null, "Them sach khong thanh cong");
        }
    }//GEN-LAST:event_btnAdd

    private void btnBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack
        new LibManageView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBack

    // Xóa sách khỏi DB 
    private void btnDel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("" + selectedIndex);
        if (selectedIndex >= 0) {
            BookModel std = bookList.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Ban co muon xoa khong ?");
            System.out.println("option:" + option);
            if (option == 0) {
                bookController.delete(std.getBookID());
                showBook();
            }
        }
    }//GEN-LAST:event_btnDel

    // Lọc theo category 
    private void Loc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc3ActionPerformed
        String Cate_Name = jComboBox3.getSelectedItem().toString();
        int cate_ID = categoryController.CateID(Cate_Name);
        if (cate_ID != 0 && cate_ID > 0) {
            bookList = categoryController.findByCate(cate_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()), Book.getAuthor(),
                    Book.getCount(), Book.getDate()});
            });
        } else {
            showBook();
        }
    }//GEN-LAST:event_Loc3ActionPerformed

    // tìm kiếm sách 
    private void btnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch
        String input = JOptionPane.showInputDialog(this, "Nhap ten sach");
        if (input != null && input.length() > 0) {
            bookList = bookController.findBookName(input);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()), Book.getAuthor(),
                    Book.getCount(), Book.getDate()});
            });
        } else {
            showBook();
        }
    }//GEN-LAST:event_btnSearch

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // lọc theo PublishId
    private void Loc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc2ActionPerformed
        String PubName = jComboBox2.getSelectedItem().toString();
        int pub_ID = publisherController.PubID(PubName);
        if (pub_ID != 0 && pub_ID > 0) {
            bookList = publisherController.findByPub(pub_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()), Book.getAuthor(),
                    Book.getCount(), Book.getDate()});
            });
        } else {
            showBook();
        }
    }//GEN-LAST:event_Loc2ActionPerformed

    // lọc theo GrounpId
    private void Loc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loc1ActionPerformed
        String Group = jComboBox1.getSelectedItem().toString();
        int group_ID = groupBookController.FindGroupBookID(Group);
        if (group_ID != 0 && group_ID > 0) {
            bookList = groupBookController.findByGroupBook(group_ID);
            tableModel.setRowCount(0);
            bookList.forEach((Book) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, Book.getBookName(),
                    groupBookController.FindGroupBookName(Book.getGroupBookID()), categoryController.CateName(Book.getCateID()), publisherController.PubName(Book.getPubID()), Book.getAuthor(),
                    Book.getCount(), Book.getDate()});
            });
        } else {
            showBook();
        }
    }//GEN-LAST:event_Loc1ActionPerformed

    int count = 0;
    int oldMAX = 0;
    int ID = 0;

    // Button sửa
    private void btnSua(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua
        int selectedIndex = jTable1.getSelectedRow();
        if (selectedIndex >= 0) {
            BookModel std = bookList.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Ban co muon sua khong ?");
            System.out.println("option:" + option);
            if (option == 0) {
                jTextBookName.setText(std.getBookName());
                jComboBox1.setSelectedItem(groupBookController.FindGroupBookName(std.getGroupBookID()));
                jComboBox2.setSelectedItem(publisherController.PubName(std.getPubID()));
                jComboBox3.setSelectedItem(categoryController.CateName(std.getCateID()));
                jTextAuthor.setText(std.getAuthor());
                jSpinnerCount.setValue(std.getMaxNum());
                jSpinnerDateBorrow.setValue(std.getDate());
                count = std.getCount();
                ID = std.getBookID();
                oldMAX = std.getMaxNum();
            }
        }
    }//GEN-LAST:event_btnSua

    // button update
    private void btnUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate
        int groupBookId = groupBookController.FindGroupBookID(jComboBox1.getSelectedItem().toString());
        int pubBookId = publisherController.PubID(jComboBox2.getSelectedItem().toString());
        int cateBookId = categoryController.CateID(jComboBox3.getSelectedItem().toString());
        String bookName = jTextBookName.getText();
        String bookAuthor = jTextAuthor.getText();
        int bookCount = (int) jSpinnerCount.getValue();
        int bookBorrow = (int) jSpinnerDateBorrow.getValue();
        BookModel book = new BookModel(bookName, groupBookId, pubBookId, cateBookId, bookAuthor,
                bookCount, bookCount, bookBorrow);
        bookController.Update(book, ID);
        
        JOptionPane.showMessageDialog(null, "Sua sach thanh cong");
        showBook();
    }//GEN-LAST:event_btnUpdate

    private void btnReset(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset
        jTextBookName.setText("");
        jTextAuthor.setText("");
    }//GEN-LAST:event_btnReset

    // hiển thị danh sách GroupBook trên spinner
    private void combobox1() {
        jComboBox1.addItem("--Chọn nhóm sách--");
        for (GroupBookModel groupBookModel : groupBookList) {
            jComboBox1.addItem(groupBookModel.getGroupBookName());
        }
    }

    // hiển thị danh sách Publisher trên spinner
    private void combobox2() {
        jComboBox2.addItem("   ---Chọn NXB----");
        publisherList.forEach((PublisherModel publisherModel) -> {
            jComboBox2.addItem(publisherModel.getPubName());
        });
    }

    // hiển thị danh sách Category trên spinner
    private void combobox3() {
        jComboBox3.addItem("----Chọn thể loại----");
        categoryList.forEach((CategoryModel categoryModel) -> {
            jComboBox3.addItem(categoryModel.getCateName());
        });
    }

    // bắt exception
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
            java.util.logging.Logger.getLogger(ManagerBookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerBookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerBookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerBookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBook;
    private javax.swing.JButton Back;
    private javax.swing.JButton DelBook;
    private javax.swing.JButton FindBook;
    private javax.swing.JButton Loc1;
    private javax.swing.JButton Loc2;
    private javax.swing.JButton Loc3;
    private javax.swing.JButton UpdateBook;
    private javax.swing.JButton UpdateFinal;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerCount;
    private javax.swing.JSpinner jSpinnerDateBorrow;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAuthor;
    private javax.swing.JTextField jTextBookName;
    // End of variables declaration//GEN-END:variables
}
