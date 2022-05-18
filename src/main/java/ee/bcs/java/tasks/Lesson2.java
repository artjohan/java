package ee.bcs.java.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decreasingArray(-2)));
        System.out.println(Arrays.toString(decreasingArray(-1)));
        System.out.println(Arrays.toString(decreasingArray(0)));
        System.out.println(Arrays.toString(decreasingArray(1)));
        System.out.println(Arrays.toString(decreasingArray(2)));
        System.out.println(Arrays.toString(sampleArray()));
        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] x = new int[n];
        int index = 0;
        while(index < n) {
            x[index] = index +1;
            index = index +1;
        }
        return x;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {

        int index = 0;
        if (n > 0) {
            int[] result = new int[n+1];
            while(index < n) {
                result[index] = n-index;
                index = index +1;
            }
            return result;
        }
        else if (n < 0) {
            int[] result = new int[-n+1];
            while(index < -n) {
                result[index] = n+index;
                index = index +1;
            }
            return result;
        }
        else {
            int[] d = {0};
            return d;
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] b = new int[n];
        int index = 0;
        while(index < n) {
            b[index] = 3;
            index = index +1;
        }
        return b;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        return a;
    }
}
