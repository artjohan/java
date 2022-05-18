package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson2;
import ee.bcs.java.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2bController {

    @PostMapping("lesson2b/reverseArray")
    public int[] reverseArray(@RequestBody int[] inputArray) {
        return Lesson2b.reverseArray(inputArray);
    }
    @PostMapping("lesson2b/evenNumbers")
    public int[] evenNumbers(@RequestBody int n) {
        return Lesson2b.evenNumbers(n);
    }
    @PostMapping("lesson2b/min")
    public int min(@RequestBody int[] x) {
        return Lesson2b.min(x);
    }
    @PostMapping("lesson2b/max")
    public int max(@RequestBody int[] x) {
        return Lesson2b.max(x);
    }
    @PostMapping("lesson2b/sum")
    public int sum(@RequestBody int[] x) {
        return Lesson2b.sum(x);
    }
    @PostMapping("lesson2b/fibonacci")
    public int fibonacci(@RequestBody int n) {
        return Lesson2b.fibonacci(n);
    }
    @PostMapping("lesson2b/sequence3n")
    public int sequence3n(@RequestBody Sequence3nRequestDto request) {
        return Lesson2b.sequence3n(request.getX(), request.getY());
    }
}
