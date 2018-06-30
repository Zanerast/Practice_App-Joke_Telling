package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class AsyncEndpoint extends AsyncTask<Void, Void, String> {
    private static final String LOG_TAG = AsyncEndpoint.class.getSimpleName();

    private static MyApi myApiService = null;

    public interface AfterJokeLoad{ void jokeLoaded(String joke); }

    private AfterJokeLoad mAfterJokeLoad;

    public AsyncEndpoint(AfterJokeLoad afterJokeLoad){
        this.mAfterJokeLoad = afterJokeLoad;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Log.i(LOG_TAG, "MSG! doInBackground()");

        if(myApiService == null) {
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setRootUrl("http://192.168.1.202:8080/_ah/api/")

                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            String joke = myApiService.tellGreatJoke().execute().getJoke();
            Log.i(LOG_TAG, "MSG! joke: " + joke);
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Log.i(LOG_TAG, "MSG! onPostExecute()");
        super.onPostExecute(joke);

        mAfterJokeLoad.jokeLoaded(joke);
    }


}
