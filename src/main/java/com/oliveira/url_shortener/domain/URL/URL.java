package com.oliveira.url_shortener.domain.URL;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "urls")
@Entity
public class URL {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "expire_at")
    private Date expireAt;

    @Column(name = "clicks")
    private int clicks;

    @Column(name = "hash")
    private String hash;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getHash() { return hash; }

    public void setHash(String hash) { this.hash = hash; }
}
