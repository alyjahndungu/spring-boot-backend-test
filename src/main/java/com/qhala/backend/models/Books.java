package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Books {
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "author")
    private String author;

    @JsonProperty(value = "ISBN")
    private String ISBN;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "publisher")
    private String publisher;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
