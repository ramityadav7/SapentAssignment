package com.sapient.androidtask.data;

import java.util.List;

/**
 * Created by ramit on 17/01/18.
 */

public class HomeData {
    private String pageName;
    private List<HomeDataItem> data = null;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<HomeDataItem> getData() {
        return data;
    }

    public void setData(List<HomeDataItem> data) {
        this.data = data;
    }
}
