package lgonzalez.repo;

import lgonzalez.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {
}
