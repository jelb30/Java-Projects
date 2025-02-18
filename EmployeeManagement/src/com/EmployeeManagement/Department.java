package com.EmployeeManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Department extends Organisation {
    protected int empIdGenerator = 0;
    public int employeeCount ;
    private String dep_name;
    private int dep_id ;
    private int org_id;
    public  TreeSet<Integer> deletedEmpIds = new TreeSet<>();
    public   HashMap<Integer,Employee> empList = new HashMap<>();

    public Department(String dep_name, int org_id) {
        this.dep_name = dep_name;
        this.dep_id = ++Organisation.org_list.get(org_id).depIdGenerator;
        this.org_id = org_id;
        this.employeeCount=0;
    }

    public Department(String dep_name, int org_id,int depId) {
        this.deletedDepIds.remove(depId);
        this.dep_name = dep_name;
        this.dep_id = depId;
        this.org_id = org_id;
        this.employeeCount=0;
    }

    public int addEmployee(Employee employee,int orgId){
        this.empList.put(employee.getEmp_id(),employee);
        this.employeeCount++;
        Organisation.org_list.get(orgId).totalEmployeeCount++;
        return employee.getEmp_id();
    }


    public Department(){
        super();

    }
    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public   void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String toString(Department obj){
        return obj.dep_name+" "+obj.dep_id;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
}
