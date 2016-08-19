package billbalancer.app.model;

import java.util.ArrayList;
import java.util.Date;

public class Bill extends Model {
    private String mTitle = "Default(Whiskey and whores)!";
    private Double mTotal;
    private ArrayList<Part> mParts = new ArrayList<>();
    private Date mCreateDate = new Date();

    public Bill(Integer id) {
        super(id);
    }

    @Override
    public boolean equals(Object other) {
        return this.getId() != null &&
                other instanceof Bill &&
                this.getId().equals(
                        ((Bill) other).getId()
                );
    }

    public Date getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(Date createDate) {
        mCreateDate = createDate;
    }

    public Bill() {
        super();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
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
