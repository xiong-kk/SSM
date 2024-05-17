package com.free.spring.test;

import java.util.Scanner;

/**
 * @author free
 * @create 2023-06-08-20:57
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        System.out.println(addDigits(num));
    }
    public static int addDigits(int num){
        if(num/10>0){
            num=addDigits(digitsSum(num));
        }
        return num;
    }

    public static int digitsSum(int num){
        int sum=0;
        while (num/10>0){
            sum+=num%10;
            num=num/10;
        }
        sum+=num;
        return sum;
    }
}
