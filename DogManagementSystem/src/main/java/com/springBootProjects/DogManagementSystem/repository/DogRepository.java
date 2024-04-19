package com.springBootProjects.DogManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBootProjects.DogManagementSystem.Models.Dog;

public interface DogRepository extends CrudRepository<Dog, Integer>{

}
