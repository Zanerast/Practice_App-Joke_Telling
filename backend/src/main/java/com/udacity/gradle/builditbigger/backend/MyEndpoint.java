package com.udacity.gradle.builditbigger.backend;

import com.example.jokesourcelibrary.FunnyJokesSource;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "tellGreatJoke")
    public Joke tellGreatJoke() {

        Joke joke = new Joke();

        joke.setJoke(FunnyJokesSource.getJoke());

        return joke;
    }

}
