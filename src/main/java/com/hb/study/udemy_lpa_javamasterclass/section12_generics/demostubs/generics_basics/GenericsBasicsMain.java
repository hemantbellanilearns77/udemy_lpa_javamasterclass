package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_basics;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

interface Player {

    String name();
}

record BaseballPlayer(String name, String position) implements Player {
}

record FootballPlayer(String name, String position) implements Player {
}

record VolleyballPlayer(String name, String position) implements Player {
}

public class GenericsBasicsMain {
    private static final String PHILADELPHIA_PHILLIES = "Philadelphia Phillies";
    private static final String HOUSTON_ASTROS = "Houston Astros";
    private static final String ADELAIDE_CROWS = "Adelaide Crows";
    private static final String COMMON_STRING_FORMATTER = "%s %s %s %n";
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {

        execution.initialize(args);

        var philly = new Affiliation("city", "Philadelphia, PA",
                "US");

        BaseballTeam phillies1 = new BaseballTeam(PHILADELPHIA_PHILLIES);
        BaseballTeam astros1 = new BaseballTeam(HOUSTON_ASTROS);

        scoreResult(phillies1, 21, astros1, 5);

        SportsTeam phillies2 = new SportsTeam(PHILADELPHIA_PHILLIES);
        SportsTeam astros2 = new SportsTeam(HOUSTON_ASTROS);
        scoreResult(phillies2, 5, astros2, 5);
        ConsoleStyler.divider();
        Team<BaseballPlayer, Affiliation> phillies =
                new Team<>(PHILADELPHIA_PHILLIES, philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>(HOUSTON_ASTROS);
        scoreResult(phillies, 11, astros, 9);
        ConsoleStyler.divider();
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        astros1.addTeamMember(harper);
        phillies1.addTeamMember(marsh);
        phillies1.listTeamMembers();
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);

        phillies.listTeamMembers();
        ConsoleStyler.divider();

        SportsTeam afc1 = new SportsTeam(ADELAIDE_CROWS);
        afc1.listTeamMembers();
        Team<FootballPlayer, String> afc = new Team<>(ADELAIDE_CROWS,
                "City of Adelaide, South Australia, in AU");
        ConsoleStyler.styleExecutionInsight("""
                /*
                If there was an upperbound defined as Affiliation on the Team's second Type parameter
                        Team<FootballPlayer, Affiliation> afc = new Team<>("Adelaide Crows",
                                new Affiliation("City of Adelaide", "South Australia", "AU"));*/
                """);
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();
        ConsoleStyler.divider();

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();
        ConsoleStyler.divider();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        ConsoleStyler.divider();
        scoreResult(canberra, 0, adelaide, 1);
        ConsoleStyler.styleExecutionInsight("""
                /*
                This would never have compiled:
                //Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
                */
                """);

        execution.finalizeExecution();
    }

    public static void scoreResult(BaseballTeam team1, int team1Score,
                                   BaseballTeam team2, int team2Score) {

        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        ConsoleStyler.styleOutput(COMMON_STRING_FORMATTER.formatted(team1, message, team2));
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        ConsoleStyler.styleOutput(COMMON_STRING_FORMATTER.formatted(team1, message, team2));
    }

    public static void scoreResult(Team<?, Affiliation> team1, int t1_score,
                                   Team<?, Affiliation> team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        ConsoleStyler.styleOutput(COMMON_STRING_FORMATTER.formatted(team1, message, team2));
    }
}
