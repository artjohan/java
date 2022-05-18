package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    @GetMapping("lesson2/generateArray")
    public int[] generateArray(int n) {
        return Lesson2.generateArray(n);
    }
    @GetMapping("lesson2/decreasingArray")
    public int[] decreasingArray(int n) {
        return Lesson2.decreasingArray(n);
    }
    @GetMapping("lesson2/yl3")
    public int[] yl3(int n) {
        return Lesson2.yl3(n);
    }
}
