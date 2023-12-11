package lgonzalez.service.impl;

import jakarta.transaction.Transactional;
import lgonzalez.model.Consult;
import lgonzalez.repo.IConsultRepo;
import lgonzalez.service.IConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultServiceImpl implements IConsultService {

    @Autowired
    private IConsultRepo repo;
    @Override
    public Consult save(Consult m) {
        return repo.save(m);
    }
    @Override
    public Consult update(Consult m) {
        return repo.save(m);
    }
    @Override
    public Consult findById(Integer id) {
        return repo.findById(id).orElse(null);
    }
    @Override
    public List<Consult> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional
    @Override
    public Consult saveTransactional(Consult consult) {
        consult.getDetails().forEach(det -> det.setConsult(consult));
        repo.save(consult);
        return null;
    }
}
