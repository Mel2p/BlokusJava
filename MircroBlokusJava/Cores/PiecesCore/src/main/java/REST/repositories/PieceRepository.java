package REST.repositories;

import REST.entities.Piece;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends MongoRepository<Piece, String> {

}
