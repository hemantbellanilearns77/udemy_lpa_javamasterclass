package com.hb.study.udemy_lpa_javamasterclass.section13.exercises.exercise49;

import java.util.ArrayList;
import java.util.List;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * created by : heman on 07-07-2025, 05:58 PM, in the "udemy_lpa_javamasterclass" project
 **/


public class Album {

    private String name;
    private String artist;
    
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList<Song>();//new SongList<Song>(new ArrayList<>());
    }

    public boolean addSong(String title, double duration) {
        boolean songAdded = false;
        Song songtoAdd = new Song(title, duration);
        if (this.songs.add(songtoAdd) == true) {
            songAdded = true;
        }
        return songAdded;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        boolean songAdded = false;
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            songAdded = true;
        } else {
            ConsoleStyler.styleOutput("This album does not have a track %d%n".formatted(trackNumber));
        }
        return songAdded;
    }


    public boolean addToPlayList(String title, List<Song> playList) {
        boolean songAdded = false;
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            songAdded = true;
        } else {
            ConsoleStyler.styleOutput("The song %s is not in this album%n".formatted(title));
        }
        return songAdded;
    }

    @Override
    public String toString() {
        StringBuilder albumToStringBuilder = new StringBuilder();
        albumToStringBuilder.append("Album name=\'" + name + '\'' +
                ", artist='" + artist + '\'' +
                "\nTrack No. Title: Duration \n");
        for (int loopCounter = 0; loopCounter < this.songs.songs.size(); loopCounter++) {
            albumToStringBuilder.append((loopCounter + 1) + ".\t" + this.songs.songs.get(loopCounter).toString() + "\n");
        }
        return albumToStringBuilder.toString();
    }

    public static class SongList<T extends Song> {
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

                private boolean add(Song songToAdd) {
                    boolean songAdded = false;
                    if (findSong(songToAdd.getTitle()) == null) {
                        songs.add(songToAdd);
                        songAdded = true;
                    }
                    return songAdded;
                }
        

        private Song findSong(String title) {
            Song foundSong = null;
            for (Song checkedSong : songs) {
                if (checkedSong.getTitle().equalsIgnoreCase(title)) {
                    foundSong = checkedSong;
                }
            }
            return foundSong;
        }

        private Song findSong(int trackNumber) {
            Song foundSong = null;
            int index = trackNumber - 1;
            if ((index >= 0) && (index < songs.size())) {
                foundSong = songs.get(index);
            }
            return foundSong;
        }
    }
}
