package com.example.td6;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    public static final String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    List<Repo> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);
}
