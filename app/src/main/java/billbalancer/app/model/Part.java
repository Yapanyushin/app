package billbalancer.app.model;


public class Part extends Model {

    public Part(Integer id) {
        super(id);
    }

    private Double mDebit;
    private Double mCredit;
    private Integer mBillId;

    public Double getDebit() {
        return mDebit;
    }

    public void setDebit(Double debit) {
        mDebit = debit;
    }

    public Double getCredit() {
        return mCredit;
    }

    public void setCredit(Double credit) {
        mCredit = credit;
    }

    public Integer getBillId() {
        return mBillId;
    }

    public void setBillId(Integer billId) {
        mBillId = billId;
    }
}
