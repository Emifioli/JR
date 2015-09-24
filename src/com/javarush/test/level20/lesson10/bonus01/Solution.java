package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result;

        ArrayList<Integer>itog = new ArrayList<>();
        for(int i=1;i<N;i++)
        {
            int [] y2 = OneN(i);
            int zero = y2.length;
            int sum=0;

            for(int w2 : y2){
                int a=w2;
                       for(int k=1;k<zero;k++)
                           a*=w2;
                sum+=a;
            }
           if(sum==i)itog.add(i);

        }
        result=new int[itog.size()];
        for (int i=0;i<result.length;i++)
            result[i]=itog.get(i);

        return result;
    }

    static int[] OneN(int u){
        int digits=0;
        int a = u;
        while (a != 0) {
            digits++;
            a = a/10;
        }
        int w[]=new int[digits];
        int b = u;
        for (int i=w.length-1;i>=0;i--){
            w[i]=b%10;
            b/=10;
        }

        return w;
    }
}
