package billbalancer.app;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;

import billbalancer.app.model.Model;
import billbalancer.app.model.repository.Repository;

public abstract class ListItemFragment extends Fragment {
    protected Model mModel;

    abstract Repository getRepository();

    protected void setupListeners(View v) {
        setupSaveButtonListener(v);
        setupRemoveButtonListener(v);
    }

    private void setupSaveButtonListener(View v) {
        ImageButton saveButton = (ImageButton) v.findViewById(R.id.item_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Repository repo = getRepository();
                if (mModel.isValid()) {
                    if (repo.contains(mModel)) {
                        repo.update(mModel);
                    } else {
                        repo.add(mModel);
                    }
                    getActivity().finish();
                }
            }
        });
    }

    private void setupRemoveButtonListener(View v) {
        ImageButton removeButton = (ImageButton) v.findViewById(R.id.item_remove_button);
        removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getRepository().remove(mModel);
                getActivity().finish();
            }
        });
    }
}
