package com.example.bookmarkmanager.service;

import com.example.bookmarkmanager.dto.CommonApiResponse;
import com.example.bookmarkmanager.model.BookMark;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BookMarkService {

    Map<Object,BookMark> bookmarksList = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    public CommonApiResponse addBookmark(BookMark bookMark) {
        bookmarksList.put("01", bookMark);
        System.out.println("add bookmarks "+ bookMark);

        return CommonApiResponse.builder()
                .message("Bookmark added successfully")
                .build();
    }

    public String getAllBookmarks() throws Exception {
        bookmarksList.put("00", new BookMark("00", "https://www.google.com", "Sample Bookmark", "2025-02-12", "Search engine"));
        return objectMapper.writeValueAsString(bookmarksList);
    }

    public CommonApiResponse deleteBookmark(String id) {
        return CommonApiResponse.builder()
                .message("Bookmark deleted successfully")
                .build();
    }

    public CommonApiResponse updateBookmark(String id) {
        return CommonApiResponse.builder()
                .message("Bookmark updated successfully")
                .build();
    }
}
