import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. View All Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Delete Book");
            System.out.println("9. Delete Member");
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewAllBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    addMember();
                    break;

                case 5:
                    viewAllMembers();
                    break;

                case 6:
                    issueBook();
                    break;

                case 7:
                    returnBook();
                    break;

                case 8:
                    deleteBook();
                    break;

                case 9:
                    deleteMember();
                    break;

                case 10:
                    System.out.println(
                            "Thank you for using Library Management System!"
                    );

                    sc.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice! Please enter 1-10."
                    );
            }
        }
    }

    // ==========================================
    // ADD BOOK
    // ==========================================

    public static void addBook() {

        System.out.println("\n===== ADD BOOK =====");

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        // Check duplicate Book ID

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                System.out.println(
                        "Book ID already exists!"
                );

                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        if (price < 0) {

            System.out.println(
                    "Price cannot be negative!"
            );

            return;
        }

        Book book = new Book(
                bookId,
                title,
                author,
                category,
                price
        );

        books.add(book);

        System.out.println(
                "Book added successfully!"
        );
    }

    // ==========================================
    // VIEW ALL BOOKS
    // ==========================================

    public static void viewAllBooks() {

        System.out.println("\n===== ALL BOOKS =====");

        if (books.isEmpty()) {

            System.out.println("No books found.");

            return;
        }

        for (Book book : books) {

            book.displayBook();
        }
    }

    // ==========================================
    // SEARCH BOOK
    // ==========================================

    public static void searchBook() {

        System.out.println("\n===== SEARCH BOOK =====");

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                System.out.println("Book Found!");

                book.displayBook();

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // ==========================================
    // ADD MEMBER
    // ==========================================

    public static void addMember() {

        System.out.println("\n===== ADD MEMBER =====");

        sc.nextLine();

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        // Check duplicate Member ID

        for (Member member : members) {

            if (member.getMemberId().equalsIgnoreCase(memberId)) {

                System.out.println(
                        "Member ID already exists!"
                );

                return;
            }
        }

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Member member = new Member(
                memberId,
                name,
                phone
        );

        members.add(member);

        System.out.println(
                "Member added successfully!"
        );
    }

    // ==========================================
    // VIEW ALL MEMBERS
    // ==========================================

    public static void viewAllMembers() {

        System.out.println("\n===== ALL MEMBERS =====");

        if (members.isEmpty()) {

            System.out.println("No members found.");

            return;
        }

        for (Member member : members) {

            member.displayMember();
        }
    }

    // ==========================================
    // FIND BOOK
    // ==========================================

    public static Book findBook(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                return book;
            }
        }

        return null;
    }

    // ==========================================
    // FIND MEMBER
    // ==========================================

    public static Member findMember(String memberId) {

        for (Member member : members) {

            if (member.getMemberId().equalsIgnoreCase(memberId)) {

                return member;
            }
        }

        return null;
    }

    // ==========================================
    // ISSUE BOOK
    // ==========================================

    public static void issueBook() {

        System.out.println("\n===== ISSUE BOOK =====");

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Book book = findBook(bookId);

        if (book == null) {

            System.out.println("Book not found.");

            return;
        }

        if (!book.isAvailable()) {

            System.out.println(
                    "Book is already issued!"
            );

            return;
        }

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println("Member not found.");

            return;
        }

        book.setAvailable(false);

        System.out.println(
                "Book issued successfully!"
        );

        System.out.println(
                "Book  : " + book.getTitle()
        );

        System.out.println(
                "Member: " + member.getName()
        );
    }

    // ==========================================
    // RETURN BOOK
    // ==========================================

    public static void returnBook() {

        System.out.println("\n===== RETURN BOOK =====");

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Book book = findBook(bookId);

        if (book == null) {

            System.out.println("Book not found.");

            return;
        }

        if (book.isAvailable()) {

            System.out.println(
                    "This book is already available."
            );

            return;
        }

        book.setAvailable(true);

        System.out.println(
                "Book returned successfully!"
        );
    }

    // ==========================================
    // DELETE BOOK
    // ==========================================

    public static void deleteBook() {

        System.out.println("\n===== DELETE BOOK =====");

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Book book = findBook(bookId);

        if (book == null) {

            System.out.println("Book not found.");

            return;
        }

        books.remove(book);

        System.out.println(
                "Book deleted successfully!"
        );
    }

    // ==========================================
    // DELETE MEMBER
    // ==========================================

    public static void deleteMember() {

        System.out.println("\n===== DELETE MEMBER =====");

        sc.nextLine();

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println("Member not found.");

            return;
        }

        members.remove(member);

        System.out.println(
                "Member deleted successfully!"
        );
    }
}