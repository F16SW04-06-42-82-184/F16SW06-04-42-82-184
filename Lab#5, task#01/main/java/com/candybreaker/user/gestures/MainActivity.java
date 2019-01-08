package com.candybreaker.user.gestures;

import android.media.Image;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {
    public static int count=0;
    private static final int SWIPE_MIN_DISTANCE = 150;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;
    GestureDetectorCompat gesture;
    ScaleGestureDetector scale;
    public float Scaling=1f;
    public float onScaleBegin =0f;
    public float onScaleEnd =0f;

   // TextView tv;
    ImageView im;
    private int[] images = {
            R.drawable.girl1,
            R.drawable.girl2,
            R.drawable.girl3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        im = (ImageView)findViewById(R.id.imv);
        gesture= new GestureDetectorCompat(this, this);
        gesture.setOnDoubleTapListener(this);
        scale = new ScaleGestureDetector(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gesture.onTouchEvent(event);
        scale.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
       //tv.setText("Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //tv.setText("Show Press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //tv.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE ) {
            onSwipeLeft();
            return true;
        }
        else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE ) {
            onSwipeRight();
            return true;
        }

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    public void onSwipeLeft(){

        count--;
        if(count==-1){
            count=2;
        }
        im.setImageResource(images[count]);
        Log.i("Left", "count"+count);

    }

    public void onSwipeRight(){

        count++;
        if(count>2){
            count=0;
        }
        im.setImageResource(images[count]);
        Log.i("Right", "count"+count);

    }


    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        Scaling*=detector.getScaleFactor();
        Scaling=Math.max( 0.1f, Math.min(Scaling, 5f));
        im.setScaleX(Scaling);
        im.setScaleY(Scaling);
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        onScaleBegin=Scaling;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        onScaleEnd=Scaling;

    }
}
