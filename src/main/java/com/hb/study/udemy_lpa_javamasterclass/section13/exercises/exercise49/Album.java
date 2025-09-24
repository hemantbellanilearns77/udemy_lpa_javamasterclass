package com.hb.study.udemy_lpa_javamasterclass.section13.exercises.exercise49;

import java.util.ArrayList;
import java.util.List;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * created by : heman on 07-07-2025, 05:58 PM, in the "udemy_lpa_javamasterclass" project
 **/


public class Album {

    private final String name;
    private final String artist;
    
    private final SongList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList<>();
    }

    public void addSong(String title, double duration) {
        Song songtoAdd = new Song(title, duration);
        if (this.songs.add(songtoAdd)) {
            ConsoleStyler.styleOutput("Song " + title + " added to album: " + name);
        } else {
            ConsoleStyler.styleOutput("Song " + title + " could not be added to album: " + name);
        }
    }

    public void addToPlayList(int trackNumber, List<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
        } else {
            ConsoleStyler.styleOutput("This album does not have a track %d%n".formatted(trackNumber));
        }
    }


    public void addToPlayList(String title, List<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
        } else {
            ConsoleStyler.styleOutput("The song %s is not in this album%n".formatted(title));
        }
    }

    @Override
    public String toString() {
        StringBuilder albumToStringBuilder = new StringBuilder();
        albumToStringBuilder.append("Album name='").append(name).append('\'').append(", artist='").append(artist).append('\'').append("\nTrack No. Title: Duration \n");
        for (int loopCounter = 0; loopCounter < this.songs.songs.size(); loopCounter++) {
            albumToStringBuilder.append((loopCounter + 1)).append(".\t").append(this.songs.songs.get(loopCounter).toString()).append("\n");
        }
        return albumToStringBuilder.toString();
    }

    public static class SongList<T extends Song> {
        private final List<T> songs;

        private SongList() {
            songs = new ArrayList<>();
        }

                private boolean add(T songToAdd) {
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
