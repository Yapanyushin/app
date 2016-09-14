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

    public static final class PartTable {
        public static final String NAME = "parts";

        public static final class Cols {
            public static final String ID = "id";
            public static final String DEBIT = "debit";
            public static final String CREDIT = "credit";
            public static final String BILL_ID = "bill_id";
        }
    }
}
