package fr.isima.calcul.controller;

import fr.isima.calcul.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Operations")
@RestController
@RequestMapping("/api/v1/calcul")
public class OperationController {

    @ApiOperation(value = "Get addition result",
            notes = "",
            response = int.class)
    @GetMapping("/addition")
    public ResponseEntity getAdditionResult(@RequestParam @ApiParam(value="First member of the addition",required = true,example = "1") int a, @RequestParam @ApiParam(value="Second member of the addition",required = true,example = "1") int b) {
        Operation operation = new Addition(a, b);

        ResponseEntity response = null;

        operation.calculer();
        response = ResponseEntity.ok(operation.getResult());
        return response;
    }

    @ApiOperation(value = "Get substraction result",
            notes = "",
            response = int.class)
    @GetMapping("/soustraction")
    public ResponseEntity getSoustractionResult(@RequestParam @ApiParam(value="First member of the soustraction",required = true,example = "1") int a, @RequestParam @ApiParam(value="Second member of the soustraction",required = true,example = "1") int b) {
        Operation operation = new Soustraction(a, b);

        ResponseEntity response = null;

        operation.calculer();
        response = ResponseEntity.ok(operation.getResult());
        return response;
    }

    @ApiOperation(value = "Get multiplication result",
            notes = "",
            response = int.class)
    @GetMapping("/multiplication")
    public ResponseEntity getMultiplicationResult(@RequestParam @ApiParam(value="First member of the multiplication",required = true,example = "1") int a, @RequestParam @ApiParam(value="Second member of the multiplication",required = true,example = "1") int b) {
        Operation operation = new Multiplication(a, b);

        ResponseEntity response = null;

        operation.calculer();
        response = ResponseEntity.ok(operation.getResult());
        return response;
    }

    @ApiOperation(value = "Get division result",
            notes = "",
            response = int.class)
    @GetMapping("/division")
    public ResponseEntity getDivisionResult(@RequestParam @ApiParam(value="First member of the division",required = true,example = "1") int a, @RequestParam @ApiParam(value="Second member of the division",required = true,example = "1") int b) {
        Operation operation = new DivisionEuclidienne(a, b);

        ResponseEntity response = null;

        operation.calculer();
        response = ResponseEntity.ok(operation.getResult());
        return response;
    }

    @ApiOperation(value = "Get division remainder",
            notes = "",
            response = int.class)
    @GetMapping("/divisionremainder")
    public ResponseEntity getDivisionRemainder(@RequestParam @ApiParam(value="First member of the division",required = true,example = "1") int a, @RequestParam @ApiParam(value="Second member of the division",required = true,example = "1") int b) {
        DivisionEuclidienne operation = new DivisionEuclidienne(a, b);

        ResponseEntity response = null;

        operation.calculer();
        response = ResponseEntity.ok(operation.getReste());
        return response;
    }
}
