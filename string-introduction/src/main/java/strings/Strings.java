package strings;

import java.util.Arrays;

public class Strings {
        static final String keyWords[] = { "abstract", "assert", "boolean",
                    "break", "byte", "case", "catch", "char", "class", "const",
                    "continue", "default", "do", "double", "else", "enum", "extends", "false",
                    "final", "finally", "float", "for", "goto", "if", "implements",
                    "import", "instanceof", "int", "interface", "long", "native",
                    "new", "null", "package", "private", "protected", "public",
                    "return", "short", "static", "strictfp", "super", "switch",
                    "synchronized", "this", "throw", "throws", "transient", "true",
                    "try", "void", "volatile", "while" }; // массив ключевых слов
    public static String firstName() {
               return "[A-Z][a-z]{4,}"; // допустимы  буквенные символы 1 заглавныые и строчные длинной 4
    }
    public static String javaVariable() {
              return "((?!_$)[a-zA-Z$_][\\w$]*)";
    }
    public static String number0_300() {
       
        return "[1-9]\\d?|[1-2]\\d\\d|300|0";
    }
    public static String ipV4Octet(){
        
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }
    public static String ipV4Address(){
        String octetExpr = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }
    public static String stringWithJavaNames(String names) {
       String [] tokens = names.split("\\s+"); // делаем массив из строки удаляя пробел который будет разделителем
        int i = getJavaNameIndex(tokens, -1);
       String res = "";
       if (i >= 0) {
         res = tokens[i];
       }
       while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
       }
       
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0; // matches str.matches(regex) Указывает, соответствует ли эта строка заданному регулярному выражению. и ищем совпадение  бинарным поиском
}
public static boolean isArithmeticExpression(String expr) { //если соответствует регуляркам и скобки парные
    return rightSymbols(expr) && isBrakes(expr);
   }

   public static boolean rightSymbols(String expr) {
       return expr.matches("^(?!.*[+\\-*/]{2})(?!.*\\(\\)).*$") && expr.matches("[\\d()+*/-]+$"); // проверяем соответствие регуляркам
   }
   public static boolean isBrakes(String expr) {
       String [] parts = expr.split("");
       int i = 0;
       int countBraket = 0;
       while (i < parts.length) {
           if (parts[i].equals("(") ) {
               countBraket++;
           } else if (parts[i].equals(")")) {
               countBraket--;
           }
           i++;
       }
       return  countBraket == 0 ? true : false; // если каунтер равен нулю то скобки парные
   }

}