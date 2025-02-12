package com.example.bookmarkmanager.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@RequiredArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
public class BookMark {
    @NotBlank(message = "id is mandatory")
    private String id;
    @NotBlank(message = "url is mandatory")
    private String url;
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "createdDate is mandatory")
    private String createdDate;
    private String description;

}
