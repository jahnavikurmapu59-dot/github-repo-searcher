package com.example.github_searcher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
int stars = repo.getStargazersCount();

String category = (stars > 500) ? "🔥 Trending" : "📉 Low Popularity";

repositoryEntity.setCategory(category);
@SpringBootTest
class GithubSearcherApplicationTests {

	@Test
	void contextLoads() {
	}

}
