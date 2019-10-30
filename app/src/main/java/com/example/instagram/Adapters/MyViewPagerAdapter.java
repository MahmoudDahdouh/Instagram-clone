package com.example.instagram.Adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    int[] fragmentIds;

    public MyViewPagerAdapter( FragmentManager fm, int [] fragmentIds) {
        super(fm);
        this.fragmentIds = fragmentIds;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return fragmentIds.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

}
