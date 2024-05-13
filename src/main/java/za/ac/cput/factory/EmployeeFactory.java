package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.util.Helper;

public class EmployeeFactory
{
    public static Employee buildEmployee(long employeeNumber, String firstName, String lastName, Contact contact){
        if (Helper.isZeroOrLess(employeeNumber) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || contact == null)
            return null;
        return new Employee.Builder().setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact)
                .build();
    }

    public static Employee buildEmployee(long employeeNumber, String firstName, String lastName, String email,
                                         String mobile, String workTelephone){
        if (Helper.isZeroOrLess(employeeNumber) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
            !Helper.isValidEmail(email) || Helper.isDigitsOrIsTen(mobile) || Helper.isDigitsOrIsTen(workTelephone))
            return null;

        Contact contact = ContactFactory.buildContact(email, mobile, workTelephone);
        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact)
                .build();
    }
    public static Employee buildEmployee(String firstName, String lastName, Contact contact){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || contact == null)
            return null;

        long employeeNumber = Helper.generateId();
        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact)
                .build();
    }

    public  static  Employee buildEmployee(String firstName, String lastName, String email, String mobile, String workTelephone){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || !Helper.isValidEmail(email)||
            Helper.isDigitsOrIsTen(mobile) || Helper.isDigitsOrIsTen(workTelephone))
            return  null;

        long employeeNumber = Helper.generateId();
        Contact contact = ContactFactory.buildContact(email, mobile, workTelephone);
        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact)
                .build();
    }



}
