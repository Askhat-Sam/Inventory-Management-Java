package com.petproject.java.Inventory.Management;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ToolServiceIntegrationTest {

    @Autowired
    private ToolService toolService;

    @Test
    public void testAddTool(){
        // Create new tool
        Tool tool = new Tool(12321,"E32", "ITI23423", "HKJHK", "Hammer",
                "Hangar", "A543", "22.04.2027", "24.09.2029");

        // Test adding the tool
        Tool newTool = toolService.update(tool);

        // Verify the addition
        assertNotNull(newTool);
        assertNotNull(newTool.getBarcodeId());
        assertEquals("ITI23423", newTool.getPartNumber());
    }
}
