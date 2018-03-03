package edu.dsalgo.geeksforgeeks.ds.array;

import edu.common.math.Gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/array-rotation/
//https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
public class ArrayRotation {
    public static void main(String... str) throws IOException {
        //get console input.
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
        //rotation by?
        int d = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        //rotation.
        //arr = rotateArray1(arr,n,d);
        //arr = rotateArray2(arr,n,d);
        arr = rotateArray3(arr,n,d);
        pw.println(Arrays.toString(arr));
        pw.flush();
    }
    //time : O(n)
    //space O(n)

    public static int[] rotateArray1(int[] arr, int n, int d) {
        int[] resultarr = new int[n];
        for (int i = d; i < n; i++) {
            resultarr[i - d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            resultarr[n - d + i] = arr[i];
        }
        return resultarr;
    }

    // T =O(n)
    // S = O(1)
    public static int[] rotateArray2(int[] arr, int n, int d) {
        int g = Gcd.getGCD(n, d);
        for (int i = 0; i < g; i++) {
            int temp = arr[i];
            int j = i;
            int k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k % n;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    // T O(n)
    public static int[] rotateArray3(int[] arr, int n, int d) {
        d = d%n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
        return arr;
    }

    public static int[] reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
