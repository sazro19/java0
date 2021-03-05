package SimpleClasses.BookService;

import java.util.List;

public class Book {

    private int id;

    private List<String> authors;

    private String publisher;

    private int publishingYear;

    private int pageAmount;

    private double price;

    private Binding binding;

    public Book(int id, List<String> authors, String publisher, int publishingYear,
                int pageAmount, double price, Binding binding) {
        this.id = id;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.pageAmount = pageAmount;
        this.price = price;
        this.binding = binding;
    }

    public int getId() {
        return id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public double getPrice() {
        return price;
    }

    public Binding getBinding() {
        return binding;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBinding(Binding binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", publishingYear=" + publishingYear +
                ", pageAmount=" + pageAmount +
                ", price=" + price +
                ", binding=" + binding +
                '}';
    }
}
