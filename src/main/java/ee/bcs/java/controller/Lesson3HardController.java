package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {
    static Random random = new Random();
    static int r = random.nextInt(100);
    static int i = 1;

    @GetMapping("lesson3/game")
    public String game(int a) {
        if (a >= 0 && a <= 99) {
            if (a > r) {
                i++;
                return "Arv on väiksem";
            }
            else if (a < r) {
                i++;
                return "Arv on suurem";
            }
            else {
                r = random.nextInt(100);
                int n = i;
                i = 1;
                return "Õige vastus! Numbri ära arvamiseks läks " + (n) + " katset.";
            }
        }
        else return "Arv peab olema vahemikus 0-99";
    }

    static int max = 99;
    static int min = 0;

    @PutMapping("lesson3/game2")
    public String game2(@RequestBody int a) {
        if (a >= 0 && a <= 99) {
            if (a <= (max + min)/2) {
                if (a > min) {
                    min = a;
                }
                if (max - min == 1) {
                    max = 99;
                    min = 0;
                    return "Mäng on läbi";
                }
                else {
                    return "Arv on suurem " + min + max;
                }
            }
            else {
                if (a < max) {
                    max = a;
                }
                if (max - min == 1) {
                    max = 99;
                    min = 0;
                    return "Mäng on läbi";
                }
                else  {
                    return "Arv on väiksem" + min + max;
                }
            }
        }
        else return "Arv peab olema vahemikus 0-99";
    }
}
