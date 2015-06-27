/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kris
 */
@Entity
public class Event extends AbstractPersistable<Long> {
    
    private String Description;
    private DateTime startTime;
    private DateTime endTime;  
    @OneToOne
    private Reservation spaceReservation;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PersonRolePair> participants;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

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

    public Reservation getSpaceReservation() {
        return spaceReservation;
    }

    public void setSpaceReservation(Reservation spaceReservation) {
        this.spaceReservation = spaceReservation;
    }

    public List<PersonRolePair> getParticipants() {
        return participants;
    }

    public void setParticipants(List<PersonRolePair> participants) {
        this.participants = participants;
    }
    
    
    
}
