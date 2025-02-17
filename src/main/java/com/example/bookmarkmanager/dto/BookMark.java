package com.example.bookmarkmanager.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.net.URL;
import java.time.LocalDate;

@Data
public class BookMark {

    private String id;

    @NotBlank(message = "url is mandatory")
    private URL url;

    @NotBlank(message = "title is mandatory")
    private String title;

    private LocalDate createdDate;

    private String description;
}
