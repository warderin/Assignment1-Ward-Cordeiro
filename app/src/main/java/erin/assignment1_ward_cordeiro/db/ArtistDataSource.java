package erin.assignment1_ward_cordeiro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import erin.assignment1_ward_cordeiro.Artist;

/**
 * Created by Erin on 2015-09-21.
 */
public class ArtistDataSource {

    private SQLiteDatabase db;
    private SQLiteOpenHelper dbOpenHelper;

    public static final String TABLE_NAME = "Artist";

    public static final String ID_COLUMN = "_id";
    public static final int ID_COLUMN_POSITION = 0;

    public static final String NAME_COLUMN = "name";
    public static final int NAME_COLUMN_POSITION = 1;

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COLUMN + " TEXT, " +
            ")";

    public ArtistDataSource(Context context) {
        dbOpenHelper = new DBOpenHelper(context);
    }

    public Artist saveArtist(Artist artist) {
        db = dbOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, artist.getName());

        long id = db.insert(TABLE_NAME, null, values);

        artist.setId(id);

        db.close();

        return artist;
    }

}
