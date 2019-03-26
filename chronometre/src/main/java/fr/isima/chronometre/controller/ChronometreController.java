package fr.isima.chronometre.controller;

import fr.isima.chronometre.model.Chronometre;
import fr.isima.chronometre.service.ChronometreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api("Chronometre")
@RestController
@RequestMapping("/api/v1/chronometres")
public class ChronometreController {
    @Autowired
    ChronometreService chronometreService;

    @ApiOperation(value = "Create a new chronometre",
            notes = "Creates a new chronometre with the given number of seconds",
            response = long.class)
    @PostMapping("/")
    public ResponseEntity addNewChronometreSeconds() {

        Date debut = new Date();

        Chronometre chronometre = new Chronometre();
        chronometre.setDebut(debut);

        chronometre = chronometreService.saveOrUpdate(chronometre);

        return ResponseEntity.ok(chronometre.getId());
    }

    @ApiOperation(value = "Return the time of a chronometre",
            notes = "Return the number of milliseconds from the start of a chronometre",
            response = int.class)
    @GetMapping("/{id}")
    public ResponseEntity getChronometreTime(@PathVariable @ApiParam(value="Chronometre Id",required = true,example = "31") long id) {
        try {
            Chronometre chronometre = chronometreService.getChronometreById(id);
            return ResponseEntity.ok(chronometre.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Id not found");
        }
    }
}
