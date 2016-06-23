package billbalancer.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String BILLS_TABLE_NAME = "bills";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";

    private static final String DATABASE_NAME = "billbalancer";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BILLS_TABLE_NAME +" ("
                + KEY_ID + " integer BILLS_TABLE_NAME key autoincrement,"
                + KEY_NAME + " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BILLS_TABLE_NAME);
        this.onCreate(db);
    }

}