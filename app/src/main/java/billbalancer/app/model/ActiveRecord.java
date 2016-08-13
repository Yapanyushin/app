package billbalancer.app.model;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;
import java.util.UUID;

import billbalancer.app.utils.ClassUtil;

public class ActiveRecord extends Object {
    protected UUID mId;

    public ActiveRecord(){
        mId = UUID.randomUUID();
    }

    public UUID getId(){
        return mId;
    }

}

