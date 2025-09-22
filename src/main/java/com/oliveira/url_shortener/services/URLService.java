package com.oliveira.url_shortener.services;

import com.oliveira.url_shortener.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;
}
