package com.sapient.androidtask.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sapient.androidtask.R;
import com.sapient.androidtask.data.HomeDataItem;
import com.sapient.androidtask.utils.AppUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ramit on 17/01/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeItemHolder>{

    private List<HomeDataItem> homeDataItems;

    public HomeAdapter(List<HomeDataItem> homeDataItems)
    {
        this.homeDataItems = homeDataItems;
    }

    @Override
    public int getItemCount() {
        return AppUtil.isCollectionEmpty(homeDataItems) ? 0 : homeDataItems.size();
    }

    @Override
    public HomeItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);

        return new HomeItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeItemHolder holder, int position) {

        HomeDataItem homeDataItem = homeDataItems.get(position);
        holder.textViewItem.setText(homeDataItem.getFormattedString());

    }

    public class HomeItemHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.textViewItem)
        TextView textViewItem;

        public HomeItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
