package com.example.bookmarkmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookMarkController {

    @PostMapping("/add-bookmark")
    public void addBookMark() {
        // Add bookmark logic
    }

    @PostMapping("/delete-bookmark")
    public void deleteBookMark() {
        // Delete bookmark logic
    }

    @PostMapping("/update-bookmark")
    public void updateBookMark() {
        // Update bookmark logic
    }

    @GetMapping("/get-bookmark")
    public String getBookMark() {
        // Get bookmark logic
        return "bookmark";
    }
}
