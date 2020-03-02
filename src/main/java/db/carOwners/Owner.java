package db.carOwners;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fid")
 //   private Collection<String> address;

    private Collection<Car> cars;

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Collection<String> getAddress() {
//        return address;
//    }
//
//    public void setAddress(List<String> address) {
//        this.address = address;
//    }
}
