package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class RunLengthEncoding {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
         String st = br.readLine();
         char[] ch = st.toCharArray();
         int count=0;
         char chi='#';
         List<Object> a = new ArrayList<>();
         for (int i=0;i<ch.length;i++){
             if(count==0){
                 chi = ch[i];
                 a.add(chi);
                 count++;
             }
             else if(ch[i]==chi){
                 count++;
             }else{
                 a.add(count);
                 count=0;
                 i--;
             }
         }
         a.add(count);
         System.out.println(Arrays.toString(a.toArray()));
    }
}
