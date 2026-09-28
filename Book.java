public class Book {

    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    private boolean available;

    // Constructor
    public Book(String bookId, String title, String author,
                String category, double price) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    // Getters

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display Book

    public void displayBook() {

        System.out.println("------------------------------");
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Category   : " + category);
        System.out.println("Price      : ₹" + price);

        if (available) {
            System.out.println("Status     : Available");
        } else {
            System.out.println("Status     : Issued");
        }

        System.out.println("------------------------------");
    }
}