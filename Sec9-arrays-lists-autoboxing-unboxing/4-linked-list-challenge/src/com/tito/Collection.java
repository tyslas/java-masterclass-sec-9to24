package com.tito;

import java.util.ArrayList;

public class Collection {
  private String name;
  private ArrayList<Album> collections;

  public Collection(String name) {
    this.name = name;
    this.collections = new ArrayList<Album>();
  }

  public void addAlbumToCollection(Album albumTitle) {
      collections.add(albumTitle);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Album> getCollections() {
    return collections;
  }
}
