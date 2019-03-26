package fr.isima.chronometre.controller;

import fr.isima.chronometre.model.Minuteur;
import fr.isima.chronometre.service.MinuteurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@Api("Chronometre")
@RestController
@RequestMapping("/api/v1/minuteurs")
public class MinuteurController {
    @Autowired
    MinuteurService minuteurService;

    @ApiOperation(value = "Create a new minuteur",
            notes = "Creates a new minuteur with the given number of seconds",
            response = long.class)
    @PostMapping("/{seconds}")
    public ResponseEntity addNewMinuteurSeconds(@PathVariable @ApiParam(value="Number of seconds",required = true,example = "3600") int seconds) {

        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND, seconds);
        Date fin = now.getTime();

        Minuteur minuteur = new Minuteur();
        minuteur.setFin(fin);

        minuteur = minuteurService.saveOrUpdate(minuteur);

        return ResponseEntity.ok(minuteur.getId());
    }

    @ApiOperation(value = "Return the remaining time of a minuteur",
            notes = "Return the number of remaining milliseconds to the end of a minuteur",
            response = int.class)
    @GetMapping("/{id}")
    public ResponseEntity getMinuteurRemainingTime(@PathVariable @ApiParam(value="Minuteur Id",required = true,example = "31") long id) {
        try {
            Minuteur minuteur = minuteurService.getMinuteurById(id);
            return ResponseEntity.ok(minuteur.getRemainingTime());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Id not found");
        }
    }
}
