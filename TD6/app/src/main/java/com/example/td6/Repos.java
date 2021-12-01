package com.example.td6;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repos {
    @SerializedName("items")
    public List<Repo> repos;

    public Repos(List<Repo> repos) {
        this.repos = repos;
    }

    public List<Repo> getRepos() {
        return repos;
    }

    public void setRepos(List<Repo> repos) {
        this.repos = repos;
    }
}
