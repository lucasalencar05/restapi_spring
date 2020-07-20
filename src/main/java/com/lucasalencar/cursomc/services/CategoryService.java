package com.lucasalencar.cursomc.services;

import com.lucasalencar.cursomc.domain.Category;
import com.lucasalencar.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategory(Integer id){

        Optional<Category> obj = repository.findById(id);
        return obj.orElse(null);

    }

}
