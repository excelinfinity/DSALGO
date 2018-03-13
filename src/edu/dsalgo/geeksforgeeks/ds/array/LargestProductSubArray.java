package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestProductSubArray {
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
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int max_prod = 1;
        int max_prod_index =1;
        int mini_prod_index = 1;

        for(int j=0;j<n;j++){
           if(arr[j]>0){
               max_prod_index = max_prod_index*arr[j];
               mini_prod_index = Math.min(mini_prod_index*arr[j],1);
           }

           if(arr[j]==0){
               max_prod_index = 1;
               mini_prod_index =1;
           }

           if(arr[j]<0){
               int temp=mini_prod_index;
               mini_prod_index = max_prod_index*arr[j];
               max_prod_index = temp*arr[j];
           }
           if(max_prod<max_prod_index){
               max_prod=max_prod_index;
           }
        }
        pw.println(max_prod);
        pw.flush();
    }
}
