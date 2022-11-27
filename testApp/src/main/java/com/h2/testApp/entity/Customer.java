package com.h2.testApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMERS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_NUMBER")
    int accountId;
    @Column(name = "CUSTOMER_NAME", nullable = false, unique = true)
    String name;
    @Column(name = "LOCATION", nullable = true, unique = false)
    String location;
    @Column(name = "BIRTHDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    Date customer_birthdate;
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    Gender gender;
    public enum Gender {
        MALE,
        FEMALE,
        M,
        F
    }

}
