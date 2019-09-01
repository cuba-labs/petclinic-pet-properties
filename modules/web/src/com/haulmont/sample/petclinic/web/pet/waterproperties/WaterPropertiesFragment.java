package com.haulmont.sample.petclinic.web.pet.waterproperties;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.sample.petclinic.entity.pet.PetProperties;
import com.haulmont.sample.petclinic.entity.pet.WaterProperties;
import com.haulmont.sample.petclinic.web.pet.pettype.PetPropertiesFragment;

import javax.inject.Inject;

@UiController("petclinic_WaterPropertiesFragment")
@UiDescriptor("water-properties-fragment.xml")
public class WaterPropertiesFragment extends ScreenFragment implements PetPropertiesFragment {

    @Inject
    private InstanceContainer<WaterProperties> waterPropertiesDc;

    @Override
    public void setPetProperties(PetProperties petProperties) {
        waterPropertiesDc.setItem((WaterProperties) petProperties);
    }
}