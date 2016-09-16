package billbalancer.app.db.cursor;

import android.database.Cursor;

import billbalancer.app.db.Schema.ParticipantsTable;
import billbalancer.app.model.Participant;

public class ParticipantCursorWrapper extends ApplicationCursorWrapper {
    public ParticipantCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Participant get() {
        Integer id = getInt(getColumnIndex(ParticipantsTable.Cols.ID));
        String name = getString(getColumnIndex(ParticipantsTable.Cols.NAME));

        Participant participant = new Participant(id);
        participant.setName(name);

        return participant;
    }
}
