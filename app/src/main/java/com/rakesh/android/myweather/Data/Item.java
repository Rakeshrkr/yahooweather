package com.rakesh.android.myweather.Data;

import org.json.JSONObject;

/**
 * Created by rakesh1 on 6/27/2016.
 */
public class Item implements JSONPopulator {
    public Condition getCondition() {
        return condition;
    }

    private Condition condition ;

    @Override
    public void Populate(JSONObject data) {
         condition = new Condition();
         condition.Populate(data.optJSONObject("condition"));
    }
}
