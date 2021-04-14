package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistery = new Speciality();
        dentistery.setDescription("dentistery");
        Speciality savedDentistery = specialtyService.save(dentistery);

        Owner owner1 = new Owner();
        owner1.setFirstName("IdoleBunty");
        owner1.setLastName("Koun");
        owner1.setAddress("75 Queen");
        owner1.setCity("Montreal");
        owner1.setTelephone("5149876859");

        Pet idolePet = new Pet();
        idolePet.setPetType(savedDogPetType);
        idolePet.setOwner(owner1);
        idolePet.setBirthDate(LocalDate.now());
        idolePet.setName("blacky");
        owner1.getPets().add(idolePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Hakim");
        owner2.setLastName("Amarouche");
        owner2.setAddress("75 Queen");
        owner2.setCity("Montreal");
        owner2.setTelephone("5149876859");

        Pet HakimPet = new Pet();
        HakimPet.setPetType(savedDogPetType);
        HakimPet.setOwner(owner2);
        HakimPet.setBirthDate(LocalDate.now());
        HakimPet.setName("pixie");
        owner2.getPets().add(HakimPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jeremy");
        vet1.setLastName("Carnus");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rudy");
        vet2.setLastName("Daabous");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
