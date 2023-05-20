package trinhquangtan.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinhquangtan.demo.Repository.ICategoryRepository;
import trinhquangtan.demo.enity.Category;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id)
    {
        return  categoryRepository.findById(id).orElse(null);
    }
    public Category saveCategory(Category category)
    {
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id)
    {
        categoryRepository.deleteById(id);
    }

}
