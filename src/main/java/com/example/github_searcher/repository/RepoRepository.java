package com.example.github_searcher.repository;

import com.example.github_searcher.model.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepoRepository extends JpaRepository<RepositoryEntity, Long> {

    // Find by language
    List<RepositoryEntity> findByLanguageIgnoreCase(String language);

    // Find by minimum stars
    List<RepositoryEntity> findByStarsGreaterThanEqual(int stars);

    // Find by language and stars
    List<RepositoryEntity> findByLanguageIgnoreCaseAndStarsGreaterThanEqual(
            String language, int stars);
}
