package com.hb.study.udemy.lpa.section10_collections.coding_challenges.linkedlistchallenge;

record Town ( String town, int distanceFromOrigin) {
    public static String originTown = "Sydney";

    @Override
    public String toString() {
        return " {" +
                "\'" + town + '\'' +
                ", distance (in km) from \'" + originTown + "\': " + distanceFromOrigin +
                "}\n";
    }

    public static String getOriginTown() {
        return originTown;
    }

    Town(String town, int distanceFromOrigin) {
        this.town = town;
        this.distanceFromOrigin = distanceFromOrigin;
    }
}
