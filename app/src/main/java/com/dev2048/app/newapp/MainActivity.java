package com.dev2048.app.newapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.dev2048.app.newapp.adapter.ViewPagerAdapter;
import com.dev2048.app.newapp.base.BaseActivity;
import com.dev2048.app.newapp.fragment.IndexFragment;
import com.dev2048.app.newapp.fragment.MeFragment;
import com.dev2048.app.newapp.fragment.SearchFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity{
    @BindView(R.id.viewpager)
    public ViewPager mViewPager;
    @BindView(R.id.navigation)
    public BottomNavigationView navigationView;
    //Fragment
    private IndexFragment indexFragment;
    private SearchFragment serachFragment;
    private MeFragment meFragment;

    MenuItem prevMenuItem;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  navigationView = (BottomNavigationView) findViewById(R.id.navigation);
       // mViewPager = (ViewPager)findViewById(R.id.viewpager);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPager();
    }


    protected void initViewPager() {
        addOnPageChangeListener(mViewPager);
        setupViewPager(mViewPager);
    }


    private void addOnPageChangeListener(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                navigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        indexFragment = new IndexFragment();
        serachFragment = new SearchFragment();
        meFragment = new MeFragment();
        adapter.addFragment(indexFragment);
        adapter.addFragment(serachFragment);
        adapter.addFragment(meFragment);
        viewPager.setAdapter(adapter);
    }
}
