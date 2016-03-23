package com.administrator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import com.library.StickHeaderViewPager;
import com.library.StickHeaderViewPager.StickHeaderViewPagerBuilder;

public class SimpleActivity extends FragmentActivity {

    StickHeaderViewPager shvp_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        shvp_content = (StickHeaderViewPager) findViewById(R.id.shvp_content);
        setData();
    }

    private void setData() {

        final ScrollViewSimpleFragment scrollViewSimpleFragment = ScrollViewSimpleFragment.newInstance();

        StickHeaderViewPagerBuilder.stickTo(shvp_content)
                .setFragmentManager(getSupportFragmentManager())
                .addScrollFragments(scrollViewSimpleFragment)
                .notifyData();

        scrollViewSimpleFragment.setCallBack(new ScrollViewSimpleFragment.CallBack() {
            @Override
            public void bindData() {
                ScrollView scrollView = scrollViewSimpleFragment.getScrollView();
                if(scrollView != null){
                    scrollView.setBackgroundColor(Color.parseColor("#000000"));
                    TextView tv_title = (TextView)scrollView.findViewById(R.id.tv_title);
                    TextView tv_data = (TextView)scrollView.findViewById(R.id.tv_data);
                     tv_data.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
    }
}
