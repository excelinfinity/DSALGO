package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 11 Marc'2018()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArraySubSequenceHalfSum {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        //input lenght of array
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // values of array
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);
        pw.println(a);
        int[] arr = new int[n];
        int i = 0;
        int sum = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
            i++;
        }

        if(sum%2!=0){
            pw.println(false);
        }else{
        sum/=2;
        pw.println(sumexist(arr,sum,n-1));
        pw.flush();}
    }

    public static boolean sumexist(int[] arr,int sum,int end){
        if(sum==0) return true;
        if(end==0) return false;
        return sumexist(arr,sum,end-1) || sumexist(arr,sum-arr[end],end-1);
    }
}
