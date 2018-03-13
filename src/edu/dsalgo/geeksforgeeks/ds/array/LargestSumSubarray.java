package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestSumSubarray {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // values of array
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);
        pw.println(a);
        int[] arr = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int max_sum = Integer.MIN_VALUE;
        int max_sum_index = 0;
        for(i=0;i<n;i++){
            max_sum_index+=arr[i];
            if(max_sum_index>max_sum)
                max_sum=max_sum_index;
            else if (max_sum_index<0)
                max_sum_index=0;
        }
        pw.println(max_sum);
        pw.flush();
    }
}
