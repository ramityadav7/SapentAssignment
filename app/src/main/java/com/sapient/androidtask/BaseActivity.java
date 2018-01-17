package com.sapient.androidtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ramit on 17/01/18.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setup Component
        setupComponent(AssignmentApp.get(this).component());
    }

    //Create Abstract Method for initializing Activity References
    protected abstract void setupComponent(AssignmentAppComponent component);
}
