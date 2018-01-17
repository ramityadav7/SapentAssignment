package com.sapient.androidtask.home;

import com.sapient.androidtask.ActivityScope;
import com.sapient.androidtask.AssignmentAppComponent;

import dagger.Component;

/**
 * Created by ramit on 17/01/18.
 */
@ActivityScope
@Component(
        dependencies = AssignmentAppComponent.class,
        modules = {
                HomeModule.class
        }
)
public interface HomeComponent
{
        void inject(HomeListActivity activity);

//        HomePresenter getHomePresenter();
}
