package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

	

}
