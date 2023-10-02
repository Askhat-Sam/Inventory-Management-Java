package com.petproject.java.Inventory.Management.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.save(..))")
    public void afterToolSaveAspect(){
        System.out.println("From ASPECT: saved");
    }

    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.deleteById(..))")
    public void afterToolDeleteAspect(){
        System.out.println("From ASPECT: deleted");
    }
}
