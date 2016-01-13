import java.util.ArrayList;

public class Organizer {
  private String mArtist;
  private String mTitle;
  // private static ArrayList<Object> cdObjects = new ArrayList<Object>();

  public Organizer(String artist, String title){
    mArtist = artist;
    mTitle = title;
    // cdObjects.add(this);
  }

  public String getArtist() {
    return mArtist;
  }

  public String getTitle() {
    return mTitle;
  }

}
