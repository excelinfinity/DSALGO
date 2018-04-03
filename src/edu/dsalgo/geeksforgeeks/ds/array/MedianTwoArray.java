package edu.dsalgo.geeksforgeeks.ds.array;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date ()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MedianTwoArray {
    public static void main(String... str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        System.out.println(findMedian(arrn,arrm,n,m));
        System.out.print(findMedian2(arrn,arrm,0,0,n,m));

    }
    public static float findMedian2(float[] arrn,float[] arrm,int sn ,int sm, int n,int m){
        if(n==1){
            return (arrn[0]+arrn[1])/2;
        }
        if(n==2){
            return (Math.max(arrn[sn],arrm[sm])+Math.min(arrn[sn+1],arrm[sm+1]))/2;
        }

        float m1 = median(arrn,sn,n);
        float m2 = median(arrm,sm,n);

        if(m1==m2){
            return m1;
        }
        if(m1>m2){
            if(n%2==0){
                return findMedian2(arrm,arrn,sm+(n-1)/2,sn,(n/2)+1,m);
            }else{
                return findMedian2(arrm,arrn,sm+n/2,sn,(n+1)/2,m);
            }
        }else{
            if(n%2==0){
                return findMedian2(arrn,arrm,sn+(n-1)/2,sm,(n/2)+1,m);
            }else{
                return findMedian2(arrn,arrm,sn+n/2,sm,(n+1)/2,m);
            }
        }
    }

    public static float median(float[] arr,int s,int n){
        if(n%2==0){
            return (arr[s+n/2]+arr[s+(n-1)/2])/2;
        }else{
            return arr[s+n/2];
        }
    }
    public static float findMedian(float[] arrn,float[] arrm,int n ,int m){
        int x = (n+m)/2;
        int p=0,q = 0;
        float r=-1f,t=-1f;
        for(int i=0;i<=x;i++){
            if(p==n){
                r= t;
                t = arrm[q++];
                continue;
            }
            if(q==m){
                r=t;
                t = arrn[p++];
                continue;
            }
            if(arrn[p]>arrm[q]){
                r=t;
                t=arrm[q++];
            }else{;
                r=t;
                t = arrn[p++];
            }
        }
        if((n+m)%2==0){
            return((r+t)/2);
        }
        else{
            return t;
        }
    }
}
