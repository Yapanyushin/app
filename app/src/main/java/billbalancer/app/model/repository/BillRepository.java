package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import billbalancer.app.db.Schema.BillTable;
import billbalancer.app.db.cursor.ApplicationCursorWrapper;
import billbalancer.app.db.cursor.BillCursorWrapper;
import billbalancer.app.model.Bill;
import billbalancer.app.model.Model;

public class BillRepository extends Repository {
    private static BillRepository sInstance;

    private BillRepository(Context context) {
        super(context);
    }

    public static Repository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new BillRepository(context);
        }
        return sInstance;
    }

    @Override
    public boolean contains(Model item) {
        return getAll().contains(item);
    }

    @Override
    protected final ContentValues getContentValues(Model model) {
        ContentValues values = new ContentValues();
        Bill bill = (Bill) model;
        values.put(BillTable.Cols.TITLE, bill.getTitle());
        values.put(BillTable.Cols.TOTAL, bill.getTotal());
        values.put(BillTable.Cols.CREATE_DATE, bill.getCreateDate().getTime());

        return values;
    }

    @Override
    protected final String getTableName() {
        return BillTable.NAME;
    }

    @Override
    protected final String getIdColumnName() {
        return BillTable.Cols.ID;
    }

    @Override
    protected final ApplicationCursorWrapper createCursorWrapper(Cursor cursor) {
        return new BillCursorWrapper(cursor);
    }
}
