package com.tito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.
    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()

    Song song1 = new Song("Hey Ya!", 180);
    Song song2 = new Song("The Love Below", 300);
    Song song3 = new Song("Aquamini", 220);
    Song song4 = new Song("Speaker Box", 190);
    Song song5 = new Song("Forgot About André", 232);
    Song song6 = new Song("The Real Slim Shady", 374);
    Song song7 = new Song("Toy Soldiers", 341);
    Song song8 = new Song("8 Mile", 278);
    Song song9 = new Song("Superman", 260);
    Song song10 = new Song("D12", 199);

    Album album1 = new Album("the white album");
    album1.addSongToAlbum(song1);
    album1.addSongToAlbum(song2);
    album1.addSongToAlbum(song3);
    album1.addSongToAlbum(song4);
    album1.addSongToAlbum(song5);
//    printAlbum(album1);
//    System.out.println("===============================");
    Album album2 = new Album("the black album");
    album2.addSongToAlbum(song6);
    album2.addSongToAlbum(song7);
    album2.addSongToAlbum(song8);
    album2.addSongToAlbum(song9);
    album2.addSongToAlbum(song10);
//    printAlbum(album2);
//    System.out.println("===============================");
    Collection collection = new Collection("the collection");
    collection.addAlbumToCollection(album1);
    collection.addAlbumToCollection(album2);
//    printCollection(collection);
//    System.out.println("===============================");
    Playlist playlist = new Playlist("the gray playlist");
    playlist.addSongToPlaylist(song2);
    playlist.addSongToPlaylist(song9);
    playlist.addSongToPlaylist(song5);
    playlist.addSongToPlaylist(song6);
    playlist.addSongToPlaylist(song1);
    playlist.addSongToPlaylist(song10);
    playlist.addSongToPlaylist(song3);
    playlist.addSongToPlaylist(song8);
//    printPlaylist(playlist);

    musicPlayer(playlist);
  }

  private static void musicPlayer(Playlist title) {
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    boolean goingForward = true;
    LinkedList<Song> tracks = title.getSongs();
    System.out.println("tracks: " + tracks.toString());
    ListIterator<Song> listIterator = tracks.listIterator();
//    System.out.println("listIterator: " + listIterator.toString());

    if (tracks.isEmpty()) {
      System.out.println("error: no songs have been added to this playlist");
    } else {
      System.out.println("now playing " + listIterator.next().toString());
      printMenu();
    }
    while (!quit) {
      int action = scanner.nextInt();
      switch (action) {
        case 0:
          System.out.println("exiting music player...");
          quit = true;
          break;
        case 1:
          if (!goingForward) {
            if (listIterator.hasNext()) {
              listIterator.next();
            }
            goingForward = true;
          }
          if (listIterator.hasNext()) {
            System.out.println("now playing " + listIterator.next().toString());
          } else {
            System.out.println("error: listening to the final song in the playlist");
            goingForward = false;
          }
          break;
        case 2:
          if (goingForward) {
            if (listIterator.hasPrevious()) {
              listIterator.previous();
            }
            goingForward = false;
          }
          if (listIterator.hasPrevious()) {
            System.out.println("now playing " + listIterator.previous().toString());
          } else {
            System.out.println("error: listening to the first song in the playlist");
            goingForward = true;
          }
          break;
        case 3:
          if (listIterator.hasPrevious() && goingForward) {
            // TODO - figure out how to properly replay songs
            System.out.println("(replay) now playing " + listIterator.previous().toString());
            goingForward = false;
          } else if (!listIterator.hasPrevious() && !goingForward) {
            System.out.println("(replay) now playing " + listIterator.next().toString());
            goingForward = true;
          } else if (!listIterator.hasNext() && !goingForward) {
            System.out.println("(replay) now playing " + listIterator.next().toString());
            goingForward = true;
          } else if (listIterator.hasNext() && goingForward) {
            System.out.println("(replay) now playing " + listIterator.previous().toString());
            goingForward = false;
          } else {
            System.out.println("error: listening to the first song in the playlist");
            goingForward = true;
          }
          break;
        case 4:
          printMenu();
          break;
      }
    }
  }

  private static void printMenu() {
    System.out.println("available actions: \npress ");
    System.out.println("0 - to quit\n" +
        "1 - play next track\n" +
        "2 - play previous track\n" +
        "3 - replay current track\n" +
        "4 - print menu options");
  }

  private static void printAlbum(Album title) {
    if (title.getAlbumTitle() != null) {
      System.out.println("album title: " + title.getAlbumTitle());
      ArrayList<Song> tracks = title.getSongs();
      for (int i = 0; i < tracks.size(); i++) {
        System.out.println("track " + (i + 1) + ". " + tracks.get(i).getTitle() + " (" + tracks.get(i).getDurationInSeconds() + " secs)");
      }
    } else {
      System.out.println("error: album does not exist");
    }
  }

  private static void printCollection(Collection name) {
    if (name.getName() != null) {
      System.out.println("collection: " + name.getName());
      ArrayList<Album> albums = name.getCollections();
      for (int i = 0; i < albums.size(); i++) {
        System.out.println("album " + (i + 1) + ". " + albums.get(i).getAlbumTitle());
      }
    } else {
      System.out.println("error: collection does not exist");
    }
  }

  private static void printPlaylist(Playlist title) {
    if (title.getTitle() != null) {
      System.out.println("playlist: " + title.getTitle());
      LinkedList<Song> tracks = title.getSongs();
      for (int i = 0; i < tracks.size(); i++) {
        System.out.println("track " + (i + 1) + ". " + tracks.get(i).getTitle() + " (" + tracks.get(i).getDurationInSeconds() + " secs)");
      }
    } else {
      System.out.println("error: playlist does not exist");
    }
  }
}
