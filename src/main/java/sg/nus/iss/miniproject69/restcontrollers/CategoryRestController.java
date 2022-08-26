package sg.nus.iss.miniproject69.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.nus.iss.miniproject69.models.CategoryModel;
import sg.nus.iss.miniproject69.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired 
    CategoryService catService;


    @PostMapping("/create")
    public String createCategory(@RequestBody CategoryModel category){
        catService.createCategory(category);
        return "done";

    }

    @GetMapping("/lists")
    public List<CategoryModel> catList(){
        return catService.catList();
    }
}
