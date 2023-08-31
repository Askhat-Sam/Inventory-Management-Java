package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
    //Custom query
    @Query(value = "SELECT * from tool s WHERE " +
            "CONCAT(s.id, s.part_number, s.serial_number, s.description) like %:keyword%", nativeQuery = true)
    public List<Tool> findAll(@Param("keyword") String keyword);
}

