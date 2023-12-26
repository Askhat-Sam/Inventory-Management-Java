package com.petproject.java.Inventory.Management.aspect;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import com.petproject.java.Inventory.Management.service.ToolService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class TransactionAspect {
    private ToolService toolService;

    public TransactionAspect(ToolService toolService) {
        this.toolService = toolService;
    }

    @Before("execution(* com.petproject.java.Inventory.Management.service.ToolService.save(..)))")
    public void beforeToolSaveAspect(JoinPoint theJoinPoint){
        Object toolJointPoint = theJoinPoint.getArgs()[0];

        //Get tool object before update
        Tool toolAfterUpdate = (Tool) toolJointPoint;
        Tool toolBeforeUpdate = toolService.findById(toolAfterUpdate.getBarcodeId());


        //List for keeping transactions
        List<Transaction> transactionList = new ArrayList<>();

        //Check if the tool was updated
        if (toolAfterUpdate.compareTo(toolBeforeUpdate)!=0){
            //Check changes of Part Number
            if(!(toolAfterUpdate.getPartNumber().equals(toolBeforeUpdate.getPartNumber()))){
                System.out.println("Pn was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getBarcodeId(),
                        "Part number was changed from '" + toolBeforeUpdate.getPartNumber() + "' to '" + toolAfterUpdate.getPartNumber()+"'"));
            }
            //Check changes of Serial Number
            if(!(toolAfterUpdate.getSerialNumber().equals(toolBeforeUpdate.getSerialNumber()))){
                System.out.println("SN was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getBarcodeId(),
                        "Serial number was changed from '" + toolBeforeUpdate.getSerialNumber() + "' to '" + toolAfterUpdate.getSerialNumber()+"'"));
            }
            //Check changes of Description
            if(!(toolAfterUpdate.getDescription().equals(toolBeforeUpdate.getDescription()))){
                System.out.println("Description was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getBarcodeId(),
                        "Description was changed from '" + toolBeforeUpdate.getDescription() + "' to '" + toolAfterUpdate.getDescription()+"'"));
            }
            //Check changes of Location
            if(!(toolAfterUpdate.getLocation().equals(toolBeforeUpdate.getLocation()))){
                System.out.println("Location was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getBarcodeId(),
                        "Location was changed from '" + toolBeforeUpdate.getLocation() + "' to '" + toolAfterUpdate.getLocation()+"'"));
            }
        }
        System.out.println("Transaction list from aspect" + transactionList);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("transactionList2", transactionList);
        System.out.println("Aspect working");
    }
    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.save(..))")
    public void afterToolSaveAspect(JoinPoint theJointPoint){
//        System.out.println("ASPECT TYPE: saved @AFTER");
//        //the tool after update
//        Object[] args = theJointPoint.getArgs();
//        Object toolAfterUpdate = args[0];
//        System.out.println("Tool after update: " + toolAfterUpdate);
    }

    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.deleteById(..))")
    public void afterToolDeleteAspect(){
//        System.out.println("ASPECT TYPE: deleted @AFTER");
    }
}
