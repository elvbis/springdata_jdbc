package pe.springdata.jdbc.person.service;

import pe.springdata.jdbc.person.domain.PersonIn;
import pe.springdata.jdbc.person.domain.PersonOut;

import java.util.List;

public interface PersonService {
	List<PersonOut> getAllPersons();
    void saveNewDocument(PersonIn personIn) throws Exception;
    void save(PersonIn personIn);
}
