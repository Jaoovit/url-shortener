package com.oliveira.url_shortener.repositories;

import com.oliveira.url_shortener.domain.URL.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface URLRepository extends JpaRepository<URL, UUID> {

    @Query("SELECT e FROM URL e WHERE e.shortUrl = :shortUrl")
    public URL getUrlByLongUrl(@Param("shortUrl") String shortUrl);
}
