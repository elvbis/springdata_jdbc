package pe.springdata.jdbc.person.service.adapter;

import pe.springdata.jdbc.person.domain.PersonIn;
import pe.springdata.jdbc.person.domain.PersonOut;
import pe.springdata.jdbc.person.repository.entity.PersonEntity;

import java.util.List;

public interface PersonAdapter {

    List<PersonOut> toListDocumentOut (List<PersonEntity>  documentEntity);

    PersonEntity toEntityDocument(PersonIn personIn);
}
