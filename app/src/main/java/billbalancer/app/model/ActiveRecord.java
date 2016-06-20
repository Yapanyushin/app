package billbalancer.app.model;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import billbalancer.app.utils.ClassUtil;

public class ActiveRecord {
    private static String mTableName = new ClassUtil().getCurrentClassName();
    private static final String mDatabaseName = "billbalancer";
    private SQLiteDatabase mDatabase;
    protected Integer id;

    public void ActiveRecord(){
        mDatabase = getDatabase();
    }

    public static ActiveRecord find(){
        return new ActiveRecord(); //
    }

    private SQLiteDatabase getDatabase(){
        return SQLiteDatabase.openOrCreateDatabase(mDatabaseName, null, null);
    }

}

