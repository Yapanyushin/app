package billbalancer.app.model;

public class Participant extends Model{
    private String mName;

    public Participant(int id) {
        super(id);
    }

    public Participant(){
        super();
    }

    @Override
    public boolean isValid() {
        return mName != null;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
