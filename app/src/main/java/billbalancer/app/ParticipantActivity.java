package billbalancer.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;

import billbalancer.app.model.Model;
import billbalancer.app.model.Participant;

public class ParticipantActivity extends  ListItemActivity{

    public static Intent getActivityIntent(Context packageContext, Serializable item, boolean isCreate) {
        Intent i = new Intent(packageContext, ParticipantActivity.class);

        i.putExtra(ITEM_OBJECT, item);
        if (isCreate) {
            i.putExtra(ITEM_CREATE, true);
        } else {
            i.putExtra(ITEM_UPDATE, true);
        }

        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        renderFragment(createBundle());
    }

    @Override
    protected Model createModel() {
        return new Participant();
    }

    @Override
    protected Fragment createFragment() {
        return new ParticipantFragment();
    }
}
