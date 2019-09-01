package com.haulmont.sample.petclinic.entity.pet;

import com.haulmont.sample.petclinic.entity.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "PETCLINIC_PET_TYPE")
@Entity(name = "petclinic_PetType")
public class PetType extends NamedEntity {
    private static final long serialVersionUID = -2633909809493220411L;

    @Column(name = "PROPERTIES_ENTITY_NAME")
    protected String propertiesEntityName;

    @Column(name = "PROPERTIES_FRAGMENT")
    protected String propertiesFragment;

    public String getPropertiesFragment() {
        return propertiesFragment;
    }

    public void setPropertiesFragment(String propertiesFragment) {
        this.propertiesFragment = propertiesFragment;
    }

    public String getPropertiesEntityName() {
        return propertiesEntityName;
    }

    public void setPropertiesEntityName(String propertiesEntityName) {
        this.propertiesEntityName = propertiesEntityName;
    }
}