package billbalancer.app.model;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;
import java.util.UUID;

import billbalancer.app.utils.ClassUtil;

public class ActiveRecord {
    protected UUID mId;
    protected Date mCreatedAt;

    public ActiveRecord(){
        mId = UUID.randomUUID();
        mCreatedAt = new Date();
    }

    public UUID getId(){
        return mId;
    }

    public Date getCreatedAt(){
        return mCreatedAt;
    }

}

