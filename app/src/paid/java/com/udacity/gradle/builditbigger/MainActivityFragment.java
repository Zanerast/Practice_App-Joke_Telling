package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jokedisplaylibrary.JokeDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncEndpoint.AfterJokeLoad {

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    public String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(LOG_TAG, "MSG! onCreateView()");

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnLaunchJokeLib = root.findViewById(R.id.btn_tell_joke);
        btnLaunchJokeLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {
        Log.i(LOG_TAG, "MSG! tellJoke()");

        new AsyncEndpoint(this).execute();
    }

    @Override
    public void jokeLoaded(String joke) {
        Log.i(LOG_TAG, "MSG! jokeLoaded()");

        mJoke = joke;
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_KEY, joke);

        startActivity(intent);
    }
}
