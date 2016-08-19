package billbalancer.app.db.cursor;

import android.database.Cursor;

import java.util.Date;

import billbalancer.app.db.Schema.BillTable;
import billbalancer.app.model.Bill;

public class BillCursorWrapper extends ApplicationCursorWrapper {
    public BillCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Bill get() {
        Integer id   = getInt(getColumnIndex(BillTable.Cols.ID));
        String title = getString(getColumnIndex(BillTable.Cols.TITLE));
        long date    = getLong(getColumnIndex(BillTable.Cols.CREATE_DATE));
        double total = getDouble(getColumnIndex(BillTable.Cols.TOTAL));

        Bill bill = new Bill(id);
        bill.setTitle(title);
        bill.setCreateDate(new Date(date));
        bill.setTotal(total);

        return bill;
    }
}
