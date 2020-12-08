package com.example.project_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout=(TabLayout)findViewById(R.id.tabLayoutID);
        viewPager=(ViewPager)findViewById(R.id.viewPagerID);
        TabLayout.Tab home = tabLayout.newTab();
        home.setIcon(R.drawable.home);
        home.setText("Home");
        tabLayout.addTab(home);

        TabLayout.Tab list = tabLayout.newTab();
        list.setIcon(R.drawable.list);
        list.setText("Grocery");
        tabLayout.addTab(list);

        TabLayout.Tab cart = tabLayout.newTab();
        cart.setIcon(R.drawable.cart);
        cart.setText("Cart");
        tabLayout.addTab(cart);

        TabLayout.Tab con = tabLayout.newTab();
        con.setIcon(R.drawable.phone);
        con.setText("Contact");
        tabLayout.addTab(con);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyTabAdapter adapter = new MyTabAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}