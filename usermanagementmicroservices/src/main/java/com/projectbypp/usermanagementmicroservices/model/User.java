package com.projectbypp.usermanagementmicroservices.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "UserDetails")

public class User {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int userId;
    private String userName;
    private String password;
    private String email;
     private String phone;





}