package pe.springdata.jdbc.person.service.adapter.impl;

import org.springframework.stereotype.Component;
import pe.springdata.jdbc.person.domain.PersonIn;
import pe.springdata.jdbc.person.domain.PersonOut;
import pe.springdata.jdbc.person.repository.entity.PersonEntity;
import pe.springdata.jdbc.person.service.adapter.PersonAdapter;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonAdapterImpl implements PersonAdapter {
    @Override
    public List<PersonOut> toListDocumentOut(List<PersonEntity>  list) {

        List<PersonOut> listReturn = new ArrayList<>();
        for(PersonEntity en : list){
            PersonOut out = new PersonOut();
            out.setId(en.getId());
            out.setFirstName(en.getFirstName());
            out.setLastName(en.getLastName());
            listReturn.add(out);
        }
        return listReturn;
    }

    @Override
    public PersonEntity toEntityDocument(PersonIn personIn) {
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(personIn.getFirstName());
        entity.setLastName(personIn.getLastName());
        entity.setId(personIn.getId());
        return entity;
    }
}
