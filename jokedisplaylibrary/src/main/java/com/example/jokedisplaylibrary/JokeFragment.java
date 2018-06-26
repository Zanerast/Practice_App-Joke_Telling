package com.example.jokedisplaylibrary;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Zane on 25/06/2018.
 */

public class JokeFragment extends Fragment {

    public JokeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);

        TextView tvJoke = view.findViewById(R.id.tv_joke);
        if (joke != null) {
            tvJoke.setText(joke);
        }

        return view;
    }
}
