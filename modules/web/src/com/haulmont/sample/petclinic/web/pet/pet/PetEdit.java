package com.haulmont.sample.petclinic.web.pet.pet;

import com.google.common.base.Strings;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.sample.petclinic.entity.pet.PetProperties;
import com.haulmont.sample.petclinic.entity.pet.PetType;
import com.haulmont.sample.petclinic.web.pet.pettype.PetPropertiesFragment;

import javax.inject.Inject;

@UiController("petclinic_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
public class PetEdit extends StandardEditor<Pet> {

    @Inject
    private DataContext dataContext;
    @Inject
    private Metadata metadata;
    @Inject
    private GroupBoxLayout propertiesBox;
    @Inject
    private Fragments fragments;
    @Inject
    private DataManager dataManager;
    @Inject
    private EntityStates entityStates;

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        PetType petType = getEditedEntity().getType();
        PetProperties properties = getEditedEntity().getProperties();
        if (properties == null && petType != null && !Strings.isNullOrEmpty(petType.getPropertiesEntityName())) {
            getEditedEntity().setProperties(createPetProperties(petType));
        }
        initPropertiesFragment(petType);
    }

    @Subscribe(id = "petDc", target = Target.DATA_CONTAINER)
    private void onPetDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Pet> event) {
        if (event.getProperty().equals("type")) {
            PetType petType = (PetType) event.getValue();
            PetProperties properties = getEditedEntity().getProperties();
            if (properties != null) {
                dataContext.remove(properties);
            }
            if (petType == null || Strings.isNullOrEmpty(petType.getPropertiesEntityName())) {
                getEditedEntity().setProperties(null);
            } else {
                getEditedEntity().setProperties(createPetProperties(petType));
            }
            initPropertiesFragment(petType);
        }
    }

    private PetProperties createPetProperties(PetType petType) {
        PetProperties properties;
        MetaClass metaClass = metadata.getClassNN(petType.getPropertiesEntityName());
        properties = dataContext.create(metaClass.getJavaClass());
        return properties;
    }

    private void initPropertiesFragment(PetType petType) {
        propertiesBox.removeAll();
        if (petType != null && !Strings.isNullOrEmpty(petType.getPropertiesFragment())) {
            PetProperties concretePetProperties = loadConcretePetProperties(getEditedEntity().getProperties());

            ScreenFragment propertiesFragment = fragments.create(this, petType.getPropertiesFragment());
            ((PetPropertiesFragment) propertiesFragment).setPetProperties(concretePetProperties);
            propertiesBox.add(propertiesFragment.getFragment());
        }
    }

    private PetProperties loadConcretePetProperties(PetProperties properties) {
        if (properties == null || entityStates.isNew(properties)) {
            return properties;
        } else {
            return dataContext.merge(dataManager.load(Id.of(properties)).one());
        }
    }
}