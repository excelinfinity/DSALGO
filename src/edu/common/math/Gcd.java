package edu.common.math;

public class Gcd {
    // a & b are non zero
    public static Integer getGCD(int a , int b) {
       if(a%b==0) return b;
       else return getGCD(b,a%b);
    }

}
