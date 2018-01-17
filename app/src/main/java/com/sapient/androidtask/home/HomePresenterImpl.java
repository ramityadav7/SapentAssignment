package com.sapient.androidtask.home;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sapient.androidtask.data.HomeData;
import com.sapient.androidtask.data.HomeDataItem;
import com.sapient.androidtask.utils.AppUtil;

import java.util.List;

/**
 * Created by ramit on 17/01/18.
 */

public class HomePresenterImpl implements HomePresenter{
    private final HomeView homeView;

    public HomePresenterImpl(HomeView homeView)
    {
        this.homeView = homeView;
    }

    @Override
    public void getHomeData()
    {

        //In case of network call we can replace folling code by Retrofit network call

        final Handler handler = new Handler();

        //Starting a worker thread to perform heavy background operations
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                String jsonString = AppUtil.loadJSONFromAsset((Context) homeView);

                if(jsonString != null && jsonString.length() > 0)
                {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    final HomeData homeData = gson.fromJson(jsonString, HomeData.class);

                    prepareFormattedData(homeData);


                    //Posting on ui thread to update ui with processed data
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            homeView.populateHomeData(homeData);
                        }
                    });
                }
            }
        };

        thread.start();


    }

    private void prepareFormattedData(HomeData homeData)
    {
        List<HomeDataItem> homeDataItems = homeData.getData();
        if(!AppUtil.isCollectionEmpty(homeDataItems))
        {
            for(HomeDataItem homeDataItem: homeDataItems)
            {
                String formattedString = modifyString(homeDataItem.getStringToBeFormatted(), homeDataItem.getOrder().equals("odd"));
                homeDataItem.setFormattedString(formattedString);
            }
        }
    }

    private String modifyString(String stringToBeFormatted, boolean isOdd)
    {
        StringBuffer stringBuffer = new StringBuffer();

        String [] words = stringToBeFormatted.split(" ");

        int length = words.length;
        for(int iterator = 0; iterator < length ; iterator++)
        {

            StringBuffer tempBuffer = new StringBuffer(words[iterator]);

            if( (isOdd && iterator % 2 == 0) ||
                    (!isOdd && iterator % 2 == 1))
                tempBuffer.reverse();

            stringBuffer.append(tempBuffer);

            if(iterator < length-1)
                stringBuffer.append(" ");
        }

        return stringBuffer.toString();
    }
}
