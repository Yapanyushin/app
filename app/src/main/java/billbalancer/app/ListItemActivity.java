package billbalancer.app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import billbalancer.app.model.Model;

public abstract class ListItemActivity  extends FragmentActivity{
    public static final String ITEM_OBJECT = "com.billbalancer.android.billbalancer.list_item_object";
    public static final String ITEM_CREATE = "com.billbalancer.android.billbalancer.bill_item_create";
    public static final String ITEM_UPDATE = "com.billbalancer.android.billbalancer.bill_item_update";

    protected boolean isItemCreate(){
        return getIntent().getBooleanExtra(ITEM_CREATE, false);
    }

    protected void renderFragment(Bundle bundle) {
        Fragment fragment = createFragment();
        fragment.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    protected Bundle createBundle() {
        Bundle bundle = new Bundle();
        if (isItemCreate()) {
            bundle.putSerializable(ITEM_OBJECT, createModel());
        }else {
            bundle.putSerializable(ITEM_OBJECT, getIntent().getSerializableExtra(ITEM_OBJECT));
        }
        return bundle;
    }

    protected abstract Model createModel();
    protected abstract Fragment createFragment();
}
