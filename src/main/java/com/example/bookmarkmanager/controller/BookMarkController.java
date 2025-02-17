package com.example.bookmarkmanager.controller;

import com.example.bookmarkmanager.dto.CommonApiResponse;
import com.example.bookmarkmanager.dto.BookMark;
import com.example.bookmarkmanager.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @GetMapping(value = "/bookmarks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getBookmarks() {
        return bookMarkService.getAllBookmarks();
    }

    @PostMapping(value = "/bookmarks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonApiResponse> addBookmark(@RequestBody BookMark bookMark) {
        return bookMarkService.addBookmark(bookMark);
    }

    @DeleteMapping("/bookmarks/{id}")
    public ResponseEntity<CommonApiResponse> deleteBookmark(@PathVariable String id) {
        return bookMarkService.deleteBookmark(id);
    }

    @PutMapping("/bookmarks/{id}")
    public ResponseEntity<CommonApiResponse> updateBookmark(@PathVariable String id, @RequestBody BookMark bookMark) {
        return bookMarkService.updateBookmark(id, bookMark);
    }

}
