package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToolService {

    List<Tool> findAll();
}
