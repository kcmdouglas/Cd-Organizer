import java.util.ArrayList;

public class Organizer {
  private String mArtist;
  private String mTitle;
  private static ArrayList<Organizer> cdObjects = new ArrayList<Organizer>();
  private int mId;

  public Organizer(String artist, String title){
    mArtist = artist;
    mTitle = title;
    cdObjects.add(this);
    mId = cdObjects.size();
  }

  public String getArtist() {
    return mArtist;
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Organizer> all(){
    return cdObjects;
  }

  public int getId(){
    return mId;
  }

  public static Organizer find(int id) {
    try {
      return cdObjects.get(id - 1);
    } catch (IndexOutOfBoundsException oob) {
      return null;
    }
  }

  public static void clear() {
    cdObjects.clear();
  }

}
