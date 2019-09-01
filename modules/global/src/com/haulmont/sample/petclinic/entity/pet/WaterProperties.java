package com.haulmont.sample.petclinic.entity.pet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "PETCLINIC_WATER_PROPERTIES")
@Entity(name = "petclinic_WaterProperties")
public class WaterProperties extends PetProperties {
    private static final long serialVersionUID = -293735050487873013L;

    @Column(name = "MAX_DEPTH")
    protected Double maxDepth;

    public Double getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(Double maxDepth) {
        this.maxDepth = maxDepth;
    }
}