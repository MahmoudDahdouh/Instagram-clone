package com.example.instagram.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instagram.Listeners.OnFragmentInteractionListener;
import com.example.instagram.MainActivity;
import com.example.instagram.R;


public class DirectFragment extends Fragment {


    private static final String ARG_INDEX = "ARG_INDEX";
    private static final String ARG_PAGE_ID = "ARG_PAGE_ID";

    private String mIndex;
    private String mPageId;

    private OnFragmentInteractionListener mListener;

    public DirectFragment() {
        // Required empty public constructor
    }


    public static DirectFragment newInstance(int index, int pageId) {
        DirectFragment fragment = new DirectFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        args.putInt(ARG_PAGE_ID, pageId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mIndex = getArguments().getString(ARG_INDEX);
            mPageId = getArguments().getString(ARG_PAGE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_direct, container, false);
        Toolbar toolbar = v.findViewById(R.id.direct_toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case android.R.id.home:
                        MainActivity.viewPager.setCurrentItem(1);
                        return true;
                    case R.id.direct_toolbar_create_group:
                        Toast.makeText(getActivity(), "Create Group", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.direct_toolbar_video:
                        Toast.makeText(getActivity(), "Video camera", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "camera", Toast.LENGTH_SHORT).show();
                MainActivity.viewPager.setCurrentItem(1);
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
