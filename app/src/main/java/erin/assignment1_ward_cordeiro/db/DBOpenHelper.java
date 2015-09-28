package erin.assignment1_ward_cordeiro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Erin on 2015-09-21.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "PlayersDB.db";

    private static final int DB_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SongDataSource.CREATE_TABLE);
        db.execSQL(ArtistDataSource.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SongDataSource.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ArtistDataSource.TABLE_NAME);
        onCreate(db);
    }

}
