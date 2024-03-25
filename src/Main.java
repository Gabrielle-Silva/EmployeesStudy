import com.Gabi.Employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
//        final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

        int totalSalary =0;
        Employees employee = null;
        String text = """
        Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
        Flinstone, Fred, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
        Flinstone, Fred, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
        Flinstone, Fred, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
        Flinstone, Fred, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
        Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
        Rubble, Barney, 2/2/1905, Manager, {orgSize=100,dr=4}
        Rubble, Barney, 2/2/1905, Manager, {orgSize=200,dr=2}
        Rubble, Barney, 2/2/1905, Manager, {orgSize=500,dr=8}
        Rubble, Barney, 2/2/1905, Manager, {orgSize=175,dr=20}
        Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
        Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=4}
        Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=5}
        Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=6}
        Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=9}
        Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
        """;
        Matcher textMat = Employees.textPat.matcher(text);

        while (textMat.find()){
            employee = Employees.addEmployee(textMat.group());
            employee.setValues();
            System.out.println(employee.toString() + " - bonus: " + employee.moneyFormat.format((employee.getBonus())));
            totalSalary += employee.getSalary();
        }
        System.out.println(Employees.moneyFormat.format(totalSalary));

    }
}