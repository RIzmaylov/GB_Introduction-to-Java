package Homework_02.Task_01;

// Дана строка sql-запроса:
// select * from students where "

// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные (параметры) для фильтрации приведены в виде json-строки в примере ниже. Если значение null, 
// то параметр не должен попадать в запрос.

// Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:

// String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами

// Пример: Строка sql-запроса:

// select * from students where 
// Параметры для фильтрации:

//  {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Результат:

// select * from students where name='Ivanov' and country='Russia' and city='Moscow'


class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder sb = new StringBuilder(QUERY);
        PARAMS.replace("{", "");
        PARAMS.replace("}", "");

        for (int i = 0; i < PARAMS.length() - 2;) {
            int indexFirst = PARAMS.indexOf('"', i);
            indexFirst++;
            int indexSec = PARAMS.indexOf('"', indexFirst);
            String parametr = PARAMS.substring(indexFirst, indexSec);
            indexSec++;

            indexFirst = PARAMS.indexOf('"', indexSec);
            indexFirst++;
            indexSec = PARAMS.indexOf('"', indexFirst);
            String value = PARAMS.substring(indexFirst, indexSec);
            if (!value.equalsIgnoreCase("null")) {
                if (!parametr.equalsIgnoreCase("name")) {
                    sb.append(" and ");
                }
                sb.append(parametr + "='" + value + "'");
            }
            indexSec++;
            i = indexSec;
        }
        return sb;
    }
}

// Решение семинариста:

// public static StringBuilder answer2(String QUERRY, String PARAMS) {
//     StringBuilder stringBuilder = new StringBuilder();
//     stringBuilder.append(QUERRY);

//     String[] partQuerry = PARAMS.split(",");        // делим на пары ключ - значение
//     for (int i = 0; i < partQuerry.length; ++i) {
//         if (!partQuerry[i].contains("null")) {          // если есть в строке null не рассматриваем эту пару
//             String part = partQuerry[i];
//             part = part.replaceAll("[{\"}]", "");   // регулярное выражение. Все указанные элементы заменятся на ничто
//             String[] partPart = part.split(":");    // делим оставшееся на массив из 2 элементов ключ и значение
//             stringBuilder.append(partPart[0]);
//             stringBuilder.append("=");
//             if (!partPart[1].matches("[0-9]*")) {   // регулярное выражение, проверяется, если цифры - то не обрабатываем, если текст то в кавычки
//                 stringBuilder.append("'");
//                 stringBuilder.append(partPart[1]);
//                 stringBuilder.append("'");
//             } else {
//                 stringBuilder.append(partPart[1]);         // если только цифры, то без кавычек
//             }

//             stringBuilder.append(" and");
//         }
//     }

//     stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());   // удаляет в конце строки - " and"

//     return stringBuilder;
// }


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
}
