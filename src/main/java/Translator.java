 public class Translator {

     private static int billion;
     private static int million;
     private static int thousand;
     private static int toThousand;
     private static long numberA;
     private static long numberMax = 999999999999L;
     protected static String numText;

     private static int indexA;
     private static int units;
     private static int decimal;
     private static int hundreds;

     public static String translateToString(long number) {
         numberA = number;
         numText = "";
         if (numberA < -numberMax || numberA > numberMax) {
             return numText = "Число выходит за рамки указанного диапазона";
         }
         if (numberA == 0) {
             return numText = "ноль ";
         }
         if (number < 0) {
             numText = "минус ";
             numberA = -numberA;
         } //делаем позитивное значение number

         billion = (int) (numberA / 1000000000);
         million = (int) (numberA - (billion * 1000000000)) / 1000000;
         thousand = (int) (numberA - (billion * 1000000000) - (million * 1000000)) / 1000;
         toThousand = (int) (numberA % 1000);


         numText = numText + words_to_thousand(billion, 0) + words_to_thousand(million, 1) + words_to_thousand(thousand, 2) + words_to_thousand(toThousand, 3);
         return numText;

     }

     private static String words_to_thousand(int numericalValue, int index) {

         hundreds = numericalValue / 100;
         decimal = (numericalValue - (hundreds * 100)) / 10;
         units = numericalValue % 10;


         numText = "";
         if (decimal == 1) numText = Dictionary.sampleText[2][hundreds] + Dictionary.sample11to19[units];
         else
             numText = Dictionary.sampleText[2][hundreds] + Dictionary.sampleText[1][decimal] + Dictionary.sampleText[0][units];

         if (index == 2) {
             if (units == 1 && decimal != 1) numText = numText + "на ";
             else if (units == 2 & decimal != 1) numText = numText + "е ";
             if (units > 1 && decimal != 1) numText = numText + " ";
         } else {
             if (units == 1 && decimal != 1) numText = numText + "ин ";
             if (units == 2 & decimal != 1) {
                 numText = numText + "а ";
             } else if (units != 0 & decimal != 1) numText = numText + " ";
         }

         indexA = 0;
         if (numericalValue != 0) {
             if (units == 0 || decimal == 1) indexA = 1;
             else if (units == 1) indexA = 2;
             else if (units > 1 & units < 5) indexA = 3;
             else indexA = 4;
         }
         numText = numText + Dictionary.textMillion[indexA][index];
         return numText;
     }

 }


