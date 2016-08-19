package billbalancer.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import billbalancer.app.model.Bill;
import billbalancer.app.model.Model;
import billbalancer.app.model.repository.BillRepository;


public class BillListFragment extends Fragment {

    private RecyclerView mBillRecyclerView;
    private BillAdapter mAdapter;
    private Bill mBill;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill_list, container, false);

        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.add_bill);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBill = new Bill();
                Intent intent = BillActivity.getBillActivityIntent(view.getContext(), mBill, true);
                startActivity(intent);

            }
        });
        mBillRecyclerView = (RecyclerView) view.findViewById(R.id.bill_recycler_view);
        mBillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        BillRepository repository = (BillRepository) BillRepository.getInstance(getActivity());
        List<Model> bills = repository.getAll();

        if (mAdapter == null) {
            mAdapter = new BillAdapter(bills);
            mBillRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setBills(bills);
            mAdapter.notifyDataSetChanged();
        }
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

        public void bindBill(Bill bill) {
            mBill = bill;
            mBillNameView.setText(bill.getTitle());
            mBillTotalView.setText(bill.getTotal().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = BillActivity.getBillActivityIntent(v.getContext(), mBill, false);
            startActivity(intent);
        }
    }

    private class BillAdapter extends RecyclerView.Adapter<BillHolder> {
        private List<Model> mBills;

        public BillAdapter(List<Model> bills) {
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
            Bill bill = (Bill) mBills.get(position);
            holder.bindBill(bill);
        }

        @Override
        public int getItemCount() {
            return mBills.size();
        }

        public void setBills(List<Model> bills) {
            mBills = bills;
        }
    }
}
