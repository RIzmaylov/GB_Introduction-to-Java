package Homework_02.Task_01;


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
