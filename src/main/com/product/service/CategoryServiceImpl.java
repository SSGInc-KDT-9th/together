package main.com.product.service;

import main.com.product.domain.Category;
import main.com.product.repository.CategoryRepository;
import main.com.product.repository.ProductRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getParents() {
        return categoryRepository.findParent();
    }

    @Override
    public List<Category> getChild() {
        return categoryRepository.findChild();
    }

    @Override
    public Category getCategory(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Long join(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Long modify(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public void quit(Long id) {
        categoryRepository.delete(id);
    }
}
