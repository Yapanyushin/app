package billbalancer.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;

import billbalancer.app.model.Bill;
import billbalancer.app.model.Model;

public class BillActivity extends ListItemActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        renderFragment(createBundle());
    }

    public static Intent getActivityIntent(Context packageContext, Serializable bill, boolean isBillCreate) {
        Intent i = new Intent(packageContext, BillActivity.class);

        i.putExtra(ITEM_OBJECT, bill);
        if (isBillCreate) {
            i.putExtra(ITEM_CREATE, true);
        } else {
            i.putExtra(ITEM_UPDATE, true);
        }

        return i;
    }

    @Override
    protected final Model createModel() {
        return new Bill();
    }

    @Override
    protected final Fragment createFragment() {
        return new BillFragment();
    }
}
