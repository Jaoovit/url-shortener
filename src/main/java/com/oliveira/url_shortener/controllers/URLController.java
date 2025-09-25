package com.oliveira.url_shortener.controllers;

import com.oliveira.url_shortener.domain.URL.ShortUrlDTO;
import com.oliveira.url_shortener.services.URLService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrlDTO> shortenUrl(@RequestBody String longUrl, HttpServletRequest request) {
        ShortUrlDTO shortUrl = urlService.shortenUrl(longUrl, request);
        return ResponseEntity.ok(shortUrl);
    }

}
