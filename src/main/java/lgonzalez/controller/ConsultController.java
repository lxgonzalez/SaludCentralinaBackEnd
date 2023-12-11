package lgonzalez.controller;

import lgonzalez.model.Consult;
import lgonzalez.service.IConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/consults")
public class ConsultController {
    @Autowired
    private IConsultService service;

    @GetMapping
    public ResponseEntity<List<Consult>> findALl() {
        List<Consult> consultList = service.findAll();
        return new ResponseEntity<>(consultList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Consult obj){
        service.saveTransactional(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        Consult obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}





