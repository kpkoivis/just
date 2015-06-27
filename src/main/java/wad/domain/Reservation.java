package wad.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Reservation extends AbstractPersistable<Long> {

    private HumanResource reserver;
    private OrganizationalEntity reservingOrganizationalEntity;
    private DateTime startTime;
    private DateTime endTime;    
    @ManyToOne(fetch = FetchType.EAGER)
    private Resource resource;

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }


}
