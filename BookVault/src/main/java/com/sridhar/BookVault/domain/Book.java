package com.sridhar.BookVault.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "name shouldn't be blank")
    String name;
    String author;
    Genre genre;
    Double cost;
    @Min(value = 1900,message = "year should be minimum of 1900")
    @Max(value = 2024, message = "year should be maximum of 2024")
    Integer year;
    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = "book")
    List<Review> reviewList;
}
