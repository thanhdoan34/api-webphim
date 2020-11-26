package com.project.movie.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    private String _id;
    private String nation;
    private String image;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
}