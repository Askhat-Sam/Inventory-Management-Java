package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ToolRepository extends JpaRepository<Tool, Integer> {
    //Custom query
    @Query(value = "SELECT * from tool s WHERE " +
            "s.id like %:keyword% OR s.part_number like %:keyword% " +
            "OR s.serial_number LIKE %:keyword% OR s.description like %:keyword% OR s.location like %:keyword%", nativeQuery = true)
    public List<Tool> findAll(@Param("keyword") String keyword);

}
