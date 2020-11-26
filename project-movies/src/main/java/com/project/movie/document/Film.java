package com.project.movie.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Film")
public class Film {
    @Id
    private String id;
    private String name;
    private String image;
    private String status;
    private List<String> director;
    private String genre;
    private String types;
    private String nation;
    private String quality;
    private String language;
    private Integer time;
    private LocalDateTime release;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
    private Boolean statusActive;
    private String url;
    private Integer age;
    private List<String> actor;
    private Serie series_movie;
    private List<Esposide> esposide;
    private List<Comment> comment;
    private String trailer;
}
