package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.database.Cursor;

import billbalancer.app.db.cursor.ApplicationCursorWrapper;
import billbalancer.app.model.Model;

public abstract class AbstractRepository {
    protected abstract ContentValues getContentValues(Model model);
    protected abstract String getTableName();
    protected abstract String getIdColumnName();
    protected abstract ApplicationCursorWrapper createCursorWrapper(Cursor cursor);
}
