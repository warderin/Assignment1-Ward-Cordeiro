package erin.assignment1_ward_cordeiro;

/**
 * Created by Erin on 2015-09-21.
 */
public class Artist {

    String name;
    long id;

    public Artist(String artistName) {
        name = artistName;
    }

    public String getName() {
        return name;
    }

    public long getId() { return id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
