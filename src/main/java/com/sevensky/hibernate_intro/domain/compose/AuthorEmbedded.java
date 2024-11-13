package com.sevensky.hibernate_intro.domain.compose;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class AuthorEmbedded {

    public AuthorEmbedded() {
    }

    public AuthorEmbedded(NameId nameId) {
        this.nameId = nameId;
    }

    public NameId getNameId() {
        return nameId;
    }

    public void setNameId(NameId nameId) {
        this.nameId = nameId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @EmbeddedId
    private NameId nameId;

    private String country;
}
