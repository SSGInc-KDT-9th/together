package main.com.product.service;

import main.com.product.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getParents();
    List<Category> getChild();
    Category getCategory(String name);
    Category getCategory(Long id);
    Long join(Category category);
    Long modify(Category category);
    void quit(Long id);
}
