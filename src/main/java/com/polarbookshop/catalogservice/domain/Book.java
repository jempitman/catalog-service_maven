package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.*;

import java.time.Instant;

public record Book(

        @Id
        Long id,

        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,

        @NotBlank(
                message = "The book title must be defined."
        )
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message = "The book price must be defined.")
        @Positive(
                message = "The book price must be greater than zero."
        )
        Double price,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
) {
        public static Book of(
                String isbn, String title, String author, Double price
        ){
                return new Book (
                        null, isbn, title, author, price, null, null, 0
                );
        }
}
