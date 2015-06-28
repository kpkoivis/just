/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kris
 */
@Entity
public class OrganizationalEntity extends AbstractPersistable<Long> {
    private String name;
    private OrganizationalEntity parentOrganizationalEntity;
    @Column
    @ElementCollection(targetClass=OrganizationalEntity.class)
    private Set<OrganizationalEntity> childOrganizationalEntities;
    
    public OrganizationalEntity () {
        childOrganizationalEntities = new HashSet();
    }
    
}
