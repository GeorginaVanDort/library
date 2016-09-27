import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

public class Book {
  private String title;
  private String author;
  private String genre;
  private boolean overdue;
  private boolean borrowedNow;
  private int id;
  private Timestamp dateBorrowed;
  private Timestamp dateReturned;
  private Timestamp dateDue;
  private int renewCount;

  public static final int MAX_RENEW_COUNT = 2;

  public Book(String title, String author, String genre){
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.renewCount = 0;
    this.overdue = false;
    this.borrowedNow = false;
    this.renewCount = 0;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getId() {
    return id;
  }

  public String getGenre() {
    return genre;
  }

  public int getRenewCount(){
    return renewCount;
  }

  public boolean getBorrowedNow(){
    return borrowedNow;
  }
  public Timestamp getDateBorrowed(){
  return dateBorrowed;
  }

  public Timestamp getDateDue(){
  return dateDue;
  }

  public static List<Book> all() {
    String sql = "SELECT * FROM books";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Book.class);
    }
  }

  @Override
  public boolean equals(Object otherBook) {
    if(!(otherBook instanceof Book)) {
      return false;
    } else{
      Book newBook = (Book) otherBook;
      return this.getTitle().equals(newBook.getTitle()) &&
            this.getAuthor().equals(newBook.getAuthor());
    }
  }

  public void save () {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO books (title, author, genre, overdue, borrowednow, renewcount) values (:title, :author, :genre, :overdue, :borrowedNow, :renewCount)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("title", this.title)
      .addParameter("author", this.author)
      .addParameter("genre", this.genre)
      .addParameter("overdue", this.overdue)
      .addParameter("borrowedNow", this.borrowedNow)
      .addParameter("renewCount", this.renewCount)
      .executeUpdate()
      .getKey();
    }
  }
}
