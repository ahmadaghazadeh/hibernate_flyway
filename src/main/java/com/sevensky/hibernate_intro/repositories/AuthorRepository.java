package com.sevensky.hibernate_intro.repositories;

import com.sevensky.hibernate_intro.domain.Author;
import com.sevensky.hibernate_intro.domain.AuthorUuid;
import com.sevensky.hibernate_intro.domain.compose.AuthorCompose;
import com.sevensky.hibernate_intro.domain.compose.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}


