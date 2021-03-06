package composite.launchGameComposite.clients;


import composite.launchGameComposite.entities.Piece;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient("PieceClient")
public interface IPieceClient {

    @RequestLine("GET /pieces/")
    List<Piece> getAll();
}
