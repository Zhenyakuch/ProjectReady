import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        long number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите целое число в промежутке  от -999 999 999 999 до 999 999 999 999, для выхода введите 0: ");
            number = scanner.nextInt();
            System.out.println(Translator.translateToString(number));
        } while (number != 0);
        System.out.println("Введено число /Ноль/ Работа программы завершена");
    }

    }
