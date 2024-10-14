package com.example.EmployeeRestWebService.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
@Component
public class EmployeeData {

    static List<Emoplyee> list = new ArrayList<Emoplyee>();

    static {
        list.add(new Emoplyee(1, "Sanjay", "sanjay@gmail.com", 450000));
        list.add(new Emoplyee(2, "Tejas", "tejas@gmail.com", 500000));
        list.add(new Emoplyee(3, "gani", "gani@gmail.com", 500000));
        list.add(new Emoplyee(4, "Bhavani", "bhavani@gmail.com", 1000000));
    }

    public List<Emoplyee> getAllEmployeeData() {
        return list;
    }

    // using Streams
//    public Emoplyee getEmployeeId(int empId) {
//        return list.stream().
//                filter(emp ->emp.getEmployeeId()==empId).
//                findAny().
//                orElse(null);
//
//    }

    public Emoplyee getEmployeeId(int empId) {
        for (Emoplyee emp : list) {
            if (emp.getEmployeeId() == empId) {
                return emp;
            }
        }
        return null;
    }


    public Emoplyee SaveEmployee(Emoplyee emp) {
        emp.setEmployeeId(list.size() + 1);
        list.add(emp);
        return emp;
    }

    public List<Emoplyee> SaveListOfEmployee(List<Emoplyee> employees) {
        list.addAll(employees);
        return employees;
    }


    public Emoplyee deleteEmployee(int empId) {
        Iterator<Emoplyee> i=list.iterator();
        while (i.hasNext())
        {
            Emoplyee emp=i.next();

            if(empId==emp.getEmployeeId())
            {
                i.remove();
                return emp;
            }

        }
        return null;
       }


//    public Emoplyee deleteEmployee(int empId) {
//        Emoplyee foundEmployee = null;
//        for (Emoplyee emp : list) {
//            if (empId == emp.getEmployeeId()) {
//                foundEmployee = emp;
//                break;
//            }
//        }
//        if (foundEmployee != null) {
//            list.remove(foundEmployee);
//        }
//        return foundEmployee;
//    }
}


