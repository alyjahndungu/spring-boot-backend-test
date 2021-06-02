package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MediaFiles {
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "fileName")
    private String fileName;

    @JsonProperty(value = "fileType")
    private  String fileType;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
