package com.example.bookmarkmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonApiResponse {
    private String message;
    private Object data;
    private Object error;
}
