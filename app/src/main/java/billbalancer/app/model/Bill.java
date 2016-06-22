package billbalancer.app.model;


public class Bill extends ActiveRecord{
    private String mName;
    private Double mTips;
    private Double mTotal;


    public String getName() {
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

    public void setTotal(Double total){
        mTotal = total;
    }

    public Double getTotal() {
        return mTotal;
    }
}
