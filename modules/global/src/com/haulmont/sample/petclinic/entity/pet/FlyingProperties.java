package com.haulmont.sample.petclinic.entity.pet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "PETCLINIC_FLYING_PROPERTIES")
@Entity(name = "petclinic_FlyingProperties")
public class FlyingProperties extends PetProperties {
    private static final long serialVersionUID = 5910167214429328307L;

    @Column(name = "WING_WIDTH")
    protected Double wingWidth;

    public Double getWingWidth() {
        return wingWidth;
    }

    public void setWingWidth(Double wingWidth) {
        this.wingWidth = wingWidth;
    }
}