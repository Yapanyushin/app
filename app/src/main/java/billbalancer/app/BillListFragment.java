package billbalancer.app;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import billbalancer.app.model.Bill;
import billbalancer.app.model.Model;
import billbalancer.app.model.repository.BillRepository;
import billbalancer.app.model.repository.Repository;


public class BillListFragment extends ItemListFragment {

    @Override
    protected final View.OnClickListener createAddItemOnClickListener() {
       return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = BillActivity.getActivityIntent(view.getContext(), new Bill(), true);
                startActivity(intent);
            }
        };
    }

    @Override
    protected final Repository getItemRepository() {
        return BillRepository.getInstance(getActivity());
    }

    @Override
    protected final ItemAdapter createAdapter(List<Model> items) {
        return new BillAdapter(items);
    }

    private final class BillHolder extends ItemViewHolder {
        private TextView mBillNameView;
        private TextView mBillTotalView;
        private TextView mBillDateView;
        private Bill mBill;

        public BillHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mBillNameView  = (TextView) itemView.findViewById(R.id.list_item_bill_name);
            mBillTotalView = (TextView) itemView.findViewById(R.id.list_item_bill_total);
            mBillDateView  = (TextView) itemView.findViewById(R.id.list_item_bill_date);
        }

        @Override
        public void bindItem(Model model) {
            mBill = (Bill) model;
            mBillNameView.setText(mBill.getTitle());
            mBillTotalView.setText(mBill.getTotal().toString());
        }

        @Override
        public void onClick(View v) {
            startActivity(BillActivity.getActivityIntent(v.getContext(), mBill, false));
        }
    }

    private final class BillAdapter extends ItemAdapter {

        public BillAdapter(List<Model> items) {
            super(items);
        }

        @Override
        protected final int getItemLayout() {
            return R.layout.list_item_bill;
        }

        @Override
        protected final ItemViewHolder createViewHolder(View v) {
          return new BillHolder(v);
        }
    }
}
