package com.sapient.androidtask.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by ramit on 09/01/18.
 */

public class AppUtil {

    //Check Collection for Empty
    public static boolean isCollectionEmpty(Collection<? extends Object> collection)
    {
        if(collection == null || collection.isEmpty())
        {
            return true;
        }

        return false;
    }

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try
        {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
