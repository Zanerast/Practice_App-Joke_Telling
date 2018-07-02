package com.udacity.gradle.builditbigger;

import org.junit.Assert;
import org.junit.Test;

public class TestAsyncTask {



    @Test
    public void loadAsync() throws InterruptedException {
        new AsyncEndpoint(null).execute();

        Thread.sleep(5000);

        Assert.assertNotNull(AsyncEndpoint.mJoke);
    }
}
