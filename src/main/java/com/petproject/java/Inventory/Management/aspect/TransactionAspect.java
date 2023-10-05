package com.petproject.java.Inventory.Management.aspect;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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
        Object toolAfterUpdate = theJoinPoint.getArgs()[0];

        //Get tool object before update
        Tool theToolAfter = (Tool) toolAfterUpdate;
        Tool toolBeforeUpdate = toolService.findById(theToolAfter.getId());

        //Get tool object after update
        System.out.println("Tool before: " + toolBeforeUpdate);
        System.out.println("Tool after: " + toolAfterUpdate);
//        System.out.println("Whether is object is changed: " + (theToolAfter.compareTo(toolBeforeUpdate)));

        //List for keeping transactions
        List<Transaction> transactionList = new ArrayList<>();

        //Check if the tool was updated
        if (theToolAfter.compareTo(toolBeforeUpdate)>0){
            //Check changes of Part Number
            if(!(theToolAfter.getPartNumber().equals(toolBeforeUpdate.getPartNumber()))){
                System.out.println("Pn was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getId(),
                        "Part number was changed from " + toolBeforeUpdate.getPartNumber() + " to " + theToolAfter.getPartNumber()));
            }
            //Check changes of Serial Number
            if(!(theToolAfter.getSerialNumber().equals(toolBeforeUpdate.getSerialNumber()))){
                System.out.println("Pn was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getId(),
                        "Serial number was changed from " + toolBeforeUpdate.getSerialNumber() + " to " + theToolAfter.getSerialNumber()));
            }
            //Check changes of Description
            if(!(theToolAfter.getDescription().equals(toolBeforeUpdate.getDescription()))){
                System.out.println("Pn was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getId(),
                        "Description was changed from " + toolBeforeUpdate.getDescription() + " to " + theToolAfter.getDescription()));
            }
            //Check changes of Location
            if(!(theToolAfter.getLocation().equals(toolBeforeUpdate.getLocation()))){
                System.out.println("Pn was changed");
                transactionList.add(new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        toolBeforeUpdate.getId(),
                        "Location was changed from " + toolBeforeUpdate.getLocation() + " to " + theToolAfter.getLocation()));
            }
        }
        System.out.println(transactionList);
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
