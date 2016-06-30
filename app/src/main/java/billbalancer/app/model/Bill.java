package billbalancer.app.model;


import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Bill extends ActiveRecord implements Serializable {
    private String mName = "Default(Whiskey and whores)!";
    private Double mTips;
    private Double mTotal;
    private ArrayList<Part> mParts = new ArrayList<>();
    private Date mCreateDate = new Date();

    @Override
    public boolean equals(Object other) {
        Bill otherBill = (Bill) other;
        return this.mId == otherBill.getId();
    }

    public Date getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(Date createDate) {
        mCreateDate = createDate;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setTotal(Double total) {
        mTotal = total;
    }

    public Double getTotal() {
        return mTotal;
    }

    public void addPart(Part part) {
        mParts.add(part);
    }

    public ArrayList getParts() {
        return mParts;
    }

    public void removePart(Part part) {
        mParts.remove(part);
    }

    public boolean isValid() {
        return mTotal != null;
    }
}
