package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstname("IdoleBunty");
        owner1.setLastname("Koun");
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
        owner2.setFirstname("Hakim");
        owner2.setLastname("Amarouche");
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
        vet1.setFirstname("Jeremy");
        vet1.setLastname("Carnus");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Rudy");
        vet2.setLastname("Daabous");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
