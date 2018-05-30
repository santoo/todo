package com.santoo.todo.category;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @PutMapping("/add")
    public void addCategory(@RequestBody String task){
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        Category category=new Category(id,task);
        categoryRepository.save(category);
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteCategory(@PathParam("id") String id){
        categoryRepository.deleteById(id);

    }

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
