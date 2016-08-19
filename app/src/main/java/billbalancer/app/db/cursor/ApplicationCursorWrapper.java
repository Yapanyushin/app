package billbalancer.app.db.cursor;

import android.database.Cursor;
import android.database.CursorWrapper;

import billbalancer.app.model.Model;

public class ApplicationCursorWrapper extends CursorWrapper {
    public ApplicationCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    // should be overwritten by subclass
    public Model get(){ return null; }
}
