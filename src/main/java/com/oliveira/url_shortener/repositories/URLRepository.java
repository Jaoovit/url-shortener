package com.oliveira.url_shortener.repositories;

import com.oliveira.url_shortener.domain.URL.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface URLRepository extends JpaRepository<URL, UUID> {
}
