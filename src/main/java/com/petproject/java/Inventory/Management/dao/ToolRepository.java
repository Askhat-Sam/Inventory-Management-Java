package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
}
