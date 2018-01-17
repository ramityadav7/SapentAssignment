package com.sapient.androidtask.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sapient.androidtask.AssignmentAppComponent;
import com.sapient.androidtask.BaseActivity;
import com.sapient.androidtask.R;
import com.sapient.androidtask.data.HomeData;
import com.sapient.androidtask.data.HomeDataItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeListActivity extends BaseActivity implements HomeView{

    @Bind(R.id.recyclerViewHome) RecyclerView recyclerViewHome;

    @Inject
    HomePresenter homePresenter;

    private HomeData homeData;

    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeView();

        loadData();
    }

    private void initializeView()
    {
        homeData = new HomeData();
        HomeDataItem homeDataItem = new HomeDataItem();
        homeDataItem.setFormattedString("sample string");
        List<HomeDataItem> homeDataItems = new ArrayList<>();
        homeDataItems.add(homeDataItem);
        homeData.setData(homeDataItems);
        homeAdapter = new HomeAdapter(homeDataItems);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHome.setLayoutManager(mLayoutManager);
        recyclerViewHome.setAdapter(homeAdapter);
    }

    private void loadData()
    {
//        homePresenter = new HomePresenterImpl(this);
        homePresenter.getHomeData();
    }

    @Override
    public void populateHomeData(HomeData homeData)
    {
        List<HomeDataItem> homeDataItems = this.homeData.getData();
        List<HomeDataItem> newHomeDataItems = homeData.getData();

        homeDataItems.clear();
        homeDataItems.addAll(newHomeDataItems);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    protected void setupComponent(AssignmentAppComponent component) {
        DaggerHomeComponent.builder()
                .assignmentAppComponent(component)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
