import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

public class BookHistory {
  private int id;
  private int book_id;
  private int patron_id;
  private TimeStamp dateBorrowed;
  private TimeStamp dateReturned;
  private TimeStamp dateDue;
  private int renewCount;

  public static final int MAX_RENEW_COUNT = 2;

  public BookHistory (int book_id, int patron_id) {
    this.book_id = book_id;
    this.patron_id = patron_id;
    this.renewCount = 0;
  }

  public int getBookId() {
    return book_id;
  }

  public int getId() {
    return id;
  }

  public int getPatronId() {
    return patron_id;
  }

  public int getRenewCount(){
    return renewCount;
  }

  public Timestamp getDateBorrowed(){
  return dateBorrowed;
  }

  public Timestamp getDateDue(){
  return dateDue;
  }
