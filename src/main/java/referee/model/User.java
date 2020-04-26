package referee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_user_id")
    private int id;

    @NotNull(message="Imię jest obowiązkowe!")
    @Pattern(regexp="^[a-zA-Z]*", message ="Błędna treść!")
    @Column(name = "first_name")
    private String name;

    @NotNull(message="Nazwisko jest obowiązkowe!")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message="Email jest obowiązkowy!")
    @Email(message = "Email jest nieprawidłowy!")
    @Column(name = "email")
    private String email;

    @NotNull(message="Adres jest obowiązkowy!")
    @Column(name = "address")
    private String address;

    @NotNull(message="Telefon jest obowiązkowy!")
    @Column(name = "phone")
    private int phone;

    @Length(min=5, message="Hasło powinno zawierać co najmniej 5 znaków!")
    @Column(name = "password")
    private String password;


    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;

    public User(){

    }

    public User(int id, @NotNull(message = "Imię jest obowiązkowe!") String name, @NotNull(message = "Nazwisko jest obowiązkowe!") String lastName, @NotNull(message = "Email jest obowiązkowy!") @Email(message = "Email jest niepoprawny!") String email, @NotNull(message = "Adres jest obowiązkowy!") String address, @NotNull(message = "Telefon jest obowiązkowy!") @Length(min = 9, max = 9, message = "Numer jest niepoprawny!") int phone, String password, String status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    public User(int id, @NotNull(message = "Imię jest obowiązkowe!") String name, @NotNull(message = "Nazwisko jest obowiązkowe!") String lastName, @NotNull(message = "Email jest obowiązkowy!") @Email(message = "Email jest niepoprawny!") String email, @NotNull(message = "Adres jest obowiązkowy!") String address, @NotNull(message = "Telefon jest obowiązkowy!") @Length(min = 9, max = 9, message = "Numer jest niepoprawny!") int phone, String status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
