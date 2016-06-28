package billbalancer.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import billbalancer.app.model.Bill;
import billbalancer.app.model.BillStorage;


public class BillListFragment extends Fragment{
    private RecyclerView mBillRecyclerView;
    private BillAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill_list, container, false);

        mBillRecyclerView = (RecyclerView) view.findViewById(R.id.bill_recycler_view);
        mBillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        BillStorage storage = BillStorage.getInstance(getActivity());
        List<Bill> bills = storage.getBills();

        mAdapter = new BillAdapter(bills);
        mBillRecyclerView.setAdapter(mAdapter);
    }

    private class BillHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mBillNameView;
        private TextView mBillTotalView;
        private TextView mBillDateView;
        private Bill mBill;

        public BillHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mBillNameView = (TextView) itemView.findViewById(R.id.list_item_bill_name);
            mBillTotalView = (TextView) itemView.findViewById(R.id.list_item_bill_total);
            mBillDateView = (TextView) itemView.findViewById(R.id.list_item_bill_date);
        }

        public void bindBill(Bill bill){
            mBill = bill;
            mBillNameView.setText(bill.getName());
            mBillTotalView.setText(bill.getTotal().toString());
            mBillDateView.setText(bill.getCreatedAt().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), BillActivity.class);
            startActivity(intent);
        }
    }

    private class BillAdapter extends RecyclerView.Adapter<BillHolder> {
        private List<Bill> mBills;

        public BillAdapter(List<Bill> bills) {
            mBills = bills;
        }

        @Override
        public BillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_bill, parent, false);
            return new BillHolder(view);
        }

        @Override
        public void onBindViewHolder(BillHolder holder, int position) {
            Bill bill = mBills.get(position);
            holder.bindBill(bill);
        }

        @Override
        public int getItemCount() {
            return mBills.size();
        }
    }
}
