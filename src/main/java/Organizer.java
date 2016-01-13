import java.util.ArrayList;

public class Organizer{
  private String mArtist;
  private String mAlbum;
  private static ArrayList<Organizer> cdObjects = new ArrayList<Organizer>();
  private int mId;

  public Organizer(String artist, String album){
    mArtist = artist;
    mAlbum = album;
    cdObjects.add(this);
    mId = cdObjects.size();
  }

  public String getArtist() {
    return mArtist;
  }

  public String getAlbum() {
    return mAlbum;
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
