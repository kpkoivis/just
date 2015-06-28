/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kris
 */
@Entity
public class Person extends AbstractPersistable<Long> {
    
    private String identifier;
    @ManyToMany
    private List <Reservation> reservations;
    
}
