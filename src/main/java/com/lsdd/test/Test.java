package com.lsdd.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class Test {

    long var;
    public void MyClass(long param) { var = param; }//(1)

    static char a;
    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {


        String str = "";
        System.out.print(str.split(",").length);
        int i =0;
        for(foo('A');foo('B')&&(i<2);foo('C'))
        {
            i++;
            foo('D');
        }

        //A
    }





    public  int sdf(int a){
        if(a==0){
            return 0;
        }
        if(a==1){
            return 1;
        }
        if(a==2){
            return 2;
        }
        return sdf(a-1)+sdf(a-2);
    }

    public int JumpFloor(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
