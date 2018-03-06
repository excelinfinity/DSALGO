package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 6 March'2018()
*/
//https://www.geeksforgeeks.org/find-a-rotation-with-maximum-hamming-distance/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HammingDistance {
    public static void main(String... str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
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
        int max = 0;
        int[] darr = new int[2*n];
        for(i=0;i<n;i++){
            darr[i] = arr[i];
            darr[i+n] = arr[i];
        }
        for (i=1;i<n;i++){
            int curr = 0;
            for (int k=i;k<n+i;k++){
                if(darr[k]!=arr[k-i])
                    curr++;
            }
            max = Math.max(curr,max);
            if(max==n)break;
        }
        pw.println(max);
        pw.flush();
    }
}
