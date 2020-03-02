package db.carOwners;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class OwnerDatabaseTest {

    private EntityManagerFactory factory;

    @BeforeEach
    void beforeEach() {
        factory = Persistence.createEntityManagerFactory("test");
    }

    @AfterEach
    void afterEach() {
        factory.close();
    }

    @DisplayName("create new owner in first transaction, next create a new query in another transaction, " +
            "then set new owner secondName and finally assert that this name is updated on commit")

    @Test
    void managedCase() {
//given
        EntityManager entityManager = factory.createEntityManager();
        Owner adamKowalski = new Owner();
        String findOwnerQueryJpql = " SELECT owner FROM Owner owner";

//when
//creating new owner in first transaction
        EntityTransaction ownerTransaction = entityManager.getTransaction();
        ownerTransaction.begin();
        adamKowalski.setLastName("Kowalski");
        entityManager.persist(adamKowalski);
        ownerTransaction.commit();

//new transaction with query
        EntityTransaction updateOwnerTransaction = entityManager.getTransaction();
        updateOwnerTransaction.begin();
        Owner foundOwner = entityManager.createQuery(findOwnerQueryJpql, Owner.class)
                .getSingleResult();
        foundOwner.setLastName("Smith");
        updateOwnerTransaction.commit();

        //then
        Owner updatedOwner = entityManager.createQuery(findOwnerQueryJpql, Owner.class)
                .getSingleResult();

        assertThat(updatedOwner.getLastName()).isEqualTo("Smith", Owner.class);
    }


    @DisplayName("Create new Owner and persist him, next create second Owner with the same ID number, " +
            "then merge this two Owners and assert that Owner was updated")
    @Test
    void mergeOwners() {
//given
        EntityManager entityManager = factory.createEntityManager();
        Owner oryginalOwner = new Owner();
        oryginalOwner.setLastName("Kowalski");
        String findOwnerQueryJpql = "SELECT o FROM Owner o";

//when
        EntityTransaction persistTransaction = entityManager.getTransaction();
        persistTransaction.begin();
        entityManager.persist(oryginalOwner);
        persistTransaction.commit();

        Owner newOwner = new Owner();
        newOwner.setLastName("Smith");
        newOwner.setId(oryginalOwner.getId());
        EntityTransaction mergeTransaction = entityManager.getTransaction();
        mergeTransaction.begin();
        entityManager.merge(newOwner);
        mergeTransaction.commit();

//then
        Owner updatedOwner = entityManager.createQuery(findOwnerQueryJpql, Owner.class)
                .getSingleResult();
        assertThat(updatedOwner.getLastName()).isEqualTo("Smith");
    }

    @DisplayName("Create two owners then delete second one, assert that there is only first owner")
    @Test
    void removeOwner() {
//given
        EntityManager entityManager = factory.createEntityManager();
        Owner Mike = new Owner();
        Mike.setFirstName("Mike");
        Owner Tom = new Owner();
        Tom.setFirstName("Tom");
        String findOwners = "SELECT o FROM Owner o";
        String findOwnerTom = "SELECT o FROM Owner o WHERE FirstName = 'Tom'";
//when
        EntityTransaction addNewOwnerTransaction = entityManager.getTransaction();
        addNewOwnerTransaction.begin();
        entityManager.persist(Mike);
        entityManager.persist(Tom);
        addNewOwnerTransaction.commit();

        EntityTransaction removeOwner = entityManager.getTransaction();
        removeOwner.begin();
        Owner ownerToBeRemoved = entityManager.createQuery(findOwnerTom, Owner.class)
                .getSingleResult();
        entityManager.remove(ownerToBeRemoved);
        removeOwner.commit();

//then
        List<Owner> isThereOwner = entityManager.createQuery(findOwners, Owner.class).getResultList();
        assertThat(isThereOwner.stream().map(owner -> owner.getFirstName())).doesNotContain("Tom");
        

    }

    @DisplayName("add Owner, then remove him flush then assert owner is still in database")
    @Test
    void repersistingTest() {
//given
        Owner tom = new Owner();
        tom.setFirstName("Tom");
        String findOwner = "SELECT o FROM Owner o WHERE FirstName = 'Tom'";
//when
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction persistingOwner = entityManager.getTransaction();
        persistingOwner.begin();
        entityManager.persist(tom);
        persistingOwner.commit();

        EntityTransaction deletingOwner = entityManager.getTransaction();
        deletingOwner.begin();
        Owner ownerToBeRemoved = entityManager.createQuery(findOwner, Owner.class).getSingleResult();
        entityManager.remove(ownerToBeRemoved);
        entityManager.flush();
        deletingOwner.commit();


        EntityTransaction rePersisting = entityManager.getTransaction();
        rePersisting.begin();
        entityManager.merge(tom);
        rePersisting.commit();

//then
        Owner owner = entityManager.createQuery(findOwner, Owner.class)
                .getSingleResult();
        assertThat(owner.getFirstName()).isEqualTo("Tom");
    }

    @DisplayName("Add new owner with two cars, assert there are owner with two cars")
    @Test
    void addOwnerWithCars(){
        //given
        EntityManager entityManager = factory.createEntityManager();
        Car ford = new Car();
        ford.setBrand("Ford");
        Car opel = new Car();
        opel.setBrand("Opel");
        Owner owner = ownerWithCars(ford, opel);

        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(owner);
        transaction.commit();

        //then
        Owner existingOwner = entityManager.createQuery("SELECT o FROM Owner o", Owner.class)
                .getSingleResult();
        assertThat(existingOwner.getCars())
                .extracting("brand")
                .containsExactlyInAnyOrder("Ford", "Opel");
    }

    private Owner ownerWithCars (Car... cars){
        Owner owner = new Owner();
        owner.setCars(Arrays.asList(cars));
        return owner;
    }
}