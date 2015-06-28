package wad.domain.resource;

import wad.domain.resource.Resource;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.domain.Person;
import wad.domain.Role;

@Entity
public class HumanResource extends Resource {
    private Person person;
    private Role role;
}
