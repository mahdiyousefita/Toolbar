package com.example.toolbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;


public class CollapsingToolbarFragment extends Fragment {

    private View view;
    private ImageButton imageButtonBack;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private TextView textView;

    public static CollapsingToolbarFragment newInstance() {
        CollapsingToolbarFragment fragment = new CollapsingToolbarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_collapsing_toolbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.view = view;
        init();

        setupCollapsingToolbar();

    }

    private void init(){
        imageButtonBack = view.findViewById(R.id.imageButtonBack);
        appBarLayout = view.findViewById(R.id.appbarLayout);
        toolbar = view.findViewById(R.id.toolbar);
        textView = view.findViewById(R.id.textView);
    }

    private void setupCollapsingToolbar(){
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        assert appCompatActivity != null;
        appCompatActivity.setSupportActionBar(toolbar);
        toolbar.setTitle("");

        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            // shows the imageView when the Collapsing View is scrolled...
            if (verticalOffset == (appBarLayout.getTotalScrollRange() * -1)) {
                imageButtonBack.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }else {
                imageButtonBack.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
            }
        });
    }
}