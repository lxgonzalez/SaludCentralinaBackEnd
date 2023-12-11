package lgonzalez.service.impl;

import lgonzalez.model.Patient;
import lgonzalez.repo.IPatientRepo;
import lgonzalez.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepo repo;
    @Override
    public Patient save(Patient p) {
        return repo.save(p);
    }

    @Override
    public Patient update(Patient p) {
        return repo.save(p);
    }

    @Override
    public Patient findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
