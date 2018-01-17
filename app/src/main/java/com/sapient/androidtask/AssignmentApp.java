package com.sapient.androidtask;

import android.app.Application;
import android.content.Context;

/**
 * Created by ramit on 17/01/18.
 */

public class AssignmentApp extends Application
{

    private AssignmentAppComponent assignmentAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeRmsAppComponentGraph();
    }

    private void initializeRmsAppComponentGraph() {
        assignmentAppComponent = DaggerAssignmentAppComponent.builder().assignmentAppModule(new AssignmentAppModule(this)).build();
        assignmentAppComponent.inject(this);
    }

    /**
     * Get Application Context
     *
     * @param context
     * @return AssignmentApp
     */
    public static AssignmentApp get(Context context) {
        return (AssignmentApp) context.getApplicationContext();
    }

    /**
     * Get Common Component
     *
     * @return AssignmentAppComponent
     */
    public AssignmentAppComponent component() {
        return assignmentAppComponent;
    }
}
