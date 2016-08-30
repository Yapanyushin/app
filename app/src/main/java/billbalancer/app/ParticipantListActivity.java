package billbalancer.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class ParticipantListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ParticipantListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openFragment();
    }
}
