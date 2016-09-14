package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import billbalancer.app.db.Schema;
import billbalancer.app.db.cursor.ApplicationCursorWrapper;
import billbalancer.app.db.cursor.BillCursorWrapper;
import billbalancer.app.model.Model;
import billbalancer.app.model.Part;

/**
 * Created by lpaniush on 14.09.16.
 */
public class PartRepository extends Repository {
    private PartRepository(Context context) {
        super(context);
    }

    public static Repository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PartRepository(context);
        }
        return sInstance;
    }

    public Boolean contains(Part part) {
        return getAll().contains(part);
    }

    @Override
    ContentValues getContentValues(Model model) {
        ContentValues values = new ContentValues();
        Part part = (Part) model;
        values.put(Schema.PartTable.Cols.DEBIT, part.getDebit());
        values.put(Schema.PartTable.Cols.CREDIT, part.getCredit());
        values.put(Schema.PartTable.Cols.BILL_ID, part.getBillId());
        return values;
    }

    @Override
    String getTableName() {
        return Schema.PartTable.NAME;
    }

    @Override
    String getIdColumnName() {
        return Schema.PartTable.Cols.ID;
    }

    @Override
    ApplicationCursorWrapper createCursorWrapper(Cursor cursor) {
        return new BillCursorWrapper(cursor);
    }
}
