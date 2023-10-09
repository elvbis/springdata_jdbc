package pe.springdata.jdbc.person.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import pe.springdata.jdbc.person.domain.PersonOut;
import pe.springdata.jdbc.person.repository.PersonRepository;
import pe.springdata.jdbc.person.repository.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.springdata.jdbc.person.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {


	@Autowired
	private PersonService personService;

	@GetMapping()
	public List<PersonOut> getTest() {
		List<PersonOut> list = personService.getAllPersons();
		System.out.println("ok");
		return list;
	}

	@PostMapping()
	public List<PersonEntity> save() {

		System.out.println("ok");
		return null;
	}

}
