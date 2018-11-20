package univ.lab;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import univ.lab.classes.domain.entities.CoffeeType;
import univ.lab.classes.repository.CoffeeTypeDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        //Get the EmployeeDAO Bean
        CoffeeTypeDAO coffeeTypeDAO = ctx.getBean("ICoffeeTypeDAO", CoffeeTypeDAO.class);


        //Read
        CoffeeType emp1 = coffeeTypeDAO.GetCoffeeType(1);
        System.out.println("Employee Retrieved::"+emp1.getWaterAmount()+" "+emp1.getMilkAmount()+" "+emp1.isWaterBeforeMilk());

        ctx.close();

        System.out.println("DONE");
    }
}
