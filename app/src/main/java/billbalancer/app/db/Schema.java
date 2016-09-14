package billbalancer.app.db;

public class Schema {
    public static final class BillTable {
        public static final String NAME = "bills";

        public static final class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String TOTAL = "total";
            public static final String CREATE_DATE = "create_date";
        }
    }

    public static final class ParticipantsTable {
        public static final String NAME = "participants";

        public static final class Cols {
            public static final String ID = "id";
            public static final String NAME = "name";
        }
    }
}
