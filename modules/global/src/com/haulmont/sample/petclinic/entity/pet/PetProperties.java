package com.haulmont.sample.petclinic.entity.pet;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PETCLINIC_PET_PROPERTIES")
@Entity(name = "petclinic_PetProperties")
public class PetProperties extends StandardEntity {
    private static final long serialVersionUID = -1548921671220801464L;
}