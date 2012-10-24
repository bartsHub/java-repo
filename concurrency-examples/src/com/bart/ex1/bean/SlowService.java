package com.bart.ex1.bean;

import java.util.concurrent.Executor;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SlowService {
    
    @Inject
    Executor executor;
    
      
    public void invoke(){
    	
        Runnable command = new Runnable() {        	
			@Override
            public void run() {                    
            	
            	for(int x = 0; x < 200000; x++) 	{      
            		System.out.println(x);
            	} 
            	
            	System.out.println("done!");
            }
        };
        executor.execute(command);		
    }
          
}