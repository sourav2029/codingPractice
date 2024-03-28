package com.sourav.arrayandstring;

public class ReverseInteger {
    public static int reverse(int x) {
        boolean positive = true;
        if(x <0){
            positive = false;
            x = -1*x;
        }
        int res = 0;
        while(x>0){
            int rem = x%10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && rem>7)){
                return 0;
            }
            res = res*10 + rem;
            x/=10;
        }
        if(!positive)
            return -1*res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(reverse(-12333));
    }
}
