package com.sevensky.hibernate_intro.repositories;

import com.sevensky.hibernate_intro.domain.Book;
import com.sevensky.hibernate_intro.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
