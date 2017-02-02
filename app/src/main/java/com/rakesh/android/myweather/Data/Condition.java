package com.rakesh.android.myweather.Data;

import org.json.JSONObject;

/**
 * Created by rakesh1 on 6/27/2016.
 */
public class Condition implements JSONPopulator {
    private int code ;

    public int getCode() {
        return code;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    private int temperature ;
    private String description ;


    @Override

    public void Populate(JSONObject data) {

        code = data.optInt("code");
        temperature = data.optInt("temp") ;
        description = data.optString("text") ;

    }
}
