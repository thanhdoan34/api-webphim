package com.project.movie.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String premium;
    private int time;
    private LocalDateTime startActive;
    private LocalDateTime endActive;
    private String content;
}
