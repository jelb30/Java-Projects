package com.EmployeeManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Organisation {
    public int totalEmployeeCount;
    private  static int orgIdGenerator=0;
    protected int depIdGenerator=0;

    private int org_id;
    private String org_name;
    public static HashMap<Integer,Organisation> org_list = new HashMap<>();
    public  HashMap<Integer,Department> depList = new HashMap<>();
    public  TreeSet<Integer> deletedDepIds = new TreeSet<>();
    public static TreeSet<Integer> deletedOrgIds = new TreeSet<>();

    public Organisation(String org_name){
            this.org_name = org_name;
            this.org_id = ++orgIdGenerator;
            this.totalEmployeeCount=0;
            org_list.put(org_id,this);
    }

    public Organisation(String org_name,int org_id){
        Organisation.deletedOrgIds.remove(org_id);
        this.org_name = org_name;
        this.org_id = org_id;
        this.totalEmployeeCount=0;
        org_list.put(org_id,this);
    }

    public Organisation(){}

    public int addDepart(Department department){
       this.totalEmployeeCount+=department.getEmployeeCount();
       this.depList.put(department.getDep_id(),department);
       return department.getDep_id();
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public int getTotalEmployeeCount() {
        return totalEmployeeCount;
    }
}
