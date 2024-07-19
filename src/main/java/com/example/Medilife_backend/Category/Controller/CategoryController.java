package com.example.Medilife_backend.Category.Controller;

import com.example.Medilife_backend.Category.Entity.Category;
import com.example.Medilife_backend.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medilife")
//@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }


    @GetMapping("/allCategory")
    public List<Category> allCategory(){
        return categoryService.allCategory();
    }


}
