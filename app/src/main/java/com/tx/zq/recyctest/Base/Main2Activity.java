package com.tx.zq.recyctest.Base;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringChain;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.tx.zq.recyctest.R;

import java.util.List;
import java.util.Random;

public class Main2Activity extends BaseActivity implements SpringListener {

    private ImageView iv;
    private RelativeLayout containerRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        containerRl = (RelativeLayout) findViewById(R.id.container);
        //随机色

        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);

        containerRl.setBackgroundColor(Color.argb(255, red, green, blue));
     //   containerRl.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        iv = (ImageView) findViewById(R.id.iv);


    }

    public void a(View w) {
        SpringChain springChain = SpringChain.create(40, 6, 50, 7);
        int childCount = containerRl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = containerRl.getChildAt(i);

            springChain.addSpring(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    //   view.setRotationX((float) spring.getCurrentValue());
                    //  view.setTranslationY((float) spring.getCurrentValue());

                }
            });
        }

        List<Spring> springs = springChain.getAllSprings();
        for (int i = 0; i < springs.size(); i++) {
            springs.get(i).setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(40, 1));
           //  springs.get(i).setCurrentValue(1);
        }

        springChain.setControlSpringIndex(0).getControlSpring().setEndValue(0);


//        SpringSystem springSystem = SpringSystem.create();
//        Spring spring = springSystem.createSpring();
//        spring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(100, 1));
//        SpringChain chain=SpringChain.create(40,6,50,7);
//
//
//        spring.addListener(new SimpleSpringListener() {
//
//            @Override
//            public void onSpringUpdate(Spring spring) {
//                float value = (float) spring.getCurrentValue();
//                float scale = 1f - (value * 0.5f);
//                iv.setScaleX(scale);
//                iv.setScaleY(scale);
//            }
//        });
//        Log.d(";;;", ":::");
//        spring.setEndValue(1);
    }

    @Override
    public void onSpringUpdate(Spring spring) {


    }

    @Override
    public void onSpringAtRest(Spring spring) {

    }

    @Override
    public void onSpringActivate(Spring spring) {

    }

    @Override
    public void onSpringEndStateChange(Spring spring) {

    }
}
