package billbalancer.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

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
