package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 7 March'2018()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//https://www.geeksforgeeks.org/sort-an-array-according-to-absolute-difference-with-given-value/
public class SortArrayWithAbsDifference {
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
        //difference by?
        int d = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        Map<Integer,List<Integer>> map= new HashMap<>();
        for(int ar : arr) {
            List<Integer> l = new ArrayList<>();
            int val = Math.abs(ar-d);
            if(map.containsKey(val)){
                l = map.get(val);
            }
            l.add(ar);
            map.put(val,l);
        }
        List s = new ArrayList<>();
        map.forEach((key,value)->{
            value.forEach(s::add);
        });

        pw.println(Arrays.toString(s.toArray()));
        pw.flush();
    }
}
