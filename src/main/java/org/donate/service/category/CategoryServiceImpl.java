package org.donate.service.category;

import org.donate.dao.CategoryRepository;
import org.donate.entity.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ItemCategory> getCategories() {
        return categoryRepository.findAll();
    }
}
