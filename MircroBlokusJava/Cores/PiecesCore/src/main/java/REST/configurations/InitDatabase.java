package REST.configurations;

import REST.entities.Piece;
import REST.repositories.PieceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitDatabase {

    @Bean
    CommandLineRunner initialize(PieceRepository pieceRepository) {
        return args -> {
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 1, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 2, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 3, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 3, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 4, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 4, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 4, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 4, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 4, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,1,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,0", false)));
            log.info("Database initialisation with :" + pieceRepository.save(new Piece( 5, "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1", false)));
        };
    }
}
