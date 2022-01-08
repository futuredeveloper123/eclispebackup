package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("웹 애플리케이션이 종료됩니다.");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("웹 애플리케이션이 시작합니다.");
    }
	
}
