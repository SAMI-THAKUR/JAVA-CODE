package GAME;
class LIBRARY{
    String [] books;
    int no_of_books=0;
    LIBRARY()
    {
        books=new String[100];
        no_of_books=0;
    }
    void addbooks(String books)
    {
        this.books[no_of_books]=books;
        no_of_books++;
        System.out.println(books + " has been added");
    }
    void show_available_books()
    {
        System.out.println("available books");
        for (String elements : books)
        {
            if (elements==null) {
                continue;
            }
            System.out.println("* "+ elements);
        }
    }
    void issueBook(String book){
        for (int i=0;i<this.books.length;i++) {
            if (this.books[i].equals(book)) {
                System.out.println("The book " + book + " has been issued");
                this.books[i] = null;
                return;
            }
        }
        System.out.println("book not available");

    }
    void return_book(String book)
    {
        addbooks(book);
    }
}


public class DIGITAL_LIBRARY {

    public static void main(String[] args) {
        LIBRARY li= new LIBRARY();
        li.addbooks("wings of fire");
        li.addbooks("c++");
        li.addbooks("hi");
        li.addbooks("java");
        li.issueBook("c++");
        li.show_available_books();
        li.return_book("c++");
        li.show_available_books();


    }
}
