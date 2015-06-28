/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
    @Column
    @ElementCollection(targetClass=Reservation.class)
    private Set<Reservation> resourceReservations;
    @Column
    @ElementCollection(targetClass=Client.class)
    private Set<Client> clients;

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

    public Collection<Reservation> getResourceReservations() {
        return resourceReservations;
    }

    public void setResourceReservations(Set<Reservation> resourceReservations) {
        this.resourceReservations = resourceReservations;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    
}
