package lgonzalez.controller;

import lgonzalez.model.Patient;
import lgonzalez.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private IPatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> findALl() {
        List<Patient> patientList = service.findAll();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Patient obj){
        service.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient obj){
        Patient response = service.findById(obj.getIdPatient());
        if (response == null){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        Patient obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}





