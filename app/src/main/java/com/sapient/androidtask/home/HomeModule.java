package com.sapient.androidtask.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramit on 17/01/18.
 */
@Module
public class HomeModule {
    private final HomeView view;

    public HomeModule(HomeView view)
    {
        this.view = view;
    }

    @Provides
    HomeView provideHomeView() {
        return view;
    }

    @Provides
    HomePresenter provideHomePresenter(HomeView view){
        return new HomePresenterImpl(view);
    }
}
