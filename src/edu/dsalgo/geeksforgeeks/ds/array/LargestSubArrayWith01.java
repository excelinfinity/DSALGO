package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 7 March'2018()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LargestSubArrayWith01 {
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
        HashMap<Integer,Integer> m = new HashMap<>();
        int sum=0;
        int startindex = 0;
        int length = 0;
        for (i=0;i<n;i++) {
            if(arr[i]==0)arr[i]=--sum;
            else arr[i]=++sum;
            if(sum==0) {length=i+1;startindex=0;}
            if(m.containsKey(sum)){
                if(length<i-m.get(sum)){
                    length = i-m.get(sum);
                    startindex = m.get(sum)+1;
                }
            }
            else m.put(sum,i);
        }
        pw.println("start index = "+startindex+"max length = "+length);
        pw.flush();
    }
}
