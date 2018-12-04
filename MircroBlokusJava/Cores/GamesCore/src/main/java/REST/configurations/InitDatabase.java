package REST.configurations;

import REST.entities.Game;
import REST.repositories.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class InitDatabase {

    List<Long> idPiecePlayedByRedPlayer= new ArrayList<>();
    List<Long> idPiecePlayedByBluePlayer= new ArrayList<>();

    @Bean
    CommandLineRunner initialize(GameRepository gameRepository) {
        return args -> {
            //log.info("Database initialisation with :" + gameRepository.save(new Game( "[1,1,0,0,0,0,0,0,0,0,0,0,0,0],[0,1,1,0,0,0,0,0,0,0,0,0,0,0]", 1,"MelitoZgueguito")));
            //log.info("Database initialisation with :" + gameRepository.save(new Game( "[1,1,0,1,1,1,0,0,0,0,0,0,0,0],[0,1,1,0,0,0,0,0,0,0,0,0,0,0]", 2,"MelitoZgueguito")));
        };
    }
}
