package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.example.instagram.Listeners.OnFragmentInteractionListener;
import com.example.instagram.Fragments.CameraFragment;
import com.example.instagram.Fragments.DirectFragment;
import com.example.instagram.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    public static ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         viewPager = findViewById(R.id.view_pager);
        int[] pages = new int[]{
                R.layout.fragment_camera,
                R.layout.fragment_main,
                R.layout.fragment_direct
        };
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(myFragmentAdapter);
        viewPager.setCurrentItem(1);

    }


        @Override
        public void onFragmentInteraction(Uri uri) {

        }


    //class Fragment Page Adapter
    class MyFragmentAdapter extends FragmentPagerAdapter {
        int[] pages;

        public MyFragmentAdapter(FragmentManager fm, int[] pages) {
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return CameraFragment.newInstance(position, pages[position]);
                case 1:
                    return MainFragment.newInstance(position, pages[position]);
                case 2:
                    return DirectFragment.newInstance(position, pages[position]);
            }
            return MainFragment.newInstance(position, pages[position]);
        }

        @Override
        public int getCount() {
            return pages.length;
        }

    }


}
