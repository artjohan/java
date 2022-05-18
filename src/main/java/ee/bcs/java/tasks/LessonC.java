package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) testMath");
        System.out.println("2) testStuff");
        System.out.println("3) userValidation");
        int valik = scanner.nextInt();

        if (valik == 1) {
            System.out.println("Sisesta esimene number");
            int x = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int y = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int z = scanner.nextInt();
            int vastus = testMath(x, y, z);
            System.out.println("Vastus on " +vastus);
        }
        else if (valik == 2) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            System.out.println("Sisesta neljas number");
            int d = scanner.nextInt();
            System.out.println("Sisesta viies number");
            int e = scanner.nextInt();
            System.out.println("Sisesta kuues number");
            int f = scanner.nextInt();
            System.out.println("Sisesta seitsmes number");
            int g = scanner.nextInt();
            int vastus = testStuff(a, b, c, d, e, f, g);
            System.out.println("Sisendites on " +vastus +" paaris arvu");
        }
        else if (valik == 3) {
            System.out.println("addressValid: ");
            boolean addressValid = scanner.nextBoolean();
            System.out.println("emailValid: ");
            boolean emailValid = scanner.nextBoolean();
            System.out.println("telephoneValid: ");
            boolean telephoneValid = scanner.nextBoolean();
            boolean vastus = userValidation(emailValid, telephoneValid, addressValid);
            System.out.println(vastus);
        }
        else System.out.println("Pole valikus");

    }

    // TODO korruta omavahel x ja z ning liida sellele y ja z korrutis
    public static int testMath(int x, int y, int z){
        return (x*z) + (y*z);
    }

    // TODO kui mitu paaris arvu on sisendites
    public static int testStuff(int a, int b, int c, int d, int e, int f, int g){
        int x = 0;
        if (a%2 == 0) {
            x++;
        }
        if (b%2 == 0) {
            x++;
        }
        if (c%2 == 0) {
            x++;
        }
        if (d%2 == 0) {
            x++;
        }
        if (e%2 == 0) {
            x++;
        }
        if (f%2 == 0) {
            x++;
        }
        if (g%2 == 0) {
            x++;
        }
        return x;
    }

    public static boolean userValidation(boolean emailValid, boolean telephoneValid, boolean addressValid){
        // tagasta true, kui muutuja addressValid on tõene ja vähemalt üks (emailValid või telephoneValid) on tõene

       if (addressValid == true) {
            if (emailValid == true || telephoneValid == true) {
                return true;
            }
            else return false;
        }
       else return false;
    }
}
