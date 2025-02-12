package com.example.bookmarkmanager.controller;

import com.example.bookmarkmanager.dto.CommonApiResponse;
import com.example.bookmarkmanager.model.BookMark;
import com.example.bookmarkmanager.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @GetMapping("/bookmarks")
    public ResponseEntity<CommonApiResponse> getBookmark() {
        try {
            return ResponseEntity.ok(CommonApiResponse.builder().data(bookMarkService.getAllBookmarks()).build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(CommonApiResponse.builder().error(e.getMessage()).build());
        }
    }

    @PostMapping("/bookmarks")
    public CommonApiResponse addBookmark(@RequestBody BookMark bookMark) {
        return bookMarkService.addBookmark(bookMark);
    }

    @DeleteMapping("/bookmarks/{id}")
    public CommonApiResponse deleteBookmark(@PathVariable String id) {
        return bookMarkService.deleteBookmark(id);
    }

    @PutMapping("/bookmarks/{id}")
    public CommonApiResponse updateBookmark(@PathVariable String id) {
        return bookMarkService.updateBookmark(id);
    }

}
