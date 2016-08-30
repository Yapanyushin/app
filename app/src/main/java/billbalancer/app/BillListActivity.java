package billbalancer.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BillListActivity extends SingleFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openFragment();
    }

    protected Fragment createFragment() {
        return new BillListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
}
