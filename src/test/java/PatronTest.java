import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class PersonTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  Patron fred = new Patron ("Fred", "503-333-3333", "email@no.com");

  @Test
  public void patron_instantiatesCorrectly_True() {
    Patron testPatron = fred;
    assertEquals(true, testPatron instanceof Patron);
  }

  @Test
  public void getName_patronInstantiatesWithName_Fred() {
    Patron testPatron = fred;
    assertEquals("Fred", testPatron.getName());
  }

  @Test
  public void getName_patronInstantiatesWithPhone_String() {
    Patron testPatron = fred;
    assertEquals("503-333-3333", testPatron.getPhone());
  }

  @Test
  public void getName_patronInstantiatesWithEmail_String() {
    Patron testPatron = fred;
    assertEquals("email@no.com", testPatron.getEmail());
  }

  // @Test
  // public void equals_returnsTrueIfNameAndEmailAreTheSame_true() {
  //   Patron patronOne = fred;
  //   Person patronTwo = fred;
  //   assertTrue(patronOne.equals(patronTwo));
  // }
  //
  // @Test
  // public void save_insertsObjectIntoDatabase_Person(){
  //   Person testPerson = fred;
  //   testPerson.save();
  //   assertTrue(Person.all().get(0).equals(testPerson));
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfPerson_true() {
  //   Person firstPerson = fred;
  //   firstPerson.save();
  //   Person secondPerson = new Person("Harriet", "harriet@harriet.com");
  //   secondPerson.save();
  //   assertEquals(true, Person.all().get(0).equals(firstPerson));
  //   assertEquals(true, Person.all().get(1).equals(secondPerson));
  // }
  //
  // @Test
  // public void save_assignsIdToObject() {
  //   Person testPerson = fred;
  //   testPerson.save();
  //   Person savedPerson = Person.all().get(0);
  //   assertEquals(testPerson.getId(), savedPerson.getId());
  // }
  //
  // @Test
  // public void find_returnsPersonWithCorrectId_secondPerson() {
  //   Person firstPerson = fred;
  //   firstPerson.save();
  //   Person secondPerson = new Person("Harriet", "harriet@harriet.com");
  //   secondPerson.save();
  //   assertEquals(Person.find(secondPerson.getId()), secondPerson);
  // }
  //
  // @Test
  // public void getMonsters_retrievesAllMonstersFromDatabase_monstersList() {
  //   Person testPerson = fred;
  //   testPerson.save();
  //   Monster firstMonster = new Monster("Squeaky", testPerson.getId());
  //   firstMonster.save();
  //   Monster secondMonster = new Monster("Spud", testPerson.getId());
  //   secondMonster.save();
  //   Monster[] monsters = new Monster[] { firstMonster, secondMonster };
  //   assertTrue(testPerson.getMonsters().containsAll(Arrays.asList(monsters)));
  // }

}
