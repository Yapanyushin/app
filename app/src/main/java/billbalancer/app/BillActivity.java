package billbalancer.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BillActivity extends SingleFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected Fragment createFragment(){
        return new BillFragment();
    }

}
