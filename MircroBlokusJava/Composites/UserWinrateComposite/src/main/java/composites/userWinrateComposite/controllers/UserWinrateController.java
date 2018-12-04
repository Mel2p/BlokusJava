package composites.userWinrateComposite.controllers;


import composites.userWinrateComposite.entities.User;
import composites.userWinrateComposite.entities.UserWithWinrate;
import composites.userWinrateComposite.services.UserWinrateService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWinrateController {

    @Setter
    @Autowired
    UserWinrateService userWinrateService;

    @RequestMapping("/user/{username}/winrate")
    ResponseEntity<UserWithWinrate> getUserWinrate(@PathVariable String username){
        return new ResponseEntity<>(userWinrateService.returnUserWinrate(username), HttpStatus.OK);
    }
}
