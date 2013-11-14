package com.wayproyect.numeric_app.vistas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.wayproyect.numeric_app.R;

/**
 * Created with Wayproyect
 * User: Julio C. Ramos
 * Date: 10/11/13
 * Time: 05:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Splash_Screen extends Activity {

    private static final int SPLASH_DURATION = 3000; // 2 seconds

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler handler = new Handler();
        StartAnimations();

        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // make sure we close the splash screen so the user won't come back when it presses back key
                finish();

                // start the home screen if the back button wasn't pressed already
                Intent intent = new Intent(Splash_Screen.this, Menu.class);
                Splash_Screen.this.startActivity(intent);

            }
        }, SPLASH_DURATION); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
    }

    private void StartAnimations() {
        //Animar el Logo
        ImageView img_logo_splash = (ImageView) findViewById(R.id.logo);
        img_logo_splash.setVisibility(ImageView.VISIBLE);
        img_logo_splash.setBackgroundResource(R.drawable.splash_animation);
        final AnimationDrawable frame = (AnimationDrawable) img_logo_splash.getBackground();
        img_logo_splash.post(new Runnable() {
            public void run() {
                frame.start();
            }
        });
        //Animar el Titulo , desplazar desde arriba a abajo
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_splash_title);
        anim.reset();
        ImageView img_top_title = (ImageView) findViewById(R.id.top_title);
        img_top_title.clearAnimation();
        img_top_title.startAnimation(anim);
        //Desvanecer Qualisoft & Wayproyect
        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView img_botom = (ImageView) findViewById(R.id.botom);
        img_botom.clearAnimation();
        img_botom.startAnimation(anim);


        /*
        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        //LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
        //l.clearAnimation();
        //l.startAnimation(anim);
         */


    }
}