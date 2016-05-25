package com.mileapps.androidanimations.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mileapps.androidanimations.R;

public class ScreenSlidePageFragment extends Fragment {

    private TextView txtNumberPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        txtNumberPage = (TextView) rootView.findViewById(R.id.txtNumberPage);
        int mPageNumber = getArguments().getInt("numberPage");
        txtNumberPage.setText(getString(R.string.title_template_step, mPageNumber));
        return rootView;
    }

    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt("numberPage", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
