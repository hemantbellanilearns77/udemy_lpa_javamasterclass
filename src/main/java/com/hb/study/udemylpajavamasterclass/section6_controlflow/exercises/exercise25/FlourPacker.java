package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise25;

public class FlourPacker {

    // write code here
    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack (1, 0, 5));
        System.out.println(canPack (0, 5, 4));
        System.out.println(canPack (2, 2, 11));
        System.out.println(canPack (-3, 2, 12));
        System.out.println(canPack(5, 3, 24));
        System.out.println(canPack(2, 1, 5));
        System.out.println(canPack(4, 18, 19));
    }

    public static boolean canPack (int bigCount, int smallCount, int goal){
        int availableTotalCapacity = (bigCount*5) + (smallCount);
        boolean canPackStatus = false;
        int a,b,c,d,e;
        int remainingGoal = 0;

        if( !(smallCount<0 || bigCount<0 || goal<0) ){

            if(goal == availableTotalCapacity) {
                canPackStatus = true;
            } else if( goal < availableTotalCapacity){
                if((bigCount == 0) || (smallCount == 0)) {
                    if(bigCount == 0) {
                        if(goal <= smallCount){
                            canPackStatus = true;
                        }
                    } else if( goal == (bigCount * 5)){
                        canPackStatus = true;
                    }
                } else {
                    if(  ((goal - smallCount) <= (bigCount*5)) && (((goal - smallCount) % 5) == 0 )) {
                        canPackStatus = true;
                    } else if( (((goal-(bigCount*5))) >0) && (((goal-(bigCount*5))) <= smallCount)) {
                        canPackStatus = true;
                    } else if( (goal < (bigCount*5)) && ((goal % 5 ) == 0 ) ) {
                        canPackStatus = true;
                    } else if( ((bigCount*5) - (goal%5)) <= smallCount) {
                        canPackStatus = true;
                    }
                }
            }
        }
        return canPackStatus;
    }
}
/*
Below is an alternative solution:
public class FlourPacker {

    private static final int BIG_WEIGHT = 5;

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        boolean result = false;
        int totalBigWeight = bigCount * BIG_WEIGHT;
        if (totalBigWeight >= goal) {
            int remaining = goal % BIG_WEIGHT;
            if (smallCount >= remaining) {
                result = true;
            }
        } else {
            if (smallCount >= goal - totalBigWeight) {
                result = true;
            }
        }
        return result;
    }
}
 */