package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;

import billbalancer.app.model.Model;

abstract class AbstractRepository {
    abstract ContentValues getContentValues(Model model);
    abstract String getTableName();
    abstract String getIdColumnName();
    abstract CursorWrapper createCursorWrapper(Cursor cursor);
}
