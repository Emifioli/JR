package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution x[]=new Solution[2];
        Solution a = new Solution();
        Solution b = new Solution();
        Solution.InnerClass ai1 = a.new InnerClass();
        Solution.InnerClass bi1 = b.new InnerClass();
        Solution.InnerClass ai2 = a.new InnerClass();
        Solution.InnerClass bi2 = b.new InnerClass();
        a.innerClasses[0]=ai1;
        a.innerClasses[1]=ai2;
        b.innerClasses[0]=bi1;
        b.innerClasses[1]=bi2;
        x[0]=a;
        x[1]=b;
        return x;
    }
}
