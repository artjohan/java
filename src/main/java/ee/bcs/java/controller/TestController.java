package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public ClientDto test() {
        ClientDto client = new ClientDto();
        client.setFirstName("Siim");
        client.setLastName("Rebane");
        client.setAddress("Tallinn");
        return client;
    }

    @PostMapping("test")
    public void test2(@RequestBody ClientDto clientDto) {
        System.out.println(clientDto.getFirstName());
        System.out.println(clientDto.getLastName());
        System.out.println(clientDto.getAddress());
    }
}
