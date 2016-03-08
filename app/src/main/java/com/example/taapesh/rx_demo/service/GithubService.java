package com.example.taapesh.rx_demo.service;

import com.example.taapesh.rx_demo.model.Github;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GithubService {
    String SERVICE_ENDPOINT = "https://api.github.com";
    String CREDENTIALS = "?client_id=3e0c7b63bfbbc9c462fe&client_secret=56efd3e08b7b04677d68dc621ba9bf0fcb24a727";

    // Add client id and secret to increase rate limit (for testing purposes only)
    @GET("/users/{login}" + CREDENTIALS)
    Observable<Github> getUser(@Path("login") String login);
}
