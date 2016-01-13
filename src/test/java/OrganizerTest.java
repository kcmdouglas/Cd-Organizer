import org.junit.*;
import static org.junit.Assert.*;

public class OrganizerTest {


  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void myOrganizer_instantiatesCorrectly_true() {
    Organizer myOrganizer = new Organizer("David Bowie", "Hunky Dory");
    assertEquals(true, myOrganizer instanceof Organizer);
  }

  @Test
  public void myOrganizer_instantiatesWithArtist_true() {
    Organizer myOrganizer = new Organizer("David Bowie", "Hunky Dory");
    assertEquals("David Bowie", myOrganizer.getArtist());
  }

  @Test
  public void isCompleted_instantiatesWithAlbum_true() {
    Organizer myOrganizer = new Organizer("David Bowie", "Hunky Dory");
    assertEquals("Hunky Dory", myOrganizer.getAlbum());
  }

  @Test
  public void all_returnsAllInstancesOfOrganizer_true() {
    Organizer firstOrganizer = new Organizer("David Bowie", "Hunky Dory");
    Organizer secondOrganizer = new Organizer("David Bowie", "Aladdin Sane");
    assertTrue(Organizer.all().contains(firstOrganizer));
    assertTrue(Organizer.all().contains(secondOrganizer));
  }

  @Test
  public void newId_tasksInstantiateWithAnID_true() {
    Organizer myOrganizer = new Organizer("David Bowie", "Hunky Dory");
    assertEquals(Organizer.all().size(), myOrganizer.getId());
  }

  @Test
  public void find_returnsOrganizerWithSameId_secondOrganizer() {
    Organizer firstOrganizer = new Organizer("David Bowie", "Hunky Dory");
    Organizer secondOrganizer = new Organizer("David Bowie", "Aladdin Sane");
    assertEquals(Organizer.find(secondOrganizer.getId()), secondOrganizer);
  }

  @Test
  public void find_returnsNullWhenNoOrganizerFound_null() {
    assertTrue(Organizer.find(999) == null);
  }

  @Test
  public void clear_emptiesAllOrganizersFromArrayList() {
    Organizer myOrganizer = new Organizer("David Bowie", "Hunky Dory");
    Organizer.clear();
    assertEquals(Organizer.all().size(), 0);
  }
}
