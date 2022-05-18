package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonD {
    public static void main(String[] args) {
        yl8();

    }

    // Kõiki alljärgnevaid ülesandeid lahenda kasutades tsükleid
    // TODO trüki numbrid 1 -> 10
    public static void yl1(){
        int x = 1;
        while (x < 10) {
            System.out.println(x);
            x = x + 1;
        }
        System.out.println(x);
    }

    // TODO trüki numbrid 10 -> 1
    public static void yl2(){
        int x = 10;
        while (x > 1) {
            System.out.println(x);
            x = x - 1;
        }
        System.out.println(x);
    }

    // TODO trüki paaris numbrid 2->20
    public static void yl3(){
        int x = 2;
        while (x < 19) {
            System.out.println(x);
            x = x + 2;
        }
        System.out.println(x);
    }

    // TODO trüki numbrid 1 -> n
    public static void yl4(int n){
        int x = 1;
        while (x < n) {
            System.out.println(x);
            x = x + 1;
        }
        System.out.println(x);
    }

    // TODO trüki numbrid n -> 1
    public static void yl5(int n){
        int x = n;
        while (x > 1) {
            System.out.println(x);
            x = x - 1;
        }
        System.out.println(x);
    }

    // TODO trüki paaris numberid 2->n
    public static void yl6(int n){
        int x = 2;
        if (n%2 == 0) {
            while (x < n) {
                System.out.println(x);
                x = x + 2;
            }
        }
        else {
            while(x < n - 1) {
                System.out.println(x);
                x = x + 2;
            }
        }
        System.out.println(x);
    }

    // TODO kasutades Scannerit loe sisse üks number, korruta see 2-ga ja trüki välja
    // TODO2 kasutades while loopi, tee seda nii kaua kuni kasutaja sisestab 0-i
    public static void yl7(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta number");
        int x = scanner.nextInt();
        while(x != 0) {
            System.out.println(x*2);
            System.out.println("Sisesta number");
            x = scanner.nextInt();
        }
    }


    // TODO täienda yl1 main meetodit
    // TODO tee nii, et kasutaja saaks lõputult valida uusi valikuid
    // TODO lisa uus käsklus (exit) valikusse
    // TODO kui kasutaja valib exit käsu siis lõpeta programmi töö
    public static void yl8(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) yl1");
            System.out.println("2) exit");
            int valik = scanner.nextInt();
            if (valik == 1) {
                System.out.println("Sisesta esimene number");
                int x = scanner.nextInt();
                System.out.println("Sisesta teine number");
                int y = scanner.nextInt();
                if (x < y) {
                    while (x < y) {
                        System.out.println(x);
                        x = x + 1;
                    }
                    System.out.println(x);
                }
                else if (x > y) {
                    while (x > y) {
                        System.out.println(x);
                        x = x - 1;
                    }
                    System.out.println(x);
                }
                else System.out.println("Numbrid ei saa võrdsed olla");
            }
            else if (valik == 2) {
                break;
            }
            else System.out.println("Pole valikus");
        }
    }

    // TODO jätka Lesson3Hard
}
