package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestSubSequanceArray {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // values of array
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);
        pw.println(a);
        int [] arr = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int[] temp = new int[n];
        temp[0]=1;
        int max_count=1;
        for (int t=1;t<n;t++){
            int index = findLargestSmall(arr,temp,t,arr[t]);
            if(index>=0)
                temp[t]=temp[index]+1;
            else temp[t]=1;
            max_count = Math.max(max_count,temp[t]);
        }
        pw.println(Arrays.toString(temp));
        pw.println(max_count);
        pw.flush();
    }
    public static int findLargestSmall(int[] arr,int temp[],int end,int val){
        int index=-1;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<end;i++) {
            if(arr[i]<val && temp[i]>max){
                max = temp[i];
                index = i;
            }
        }
        return index;
    }
}
