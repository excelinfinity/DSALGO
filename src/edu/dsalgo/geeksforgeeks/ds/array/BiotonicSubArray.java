package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 7 March 2018()
*/
//https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BiotonicSubArray {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        //input length of array
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

        int inc[] = new int[n];
        int desc[] = new int[n];
        inc[0]=1;
        for (i=1;i<n;i++){
            if(arr[i]>arr[i-1])
                inc[i]=inc[i-1]+1;
            else inc[i]=1;
        }
        desc[n-1]=1;
        for (i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1])
                desc[i]=desc[i+1]+1;
            else desc[i]=1;
        }
        pw.println(Arrays.toString(inc));
        pw.println(Arrays.toString(desc));
        int max = 1;
        for (i=0;i<n;i++){
            max = Math.max(inc[i]+desc[i]-1,max);
        }
        pw.println(max);
        pw.flush();
    }
}
