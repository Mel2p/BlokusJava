package composites.userWinrateComposite.clients;

import composites.userWinrateComposite.entities.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("UserClient")
public interface IUserClient {

    @RequestLine("GET /user/{username}")
    User getOneByUsername(@Param("username") String username);
}
