package edu.dsalgo.geeksforgeeks.ds.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class ArrayRotationSearch {
    public static void main(String... str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        //input length of array
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
        //search index of?
        int val = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // get index
        //int index =findIndex(arr,n,val);//no need to pass n;but I am lazy to remove it.
        int index = findIndex2(arr,0,n-1,val);
        pw.print(index);
        pw.flush();
    }

    public static int findIndex(int[] arr,int n, int val){
        int pivotInd = findPivot(arr,0,n);
        if(pivotInd==0 || pivotInd==-1)
            return binarySearch(arr,0,n-1,val);
        if(val>=arr[0])
            return binarySearch(arr,0,pivotInd-1,val) ;
        return binarySearch(arr,pivotInd,n-1,val);
    }
    public static int findPivot(int arr[],int start,int end){
        if(start>end) return -1;
        if(start==end)return end;
        int mid =(start+end)/2;
        if(mid<end && arr[mid] > arr[mid + 1])
            return mid+1;
        if (mid > start && arr[mid] < arr[mid - 1])
            return mid;
        if(arr[start] >= arr[mid])
            return findPivot(arr, start, mid-1);
        return findPivot(arr,mid+1,end);
    }

    public static int binarySearch(int[]arr,int start,int end,int val){
        if(end<start) return -1;
        int mid = (start+end)/2;
        if(val==arr[mid])
            return mid;
        if(arr[mid]<val)
            return binarySearch(arr,mid+1,end,val);
        return binarySearch(arr,start,mid-1,val);
    }

    public static int findIndex2(int []arr,int start,int end,int val){
        if(end<start) return -1;
        int mid = (start+end)/2;
        if(arr[mid]==val) return mid;
        if(arr[start]<arr[mid]) {
            if (arr[mid] > val && arr[start] <= val)
                return binarySearch(arr, start, mid - 1, val);
            return findIndex2(arr,mid+1,end,val);
        }
        if(arr[end] >= val && arr[mid] < val)
            return binarySearch(arr,mid+1,end,val);
        return findIndex2(arr,start,mid-1,val);
    }
}
