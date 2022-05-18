package ee.bcs.java.tasks;

import java.util.Arrays;

public class Lesson2c {

    public static void main(String[] args) {
        System.out.println(sequence3n(10, 30));
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
    // Näiteks sisendi 10 ja 20 puhul on vastus 21

    // TODO 3
    //  tehke tsükkel x -> y
    //  kutsuge iga väärtuse korral välja meetodit getSeqLength
    //  salvestage maha kõige suurem ja funktsiooni lõpus tagastage leitud arv
    public static int sequence3n(int x, int y) {
        int s = y-x+1;
        int[] a = new int[s];
        int index = 0;

        while (x <= y) {
            int b = getSeqLength(x);
            a[index] = b;
            if (index != s) {
                index = index + 1;
            }
            x = x + 1;
        }
        int index2 = 0;

        while (index2 < s - 1) {
            if (a[index2] > a[index2 + 1]) {
                a[index2 + 1] = a[index2];
            }
            index2 = index2 + 1;
        }
        return a[s - 1];
    }

    // TODO 2
    //  kutsuge välja meetodit nextElement nii kaua kuni vastus tuleb 1
    //  tagastage korduste arv + 1
    //  x = 1 ->1
    //  x = 2 -> 2
    public static int getSeqLength(int x){
        int index = 0;

        while (nextElement(x) != 1) {
            nextElement(x);
            int y = nextElement(x);
            x = y;
            if (nextElement(x) == 1) {
                index = index + 2;
            }
            else {
                index = index + 1;
            }
        }
        return index + 1;
    }

    // TODO 1
    //  tagasta jada järgmine element
    //  x = 1 -> 4
    //  x = 2 -> 1
    //  x = 3 -> 10
    public static int nextElement(int x){
        if (x == 1) {
            return x;
        }
        else if (x % 2 == 0) {
            x = x / 2;
        }
        else {
            x = 3 * x + 1;
        }
        return x;
    }

}
