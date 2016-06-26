package com.example.namtran.xml_json;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 7/29/2015.
 */
public class JSONDemo {
//    static String demoJson = "{\"[{ \"id\":1, \"FName\":\"John\", \"Minit\":\"B\", \"LName\":\"Smith\", \"Ssn\":\"123456789\", \"BDate\":\"1955-01-09T00:00:00\", \"Address\":\"731 Fondren, Houston, TX\", \"Sex\":\"M\", \"Salary\":30000, \"SuperSsn\":\"987654321\", \"Dno\":5}, {\"id\":2, \"FName\":\"Franklin\", \"Minit\":\"T\", \"LName\":\"Wong\", \"Ssn\":\"333445555\", \"BDate\":\"1945-12-08T00:00:00\", \"Address\":\"638 Voss, Houston, TX\", \"Sex\":\"M\", \"Salary\":40000, \"SuperSsn\":\"888665555\", \"Dno\":5}, { \"id\":3, \"FName\":\"Joyce\", \"Minit\":\"A\", \"LName\":\"English\", \"Ssn\":\"453453453\", \"BDate\":\"1962-07-31T00:00:00\", \"Address\":\"5631 Rice, Houston, TX\", \"Sex\":\"F\", \"Salary\":25000, \"SuperSsn\":\"333445555\", \"Dno\":5}, { \"id\":4, \"FName\":\"Ramesh\", \"Minit\":\"K\", \"LName\":\"Narayan\", \"Ssn\":\"666884444\", \"BDate\":\"1952-09-15T00:00:00\", \"Address\":\"975 Fire Oak, Humble, TX\", \"Sex\":\"M\", \"Salary\":38000, \"SuperSsn\":\"333445555\", \"Dno\":5}, { \"id\":5, \"FName\":\"James\", \"Minit\":\"E\", \"LName\":\"Borg\", \"Ssn\":\"888665555\", \"BDate\":\"1927-11-10T00:00:00\", \"Address\":\"450 Stone, Houston, TX\", \"Sex\":\"M\", \"Salary\":55000, \"Dno\":1}, { \"id\":6, \"FName\":\"Jennifer\", \"Minit\":\"S\", \"LName\":\"Wallace\", \"Ssn\":\"987654321\", \"BDate\":\"1931-06-20T00:00:00\", \"Address\":\"291 Berry, Bellaire, TX\", \"Sex\":\"F\", \"Salary\":43000, \"SuperSsn\":\"888665555\", \"Dno\":4}, { \"id\":7, \"FName\":\"Ahmad\", \"Minit\":\"V\", \"LName\":\"Jabbar\", \"Ssn\":\"987987987\", \"BDate\":\"1959-03-29T00:00:00\", \"Address\":\"980 Dallas, Houston, TX\", \"Sex\":\"M\", \"Salary\":25000, \"SuperSsn\":\"987654321\", \"Dno\":4}, { \"id\":8, \"FName\":\"Alicia\", \"Minit\":\"J\", \"LName\":\"Zelaya\", \"Ssn\":\"999887777\", \"BDate\":\"1958-07-19T00:00:00\", \"Address\":\"3321 Castle, SPring, TX\", \"Sex\":\"F\", \"Salary\":25000, \"SuperSsn\":\"987654321\", \"Dno\":4}]}";
    static String demoJson = "[ { \"id\":1, \"FName\":\"John\", \"Minit\":\"B\", \"LName\":\"Smith\", \"Ssn\":\"123456789\", \"BDate\":\"1955-01-09T00:00:00\", \"Address\":\"731 Fondren, Houston, TX\", \"Sex\":\"M\", \"Salary\":30000, \"SuperSsn\":\"987654321\", \"Dno\":5}, {\"id\":2, \"FName\":\"Franklin\", \"Minit\":\"T\", \"LName\":\"Wong\", \"Ssn\":\"333445555\", \"BDate\":\"1945-12-08T00:00:00\", \"Address\":\"638 Voss, Houston, TX\", \"Sex\":\"M\", \"Salary\":40000, \"SuperSsn\":\"888665555\", \"Dno\":5}, { \"id\":3, \"FName\":\"Joyce\", \"Minit\":\"A\", \"LName\":\"English\", \"Ssn\":\"453453453\", \"BDate\":\"1962-07-31T00:00:00\", \"Address\":\"5631 Rice, Houston, TX\", \"Sex\":\"F\", \"Salary\":25000, \"SuperSsn\":\"333445555\", \"Dno\":5}, { \"id\":4, \"FName\":\"Ramesh\", \"Minit\":\"K\", \"LName\":\"Narayan\", \"Ssn\":\"666884444\", \"BDate\":\"1952-09-15T00:00:00\", \"Address\":\"975 Fire Oak, Humble, TX\", \"Sex\":\"M\", \"Salary\":38000, \"SuperSsn\":\"333445555\", \"Dno\":5}, { \"id\":5, \"FName\":\"James\", \"Minit\":\"E\", \"LName\":\"Borg\", \"Ssn\":\"888665555\", \"BDate\":\"1927-11-10T00:00:00\", \"Address\":\"450 Stone, Houston, TX\", \"Sex\":\"M\", \"Salary\":55000, \"Dno\":1}, { \"id\":6, \"FName\":\"Jennifer\", \"Minit\":\"S\", \"LName\":\"Wallace\", \"Ssn\":\"987654321\", \"BDate\":\"1931-06-20T00:00:00\", \"Address\":\"291 Berry, Bellaire, TX\", \"Sex\":\"F\", \"Salary\":43000, \"SuperSsn\":\"888665555\", \"Dno\":4}, { \"id\":7, \"FName\":\"Ahmad\", \"Minit\":\"V\", \"LName\":\"Jabbar\", \"Ssn\":\"987987987\", \"BDate\":\"1959-03-29T00:00:00\", \"Address\":\"980 Dallas, Houston, TX\", \"Sex\":\"M\", \"Salary\":25000, \"SuperSsn\":\"987654321\", \"Dno\":4}, { \"id\":8, \"FName\":\"Alicia\", \"Minit\":\"J\", \"LName\":\"Zelaya\", \"Ssn\":\"999887777\", \"BDate\":\"1958-07-19T00:00:00\", \"Address\":\"3321 Castle, SPring, TX\", \"Sex\":\"F\", \"Salary\":25000, \"SuperSsn\":\"987654321\", \"Dno\":4}]";
    public static List<Employee> parseEmployeewithJSON ( Context context)
    {
        String json = demoJson;
        List<Employee> employees = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArrayEmployee = jsonObject.getJSONArray("Employees");
            Employee employee = null;
            for (int i=0;i<jsonArrayEmployee.length();i++)
            {
                employee = new Employee();
                JSONObject child = jsonArrayEmployee.getJSONObject(i);
                employee.setId(child.getInt(Employee.ID));
                employee.setFName(child.getString(Employee.FNAME));
                employee.setMinit(child.getString(Employee.MINIT));
                employee.setLName(child.getString(Employee.LNAME));
                employee.setBDate(child.getString(Employee.BDATE));
                employee.setAddress(child.getString(Employee.ADDRESS));
                employee.setSex(child.getString(Employee.SEX));
                employee.setSsn(child.getString(Employee.SSN));
               // employee.setSuperSsn(child.getString(Employee.SUPERSSN));
                employee.setDno(child.getInt(Employee.DNO));
                employee.setSalary(child.getDouble(Employee.SALARY));
                employees.add(employee);
            }

            Log.d("TranNam", String.valueOf(employees));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return employees;
    }
    public static List<Employee> parseEmployeewithGSON (Context context)
    {
        List<Employee> employees = new ArrayList<>();
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(demoJson);
            JSONArray jsonArray = jsonObject.getJSONArray("Employees");
            for (int i=0;i<jsonArray.length();i++)
            {
                Employee employee = gson.fromJson(jsonArray.getJSONArray(i).toString(),Employee.class);
                employees.add(employee);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
