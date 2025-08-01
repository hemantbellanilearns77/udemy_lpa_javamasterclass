package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise29;

public class PaintJob {
    public static void main(String[] args) {
        // Testing of first method:
        System.out.println("Below are the results of testing of first overloaded form ");
        System.out.println("Buckets to Buy with getBucketCount(-3.4, 2.1, 1.5, 2) is : " + getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println("Buckets to Buy with getBucketCount(3.4, 2.1, 1.5, 2) is : " + getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println("Buckets to Buy with getBucketCount(2.75, 3.25, 2.5, 1) is : " + getBucketCount(2.75, 3.25, 2.5, 1));

        // Testing of second method:
        System.out.println("Below are the results of testing of second overloaded form ");
        System.out.println("Buckets to Buy with getBucketCount(-3.4, 2.1, 1.5) is : " + getBucketCount(-3.4, 2.1, 1.5));
        System.out.println("Buckets to Buy with getBucketCount(3.4, 2.1, 1.5) is : " + getBucketCount(3.4, 2.1, 1.5) );
        System.out.println("Buckets to Buy with getBucketCount(7.25, 4.3, 2.35) is : " + getBucketCount(7.25, 4.3, 2.35));

        // Testing of third method:
        System.out.println("Below are the results of testing of third overloaded form ");
        System.out.println("Buckets to Buy with getBucketCount(3.4, 1.5) is : " + getBucketCount(3.4, 1.5));
        System.out.println("Buckets to Buy with getBucketCount(6.26, 2.2) is : " + getBucketCount(6.26, 2.2));
        System.out.println("Buckets to Buy with getBucketCount(3.26, 0.75) is : " + getBucketCount(3.26, 0.75));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, double extraBuckets){
        int bucketsToBuy = -1;
        double totalBucketsNeeded = 0.0;
        if( !(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0 ) ) {
            totalBucketsNeeded = ((width * height) / areaPerBucket);
            System.out.println("Total Buckets Needed is: " + totalBucketsNeeded);
            bucketsToBuy = (int) Math.ceil(totalBucketsNeeded - extraBuckets);
        }
        return bucketsToBuy;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        int bucketsToBuy = -1;
        if( !(width <= 0 || height <= 0 || areaPerBucket <= 0 ) ) {
            bucketsToBuy = getBucketCount(width * height, areaPerBucket);
        }
        return bucketsToBuy;
    }

    public static int getBucketCount(double area , double areaPerBucket){
        int bucketsToBuy = -1;
        if( !(area  <= 0 || areaPerBucket <= 0 ) ) {
            bucketsToBuy = (int) Math.ceil(area / areaPerBucket);
        }
        return bucketsToBuy;
    }
}
