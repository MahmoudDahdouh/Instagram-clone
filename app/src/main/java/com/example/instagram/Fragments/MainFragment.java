package com.example.instagram.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instagram.Listeners.OnFragmentInteractionListener;
import com.example.instagram.MainActivity;
import com.example.instagram.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends Fragment {


    private static final String ARG_INDEX = "ARG_INDEX";
    private static final String ARG_PAGE_ID = "ARG_PAGE_ID";

    private String mIndex;
    private String mPageId;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance(int index, int pageId) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        args.putInt(ARG_PAGE_ID, pageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


        if (getArguments() != null) {
            mIndex = getArguments().getString(ARG_INDEX);
            mPageId = getArguments().getString(ARG_PAGE_ID);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // main fragment
        getFragmentManager().beginTransaction()
                .add(R.id.main_fragment_container, new TimelineFragment())
                .commit();

//        Tool bar main fragment
        Toolbar toolbar = v.findViewById(R.id.main_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.toolbar_direct) {
                    MainActivity.viewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_camera);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "camera", Toast.LENGTH_SHORT).show();
                MainActivity.viewPager.setCurrentItem(0);

            }
        });


        // Bottom Navigation
        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.btm_nav_home:
                        selectedFragment = new TimelineFragment();
                        break;                    case R.id.btm_nav_search:
                        selectedFragment = new ExploreFragment();
                        break;                    case R.id.btm_nav_add:
                        selectedFragment = new AddFragment();
                        break;                    case R.id.btm_nav_activity:
                        selectedFragment = new ActivityFragment();
                        break;                    case R.id.btm_nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment_container,selectedFragment)
                        .commit();

                return true;
            }
        });
        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
