import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Input:");

        Scanner scan = new Scanner(System.in);
        String val = scan.nextLine().trim();
        String[] valArray = val.split(" ", 3);  //получаем массив без пробелов типа a+b (0 1 2)
        Rim[] romanArray = Rim.values();

        String a = valArray[0];
        String b = valArray[2];
        String z = valArray[1];
        int x, y, c;
        Boolean check1 = false;
        Boolean check2 = false;

        for (int l = 0; l < romanArray.length; l++) {
            if (Objects.equals(valArray[0], String.valueOf(romanArray[l]))) {
                for (int i = 0; i < romanArray.length; i++) {
                    if (Objects.equals(valArray[0], String.valueOf(romanArray[i]))) {
                        a = String.valueOf(i + 1);
                        check1 = true;
                        break;
                    }
                }
                for (int j = 0; j < romanArray.length; j++) {
                    if (Objects.equals(valArray[2], String.valueOf(romanArray[j])) && check1) {
                        b = String.valueOf(j + 1);
                        check2 = true;
                        break;
                    } else {check2 = false;}
                }
                if (!check2) {throw new Exception ("Ошибка ввода данных");}
                break;
            }
        }
        x = Integer.parseInt(a);
        y = Integer.parseInt(b);
        if (x <=10 && y<=10) {
            switch (z) {
                case "+":
                    c = x + y;
                    break;
                case "-":
                    c = x - y;
                    break;
                case "*":
                    c = x * y;
                    break;
                case "/":
                    c = x / y;
                    break;
                default:
                    throw new Exception("Неверный знак операции");
            }
            System.out.println("Output:");
            if (check1 && check2) {
                System.out.println(romanArray[c - 1]);
            } else {
                System.out.println(c);
            }
        } else {throw new Exception("Введите число не более 10");}
    }
}