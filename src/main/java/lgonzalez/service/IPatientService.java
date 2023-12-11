package lgonzalez.service;

import lgonzalez.model.Patient;

import java.util.List;

public interface IPatientService {
    Patient save(Patient p);
    Patient update(Patient p);
    Patient findById(Integer id);
    List<Patient> findAll();
    void delete(Integer id);
}
