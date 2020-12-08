package com.example.project_android;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyTabAdapter  extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyTabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home Tab1 = new Home();
                return Tab1;
            case 1:
                Grocery Tab2 = new Grocery();
                return Tab2;
            case 2:
                MyList Tab3 = new MyList();
                return Tab3;
            case 3:
                Contact Tab4 = new Contact();
                return Tab4;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
