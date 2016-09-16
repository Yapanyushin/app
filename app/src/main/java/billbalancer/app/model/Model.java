package billbalancer.app.model;

import java.io.Serializable;

public abstract class Model implements Serializable {
    protected Integer mId;

    public Model(Integer id) {
        mId = id;
    }

    public Model() {
    }

    public Integer getId() {
        return mId;
    }

    public abstract boolean isValid();
}

