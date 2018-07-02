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
import com.example.jokesourcelibrary.FunnyJokesSource;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncEndpoint.AfterJokeLoad {

    @BindView(R.id.pb_loading_indicator)
    ProgressBar progressBar;
    @BindView(R.id.btn_tell_joke)
    Button btnTellJoke;
    @BindView(R.id.tv_instructions)
    TextView tvInstructions;
    @BindView(R.id.adView)
    AdView mAdView;

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    public String mJoke;
    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(LOG_TAG, "MSG! onCreateView()");

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        btnTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });
        return root;
    }

    public void tellJoke() {
        Log.i(LOG_TAG, "MSG! tellJoke()");

        setVisibilities(true);

        new AsyncEndpoint(this).execute();
    }

    @Override
    public void jokeLoaded(String joke) {
        Log.i(LOG_TAG, "MSG! jokeLoaded()");



        mJoke = joke;
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_KEY, joke);

        startActivity(intent);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d(LOG_TAG, "MSG! The interstitial wasn't loaded yet.");
        }

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
