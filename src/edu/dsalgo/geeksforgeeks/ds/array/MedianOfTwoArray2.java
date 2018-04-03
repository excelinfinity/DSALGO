package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MedianOfTwoArray2 {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        float []arrn = new float [n];
        float[] arrm = new float[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arrn[i] =Float.parseFloat(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arrm[i] =Float.parseFloat(st.nextToken());
        }
        pw.println(findMedian(arrn,arrm,n,m));
        pw.println(13344&1);
        pw.flush();
    }

    public static float median(float[]arr,int n,int s){
        if(n%2!=0){
            return arr[s+(n-1)/2];
        }else{
            return arr[s+(n-1)/2]+arr[s+n/2];
        }
    }
    public static float findMedian(float[] arrn,float[] arrm,int n,int m){
        int p=0;
        int q=0;
        int x = (n+m)/2+1;
        float m1 = -1,m2 = -1;

        for(int i=0;i<x;i++){
            if(p==n){
                m1 = m2;
                m2 = arrm[q++];
            }
            else if(q==n){
                m1 = m2;
                m2 = arrn[p++];
            }
            else if(arrn[p]<arrm[q]){
                m1 = m2;
                m2 = arrn[p++];
            }else{
                m1 = m2;
                m2 = arrm[q++];
            }
        }
        if((n+m)%2==0){
            return (m1+m2)/2;
        }
        return m2;
    }
}
