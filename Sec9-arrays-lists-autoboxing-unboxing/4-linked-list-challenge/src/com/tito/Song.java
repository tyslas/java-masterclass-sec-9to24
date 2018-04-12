package com.tito;

import java.util.ArrayList;

public class Song {
  private String title;
  private int durationInSeconds;

  public Song(String title, int durationInSeconds) {
    this.title = title;
    this.durationInSeconds = durationInSeconds;
  }

  public Song createSong(String title, int durationInSeconds) {
    return new Song(title, durationInSeconds);
  }

  public String getTitle() {
    return title;
  }

  public int getDurationInSeconds() {
    return durationInSeconds;
  }
}
