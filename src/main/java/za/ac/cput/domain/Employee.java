package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import za.ac.cput.domain.demography.Contact;

import java.util.Objects;

@Entity
public class Employee
{
    @Id
    private long employeeNumber;
    private String firstName;
    private String lastname;

    @OneToOne
    private Contact contact;

    protected Employee(){
    }

    public Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastname = builder.lastname;
        this.contact = builder.contact;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeNumber == employee.employeeNumber && Objects.equals(firstName, employee.firstName) && Objects.equals(lastname, employee.lastname) && Objects.equals(contact, employee.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, firstName, lastname, contact);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private long employeeNumber;
        private String firstName;
        private String lastname;
        private Contact contact;

        public Builder setEmployeeNumber(long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Employee emp){
            this.employeeNumber = emp.employeeNumber;
            this.firstName = emp.firstName;
            this.lastname = emp.lastname;
            this.contact = emp.contact;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
}
