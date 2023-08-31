package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
    //Custom query
    @Query(value = "select * from tool s where s.description like %:keyword% or s.id like %:keyword% " +
            "or s.part_number like %:keyword% or s.serial_number like %:keyword%", nativeQuery = true)
    public List<Tool> findAll(@Param("keyword") String keyword);
}

