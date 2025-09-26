package com.hb.study.udemy_lpa_javamasterclass.section10_collections.coding_challenges.linkedlistchallenge;

record Town ( String town, int distanceFromOrigin) {
    public static String originTown = "Sydney";

    @Override
    public String toString() {
        return " {" +
                "\'" + town + '\'' +
                ", distance (in km) from \'" + originTown + "\': " + distanceFromOrigin +
                "}CommonConstants.NEWLINE";
    }

}
