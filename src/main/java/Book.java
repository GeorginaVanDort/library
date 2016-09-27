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
  private int patron_id;
  private int id;

  public Book(String title, String author, String genre){
    this.title = title;
    this.phone = author;
    this.email = genre;
    this.overdue = false;
    this.borrowedNow = false;
    this.patron_id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPatronId() {
    return patron_id;
  }

  public int getId() {
    return id;
  }

  public String getGenre() {
    return genre;
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
      String sql = "INSERT INTO books (title, author, genre, patron_id, borrowedNow, overdue)"
    }
  }

}
