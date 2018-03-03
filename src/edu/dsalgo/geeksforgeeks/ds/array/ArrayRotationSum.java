package edu.dsalgo.geeksforgeeks.ds.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 4,March,2018
*/
//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class ArrayRotationSum {
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        //input length of array
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // values of array
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);
        int[] arr = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        //sum of 2 values;
        int sum = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        pw.println(isSumExist(arr,n,sum));
        pw.flush();
    }
    public static boolean isSumExist(int[] arr,int n , int sum){
        int index = ArrayRotationSearch.findPivot(arr,0,n);
        int i = index,j = (index+n-1)%n;
        while(i!=j){
            int tempArr = arr[i]+arr[j];
            if(tempArr==sum)
                return true;
            if(tempArr<sum)
                i = (i+1)%n;
            else
            j=(j+n-1)%n;
        }
        return false;
    }
}
