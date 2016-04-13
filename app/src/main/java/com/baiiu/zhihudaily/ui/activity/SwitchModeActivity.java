package com.baiiu.zhihudaily.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.baiiu.zhihudaily.R;
import com.baiiu.zhihudaily.util.Constant;

public class SwitchModeActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //requestWindowFeature(Window.FEATURE_NO_TITLE);
    //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    //    WindowManager.LayoutParams.FLAG_FULLSCREEN);

    Bitmap pic = Constant.bitmap;

    ImageView imageView = new ImageView(this);

    if (pic != null) {
      imageView.setImageBitmap(pic);
    }

    setContentView(imageView);

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
      }
    }, 500);

    //AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
    //alphaAnimation.setDuration(500);
    //alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
    //  @Override public void onAnimationStart(Animation animation) {
    //
    //  }
    //
    //  @Override public void onAnimationEnd(Animation animation) {
    //    finish();
    //    overridePendingTransition(0, 0);
    //  }
    //
    //  @Override public void onAnimationRepeat(Animation animation) {
    //
    //  }
    //});

    //imageView.startAnimation(alphaAnimation);
  }
}
