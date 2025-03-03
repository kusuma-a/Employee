package com.example.Project_one_demo.repository;

import com.example.Project_one_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    void deleteAllById(Long id);
}
