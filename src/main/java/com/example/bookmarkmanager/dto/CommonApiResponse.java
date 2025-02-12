package com.example.bookmarkmanager.dto;

import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CommonApiResponse {
    private String message;
    private List<BookMark> data;
    private Object error;
}
