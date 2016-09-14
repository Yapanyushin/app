package billbalancer.app.model;


public class Part extends Model {
    private Double debit;
    private Double credit;
    private Integer bill_id;
    private Integer participant_id;

    @Override
    public boolean isValid() {
        return false;
    }
}
