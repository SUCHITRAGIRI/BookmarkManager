package com.example.bookmarkmanager.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class BookMark {

    private String id;

    @NotBlank(message = "url is mandatory")
    private String url;

    @NotBlank(message = "title is mandatory")
    private String title;

    private String createdDate;

    private String description;
}
