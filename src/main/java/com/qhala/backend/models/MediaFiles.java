package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class MediaFiles {
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "fileName")
    private String fileName;

    @JsonProperty(value = "fileType")
    private  String fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonProperty("users")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users users;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
