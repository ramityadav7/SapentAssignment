package com.sapient.androidtask;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramit on 17/01/18.
 */
@Module
public class AssignmentAppModule {

    private final AssignmentApp assignmentApp;

    public AssignmentAppModule(AssignmentApp assignmentApp)
    {
        this.assignmentApp = assignmentApp;
    }

    @Provides
    public AssignmentApp provideApplication(){
        return assignmentApp;
    }

}
