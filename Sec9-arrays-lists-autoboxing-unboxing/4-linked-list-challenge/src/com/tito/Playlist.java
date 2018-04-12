package com.tito;

import java.util.LinkedList;

public class Playlist {
  private String title;
  private LinkedList<Song> songs;

  public Playlist(String title) {
    this.title = title;
    this.songs = new LinkedList<Song>();
  }

  public void addSongToPlaylist(Song song) {
    songs.add(song);
  }

  public String getTitle() {
    return title;
  }

  public LinkedList<Song> getSongs() {
    return songs;
  }
}
