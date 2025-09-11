package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise45;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;


public class Album {

    private final String name;
    private final String artist;
    private final ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(String title, double duration) {

        if (findSong(title) != null) {
            ConsoleStyler.styleOutput("Song couldn't be added, it already exists");
        } else {
            songs.add(new Song(title, duration));
            ConsoleStyler.styleOutput("Song -> " + title + "  added to album: " + this.name);
        }
    }

    private Song findSong(String title) {

        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public void addToPlayList(int trackNumber, List<Song> playList) {

        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playList.add(songs.get(index));
        } else {
            ConsoleStyler.styleOutput("Some issue occurred. ");
        }
    }

    public void addToPlayList(String title, List<Song> playList) {

        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
        } else {
            ConsoleStyler.styleOutput("Some issue occurred. ");
        }
    }

    @Override
    public String toString() {
        StringBuilder albumToStringBuilder = new StringBuilder();
        albumToStringBuilder.append("Album name='").append(name).append('\'').append(", artist='").append(artist).append('\'').append("\nTrack No. Title: Duration \n");
        for (int loopCounter = 0; loopCounter < songs.size(); loopCounter++) {
            albumToStringBuilder.append(loopCounter + 1)
                    .append(".\t")
                    .append(songs.get(loopCounter).toString())
                    .append("\n");
        }
        return albumToStringBuilder.toString();
    }
}
