package com.leo.service.book;

import com.leo.entity.Book;
import com.leo.util.Params;

import java.util.List;

public interface BookService {
    List<Book> selectBookAll(Params params);
    Book selectBookById(Integer id);
    void saveBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
}
