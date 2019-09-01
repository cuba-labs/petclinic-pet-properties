package com.haulmont.sample.petclinic.web.pet.flyingproperties;

import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.sample.petclinic.entity.pet.FlyingProperties;
import com.haulmont.sample.petclinic.entity.pet.PetProperties;
import com.haulmont.sample.petclinic.web.pet.pettype.PetPropertiesFragment;

import javax.inject.Inject;

@UiController("petclinic_FlyingPropertiesFragment")
@UiDescriptor("flying-properties-fragment.xml")
public class FlyingPropertiesFragment extends ScreenFragment implements PetPropertiesFragment {

    @Inject
    private InstanceContainer<FlyingProperties> flyingPropertiesDc;

    @Override
    public void setPetProperties(PetProperties petProperties) {
        flyingPropertiesDc.setItem((FlyingProperties) petProperties);
    }
}