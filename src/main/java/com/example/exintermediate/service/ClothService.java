package com.example.exintermediate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.domain.Cloth;
import com.example.exintermediate.repository.ClothRepository;

@Service
@Transactional
public class ClothService {
    @Autowired
    private ClothRepository clothRepository;
    public Cloth find(Integer gender, String color) {
        return clothRepository.find(gender, color);
    }
}
