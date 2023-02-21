package com.example.beansutils.service.impl;

import com.example.beansutils.dto.ExampleDto;
import com.example.beansutils.entity.Example;
import com.example.beansutils.repository.ExampleRepository;
import com.example.beansutils.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<ExampleDto> findAll() {
        List<Example> findAll = exampleRepository.findAll();
        return Example.toDtos(findAll);
    }

    @Override
    public ExampleDto findById(String id) {
        Optional<Example> findById = exampleRepository.findById(id);
        if (findById.isPresent()) {
            return findById.get().toDto();
        } else {
            return null;
        }
    }

    @Override
    public ExampleDto save(ExampleDto exampleDto) {
        Example example = new Example(exampleDto);
        return exampleRepository.save(example).toDto();
    }

    @Override
    public ExampleDto put(ExampleDto exampleDto) {
        Example example = new Example(exampleDto);
        return exampleRepository.save(example).toDto();
    }

    @Override
    public void deleteById(String id) {
        exampleRepository.deleteById(id);
    }
}
