package com.hblearns77.udemy_lpa_javamasterclass.section10_collections.exercises.exercise45;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise45PlaylistMainClass {
    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();

        public static void main(String[] args) {

        execution.initialize(args);
        ArrayList<Album> albums = new ArrayList<>();
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);
        ConsoleStyler.styleOutput("The album 'Stormbringer' looks like below: CommonConstants.NEWLINE" + album);
        ConsoleStyler.divider();

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);
        ConsoleStyler.styleOutput("The album 'For those about to rock' looks like below: CommonConstants.NEWLINE" + album);
        ConsoleStyler.divider();

        LinkedList<Song> playList = new LinkedList<>();
        albums.getFirst().addToPlayList("You can't do it right", playList);
        albums.getFirst().addToPlayList("Holy man", playList);
        albums.getFirst().addToPlayList("Speed king", playList);  // Does not exist
        albums.getFirst().addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
        ConsoleStyler.styleOutput("Playlist:");
        ConsoleStyler.styleOutput("Track No. Title: Duration");

        for (int loopCounter = 0; loopCounter < playList.size(); loopCounter++) {
            ConsoleStyler.styleOutput(  (loopCounter + 1) + ".\t" + playList.get(loopCounter));
        }
        ConsoleStyler.divider();

        execution.finalizeExecution();
    }
}
