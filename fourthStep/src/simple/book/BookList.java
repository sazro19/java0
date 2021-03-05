package simple.book;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<Book> bookList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void printBookList() {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public void printBookListByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            for (String auth : book.getAuthors()) {
                if (auth.equals(author)) {
                    result.add(book);
                    break;
                }
            }
        }
        printBookList(result);
    }

    public void printBookListByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublisher().equals(publisher)) {
                result.add(book);
            }
        }
        printBookList(result);
    }

    public void printBookListByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublishingYear() > year) {
                result.add(book);
            }
        }
        printBookList(result);
    }

    public void printBookById(int id) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getId() == id) {
                result.add(book);
            }
        }
        printBookList(result);
    }

    private void printBookList(List<Book> list) {
        for (Book book : list) {
            System.out.println(book.toString());
        }
    }
}
