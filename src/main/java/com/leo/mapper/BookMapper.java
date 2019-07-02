package com.leo.mapper;

import com.leo.entity.Book;
import com.leo.util.Params;

import java.util.List;

public interface BookMapper {
    List<Book> selectBookAll(Params params);
    Book selectBookById(Integer id);
    void saveBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
}
