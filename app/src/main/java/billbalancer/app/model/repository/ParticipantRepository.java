package billbalancer.app.model.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import billbalancer.app.db.Schema.ParticipantsTable;
import billbalancer.app.db.cursor.ApplicationCursorWrapper;
import billbalancer.app.db.cursor.ParticipantCursorWrapper;
import billbalancer.app.model.Model;
import billbalancer.app.model.Participant;

public class ParticipantRepository extends Repository {

    private static ParticipantRepository sInstance;

    protected ParticipantRepository(Context context) {
        super(context);
    }

    @Override
    public boolean contains(Model item) {
        return false;
    }

    public static Repository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ParticipantRepository(context);
        }
        return sInstance;
    }

    @Override
    protected ContentValues getContentValues(Model model) {
        ContentValues values = new ContentValues();
        Participant participant = (Participant) model;

        values.put(ParticipantsTable.Cols.NAME, participant.getName());
        return values;
    }

    @Override
    protected String getTableName() {
      return ParticipantsTable.NAME;
    }

    @Override
    protected String getIdColumnName() {
       return ParticipantsTable.Cols.ID;
    }

    @Override
    protected ApplicationCursorWrapper createCursorWrapper(Cursor cursor) {
        return new ParticipantCursorWrapper(cursor);
    }
}
