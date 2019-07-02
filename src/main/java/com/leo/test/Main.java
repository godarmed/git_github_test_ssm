package com.leo.test;
import java.util.*;

public class Main{
    public static void main(String[] args){
        //接收输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        for(int i = 0;i < n ;i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }
        getResult(arr);

    }

    //判断a+b>c?
    public static void getResult(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            //判断符号
            if(arr[i][0]>=0&&arr[i][1]>=0){    //a,b均大于等于0
                if(arr[i][2]>=0){
                    System.out.println("Case #" + (i+1) + ":" + (arr[i][0]>arr[i][2]-arr[i][1]));
                }else{
                    System.out.println("Case #" + (i+1) + ":true");
                }
            }else if(arr[i][0]<=0&&arr[i][1]<=0){    //a,b均小于等于0
                if(arr[i][2]<=0){
                    System.out.println("Case #" + (i+1) + ":" + (arr[i][0]>arr[i][2]-arr[i][1]));
                }else{
                    System.out.println("Case #" + (i+1) + ":false");
                }
            }else{
                System.out.println("Case #" + (i+1) + ":" + (arr[i][0]+arr[i][1]>arr[i][2]));
            }
        }
    }
}