package com.hb.study.udemy_lpa_javamasterclass.section13.exercises.exercise49;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by : heman on 07-07-2025, 06:07 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class Exercise49MainClass {
    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();
    private static final String STORMBRINGER = "Stormbringer";

        public static void main(String[] args) {
        //

        execution.initialize(args);

        List<Album> albums = new ArrayList<>();
        Album album = new Album(STORMBRINGER, "Deep Purple");
        album.addSong(STORMBRINGER, 4.6);
        album.addSong(STORMBRINGER, 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);
        ConsoleStyler.styleOutput(album + CommonConstants.EMPTYSTRING);
         ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);

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
        ConsoleStyler.styleOutput(album + CommonConstants.EMPTYSTRING);
         ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList("Huppa Huyya", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(10, playList);  // There is no track 10
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
         ConsoleStyler.styleOutput(CommonConstants.FULLLINEASTERISKSEPERATOR);
        ConsoleStyler.styleOutput("Final Playlist:");
        ConsoleStyler.styleOutput("Track No. Title: Duration");
        for (int loopCounter = 0; loopCounter < playList.size(); loopCounter++) {
            ConsoleStyler.styleOutput(loopCounter + 1 + ".\t" + playList.get(loopCounter).toString());
        }
        execution.finalizeExecution();
    }
}