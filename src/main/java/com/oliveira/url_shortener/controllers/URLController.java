package com.oliveira.url_shortener.controllers;

import com.oliveira.url_shortener.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class URLController {

    @Autowired
    private URLService urlService;

}
