package com.liftoff.cnvInvestments.dto.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String usersName;
    private String usersFirstName;
    private String usersLastName;
    private String usersPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
        joinColumns = {
            @JoinColumn(name = "USER_ID")
        },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersFirstName() {
        return usersFirstName;
    }

    public void setUsersFirstName(String usersFirstName) {
        this.usersFirstName = usersFirstName;
    }

    public String getUsersLastName() {
        return usersLastName;
    }

    public void setUsersLastName(String usersLastName) {
        this.usersLastName = usersLastName;
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
