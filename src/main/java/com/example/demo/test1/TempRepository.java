package com.example.demo.test1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempRepository extends JpaRepository<Temp, Integer>{
	Temp findByid(int id);
}
