package com.tx.zq.recyctest.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.tx.zq.recyctest.R;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/4/13.
 */
public class BaseActivity extends Activity implements SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout slid;
    private FrameLayout mContainerFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            slid = new SlidingPaneLayout(this);

            Field filed = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
            filed.setAccessible(true);
            filed.set(slid, 0);
            slid.setPanelSlideListener(this);
           // slid.setSliderFadeColor(getResources().getColor(android.R.color.transparent));

        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);

        //添加两个view,这是左侧菜单，因为Activity是透明的，这里就不用设置了
        View leftView = new View(this);
        //设置全屏
        leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //添加到SlidingPaneLayout中
        slid.addView(leftView, 0);


        //内容布局，用来存放Activity布局用的
        mContainerFl = new FrameLayout(this);
        //内容布局不应该是透明，这里加了白色背景   mContainerFl.setBackgroundColor(getResources().getColor(android.R.color.white));
        //全屏幕显示
        mContainerFl.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //添加到SlidingPaneLayout中


        slid.addView(mContainerFl, 1);

    }

    @Override
    public void setContentView(int id) {
        setContentView(getLayoutInflater().inflate(id, null));
    }
    @Override
    public void setContentView(View v) {
        setContentView(v, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View v, ViewGroup.LayoutParams params) {
        super.setContentView(slid, params);

        mContainerFl.removeAllViews();
        mContainerFl.addView(v, params);
    }


    @Override
    public void onPanelSlide(View panel, float slideOffset) {

    }

    @Override
    public void onPanelOpened(View panel) {
        finish();
        this.overridePendingTransition(0, R.anim.slide_out_right);

    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
