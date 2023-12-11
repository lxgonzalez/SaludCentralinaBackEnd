package lgonzalez.service;

import lgonzalez.model.Consult;

import java.util.List;

public interface IConsultService {
    Consult findById(Integer id);
    List<Consult> findAll();
    void delete(Integer id);
    void saveTransactional(Consult consult);

}
