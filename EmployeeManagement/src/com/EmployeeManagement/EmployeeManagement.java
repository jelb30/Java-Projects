package com.EmployeeManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagement {

    public static boolean isValidOrgId(int orgId){
        return Organisation.org_list.containsKey(orgId);
    }

    public static boolean isValidDepId(int depId,int orgId){
        if(isValidOrgId(orgId)){
           return Organisation.org_list.get(orgId).depList.containsKey(depId);
        }
        return false;
    }

    public static boolean isValidEmpId(int orgId, int depId, int empId){
        if(isValidDepId(depId,orgId)){
            return Organisation.org_list.get(orgId).depList.get(depId).empList.containsKey(empId);
        }
        return false;
    }

    public static int countEmpByOrg(int orgId){
        if(!isValidOrgId(orgId)){
            System.out.println("INVALID ORGANISATION ID, DOES NOT EXISTS");
            return 0;
        }
        System.out.println("EMPLOYEE COUNT OF THE ORGANIZATION " +Organisation.org_list.get(orgId).getOrg_name());
        return Organisation.org_list.get(orgId).getTotalEmployeeCount();
    }

    public static int countEmpByDep(int depId, int orgId){
        if(!isValidDepId(depId,orgId)){
            System.out.println("INVALID DEPID OR ORGID");
            return 0;
        }
        return Organisation.org_list.get(orgId).depList.get(depId).employeeCount;
    }

    public static void showEmployeeDetails(int orgId,int depId, int empId){
        if(!isValidEmpId(orgId,depId,empId)){
            return;
        }
        Employee emp = Organisation.org_list.get(orgId).depList.get(depId).empList.get(empId);
        if(emp!=null){
            System.out.println("EMPLOYEE NAME "+emp.getEmp_name());
        }
        else{
            System.out.println("NO SUCH EMPLOYEE EXISTS");
        }

    }

    public static void removeOrganization(int orgId){
        if(!isValidOrgId(orgId)){
            return;
        }
        Organisation.org_list.remove(orgId);
        Organisation.deletedOrgIds.add(orgId);
        System.out.println("ORGANISATION REMOVED SUCCESSFULLY");
    }

    public static void removeDepartment(int orgId, int depId){
        if(!isValidDepId(depId,orgId)){
            System.out.println("INVALID ORGID OR DEPID");
            return;
        }

        Organisation.org_list.get(orgId).deletedDepIds.add(depId);
        Organisation.org_list.get(orgId).totalEmployeeCount-=Organisation
                .org_list.get(orgId).depList.get(depId).employeeCount;

        Organisation.org_list.get(orgId).depList.remove(depId);
        System.out.println("DEPARTMENT REMOVED SUCCESSFULLY");
    }

    public static void removeEmployee(int orgId, int depId, int empId){
        if(!isValidEmpId(orgId,depId,empId)){
            System.out.println("INVALID EMP ID OR DEPID OR ORGID");
            return;
        }
        Organisation.org_list.get(orgId).depList.get(depId).deletedEmpIds.add(empId);

        Organisation.org_list.get(orgId).totalEmployeeCount--;
        Organisation.org_list.get(orgId).depList.get(depId).employeeCount--;

        Organisation.org_list.get(orgId).depList.get(depId).empList.remove(empId);
        System.out.println("EMPLOYEE REMOVED SUCCESSFULLY");
    }

    // ADDING ORGANIZATIONS
    public static int addOrg(String orgName){
        Organisation organisation;
        if(Organisation.deletedOrgIds.isEmpty()){
            organisation = new Organisation(orgName);
            System.out.println("ORGANISATION ADDED WITH ID" +organisation.getOrg_id());
            return organisation.getOrg_id();
        }
        organisation = new Organisation(orgName, Organisation.deletedOrgIds.first());
        System.out.println("ORGANISATION ADDED WITH ID" +organisation.getOrg_id());
        return organisation.getOrg_id();
    }

    //ADDING DEPARTMENTS
    public static int addDep(String depName,int orgId){
        Organisation organisation = Organisation.org_list.get(orgId);
        Department department;

        if(organisation.deletedDepIds.isEmpty()){
            department = new Department(depName,orgId);
            organisation.addDepart(department);
            System.out.println("DEPARTMENT ADDED WITH ID" +department.getDep_id());
            return department.getDep_id();
        }
        department = new Department(depName,orgId,organisation.deletedDepIds.first());

        organisation.addDepart(department);
        System.out.println("DEPARTMENT ADDED WITH ID" +department.getDep_id());
        return department.getDep_id();
    }

    //ADDING EMPLOYEES
    public static int  addEmployee(String name, int depId, int orgId){

        if(!isValidDepId(depId,orgId)){
            System.out.println("INVALID DEPID OR ORGID");
        }
        Organisation organisation = Organisation.org_list.get(orgId);
        Department department = organisation.depList.get(depId);
        Employee employee;
        if(organisation.depList.get(depId).deletedEmpIds.isEmpty()){
            employee = new Employee(name,depId,orgId);
            department.addEmployee(employee,orgId);
            System.out.println("EMPLOYEE ADDED WITH ID : "+employee.getEmp_id());
            return employee.getEmp_id();
        }
        employee = new Employee(name,depId,orgId,organisation.depList.get(depId).deletedEmpIds.first());
        department.addEmployee(employee,orgId);
        System.out.println("EMPLOYEE ADDED WITH ID : "+employee.getEmp_id());
        return employee.getEmp_id();
    }

    public static void listAllEmp(int depId, int orgId){
        for (Employee employee : Organisation.org_list.get(orgId).depList.get(depId).empList.values()) {
            System.out.println("ID   NAME    depId   orgID");
            System.out.println(employee.getEmp_id()+"  "+
                    employee.getEmp_name()+"   "+employee.getDep_id()+"  "+
                    employee.getOrg_id());
        }
    }

    public static void askUser(){
        int action = 0;
        try{
            do{
                Scanner scan = new Scanner(System.in);
                System.out.println("1. LIST ALL EMPLOYEE OF THE DEPARTMENT");
                System.out.println("2. TO ADD NEW EMPLOYEE");
                System.out.println("3. ADD NEW DEPARTMENT");
                System.out.println("4. ADD ORGANISATION");
                System.out.println("5. TOTAL EMPLOYEES IN ORGANISATION");
                System.out.println("6. TOTAL EMPLOYEES IN DEPARTMENT");
                System.out.println("7. REMOVE EMPLOYEE");
                System.out.println("8. REMOVE DEPARTMENT");
                System.out.println("9. REMOVE ORGANISAION");
                System.out.println("10. EXIT");
                do{
                    System.out.println("ENTER HERE \n");
                    action = scan.nextInt();
                }while (action<1 || action>10);

                switch (action){
                    case 1 :{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER DEPARTMENT ID :");
                        int depId = scan.nextInt();
                        listAllEmp(depId,orgId);
                        break;
                    }
                    case 2:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER DEPARTMENT ID :");
                        int depId = scan.nextInt();
                        System.out.println("ENTER NAME:");
                        String name = scan.next();
                        addEmployee(name,depId,orgId);
                        break;
                    }
                    case 3:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER NAME :");
                        String name = scan.next();
                        addDep(name,orgId);
                        break;
                    }
                    case 4:{
                        System.out.println("ENTER NAME :");
                        String name = scan.next();
                        addOrg(name);
                        break;
                    }
                    case 5:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("TOTAL COUNT IS "+countEmpByOrg(orgId));
                        break;
                    }
                    case 6:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER DEPARTMENT ID :");
                        int depId = scan.nextInt();
                        System.out.println("TOTAL COUNT IS "+countEmpByDep(depId,orgId));
                        break;
                    }
                    case 7:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER DEPARTMENT ID :");
                        int depId = scan.nextInt();
                        System.out.println("ENTER EMPLOYEE ID :");
                        int empId = scan.nextInt();
                        removeEmployee(orgId,depId,empId);
                        break;
                    }
                    case 8:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        System.out.println("ENTER DEPARTMENT ID :");
                        int depId = scan.nextInt();
                        removeDepartment(orgId,depId);
                        break;
                    }
                    case 9:{
                        System.out.println("ENTER ORGANISATION ID :");
                        int orgId = scan.nextInt();
                        removeOrganization(orgId);
                        break;
                    }
                    case 10:{
                        break;
                    }
                };
            }while (action!=10);

        }catch (InputMismatchException e){
            System.out.println(e.getCause());
            askUser();
        }


    }
    // 2 ORGS WITH 2 EACH DEP AND 1 EMP PER DEP
    public static void main(String[] args) {

        // USER INTERACTION !
        askUser();

//     STATIC

//        int orgId = addOrg("KNOVOS");
//        System.out.println("ORGANIZATION ID FOR KNOVOS : "+orgId);
//        int orgId2 = addOrg("GOOGLE");
//        System.out.println("ORGANIZATION ID FOR GOOGLE : "+orgId);
//
//        int depId = addDep("TECH",orgId);  //KNOVOS
//        System.out.println("DEP ID FOR TECH IN KNOVOS :"+depId);
//
//        int depId2 = addDep("it",orgId2);  //GOOGLE
//        System.out.println("DEP ID FOR IT IN GOOGLE :"+depId);
//
//        int depId3 = addDep("HR", orgId); //KNOVOS
//        System.out.println("DEP ID FOR HR IN KNOVOS :"+depId3);
//        int depId4 = addDep("ADMIN",orgId2);  // GOOGLE
//        System.out.println("DEP ID FOR ADMIN IN GOOGLE :"+depId4);
//
//
//        int idJill = addEmployee("JILL",depId3,orgId);  //KNOVOS
//        int idMill = addEmployee("MILL",depId,orgId);  //KNOVOS
//        System.out.println("EMPLOYEE ID FOR JILL IN KNOVOS :"+idJill);
//        System.out.println("EMPLOYEE ID FOR mILL IN KNOVOS :"+idMill);
//
//        int idKill = addEmployee("kill",depId4,orgId2); //GOOGLE
//        int idMGill = addEmployee("GILL",depId2,orgId2);  //GOOGLE
//        System.out.println("EMPLOYEE ID FOR KILL IN GOOGLE :"+idKill);
//        System.out.println("EMPLOYEE ID FOR GILL IN GOOGLE :"+idMGill);
//
//
//        System.out.println();
//        System.out.println("emp : "+Organisation.org_list.get(orgId2).totalEmployeeCount);
//        System.out.println("emp : "+Organisation.org_list.get(orgId).totalEmployeeCount);
//
//        System.out.println(countEmpByOrg(orgId));
//        System.out.println(countEmpByOrg(orgId2));
//
//        System.out.println(countEmpByDep(1,1));
//        System.out.println(countEmpByDep(2,1));
//        System.out.println(countEmpByDep(1,2));
//        System.out.println(countEmpByDep(2,2));
//
//        showEmployeeDetails(1,1,1);
//        showEmployeeDetails(1,2,1);
//        showEmployeeDetails(2,1,1);
//        showEmployeeDetails(2,2,1);
//
//        removeEmployee(2,2,1);
//        showEmployeeDetails(2,2,1);
//
//        removeDepartment(2,2);
//        removeOrganization(2);
//

    }
}
