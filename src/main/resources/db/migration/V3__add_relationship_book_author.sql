
ALTER TABLE book
    ADD COLUMN author_id BIGINT;

ALTER TABLE book
    ADD CONSTRAINT FK_author_id
        FOREIGN KEY (author_id) REFERENCES author (id);