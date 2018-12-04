package REST.repositories;

import REST.entities.Piece;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PieceRepositoryTest {

    @Autowired
    PieceRepository pieceRepository;

    Piece pieceTest = new Piece("1",1, "Shape",true);
    Optional emptyoptional = Optional.empty();

    @Test
    public void should_create_right_game(){
        pieceRepository.save(pieceTest);
        assertEquals("gameTest should be the same optional as the saved game", pieceRepository.findById("1"), Optional.of(pieceTest));
    }

    @Test
    public void should_delete_right_game(){
        pieceRepository.delete(pieceTest);
        assertEquals("should return empty optional", pieceRepository.findById("1"), emptyoptional) ;
    }
}
