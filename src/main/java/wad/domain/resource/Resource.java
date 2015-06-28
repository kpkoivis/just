/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain.resource;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import org.joda.time.Interval;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.domain.Reservation;

/**
 *
 * @author kris
 */
@Entity
public class Resource extends AbstractPersistable<Long> {
    @Column
    private String name;
    private TreeSet<Interval> reservableIntervals;
    private TreeSet<Interval> reservedIntervals;
    //@ManyToMany(fetch = FetchType.EAGER)
    private TreeSet<Reservation> reservations;
    
    public Resource () {
        this.reservableIntervals = new TreeSet(new IntervalStartComparator());
        this.reservedIntervals = new TreeSet(new IntervalStartComparator());
        this.reservations = new TreeSet();
    }

    
    @Transactional
    public Reservation reserve(Interval interval) {
        if (!isAvailable(interval)) {
            return null;
        }
        reservedIntervals.add(interval);
        Reservation reservation = new Reservation();
        reservation.setInterval(interval);
        reservation.setResource(this);
        return reservation;
    }
    
    public boolean isAvailable(Interval interval) {
        Interval floorReserveableInterval = this.reservableIntervals.floor(interval);
        if (floorReserveableInterval == null || !floorReserveableInterval.contains(interval)) {
            return false;
        }
        Interval floorReservedInterval = this.reservableIntervals.floor(interval);
        if (floorReservedInterval != null && floorReservedInterval.overlaps(interval)) {
            return false;
        }
        Interval ceilingReservedInterval = this.reservableIntervals.ceiling(interval);
        if (ceilingReservedInterval != null && ceilingReservedInterval.overlaps(interval)) {
            return false;
        }
        return true;
    }
    
}

class IntervalStartComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval x, Interval y) {
        return x.getStart().compareTo(y.getStart());
    }
}