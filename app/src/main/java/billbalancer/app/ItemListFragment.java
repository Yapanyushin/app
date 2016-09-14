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

import java.util.List;

import billbalancer.app.model.Model;
import billbalancer.app.model.repository.Repository;

public abstract class ItemListFragment extends Fragment{
    protected RecyclerView mRecyclerView;
    protected ItemAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getListLayout(), container, false);
        createAddItemButton(view);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        Repository repository = getItemRepository();
        List<Model> items = repository.getAll();

        if (mAdapter == null) {
            mAdapter = createAdapter(items);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setItems(items);
            mAdapter.notifyDataSetChanged();
        }
    }

    private void createAddItemButton(View view) {
        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.add_item);
        button.setOnClickListener(createAddItemOnClickListener());
    }

    protected int getListLayout() {
        return  R.layout.fragment_item_list;
    };

    protected abstract View.OnClickListener createAddItemOnClickListener();
    protected abstract Repository getItemRepository();
    protected abstract ItemAdapter createAdapter(List<Model> items);



    protected abstract class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        abstract void bindItem(Model item);
    }
    


    protected abstract class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        protected List<Model> mItems;
        
        public ItemAdapter(List<Model> items) {
            mItems = items;
        }
        
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(getItemLayout(), parent, false); 
            return createViewHolder(view);
        }
        
        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Model item = mItems.get(position);
            holder.bindItem(item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void setItems(List<Model> items) {
            mItems = items;
        }

        protected abstract int getItemLayout();
        protected abstract ItemViewHolder createViewHolder(View v);
    }

}
