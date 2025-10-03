package com.oliveira.url_shortener.repositories;

import com.oliveira.url_shortener.domain.URL.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface URLRepository extends JpaRepository<URL, UUID> {

    @Query("SELECT e FROM URL e WHERE e.shortUrl = :shortUrl")
    public URL getUrlByShortUrl(@Param("shortUrl") String shortUrl);

    @Transactional
    @Modifying
    @Query("UPDATE URL e SET e.clicks = :clicks WHERE e.id = :id")
    public int updateClicks(@Param("id") UUID id, @Param("clicks") int clicks);
}
