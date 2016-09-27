import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

public class Patron {
  private String name;
  private String phone;
  private String email;
  private int id;

  public Patron(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getId() {
    return id;
  }
  public String getPhone() {
    return phone;
  }

  @Override
  public boolean equals(Object otherPatron) {
    if(!(otherPatron instanceof Patron)) {
      return false;
    } else{
      Patron newPatron = (Patron) otherPatron;
      return this.getName().equals(newPatron.getName()) &&
            this.getEmail().equals(newPatron.getEmail());
    }
  }
