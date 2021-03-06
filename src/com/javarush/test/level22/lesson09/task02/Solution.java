package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder str = new StringBuilder();
            if(params!=null)
            {
                int i = 0;
                for (Map.Entry<String, String> pair : params.entrySet())
                {
                    ++i;
                    String x = pair.getKey();
                    String y = pair.getValue();
                    if (y != null && x != null){
                        str.append(x + " = " + "'" + y + "' and ");
                    }
                    if (params.size() == i && str.length() > 0){
                        int a = str.length() - 5;
                        int b = str.length();
                        str.delete(a, b);
                    }
                }
            }
        return str;
    }
}
