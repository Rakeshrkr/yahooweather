package com.rakesh.android.myweather;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakesh.android.myweather.Data.Channel;
import com.rakesh.android.myweather.Data.Item;
import com.rakesh.android.myweather.Service.WeatherServiceCallBack;
import com.rakesh.android.myweather.Service.YahooWeatherService;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallBack {
    private ImageView weatherIconImageView ;
    private TextView temperatureTextView ;
    private TextView conditionTextView ;
    private TextView locationTextView ;

    private YahooWeatherService service ;
    private ProgressDialog progressDialog ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView)findViewById(R.id.temptaureTextView);
        conditionTextView = (TextView)findViewById(R.id.conditionTextView);
        locationTextView =(TextView)findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        service.refreshWeather("Powai,Mumbai");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

    }

    @Override
    public void serviceSuccess(Channel channel) {
        progressDialog.hide();
        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_"+ item.getCondition().getCode(),null,getPackageName());
        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);
        weatherIconImageView.setImageDrawable(weatherIconDrawable);
        conditionTextView.setText(item.getCondition().getDescription());
        temperatureTextView.setText(item.getCondition().getTemperature()+"\u00B0 "+ channel.getUnits().getTemperature());
        locationTextView.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception) {
        progressDialog.hide();
        Toast.makeText(this,exception.getMessage(),Toast.LENGTH_LONG).show();
    }
}
