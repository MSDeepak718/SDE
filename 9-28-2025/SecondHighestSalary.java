import java.util.*;

/*
Given class of employees with name, age and salary return the employee name
with second highest salary
 */

public class SecondHighestSalary {

    public static class Employee{
        String name;
        int age;
        int salary;
        Employee(String name,int age,int salary){
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String name = sc.next();
            int age = sc.nextInt();
            int salary = sc.nextInt();
            list.add(new Employee(name, age, salary));
        }
        Collections.sort(list,(a,b)->{
            return b.salary-a.salary;
        });
        Employee ans = list.get(1);
        System.out.println("Employee with 2nd Highest Salary: ");
        System.out.println("Name: "+ans.name);
        System.out.println("Age: "+ans.age);
        System.out.println("Salary: "+ans.salary);
        sc.close();
    }
}

//Time Complexity: O(nlogn) due to sorting
//Space Complexity: O(1)
