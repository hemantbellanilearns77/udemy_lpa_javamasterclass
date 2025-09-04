package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise45;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;


public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {

        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {

        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {

        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {

        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder albumToStringBuilder = new StringBuilder();
        albumToStringBuilder.append("Album name=\'" + name + '\'' +
                ", artist='" + artist + '\'' +
                "\nTrack No. Title: Duration \n");
        for(int loopCounter = 0; loopCounter < songs.size(); loopCounter++ ){
            albumToStringBuilder.append(loopCounter + 1)
                    .append(".\t")
                    .append(songs.get(loopCounter).toString())
                    .append("\n");
        }
        return albumToStringBuilder.toString();
    }
}
