package comAPi.Controller;

import comAPi.UserModelFeignAPi.UserFeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFeignController {
    @Resource
    private UserFeignApi userFeignApi;
    @GetMapping("/feign/users/hello")
    public String hello()
    {
        return userFeignApi.hello();
    }

}
