package wad.domain.resource;

import wad.domain.resource.Resource;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class SpacialResource extends Resource {
    private String Location;


}
