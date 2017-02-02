package com.rakesh.android.myweather.Service;

import com.rakesh.android.myweather.Data.Channel;

/**
 * Created by rakesh1 on 6/27/2016.
 */
public interface WeatherServiceCallBack {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);

}
