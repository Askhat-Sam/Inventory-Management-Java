//package com.petproject.java.Inventory.Management;
//
//import com.petproject.java.Inventory.Management.enntity.Tool;
//import com.petproject.java.Inventory.Management.repository.ToolRepository;
//import com.petproject.java.Inventory.Management.service.ToolServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static junit.framework.TestCase.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//public class ToolServiceUnitTest {
//
//
//    @Mock
//    private ToolRepository toolRepository;
//    @InjectMocks
//    private ToolServiceImpl toolService;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddTool(){
//        // Create new tool
//        Tool aMockTool = new Tool(12321,"E32", "ITI23423", "HKJHK", "Hammer",
//                "Hangar", "A543", "22.04.2027", "24.09.2029");
//
////        when(toolRepository.save(any(Tool.class))).thenReturn(aMockTool);
//
//        //save tool
//        Tool newTool = toolService.save(null);
//
//        //verify the save
//
//        assertEquals("E32", newTool.getBarcodeId());
//    }
//}
