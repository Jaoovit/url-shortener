CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE urls (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    long_url VARCHAR(250) NOT NULL,
    short_url VARCHAR(100) NOT NULL,
    hash VARCHAR(6) NOT NULL,
    create_at TIMESTAMP NOT NULL,
    expire_at TIMESTAMP NOT NULL,
    clicks INTEGER NOT NULL
)