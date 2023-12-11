package lgonzalez.service;

import lgonzalez.model.Consult;
import lgonzalez.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPatientService {
    Patient save(Patient p);
    Patient update(Patient p);
    Patient findById(Integer id);
    List<Patient> findAll();
    void delete(Integer id);
}
