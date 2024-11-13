package com.sevensky.hibernate_intro.domain.compose;

import com.sevensky.hibernate_intro.domain.Book;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(NameId.class)
public class AuthorCompose {

    public AuthorCompose(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    private String firstName;

    @Id
    private String lastName;

    public AuthorCompose() {

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


}
