package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_basics;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


import java.util.ArrayList;
import java.util.List;



public class Team<T extends Player, A> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private A affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, A affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {

        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {

        System.out.print(teamName + " Roster:");
        ConsoleStyler.styleOutput((affiliation == null ? "" : " AFFILIATION: "+ affiliation));
        for (T t : teamMembers) {
            ConsoleStyler.styleOutput(t.name());
        }
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {

        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }

        return message;

    }

    @Override
    public String toString() {
        return teamName + " (Ranked "  + ranking() + ")";
    }
}
