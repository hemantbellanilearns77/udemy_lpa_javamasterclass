package com.hb.study.udemylpajavamasterclass.section12_generics.misc_practice.generics_basics;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

interface Player {

    String name();
}
record BaseballPlayer(String name, String position) implements Player {}
record FootballPlayer(String name, String position) implements Player {}
record VolleyballPlayer(String name, String position) implements Player {}

public class GenericsBasicsMain {

    public static void main(String[] args) {

        System.out.println(CommonConstants.PROGRAMOUTPUTBEGINSSTR);
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        var philly = new Affiliation("city", "Philadelphia, PA",
                "US");

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 21, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 5, astros2, 5);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);
        Team<BaseballPlayer, Affiliation> phillies =
                new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 11, astros, 9);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);

        phillies.listTeamMembers();
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);

        SportsTeam afc1 = new SportsTeam ("Adelaide Crows");
        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows",
                "City of Adelaide, South Australia, in AU");
/*
If there was an upperbound defined as Affiliation on the Team's second Type parameter
        Team<FootballPlayer, Affiliation> afc = new Team<>("Adelaide Crows",
                new Affiliation("City of Adelaide", "South Australia", "AU"));*/
        var tex = new FootballPlayer("Tex Walker" , "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);
        scoreResult(canberra, 0, adelaide, 1);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTR);
        excecutionUtil.updateExecutionStats();
        System.out.println(excecutionUtil.toString());
        System.out.println(CommonConstants.PROGRAMOUTPUTENDSSTR);

//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
