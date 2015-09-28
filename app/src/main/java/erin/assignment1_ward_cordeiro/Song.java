package erin.assignment1_ward_cordeiro;

/**
 * Created by Erin on 2015-09-21.
 */
public class Song {

    String name;
    long artistId;
    String duration;
    long id;

    public Song(String songName, long songArtistId, String songDuration) {
        name = songName;
        artistId = songArtistId;
        duration = songDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public void setId(long id) {
        this.id = id;
    }

}
