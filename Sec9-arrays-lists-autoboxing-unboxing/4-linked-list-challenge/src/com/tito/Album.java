package com.tito;

import java.util.ArrayList;

public class Album {
  private String albumTitle;
  private ArrayList<Song> songs;

  public Album(String albumTitle) {
    this.albumTitle = albumTitle;
    this.songs = new ArrayList<Song>();
  }

  public void addSongToAlbum(Song song) {
    this.songs.add(song);
  }

  public String getAlbumTitle() {
    return albumTitle;
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }
}
