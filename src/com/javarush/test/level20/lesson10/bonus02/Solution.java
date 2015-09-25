package com.javarush.test.level20.lesson10.bonus02;

/* ���������-��������������
1. ��� ��������� ������ N*N, ������� �������� ��������� ���������������.
2. ��������� �������������� �� ������������� � �� �������������.
3. ������ ������������� ���� �������� 1.
4. � �������:
4.1) a[i, j] = 1, ���� ������� (i, j) ����������� ������-���� ��������������
4.2) a[i, j] = 0, � ��������� ������
5. getRectangleCount ������ ���������� ���������� ���������������.
6. ����� main �� ��������� � ������������
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". ������ ���� 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count=0;
        if(a!=null)
            if(a.length>0)
            {
                int height = a.length;
                int width = a[0].length;
                boolean kub=false;
                for(int i=0;i<height;i++)
                {
                    for (int k = 0; k < width; k++)
                    {
                        int num = a[i][k];
                        int Hnum=-1;
                        if(i>0)Hnum=a[i-1][k];
                        if (num == 1)
                        {

                            if (!kub & !(Hnum==1)) count++;
                            kub = true;
                        }else kub = false;
                    }
                }
            }
        return count;
    }
}
