package pe.springdata.jdbc.person.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pe.springdata.jdbc.common.NumberUtil;
import pe.springdata.jdbc.person.domain.PersonIn;
import pe.springdata.jdbc.person.domain.PersonOut;
import pe.springdata.jdbc.person.repository.PersonRepository;
import pe.springdata.jdbc.person.repository.entity.PersonEntity;
import pe.springdata.jdbc.person.service.PersonService;
import pe.springdata.jdbc.person.service.adapter.PersonAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

	private final PersonRepository personRepository;
	private final PersonAdapter personAdapter;


	@Override
	public void saveNewDocument(PersonIn personIn) throws Exception {
		long cant = personRepository.count();
		String keyTable = NumberUtil.fullLefthZero(String.valueOf(cant+1),3);
		PersonEntity entity = personAdapter.toEntityDocument(personIn);
		entity.setId(keyTable);
		personRepository.save(entity);
	}

	@Override
	public void save(PersonIn personIn) {
		Optional<PersonEntity> entity = personRepository.findById(personIn.getId());

	}

	@Override
	public List<PersonOut> getAllPersons() {
		List<PersonOut> listReturn = new ArrayList<>();
		List<PersonEntity> list = (List<PersonEntity>) personRepository.findAll();
		return personAdapter.toListDocumentOut(list);
	}


}
