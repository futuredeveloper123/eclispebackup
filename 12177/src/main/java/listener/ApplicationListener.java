package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {       
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("stop web app");   
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("start web app");
    
    }
    
	
}
