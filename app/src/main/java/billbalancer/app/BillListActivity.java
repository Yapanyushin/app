package billbalancer.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import billbalancer.app.model.BillStorage;

public class BillListActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return new BillListFragment();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openFragment();

    }


}
