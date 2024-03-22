import com.Gabi.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
        }
        int totalSalary =0;
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

        String textRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*(?<details>\\{.*\\})\\n";
        Pattern textPat = Pattern.compile(textRegex);
        Matcher textMat = textPat.matcher(text);
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("M/d/yyyy");


        while (textMat.find()){
            totalSalary+= switch (textMat.group("role")){
                case "Programmer"-> {
                    Programer prog = new Programer(textMat.group("firstName"), textMat.group("lastName"), LocalDate.from(dtForm.parse(textMat.group("dob"))), textMat.group("details"));
                    prog.setValues();
                    System.out.println(prog.toString());
                    yield prog.getSalary();
                }
                case "Manager"-> {
                    Manager man = new Manager(textMat.group("firstName"), textMat.group("lastName"), LocalDate.from(dtForm.parse(textMat.group("dob"))), textMat.group("details"));
                    man.setValues();
                    System.out.println(man.toString());
                    yield man.getSalary();
                }
                case "Analyst"-> {
                    Analyst analy = new Analyst(textMat.group("firstName"), textMat.group("lastName"), LocalDate.from(dtForm.parse(textMat.group("dob"))), textMat.group("details"));
                    analy.setValues();
                    System.out.println(analy.toString());
                    yield analy.getSalary();
                }
                case "CEO"-> {
                    CEO ceo = new CEO(textMat.group("firstName"), textMat.group("lastName"), LocalDate.from(dtForm.parse(textMat.group("dob"))), textMat.group("details"));
                    ceo.setValues();
                    System.out.println(ceo.toString());
                    yield ceo.getSalary();
                }
                default -> 0;
            };

        }
        System.out.println(NumberFormat.getCurrencyInstance().format(totalSalary));
//
    }
}