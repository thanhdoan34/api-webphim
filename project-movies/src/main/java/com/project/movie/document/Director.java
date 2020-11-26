package com.project.movie.document;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Director {
    @Id
    private String _id;
    private String name;
    private String image;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime modifyAt;
}
