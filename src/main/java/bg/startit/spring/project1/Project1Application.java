package bg.startit.spring.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@Configuration
public class Project1Application
{

  public static void main(String[] args)
  {
    SpringApplication.run(Project1Application.class, args);
  }
}


