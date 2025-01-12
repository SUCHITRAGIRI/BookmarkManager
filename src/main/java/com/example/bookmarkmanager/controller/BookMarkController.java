package com.example.bookmarkmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmark")
public class BookMarkController {

    @PostMapping("/add")
    public String addBookmark() {
        return "Bookmark added successfully";
    }

    @PostMapping("/delete")
    public String deleteBookmark() {
        return "Bookmark deleted successfully";
    }

    @PostMapping("/update")
    public String updateBookmark() {
        return "Bookmark updated successfully";
    }

    @GetMapping("/get")
    public String getBookmark() {
        return "Bookmark retrieved successfully";
    }

}
