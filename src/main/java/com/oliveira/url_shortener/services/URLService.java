package com.oliveira.url_shortener.services;

import com.oliveira.url_shortener.domain.URL.ShortUrlDTO;
import com.oliveira.url_shortener.domain.URL.URL;
import com.oliveira.url_shortener.repositories.URLRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public ShortUrlDTO shortenUrl(String longUrl, HttpServletRequest request) {
        if (longUrl.length() < 1) throw new IllegalArgumentException("URL cannot be null");

        URL url = new URL();

        url.setLongUrl(longUrl);

        String hash = UUID.randomUUID().toString().substring(0,6);

        String domain = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80 && request.getServerPort() != 403) {
            domain += ":" + request.getServerPort();
        }

        Date now = new Date();
        url.setCreateAt(now);

        long threeDays = 3L * 24 * 60 * 60 * 1000;
        Date expireAt = new Date(now.getTime() + threeDays);

        url.setExpireAt(expireAt);
        url.setClicks(0);

        urlRepository.save(url);

        ShortUrlDTO shortUrl = new ShortUrlDTO(domain + "/" + hash);

        return shortUrl;
    }
}
