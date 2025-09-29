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

        if(!urlValidator(longUrl)) throw new IllegalArgumentException("The URL is not valid");

        URL url = new URL();

        url.setLongUrl(longUrl);

        String hash = UUID.randomUUID().toString().substring(0,6);

        String scheme = request.getHeader("X-Forwarded-Proto");
        if (scheme == null) scheme = request.getScheme();

        String host = request.getHeader("X-Forwarded-Host");
        if (host == null) host = request.getServerName();

        String domain = scheme + "://" + host;
        url.setShortUrl(domain + "/" + hash);

        Date now = new Date();
        url.setCreateAt(now);

        long threeDays = 3L * 24 * 60 * 60 * 1000;
        Date expireAt = new Date(now.getTime() + threeDays);

        url.setExpireAt(expireAt);
        url.setClicks(0);

        urlRepository.save(url);

        return new ShortUrlDTO(domain + "/" + hash);
    }

    private Boolean urlValidator(String longUrl) {
        try {
            new java.net.URL(longUrl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private URL findUrlById(UUID urlId) {
        URL url = urlRepository.getReferenceById(urlId);

        if (url == null) throw new IllegalArgumentException("Url not found");

        return url;
    }

    private void deleteUrl(UUID urlId) {
        findUrlById(urlId);
        urlRepository.deleteById(urlId);
    }
}
