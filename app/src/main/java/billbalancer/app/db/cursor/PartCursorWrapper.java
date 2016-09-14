package billbalancer.app.db.cursor;

import android.database.Cursor;

import java.util.Date;

import billbalancer.app.db.Schema.PartTable;
import billbalancer.app.model.Part;


public class PartCursorWrapper extends ApplicationCursorWrapper {
    public PartCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Part get() {

        Integer id = getInt(getColumnIndex(PartTable.Cols.ID));
        double debit = getDouble(getColumnIndex(PartTable.Cols.DEBIT));
        double credit = getDouble(getColumnIndex(PartTable.Cols.CREDIT));
        Integer bill_id = getInt(getColumnIndex(PartTable.Cols.BILL_ID));


        Part part = new Part(id);
        part.setDebit(debit);
        part.setCredit(credit);
        part.setBillId(bill_id);
        return part;
    }
}
