package com.rakesh.android.myweather.Data;

import org.json.JSONObject;

/**
 * Created by rakesh1 on 6/27/2016.
 */
public class Units implements JSONPopulator {

    private String temperature ;

    public String getTemperature() {
        return temperature;
    }

    @Override

    public void Populate(JSONObject data) {
     temperature = data.optString("temperature") ;
    }
}
