package REST.repositories;

import REST.entities.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    Game gameTest = new Game("1","BOARD", 1,"1");
    Optional emptyoptional = Optional.empty();

    @Before
    public void setup(){

    }

    @Test
    public void should_create_right_game(){
        gameRepository.save(gameTest);
        assertEquals("gameTest should be the same optional as the saved game", gameRepository.findById("1"), Optional.of(gameTest));
    }

    @Test
    public void should_delete_right_game(){
        gameRepository.delete(gameTest);
        assertEquals("should return empty optional", gameRepository.findById("1"), emptyoptional) ;
    }
}
