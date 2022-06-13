//package ru.kata.spring.boot_security.demo.model;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Size(min = 2, max = 45, message = "first name should be between 2 and 45 characters")
//    @NotNull(message = "enter first name")
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Size(min = 2, max = 45, message = "last name should be between 2 and 45 characters")
//    @NotNull(message = "enter last name")
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Size(min = 0, max = 100, message = "age should be between 0 and 100 characters")
//    @NotNull(message = "enter age")
//    @Column(name = "age")
//    private int age;
//
//    @Email(message = "email should be valid")
//    @Size(min = 2, max = 45, message = "email should be between 2 and 45 characters")
//    @NotNull(message = "enter email")
//    @Column(name = "email", unique = true)
//    private String email;
//
//    @Size(min = 4, max = 8, message = "password should be between 2 and 45 characters")
//    @NotNull(message = "enter password")
//    @Column(name = "password")
//    private String password;
//
//    @NotNull(message = "enter roles")
//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Role> roles;
//
//    public User() {
//    }
//
//    public User(String firstName, String lastName, int age, String email, String password, List<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
