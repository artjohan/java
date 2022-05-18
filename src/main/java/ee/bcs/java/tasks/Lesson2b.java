package ee.bcs.java.tasks;

import java.util.Arrays;

public class Lesson2b {

    public static void main(String[] args) {
        //System.out.println(sequence3n(10, 20));
        System.out.println(fibonacci(1));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int n = inputArray.length;
        int index = 0;
        int[] reverseArray = new int[n];
        while (index < n) {
            reverseArray[index] = inputArray[n - index - 1];
            index = index + 1;
        }
        return reverseArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu (n >= 0)
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] x = new int[n];
        int index = 0;
        while (index < n) {
            x[index] = (index + 1)*2;
            index = index + 1;
        }
        return x;

        /*
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = (i +1) * 2;
        }
        return array;*/
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        int n = x.length;
        int index = 0;
        while (index < n-1) {
            if (x[index] < x[index + 1]) {
                x[index + 1] = x[index];
            }
            index = index + 1;
        }
        return x[n-1];
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int n = x.length;
        int index = 0;
        while (index < n-1) {
            if (x[index] > x[index + 1]) {
                x[index + 1] = x[index];
            }
            index = index + 1;
        }
        return x[n-1];
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int n = x.length;
        int index = 0;
        int sum = 0;
        while (index < n) {
            sum = sum + x[index];
            index = index + 1;
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        int index = 1;
        while (index < y + 1) {
            int index2 = 1;
            while (index2 < x + 1) {
                System.out.print(index2*index + " ");
                index2 = index2 + 1;
            }
            System.out.println();
            index = index + 1;
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        else {
            int[] jada = new int[n + 1];
            jada[0] = 0;
            jada[1] = 1;
            for (int i = 2;i <= n;i++) {
                jada[i] = (jada[i - 1]) + (jada[i - 2]);
            }
            //System.out.println(Arrays.toString(jada));
            return jada[n];
        }
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 1 ja 10 puhul on vastus 20

    public static int sequence3n(int x, int y) {
        int s = y-x+1;
        int[] vastused = new int[s];
        int index = 0;

        while (x <= y) {
            int n = x;
            int arv = 1;

            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                }
                else {
                    n = 3 * n + 1;
                }
                arv = arv + 1;
            }
            vastused[index] = arv;
            if (index != s) {
                index = index + 1;
            }
            x = x + 1;
        }
       // System.out.println(Arrays.toString(vastused));
        int index2 = 0;

        while (index2 < s - 1) {
            if (vastused[index2] > vastused[index2 + 1]) {
                vastused[index2 + 1] = vastused[index2];
            }
            index2 = index2 + 1;
        }
        return vastused[s-1];
    }
}
