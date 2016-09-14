package billbalancer.app;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import billbalancer.app.model.Model;
import billbalancer.app.model.Participant;
import billbalancer.app.model.repository.ParticipantRepository;
import billbalancer.app.model.repository.Repository;

public class ParticipantListFragment extends ItemListFragment{

    @Override
    protected View.OnClickListener createAddItemOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ParticipantActivity.getActivityIntent(view.getContext(), new Participant(), true ));
            }
        };
    }

    @Override
    protected final Repository getItemRepository() {
        return ParticipantRepository.getInstance(getActivity());
    }

    @Override
    protected ItemAdapter createAdapter(List<Model> items) {
        return new ParticipantAdapter(items);
    }

    private final class ParticipantHolder extends ItemViewHolder {
        private TextView mParticipantNameView;
        private Participant mParticipant;

        public ParticipantHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mParticipantNameView = (TextView) itemView.findViewById(R.id.list_item_participant_name);
        }

        @Override
        void bindItem(Model item) {
            mParticipant = (Participant) item;
            mParticipantNameView.setText(mParticipant.getName());
        }

        @Override
        public void onClick(View v) {
            startActivity(ParticipantActivity.getActivityIntent(v.getContext(), mParticipant, false));
        }
    }

    private final class ParticipantAdapter extends ItemAdapter {

        public ParticipantAdapter(List<Model> items) {
            super(items);
        }

        @Override
        protected int getItemLayout() {
            return R.layout.list_item_participant;
        }

        @Override
        protected ItemViewHolder createViewHolder(View v) {
            return new ParticipantHolder(v);
        }
    }


}
