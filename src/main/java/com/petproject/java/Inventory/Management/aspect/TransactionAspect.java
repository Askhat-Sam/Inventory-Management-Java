package com.petproject.java.Inventory.Management.aspect;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
        Tool theTool = (Tool) toolAfterUpdate;
        Tool toolBeforeUpdate = toolService.findById(theTool.getId());

        //Get tool object after update
        System.out.println("Tool before: " + toolBeforeUpdate);
        System.out.println("Tool after: " + toolAfterUpdate);
        System.out.println("Whether is object is changed: " + ((Tool) toolAfterUpdate).compareTo(toolBeforeUpdate));

    }
    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.save(..))")
    public void afterToolSaveAspect(JoinPoint theJointPoint){
        System.out.println("ASPECT TYPE: saved @AFTER");
        //the tool after update
        Object[] args = theJointPoint.getArgs();
        Object toolAfterUpdate = args[0];
        System.out.println("Tool after update: " + toolAfterUpdate);
    }

    @After("execution(* com.petproject.java.Inventory.Management.service.ToolService.deleteById(..))")
    public void afterToolDeleteAspect(){
        System.out.println("ASPECT TYPE: deleted @AFTER");
    }
}
