# Petclinic with Pet Properties 

This example demonstrates how to use fragments to implement a dynamic part of an entity editor depending on the type of a linked entity. 

Here we extend the [CUBA Petclinic](https://github.com/cuba-platform/cuba-petclinic) data model with the following:

- `Pet` entity has a reference to the `PetProperties` entity
- `PetProperties` entity is a base class of pet properties
- `FlyingProperties` entity is a subclass of `PetProperties` for flying pets   
- `WaterProperties` entity is a subclass of `PetProperties` for water pets
- `PetType` entity defines the properties entity class and screen fragment id for this type of pets   

The UI has the following modifications:

- Created two fragments for working with different types of pet properties: `FlyingPropertiesFragment` and `WaterPropertiesFragment`
- Both fragments implement the `PetPropertiesFragment` interface which defines a method to set the `PetProperties` entity instance
- `PetEdit` screen creates an appropriate fragment depending on the type of the edited pet. It also replaces the fragment if the type is changed by the user while the screen is open. 

To see the example in action, start the application, open Pets browser and find a pet of type "Water" or "Flying". Open it for editing and see the "Properties" group box.
