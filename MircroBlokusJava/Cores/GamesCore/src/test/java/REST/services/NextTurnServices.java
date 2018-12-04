package REST.services;

import REST.entities.Game;
import REST.repositories.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertSame;

public class NextTurnServices {

    @Mock
    GameRepository gameRepository;


    NextTurnService turnService = new NextTurnService();


    private static Game CLIENT_RESPONSE = new Game("1", "BOARD",1,"2");

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        turnService.setGameRepository(gameRepository);
    }

    @Test
    public void should_increase_number_by_one(){
        Game expectedResult = new Game("1", "BOARD",2,"2");
        Mockito.when(gameRepository.findById("1")).thenReturn(Optional.of(CLIENT_RESPONSE));
        assertSame("turn should be 2",
                expectedResult.getTurn(), turnService.nextTurn("1").getTurn());
    }
}
