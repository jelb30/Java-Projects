package com.EmployeeManagement;

import java.util.ArrayList;
import java.util.TreeSet;

public class Employee extends Department{
    private String emp_name;
    private int org_id;
    private int dep_id;
    private int emp_id ;
    public Employee(String name, int dep_id, int org_id){
        this.emp_name = name;
        this.emp_id = ++Organisation.org_list.get(org_id).depList.get(dep_id).empIdGenerator;
        this.org_id = org_id;
        this.dep_id = dep_id;
    }

    public Employee(String name, int dep_id, int org_id,int empId){
        this.deletedEmpIds.remove(empId);
        this.emp_name = name;
        this.emp_id = empId;
        this.org_id = org_id;
        this.dep_id = dep_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Override
    public int getOrg_id() {
        return org_id;
    }

    @Override
    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    @Override
    public int getDep_id() {
        return dep_id;
    }

    @Override
    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_name='" + emp_name + '\'' +
                ", org_id=" + org_id +
                ", dep_id=" + dep_id +
                ", emp_id=" + emp_id +
                '}';
    }
}
