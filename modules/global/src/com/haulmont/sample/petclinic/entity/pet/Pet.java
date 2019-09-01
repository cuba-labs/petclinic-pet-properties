package com.haulmont.sample.petclinic.entity.pet;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.sample.petclinic.entity.NamedEntity;
import com.haulmont.sample.petclinic.entity.owner.Owner;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamePattern("%s - %s|identificationNumber,name")
@Table(name = "PETCLINIC_PET", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_PETCLINIC_PET_ID_UNQ", columnNames = {"IDENTIFICATION_NUMBER", "DELETE_TS"})
})
@Entity(name = "petclinic_Pet")
public class Pet extends NamedEntity {
    private static final long serialVersionUID = -3431453457784831240L;

    @NotNull
    @Column(name = "IDENTIFICATION_NUMBER", nullable = false)
    protected String identificationNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    protected PetType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    protected Owner owner;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROPERTIES_ID")
    protected PetProperties properties;

    public PetProperties getProperties() {
        return properties;
    }

    public void setProperties(PetProperties properties) {
        this.properties = properties;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public PetType getType() {
        return type;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}