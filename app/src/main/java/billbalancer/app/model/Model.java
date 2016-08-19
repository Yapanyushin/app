package billbalancer.app.model;

import java.io.Serializable;

public class Model extends Object implements Serializable {
    protected Integer mId;

    public Model(Integer id) {
        mId = id;
    }

    public Model() {
    }

    public Integer getId() {
        return mId;
    }

}

