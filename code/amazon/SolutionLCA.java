package com.amazon;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tian on 2017/4/9.
 */
public class SolutionLCA {
    static class Employee {
        String name;
        List<Employee> reporters;
        public Employee(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "name: " + name;
        }
    }

    static class ResultType {
        boolean a_exist, b_exist;
        Employee node;
        ResultType(boolean a, boolean b, Employee n) {
            a_exist = a;
            b_exist = b;
            node = n;
        }
    }

    public static ResultType closestCommonManager1(Employee root, Employee node1, Employee node2) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        boolean a_exist = false, b_exist = false;

        if (root.reporters == null) {
            if (root == node1)
                a_exist = true;
            if (root == node2)
                b_exist = true;
            //System.out.println("leaf: " + root.name + a_exist + b_exist);
            return new ResultType(a_exist, b_exist, (a_exist || b_exist) ? root : null);
        }

        int count = 0;
        Employee lca = null;
        for (Employee reporter : root.reporters) {
            ResultType sub = closestCommonManager1(reporter, node1, node2);

            if (sub.a_exist || root == node1)
                a_exist = true;
            if (sub.b_exist || root == node2)
                b_exist = true;

            if (sub.node != null) {
                lca = sub.node;
                count++;
            }
        }

        if (root == node1 || root == node2) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (count == 2) {
            return new ResultType(a_exist, b_exist, root);
        }

        if (lca != null) {
            return new ResultType(a_exist, b_exist, lca);
        }

        return new ResultType(a_exist, b_exist, null);
    }

    public static Employee closestCommonManager(Employee root, Employee node1, Employee node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        int count = 0;
        Employee lca = null;
        if (root.reporters == null) {
            return null;
        }
        for (Employee reporter : root.reporters) {
            Employee sub = closestCommonManager(reporter, node1, node2);

            if (sub != null) {
                lca = sub;
                count++;
            }
        }
        if (count == 2) {
            return root;
        }
        return lca;
    }

    public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");

        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.reporters = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.reporters = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.reporters = Arrays.asList(dom, samir, michael);

        Employee xiaopan = new Employee("xiaopan");

        System.out.println(closestCommonManager(bill, milton, nina));
        System.out.println(closestCommonManager(bill, nina, porter));
        System.out.println(closestCommonManager(bill, nina, samir));
        System.out.println(closestCommonManager(bill, peter, nina));
        //System.out.println(closestCommonManager(bill, xiaopan, nina));

        System.out.println(closestCommonManager1(bill, peter, nina).a_exist);
        System.out.println(closestCommonManager1(bill, peter, nina).b_exist);
        System.out.println(closestCommonManager1(bill, peter, nina).node);
        System.out.println(closestCommonManager1(bill, xiaopan, nina).a_exist);
        System.out.println(closestCommonManager1(bill, xiaopan, nina).b_exist);
        System.out.println(closestCommonManager1(bill, xiaopan, nina).node);

    }
}
/*
Sample calls:
closestCommonManager(Milton, Nina) = Peter
closestCommonManager(Nina, Porter) = Dom
closestCommonManager(Nina, Samir) = Bill
closestCommonManager(Peter, Nina) = Peter
 */