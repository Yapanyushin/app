package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import billbalancer.app.db.DatabaseHelper;
import billbalancer.app.db.cursor.ApplicationCursorWrapper;
import billbalancer.app.model.Model;

public abstract class  Repository extends AbstractRepository {
    protected SQLiteDatabase mDB;

    protected Repository(Context context) {
        mDB = new DatabaseHelper(context).getWritableDatabase();
    }

    protected ApplicationCursorWrapper query(String whereClause, String[] whereArgs) {
        Cursor cursor = mDB.query(
                getTableName(),
                null, // columns - null => select all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );

        return createCursorWrapper(cursor);
    }

    public void add(Model model) {
        ContentValues values = getContentValues(model);
        mDB.insert(getTableName(), null, values);
    }

    public void remove(Model model) {
        String id = model.getId().toString();
        mDB.delete(getTableName(), getIdColumnName() + " = ?", new String[]{id});
    }

    public void update(Model model) {
        String id = model.getId().toString();
        ContentValues values = getContentValues(model);
        mDB.update(getTableName(), values, getIdColumnName() + " = ?", new String[]{id});
    }

    public Model get(Integer id) {
        ApplicationCursorWrapper wrapper = query(
                getIdColumnName() + "= ?",
                new String[]{id.toString()}
        );

        try {
            if (wrapper.getCount() == 0) {
                return null;
            }

            wrapper.moveToFirst();
            return wrapper.get();
        } finally {
            wrapper.close();
        }
    }

    public List<Model> getAll() {
        List<Model> models = new ArrayList<>();
        ApplicationCursorWrapper wrapper = query(null, null);

        try {
            wrapper.moveToFirst();
            while (!wrapper.isAfterLast()) {
                models.add(wrapper.get());
                wrapper.moveToNext();
            }
        } finally {
            wrapper.close();
        }

        return models;
    }

    public abstract boolean contains(Model item);
}
