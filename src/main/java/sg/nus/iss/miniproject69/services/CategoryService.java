package sg.nus.iss.miniproject69.services;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.nus.iss.miniproject69.models.CategoryModel;
import sg.nus.iss.miniproject69.repositories.CategoryRepository;
import sg.nus.iss.miniproject69.repositories.ProjectRepository;

@Service
public class CategoryService {

    @Autowired 
    ProjectRepository projRepo;
    CategoryRepository catRepo;

    public void createCategory(CategoryModel category){
        catRepo.save(category);
    }

    public List<CategoryModel> catList(){
        return catRepo.findAll();
    }
    
}
