package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson2b;
import ee.bcs.java.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {
    @GetMapping("lesson3/factorial")
    public int factorial(int x) {
        return Lesson3.factorial(x);
    }
    @GetMapping("lesson3/reverseString")
    public String reverseString(String a) {
        return Lesson3.reverseString(a);
    }
    @GetMapping("lesson3/isPrime")
    public boolean isPrime (int x) {
        return Lesson3.isPrime(x);
    }
    @GetMapping("lesson3/sort")
    public int[] sort(int[] a) {
        return Lesson3.sort(a);
    }
    @GetMapping("lesson3/evenFibonacci")
    public int evenFibonacci(int x) {
        return Lesson3.evenFibonacci(x);
    }
    @GetMapping("lesson3/morseCode")
    public String morseCode(String text) {
        return Lesson3.morseCode(text);
    }
}
