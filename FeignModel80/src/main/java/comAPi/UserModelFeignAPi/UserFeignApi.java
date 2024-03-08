package comAPi.UserModelFeignAPi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "Gateway")
public interface UserFeignApi {
   @GetMapping("/users/hello")
   String hello() ;

}
