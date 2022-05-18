package ee.bcs.java.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("1) Miinimum");
        System.out.println("2) Maksimum");
        System.out.println("3) Absoluutväärtus");
        System.out.println("4) Paaris või paaritu");
        System.out.println("5) Kolme arvu miinimum");
        System.out.println("6) Kolme arvu maksimum");
        int valik = scanner.nextInt();

        if (valik == 1) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            int vastus = min(a, b);
            System.out.println("Väikseim arv on " + vastus);
        }
        if (valik == 2) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            int vastus = max(a, b);
            System.out.println("Suurim arv on " + vastus);
        }
        if (valik == 3) {
            System.out.println("Sisesta number");
            int a = scanner.nextInt();
            int vastus = abs(a);
            System.out.println("Arvu absoluutväärtus on " + vastus);
        }
        if (valik == 4) {
            System.out.println("Sisesta number");
            int a = scanner.nextInt();
            boolean vastus = isEven(a);
            if (vastus == true) {
                System.out.println("See arv on paaris");
            }
            else System.out.println("See arv on paaritu");
        }
        if (valik == 5) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            int vastus = min3(a, b, c);
            System.out.println("Väikseim arv on " + vastus);
        }
        if (valik == 6) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            int vastus = max3(a, b, c);
            System.out.println("Suurim arv on " + vastus);
        }
    }

    // TODO
    //  defineeri 3 muutujat a = 1, b = 1, c = 3
    //  Prindi välja a==b
    //  Prindi välja a==c
    //  Lisa rida a = c
    //  Prindi välja a==b
    //  Prindi välja a==c, mis muutus???
    public static void excersie0() {
        int a = -1;
        int b = 1;
        int c = 3;




    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        }
        else {
            return b;
        }

    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a >= 0) {
            return a;
        }
        else {
            return (-a);
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a%2 == 1) {
            return false;
        }
        else {
            return true;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a < b) {
            if (a < c) {
                return a;
            }
            else {
                return c;
            }
        }
        else {
            if (b < c) {
                return b;
            }
            else {
                return c;
            }
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            }
            else {
                return c;
            }
        }
        else {
            if (b > c) {
                return b;
            }
            else {
                return c;
            }
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

}
