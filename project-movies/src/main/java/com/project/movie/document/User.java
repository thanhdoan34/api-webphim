package com.project.movie.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "User")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDay;
    private LocalDateTime create_At;
    private LocalDateTime modify_At;
    @Indexed(unique = true)
    private String email;
    private String phone;
    private Member member;
    private List<String> roles;
    private List<String> saved_video;
    private Boolean isActive;
    private Integer age;



    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
