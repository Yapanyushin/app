package billbalancer.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import billbalancer.app.model.Participant;
import billbalancer.app.model.repository.ParticipantRepository;
import billbalancer.app.model.repository.Repository;

public class ParticipantFragment extends ListItemFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        mModel = (Participant) arguments.getSerializable(ListItemActivity.ITEM_OBJECT);
        View v = inflater.inflate(R.layout.fragment_participant, container, false);
        setupListeners(v);

        return v;
    }

    @Override
    Repository getRepository() {
        return ParticipantRepository.getInstance(getActivity());
    }

    protected void setupListeners(View v) {
        super.setupListeners(v);
        EditText nameField = (EditText) v.findViewById(R.id.participant_name);
        if(mModel.isValid()) {
            nameField.setText(((Participant)mModel).getName());
        }

        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((Participant)mModel).setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
