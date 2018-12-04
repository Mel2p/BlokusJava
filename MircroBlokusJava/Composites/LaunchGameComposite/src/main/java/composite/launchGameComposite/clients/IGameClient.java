package composite.launchGameComposite.clients;

import composite.launchGameComposite.entities.Game;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

 @Component
 @FeignClient("GameClient")
 public interface IGameClient {

        @RequestLine("GET /games/{id}")
        Game getOneById(@Param("id") String id);
 }

