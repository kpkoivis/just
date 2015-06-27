/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kris
 */
@Entity
public class Resource extends AbstractPersistable<Long> {
        @Column
    private String name;
    @ManyToMany(mappedBy = "space", fetch = FetchType.EAGER)
    private List<Reservation> reservations;
}
