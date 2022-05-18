package ee.bcs.java.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Lesson3 {

    public static void main(String[] args) {
        System.out.println(morseCode("Hello world"));
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int[] f = new int[x];
        int index = 0;
        int index2 = 0;
        int sum = 1;
        while (index < x) {
            f[index] = f[index] + x - index;
            index = index + 1;
        }
        while (index2 < x) {
            sum = sum * f[index2];
            index2 = index2 + 1;
        }
        return sum;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        int n = a.length();
        char[] s = new char[n];
        int index = 0;
        //a.getChars(0, n, s, 0);
        while (index < n) {
            char temp = a.charAt(index);
            s[index] = temp;
            index = index + 1;
        }
        char[] reverseArray = new char[n];
        int index2 = 0;
        while (index2 < n) {
            reverseArray[index2] = s[n - index2 - 1];
            index2 = index2 + 1;
        }
        String reverse = new String(reverseArray);
        return reverse;
    }

    // TODO tagasta kas sisestatud arv on algarv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x){
        float index = 1;

        if (x == 1) {
            return false;
        }
        else {
            while (index < x - 1) {
                index = index + 1;
                float result = x / index;
                if (result%1 == 0) {
                    return false;
                }
                else if (index == x - 1) {
                    break;
                }
            } return true;
        }
    }

    // TODO sorteeri massiiv suuruse järgi (väiksemast suuremaks)
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        int n = a.length;
        int index = 0;
        while (index < n-1) {
            if (a[index] > a[index + 1]) {
                int temp = a[index + 1];
                a[index + 1] = a[index];
                a[index] = temp;
                index = 0;
            }
            else {
                index = index + 1;
            }
        }
        return a;
    }

    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
    public static int evenFibonacci(int x){
        if (x == 0 || x == 1) {
            return 0;
        }
        else {
            int[] jada = new int[x + 1];
            jada[0] = 0;
            jada[1] = 1;
            for (int i = 2; i <= x; i++) {
                jada[i] = (jada[i - 1]) + (jada[i - 2]);
                if (jada[i] >= x) {
                    break;
                }
            }
            int sum = 0;
            for (int i2 = 0;i2 < x;i2++) {
                if (jada[i2]%2 == 0) {
                    sum = sum + jada[i2];
                }
            }
            return sum;
        }
    }

    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
    // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
    public static String morseCode(String text){
        Map<Character, String> morse = new HashMap<>();

        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c', "-.-.");
        morse.put('d', "-..");
        morse.put('e', ".");
        morse.put('f', "..-.");
        morse.put('g', "--.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".---");
        morse.put('k', "-.-");
        morse.put('l', ".-..");
        morse.put('m', "--");
        morse.put('n', "-.");
        morse.put('o', "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s', "...");
        morse.put('t', "-");
        morse.put('u', "..-");
        morse.put('v', "...-");
        morse.put('w', ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2', "..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put(' ', "\t");
        char[] inputArray = text.toLowerCase().toCharArray();
        int n = inputArray.length;
        String[] morseArray = new String[n];
        String morseFinal = new String();
        for (int i = 0;i < n;i++) {
            morseArray[i] = morse.get(inputArray[i]);
        }
        for (int i = 0;i < n;i++) {
            morseFinal = morseFinal + morseArray[i] +" ";
        }
        return morseFinal.trim();
    }
}
