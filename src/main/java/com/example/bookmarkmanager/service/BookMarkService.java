package com.example.bookmarkmanager.service;

import com.example.bookmarkmanager.dto.CommonApiResponse;
import com.example.bookmarkmanager.dto.BookMark;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
@RequiredArgsConstructor
public class BookMarkService {

    List<BookMark> bookmarksList = new ArrayList<>();

    public ResponseEntity<CommonApiResponse> addBookmark(BookMark bookMark) {
        try {
            if (bookMark.getId() == null) {
                bookMark.setId(UUID.randomUUID().toString());
            }
            bookMark.setCreatedDate(LocalDate.now());
            bookmarksList.add(bookMark);
            return ResponseEntity.ok(CommonApiResponse.builder()
                    .message("Bookmark added successfully")
                    .data(Collections.singletonList(bookMark))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body((CommonApiResponse.builder()
                    .message("Error adding bookmark")
                    .error(e)
                    .build()));
        }
    }

    public ResponseEntity<List> getAllBookmarks() {
        try {
            return ResponseEntity.ok(bookmarksList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ArrayList<>());
        }
    }

    public ResponseEntity<CommonApiResponse> deleteBookmark(String id) {
        try {
            Optional<BookMark> bookMark = bookmarksList.stream().filter(bm -> bm.getId().equals(id)).findFirst();
            if (bookMark.isEmpty()) {
                return ResponseEntity.status(404).body(CommonApiResponse.builder()
                        .message("Bookmark not found")
                        .build());
            }
            bookmarksList.remove(bookMark.get());
            return ResponseEntity.ok(CommonApiResponse.builder()
                    .message("Bookmark deleted successfully")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body((CommonApiResponse.builder()
                    .message("Error deleting bookmark")
                    .error(e)
                    .build()));
        }
    }

    public ResponseEntity<CommonApiResponse> updateBookmark(String id, BookMark bookMark) {
        try {
            Optional<BookMark> existsBookMark = bookmarksList.stream().filter(bm -> bm.getId().equals(id)).findFirst();
            if (existsBookMark.isEmpty()) {
                return ResponseEntity.status(404).body(CommonApiResponse.builder()
                        .message("Bookmark not found")
                        .build());
            }
            BookMark updatedBookMark = existsBookMark.get();
            updatedBookMark.setTitle(bookMark.getTitle());
            updatedBookMark.setDescription(bookMark.getDescription());
            updatedBookMark.setUrl(bookMark.getUrl());
            updatedBookMark.setCreatedDate(LocalDate.now());
            return ResponseEntity.ok(CommonApiResponse.builder()
                    .message("Bookmark updated successfully")
                    .data(Collections.singletonList(updatedBookMark))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body((CommonApiResponse.builder()
                    .message("Error updating bookmark")
                    .error(e)
                    .build()));
        }
    }
}
