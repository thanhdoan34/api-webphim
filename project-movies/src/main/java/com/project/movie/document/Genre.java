package com.project.movie.document;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    private String _id;
    private String name;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime modifyAt;
}
