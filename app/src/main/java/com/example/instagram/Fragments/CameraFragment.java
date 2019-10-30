
        package com.example.instagram.Fragments;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.Listeners.OnFragmentInteractionListener;
import com.example.instagram.R;

public class CameraFragment extends Fragment {


    private static final String ARG_INDEX = "ARG_INDEX";
    private static final String ARG_PAGE_ID = "ARG_PAGE_ID";

    private String mIndex;
    private String mPageId;

    private OnFragmentInteractionListener mListener;

    public CameraFragment() {
        // Required empty public constructor
    }


    public static com.example.instagram.Fragments.CameraFragment newInstance(int index, int pageId) {
        com.example.instagram.Fragments.CameraFragment fragment = new com.example.instagram.Fragments.CameraFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        args.putInt(ARG_PAGE_ID, pageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getString(ARG_INDEX);
            mPageId = getArguments().getString(ARG_PAGE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_camera, container, false);
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
