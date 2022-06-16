package dsa.basic.ScannerTrials;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

class InvalidInputException extends Exception {
    static final long serialVersionUID = 1L;
    public InvalidInputException()
    {
        super();
    }
}

class Employee {

    private int id = 0;
    private String name = null;
    private boolean male = true;

    Employee(int id, String name,  boolean male) {
        super();
        this.id = id;
        this.name = name;
        this.male = male;


    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ",  male=" + male + "]";
    }

    @Override
    public int hashCode() {
        // Complete all relevent code
        return this.id;
    }


}

public class Test {

    /*
     * Validate the input and create Employee object
     * If any of the given input is not valid throw InvalidInputException();
     */
    public static Employee createEmployee(String record) throws InvalidInputException {
        Employee e = null;
        try{
            String[] inputs= record.split(",");
            e = new Employee(Integer.parseInt(inputs[0]),inputs[1],Boolean.valueOf(inputs[2]));
        }catch(Exception pse)
        {
            throw new InvalidInputException();
        }

        return e;
        //Complete the code

    }

    public static void main(String[] str) {

        //Input is expected as comma separated values for Employee object like id(int), name (String),isMale(boolean)"
        // 1,John,true
        Scanner scan = new Scanner(System.in);

        HashSet<Employee> employeeSet = new HashSet<>();

        /*Process each line and create Employee object using the "createEmployee" method add in employeeSet*/
        while (scan.hasNext()) {
            try {
                String employeeRecord = scan.nextLine();
                Employee e = createEmployee(employeeRecord);
                employeeSet.add(e);
            }catch(Exception e) {
                System.out.println(e.getClass().getName());
                System.exit(0);
            }

        }

        //Don't delete or modify this print statement
        System.out.println("Employees info : "+ employeeSet);

    }

}