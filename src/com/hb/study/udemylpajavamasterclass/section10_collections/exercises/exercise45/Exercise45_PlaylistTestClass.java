package com.hb.study.udemylpajavamasterclass.section10_collections.exercises.exercise45;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise45_PlaylistTestClass {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] args) {
        execution.setUp();
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
       // System.out.println("The album 'Stormbringer' looks like below: \n" + album ) ;
        System.out.println(album) ;

        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
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
        //System.out.println("The album 'For those about to rock' looks like below: \n" + album.toString() ) ;
        System.out.println(album) ;
        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTRFULL);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
        System.out.println("Playlist:" ) ;
        System.out.println("Track No. Title: Duration");
        for(int loopCounter = 0; loopCounter < playList.size(); loopCounter++ ){
            System.out.println((loopCounter+1) + ".\t" + playList.get(loopCounter).toString());
            //albumToStringBuilder.append((loopCounter+1) +". " + songs.get(loopCounter).toString()+"\n");
        }
        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
        /*

         ******************************************************
         */
        execution.windDown();
    }

  //


}
