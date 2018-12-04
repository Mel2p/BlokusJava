package composites.EndGameComposite.clients;

import composites.EndGameComposite.entities.GameAndPlayersPieces;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("GameAndPlayersPiecesClient")
public interface IGameAndPlayersPiecesClient {

    @RequestLine("GET game/finalobject/{id}")
    GameAndPlayersPieces getOneById(@Param("id") String id);
}
