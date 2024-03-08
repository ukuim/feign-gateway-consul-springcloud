package comAPi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserHelloController {
    @GetMapping("/users/hello")
    public String hello1()
    {
        return "hello1";
    }

}
