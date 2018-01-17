package com.sapient.androidtask.data;

/**
 * Created by ramit on 17/01/18.
 */

public class HomeDataItem {
    private String stringId;
    private String order;
    private String stringToBeFormatted;
    private String formattedString;

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStringToBeFormatted() {
        return stringToBeFormatted;
    }

    public void setStringToBeFormatted(String stringToBeFormatted) {
        this.stringToBeFormatted = stringToBeFormatted;
    }

    public String getFormattedString() {
        return formattedString;
    }

    public void setFormattedString(String formattedString) {
        this.formattedString = formattedString;
    }
}
