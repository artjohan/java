package ee.bcs.java.tasks;

import java.util.Scanner;

public class LessonB {

    public static void main(String[] args) {
        // TODO kasuta scannerit nii, et mainist oleks võimalik kõiki meetodeid välja kutsuda
        // Täpselt nii nagu Lesson 1 main meetod
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) checkOrder");
        System.out.println("2) checkEqual");
        System.out.println("3) isSmall");
        int valik = scanner.nextInt();

        if (valik == 1) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            String vastus = checkOrder(a, b, c);


        }
        else if (valik == 2) {
            System.out.println("Sisesta esimene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            Boolean vastus = checkEqual(a, b, c);
            System.out.println(vastus);
        }
        else if (valik == 3) {
            System.out.println("Sisesta number");
            int a = scanner.nextInt();
            Boolean vastus = isSmall(a);
            System.out.println(vastus);
        }
        else System.out.println("Valik puudub");

    }

    public static String checkOrder(int a, int b, int c){
        // Print "increasing" if c > b > a
        // Print "decreasing" if c < b < a
        // Print "neither" if none of them is true
        if (c > b && b > a) {
            System.out.println("increasing");
        }
        else if (c < b && b < a) {
            System.out.println("decreasing");
        }
        else System.out.println("neither");
        return null;
    }

    public static boolean checkEqual(int a, int b, int c){
        // return true if all 3 parameters are the same
        if (a == b && b == c) {
            return true;
        }
        else return false;

    }

    public static boolean isSmall(int a){
        // return true if the absolute number of a is smaller than 1000
        if (a >= 0){
            if (a < 1000) {
                return true;
            }
            else return false;
        }
        else if (a <= 0) {
            if (-a < 1000) {
                return true;
            }
            else return false;
        }
        return true;
    }

}
