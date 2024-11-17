package com.sridhar.BookVault.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String review;
    @Min(value = 1,message = "rating should be minimum of 1")
    @Max(value = 5,message = "rating should be maximum of 5")
    Integer rating;
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
}
