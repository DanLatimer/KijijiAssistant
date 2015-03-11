package com.danlatimer.android.kijiji.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.danlatimer.android.kijiji.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class AdDescriptionFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment AdDescriptionFragment.
     */
    public static AdDescriptionFragment newInstance() {
        AdDescriptionFragment fragment = new AdDescriptionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public String getTitle() {
        // TODO: return ad's title
        return "Sample Advertisement";
    }

    public AdDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ad_description, container, false);
    }

}
