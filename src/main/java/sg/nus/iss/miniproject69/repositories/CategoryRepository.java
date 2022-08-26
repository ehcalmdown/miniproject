package sg.nus.iss.miniproject69.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.miniproject69.models.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{
    
}
