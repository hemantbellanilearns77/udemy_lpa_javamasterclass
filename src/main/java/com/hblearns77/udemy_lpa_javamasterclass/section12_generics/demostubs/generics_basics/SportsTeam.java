package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_basics;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    private final String teamName;
    private final List<Player> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public void listTeamMembers() {
        FootballPlayer footballPlayer1 = new FootballPlayer("FP1", "striker");
        teamMembers.add(footballPlayer1);
        ConsoleStyler.styleOutput(teamName + " Roster:");
        ConsoleStyler.styleOutput(teamMembers.toString());
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }


    public String setScore(int ourScore, int theirScore) {

        String message;
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
            message = "lost to";
        }
        return message;

    }

    @Override
    public String toString() {
        return "SportsTeam{" +
                "teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                ", is Ranked=" + ranking() + " with " +
                ", totalWins=" + totalWins +
                ", totalLosses=" + totalLosses +
                ", totalTies=" + totalTies +
                '}';
    }
}
