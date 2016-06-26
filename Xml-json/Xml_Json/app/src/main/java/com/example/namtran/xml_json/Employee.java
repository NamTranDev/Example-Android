package com.example.namtran.xml_json;

/**
 * Created by Nam Tran on 7/19/2015.
 */
public class Employee {

    public static final String ID = "id";
    public static final String EMPOLYEE = "Employee";
    public static final String FNAME = "FName";
    public static final String LNAME = "LName";
    public static final String MINIT = "Minit";
    public static final String SSN = "Ssn";
    public static final String BDATE = "BDate";
    public static final String ADDRESS = "Address";
    public static final String SEX = "Sex";
    public static final String SALARY = "Salary";
    public static final String SUPERSSN = "SuperSsn";
    public static final String DNO = "Dno";

    int id;
    String FName;
    String LName;
    String Minit;
    String Ssn;
    String BDate;
    String Address;
    String Sex;
    double Salary;
    String SuperSsn;
    int Dno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getMinit() {
        return Minit;
    }

    public void setMinit(String minit) {
        Minit = minit;
    }

    public String getSsn() {
        return Ssn;
    }

    public void setSsn(String ssn) {
        Ssn = ssn;
    }

    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getSuperSsn() {
        return SuperSsn;
    }

    public void setSuperSsn(String superSsn) {
        SuperSsn = superSsn;
    }

    public int getDno() {
        return Dno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    @Override
    public String toString() {
       /* return FName + LName + BDate + Minit + Ssn + Address + Sex + SuperSsn;*/
        return "" + id;
    }

}
