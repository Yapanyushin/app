package billbalancer.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import billbalancer.app.db.Schema.BillTable;
import billbalancer.app.db.Schema.ParticipantsTable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "billbalancer.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createBills(db);
        createParticipants(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BillTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ParticipantsTable.NAME);
        onCreate(db);
    }

    private void createBills(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + BillTable.NAME + "(" +
                BillTable.Cols.ID + " integer primary key autoincrement, " +
                BillTable.Cols.TITLE + ", " +
                BillTable.Cols.TOTAL + ", " +
                BillTable.Cols.CREATE_DATE + ")"
        );
    }

    private void createParticipants(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + ParticipantsTable.NAME + "(" +
                ParticipantsTable.Cols.ID + " integer primary key autoincrement, " +
                ParticipantsTable.Cols.NAME + ")"
        );
    }


}
