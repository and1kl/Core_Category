package de.hska.iwi.vslab.Core_Category;

import de.hska.iwi.vslab.Core_Category.Interfaces.CategoryDB_Repo;
import de.hska.iwi.vslab.Core_Category.Models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoreCategoryApplication {

	private static final Logger log = LoggerFactory.getLogger(CoreCategoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CoreCategoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryDB_Repo repository) {
		return (args) -> {
			// save a few categories
			repository.save(new Category("Obst"));
			repository.save(new Category("Gemüse"));
			repository.save(new Category("Süßigkeiten"));



			// fetch all categories
			log.info("Category found with findAll():");
			log.info("-------------------------------");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Category category = repository.findById(1);
			log.info("Category found with findById(1):");
			log.info("--------------------------------");
			log.info(category.toString());
			log.info("");

			// fetch categories by last name
			log.info("Category found with findByName('Obst'):");
			log.info("--------------------------------------------");
			repository.findByName("Obst").forEach(obst -> {
				log.info(obst.toString());
			});
			// for (Category category : repository.findByName("Obst")) {
			// 	log.info(category.toString());
			// }

			// fetch all categories
			log.info("Categories found with findAll():");
			log.info("--------------------------------------------");
			repository.findAll().forEach(cat -> {
				log.info(cat.toString());
			});

		};
	}

}
