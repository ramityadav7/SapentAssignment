package com.sapient.androidtask;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ramit on 17/01/18.
 */
@Singleton
@Component(modules = {AssignmentAppModule.class})
public interface AssignmentAppComponent {
    void inject(AssignmentApp app);

//    AssignmentApp getAssignmentApp();
}
