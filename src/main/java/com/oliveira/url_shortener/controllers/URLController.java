package com.oliveira.url_shortener.controllers;

import com.oliveira.url_shortener.domain.URL.LongUrlDTO;
import com.oliveira.url_shortener.domain.URL.ShortUrlDTO;
import com.oliveira.url_shortener.services.URLService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/api/url/shorten")
    public ResponseEntity<ShortUrlDTO> shortenUrl(@RequestBody LongUrlDTO longUrlDTO, HttpServletRequest request) {
        ShortUrlDTO shortUrl = urlService.shortenUrl(longUrlDTO.longUrl(), request);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Void> redirect(@PathVariable String hash) {
        LongUrlDTO longUrlDTO = urlService.redirect(hash);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", longUrlDTO.longUrl())
                .build();
    }

}
