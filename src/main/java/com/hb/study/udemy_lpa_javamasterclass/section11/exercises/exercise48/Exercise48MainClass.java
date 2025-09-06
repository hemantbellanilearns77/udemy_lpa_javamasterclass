package com.hb.study.udemy_lpa_javamasterclass.section11.exercises.exercise48;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.List;

public class Exercise48MainClass {
    public static void main(String[] args) {
        // create player
        Player player = new Player("HB", 100, 75);
         ConsoleStyler.styleOutput(player + CommonConstants.EMPTYSTRING);

        // change some values
        player.setWeapon("Axe");
        player.setHitPoints(80);
        ConsoleStyler.styleOutput("After changes: " + player);

        // save player data
        List<String> playerData = player.write();
         ConsoleStyler.styleOutput("Saved Player Data: " + playerData);
        // Use getters
         ConsoleStyler.styleOutput("Name: " + player.getName());
         ConsoleStyler.styleOutput("HitPoints: " + player.getHitPoints());
         ConsoleStyler.styleOutput("Strength: " + player.getStrength());
         ConsoleStyler.styleOutput("Weapon: " + player.getWeapon());

        // Use setters
        player.setName("HeroHB");
        player.setHitPoints(120);
        player.setStrength(75);
        player.setWeapon("Axe");
         ConsoleStyler.styleOutput("After setters: " + player);

        // Save to List<String>
        List<String> savedData = player.write();
         ConsoleStyler.styleOutput("Saved data: " + savedData);

        // Create another player with dummy values
        Player loadedPlayer = new Player("Dummy", 1, 1);
         ConsoleStyler.styleOutput("Before read: " + loadedPlayer);

        // Load data (currently just collects, doesn’t assign back)
        loadedPlayer.read(savedData);
        ConsoleStyler.styleOutput("After read (no real changes): " + loadedPlayer);

        // Change again via setters
        loadedPlayer.setName("LoadedHB");
        loadedPlayer.setHitPoints(90);
        loadedPlayer.setStrength(60);
        loadedPlayer.setWeapon("Bow");
         ConsoleStyler.styleOutput("Modified loaded player: " + loadedPlayer);

        // Round trip save again
         ConsoleStyler.styleOutput("Reloaded data: " + loadedPlayer.write());

        // create monster
        Monster monster = new Monster("Orc", 150, 50);
         ConsoleStyler.styleOutput(monster + CommonConstants.EMPTYSTRING);

        // save monster data
        List<String> monsterData = monster.write();
         ConsoleStyler.styleOutput("Saved Monster Data: " + monsterData);

        // "load" back into new player for testing read()
        Player newPlayer = new Player("Dummy", 1, 1);
         ConsoleStyler.styleOutput("Before read: " + newPlayer);

        newPlayer.read(playerData); // currently your read() just stores them, doesn’t parse back
         ConsoleStyler.styleOutput("After read (no real change): " + newPlayer);
    }
}
