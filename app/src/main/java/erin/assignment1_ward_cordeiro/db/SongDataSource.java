package erin.assignment1_ward_cordeiro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import erin.assignment1_ward_cordeiro.Artist;
import erin.assignment1_ward_cordeiro.Song;

/**
 * Created by Erin on 2015-09-21.
 */
public class SongDataSource {

    private SQLiteDatabase db;
    private SQLiteOpenHelper dbOpenHelper;

    public static final String TABLE_NAME = "Song";

    public static final String ID_COLUMN = "_id";
    public static final int ID_COLUMN_POSITION = 0;

    public static final String NAME_COLUMN = "name";
    public static final int NAME_COLUMN_POSITION = 1;

    public static final String ARTISTID_COLUMN = "artistId";
    public static final int ARTISTID_COLUMN_POSITION = 2;

    public static final String DURATION_COLUMN = "duration";
    public static final int DURATION_COLUMN_POSITION = 3;

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COLUMN + " TEXT, " +
            ARTISTID_COLUMN + " INT, " +
            DURATION_COLUMN + " TEXT, " +
            ")";

    public SongDataSource(Context context) {
        dbOpenHelper = new DBOpenHelper(context);
    }

    public Song saveSong(Song song) {
        db = dbOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, song.getName());
        values.put(ARTISTID_COLUMN, song.getArtistId());
        values.put(DURATION_COLUMN, song.getDuration());

        long id = db.insert(TABLE_NAME, null, values);

        song.setId(id);

        db.close();

        return song;
    }

    public List<Song> getSongs(Artist artist) {
        List<Song> songs = new ArrayList<>();

        db = dbOpenHelper.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ARTISTID_COLUMN}, ARTISTID_COLUMN + " like ?", new String[]{ artist.getId()+"%" }, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(NAME_COLUMN_POSITION);
            long artistId = cursor.getLong(ARTISTID_COLUMN_POSITION);
            String duration = cursor.getString(DURATION_COLUMN_POSITION);
            songs.add(new Song(name, artistId, duration));
        }

        cursor.close();

        db.close();

        return songs;
    }

}
