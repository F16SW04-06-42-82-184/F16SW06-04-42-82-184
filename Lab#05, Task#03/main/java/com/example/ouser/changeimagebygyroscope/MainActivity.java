package com.example.ouser.changeimagebygyroscope;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ImageView img;
    int imgArr[] = {R.drawable.dragontales, R.drawable.looneytoons, R.drawable.powerpuff_girls, R.drawable.tomandjerry, R.drawable.tweety};
    int count=0;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.values[0] > 0.5f){
            if(count <4 ){
                count++;
                img.setImageResource(imgArr[count]);
            }
        }

        else if(event.values[1] > 0.5f){
            if(count >0){
                count--;
                img.setImageResource(imgArr[count]);
            }
        }

        else if(event.values[2] > 0){
            if(count < 4 ){
                count++;
                img.setImageResource(imgArr[count]);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
