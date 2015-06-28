package wad.domain;

import wad.domain.resource.HumanResource;
import wad.domain.resource.Resource;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Reservation extends AbstractPersistable<Long> {

    private HumanResource reserver;
    private OrganizationalEntity reservingOrganizationalEntity;
    private Interval interval; 
    @ManyToOne(fetch = FetchType.EAGER)
    private Resource resource;

    public HumanResource getReserver() {
        return reserver;
    }

    public void setReserver(HumanResource reserver) {
        this.reserver = reserver;
    }

    public OrganizationalEntity getReservingOrganizationalEntity() {
        return reservingOrganizationalEntity;
    }

    public void setReservingOrganizationalEntity(OrganizationalEntity reservingOrganizationalEntity) {
        this.reservingOrganizationalEntity = reservingOrganizationalEntity;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    

}
