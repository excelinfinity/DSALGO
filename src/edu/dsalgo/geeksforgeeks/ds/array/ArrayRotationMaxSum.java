package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 4,March,2018
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
//https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
public class ArrayRotationMaxSum{
    public static void main(String[] args) throws IOException{
        //get console input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        //input lenght of array
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // values of array
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);
        pw.println(a);
        double [] arr = new double[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        // S(i+1) = S(i)+s-arr[n-i-1]*(n-1)
        pw.println(findSum(arr));
    }
    public static double findSum(double[] arr){
        double sum = 0;
        double currVal = 0;
        for (int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
            currVal = currVal+(i*arr[i]);
        }
        double maxSum = currVal;
        for (int j=1; j<arr.length; j++) {
            currVal = currVal + sum-arr.length*arr[arr.length-j];//j is starting from 1
            if (currVal > maxSum)
                maxSum = currVal;
        }
        return maxSum;
    }
}
