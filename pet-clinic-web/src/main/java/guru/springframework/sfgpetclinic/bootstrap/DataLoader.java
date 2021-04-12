package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstname("IdoleBunty");
        owner1.setLastname("Koun");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Hakim");
        owner2.setLastname("Amarouche");

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
