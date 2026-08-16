package lk.ijse.eca.trainingprogramservice.client;

import lk.ijse.eca.trainingprogramservice.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/api/v1/user/role/{email}")
    Role getUserRole(@PathVariable("email") String email);
}