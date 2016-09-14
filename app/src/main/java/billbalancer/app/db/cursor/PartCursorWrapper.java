package billbalancer.app.db.cursor;

import android.database.Cursor;

import java.util.Date;

import billbalancer.app.db.Schema;
import billbalancer.app.model.Part;
import billbalancer.app.model.Bill;

/**
 * Created by lpaniush on 14.09.16.
 */
public class PartCursorWrapper extends ApplicationCursorWrapper {
    public PartCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Part get() {

        Integer id = getInt(getColumnIndex(Schema.PartTable.Cols.ID));
        double debit = getDouble(getColumnIndex(Schema.PartTable.Cols.DEBIT));
        double credit = getDouble(getColumnIndex(Schema.PartTable.Cols.CREDIT));
        Integer bill_id = getInt(getColumnIndex(Schema.PartTable.Cols.BILL_ID));


        Part part = new Part(id);
        part.setDebit(debit);
        part.setCredit(credit);
        part.setBillId(bill_id);
        return part;
    }
}
