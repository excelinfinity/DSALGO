package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 7 March'2018()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
public class SortSubSequanceSize3 {
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

        //solution
        int sml[] = new int[n];
        int lrg[] = new int[n];
        sml[0]=-1;
        int min = 0;

        for(i=1;i<n;i++){
            if(arr[i]>arr[min]){
                sml[i]=min;
            }else{
                sml[i] = -1;
                min = i;
            }
        }
        pw.println(Arrays.toString(sml));
        int max = n-1;
        lrg[n-1] = -1;
        for(i=n-2;i>=0;i--){
            if(arr[i]<arr[max]){
                lrg[i]=max;
            }else{
                lrg[i] = -1;
                max = i;
            }
        }
        boolean b = false;
        for(i=0;i<n;i++){
            if(sml[i]>=0 && lrg[i]>=0){
                pw.println(arr[sml[i]] + " " +arr[i]+" "+ arr[lrg[i]]);
                break;
            }
        }
        pw.println(Arrays.toString(lrg));
        pw.flush();
    }
}
