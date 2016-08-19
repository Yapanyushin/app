package billbalancer.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.io.Serializable;

import billbalancer.app.model.Bill;

public class BillActivity extends FragmentActivity
        implements PartListFragment.OnListFragmentInteractionListener {

    private static final String BILL_OBJECT = "com.billbalancer.android.billbalancer.bill_object";
    private static final String BILL_CREATE = "com.billbalancer.android.billbalancer.bill_create";
    private static final String BILL_UPDATE = "com.billbalancer.android.billbalancer.bill_update";

    public void onPartSelected(int position) {
        // The user selected the headline of an part from the PartListFragment
        // Do something here to display that article
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        boolean isBillUpdate = getIntent().getBooleanExtra(BILL_UPDATE, false);

        Bundle bundle = new Bundle();
        if (isBillUpdate) {
            bundle.putSerializable(BillFragment.BILL, getIntent().getSerializableExtra(BILL_OBJECT));
        }else {
            bundle.putSerializable(BillFragment.BILL, new Bill());
        }

        renderFragment(bundle);
    }

    private void renderFragment(Bundle bundle) {
        BillFragment fragment = new BillFragment();
        fragment.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    public static Intent getBillActivityIntent(Context packageContext, Serializable bill, boolean isBillCreate) {
        Intent i = new Intent(packageContext, BillActivity.class);

        i.putExtra(BILL_OBJECT, bill);
        if (isBillCreate) {
            i.putExtra(BILL_CREATE, true);
        } else {
            i.putExtra(BILL_UPDATE, true);
        }

        return i;
    }
}
