package REST.controllers;

import REST.entities.Piece;
import REST.exceptions.PieceNotFoundException;
import REST.repositories.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PieceController {

    @Autowired
    private PieceRepository pieceRepository;

    @RequestMapping(value = "/pieces", method = RequestMethod.GET)
    List<Piece> getAll(){
        return pieceRepository.findAll();
    }

    @RequestMapping(value = "/pieces/{id}", method =  RequestMethod.GET)
    Piece getOne(@PathVariable String id){
        return pieceRepository.findById(id)
                .orElseThrow(()-> new PieceNotFoundException(id));
    }

}
