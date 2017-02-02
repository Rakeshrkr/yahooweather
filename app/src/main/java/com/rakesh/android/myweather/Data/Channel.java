package com.rakesh.android.myweather.Data;

import org.json.JSONObject;

/**
 * Created by rakesh1 on 6/27/2016.
 */
public class Channel implements JSONPopulator {
    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    private Units units ;
    private Item item ;
    @Override
    public void Populate(JSONObject data) {
        units = new Units();
        units.Populate(data.optJSONObject("units"));

        item = new Item();
        item.Populate(data.optJSONObject("item"));



    }
}
