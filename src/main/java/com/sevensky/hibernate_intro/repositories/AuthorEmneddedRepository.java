package com.sevensky.hibernate_intro.repositories;

import com.sevensky.hibernate_intro.domain.compose.AuthorEmbedded;
import com.sevensky.hibernate_intro.domain.compose.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmneddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
