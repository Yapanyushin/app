package billbalancer.app.utils;

public class ClassUtil extends SecurityManager {
    public Class getCurrentClass() {
        return getClassContext()[1];
    }

    public String getCurrentClassName(){
        return getCurrentClass().getName();
    }

}

