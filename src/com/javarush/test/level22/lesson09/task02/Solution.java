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
        int i=0;
        for(Map.Entry<String,String> pair : params.entrySet()){
            String x = pair.getKey();
            String y = pair.getValue();
            if(y!=null){
                if(i!=params.size()-1)
                str.append(x + " = " + "'" + y + "'" + " and ");
                else str.append(x + " = " + "'" + y + "'");

            }
            ++i;
        }

        return str;
    }
}
