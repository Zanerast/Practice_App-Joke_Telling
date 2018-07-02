package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jokedisplaylibrary.JokeDisplayActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment implements AsyncEndpoint.AfterJokeLoad {


    @BindView(R.id.pb_loading_indicator)
    ProgressBar progressBar;
    @BindView(R.id.btn_tell_joke)
    Button btnTellJoke;
    @BindView(R.id.tv_instructions)
    TextView tvInstructions;

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    public String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        btnTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {

        setVisibilities(true);

        new AsyncEndpoint(this).execute();
    }

    @Override
    public void jokeLoaded(String joke) {

        setVisibilities(false);

        mJoke = joke;
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_KEY, joke);

        startActivity(intent);

        setVisibilities(false);

    }

    private void setVisibilities(boolean loading) {

        if (loading) {
            tvInstructions.setVisibility(View.INVISIBLE);
            btnTellJoke.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            tvInstructions.setVisibility(View.VISIBLE);
            btnTellJoke.setVisibility(View.VISIBLE);
        }
    }
}
