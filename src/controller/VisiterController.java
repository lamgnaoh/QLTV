/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Lib.PublisherController;
import controller.Lib.GroupBookController;
import controller.Lib.CategoryController;
import java.util.List;
import model.BookModel;
import model.CategoryModel;
import model.GroupBookModel;
import model.PublisherModel;


public class VisiterController {

    BookController bookController = new BookController();
    GroupBookController groupBookController = new GroupBookController();
    CategoryController categoryController = new CategoryController();
    PublisherController publisherController = new PublisherController();
    
    public List<GroupBookModel> getGroupBookList() {
        return groupBookController.findAll();
    }

    public List<CategoryModel> getCategoryList() {
        return categoryController.findAll();
    }

    public List<PublisherModel> getPublisherList() {
        return publisherController.findAll();
    }
    
    public List<BookModel> getBookList() {
        return bookController.findAll();
    }
}
