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

    private BillRepository(Context context) {
        super(context);
    }

    public static Repository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new BillRepository(context);
        }
        return sInstance;
    }

    public Boolean contains(Bill bill) {
        return getAll().contains(bill);
    }

    @Override
    ContentValues getContentValues(Model model) {
        ContentValues values = new ContentValues();
        Bill bill = (Bill) model;
        values.put(BillTable.Cols.TITLE, bill.getTitle());
        values.put(BillTable.Cols.TOTAL, bill.getTotal());
        values.put(BillTable.Cols.CREATE_DATE, bill.getCreateDate().getTime());

        return values;
    }

    @Override
    String getTableName() {
        return BillTable.NAME;
    }

    @Override
    String getIdColumnName() {
        return BillTable.Cols.ID;
    }

    @Override
    ApplicationCursorWrapper createCursorWrapper(Cursor cursor) {
        return new BillCursorWrapper(cursor);
    }
}
