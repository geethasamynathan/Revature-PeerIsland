# Lambda Expression in Java with Collection API and Employee List Examples

## 1. What is Lambda Expression in Java?

A **Lambda Expression** in Java is a short way to write **anonymous functions**.

It is mainly used to provide implementation for:

- functional interfaces
- collection operations
- sorting
- filtering
- iteration
- custom behavior passed as argument

In simple words:

**Lambda lets us write behavior in a compact form instead of creating a separate class or anonymous inner class.**

---

## 2. Why lambda was introduced

Before Java 8, if we wanted to pass some behavior, we often had to write:

- a separate implementation class
- an anonymous inner class

That made code lengthy.

Lambda was introduced to make code:

- shorter
- cleaner
- more readable
- more functional in style

---

## 3. Simple definition

A lambda expression is:

- a function without a name
- a compact implementation of a functional interface
- often written using `->`

### General syntax

```java
(parameters) -> expression
```

or

```java
(parameters) -> {
    // statements
}
```

---

## 4. Small example

### Without lambda

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running task");
    }
};
```

### With lambda

```java
Runnable r = () -> System.out.println("Running task");
```

Same meaning, less code.

---

## 5. What is needed for lambda?

Lambda works with a **functional interface**.

A functional interface is an interface with **only one abstract method**.

### Examples

- `Runnable`
- `Comparator`
- `Predicate`
- `Function`
- `Consumer`
- `Supplier`

---

## 6. Real-world use of lambda with collections

In real projects, lambda is heavily used with **Collection API** for:

- sorting employees
- filtering employees
- printing selected employees
- finding max salary employee
- grouping data
- mapping employee names
- checking conditions
- removing records
- iterating through list

---

## 7. Employee model for all examples

```java
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
```

---

## 8. Create employee list

```java
import java.util.ArrayList;
import java.util.List;

public class EmployeeLambdaDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Ravi", "IT", 60000, 28));
        employees.add(new Employee(102, "Priya", "HR", 45000, 32));
        employees.add(new Employee(103, "Arun", "Finance", 70000, 35));
        employees.add(new Employee(104, "Divya", "IT", 55000, 26));
        employees.add(new Employee(105, "Karthik", "Admin", 40000, 30));
        employees.add(new Employee(106, "Meena", "IT", 80000, 38));
    }
}
```

This list will be used for all lambda operations.

---

## 9. Lambda with `forEach()`

### Purpose
Print each employee.

```java
employees.forEach(emp -> System.out.println(emp));
```

### Explanation
Here:

- `emp` is each employee object
- `->` means “do this”
- for each employee, print it

### Another style

```java
employees.forEach((Employee emp) -> System.out.println(emp));
```

### Another style using method reference

```java
employees.forEach(System.out::println);
```

---

## 10. Lambda with filtering using `stream().filter()`

### Find employees from IT department

```java
employees.stream()
         .filter(emp -> emp.getDepartment().equals("IT"))
         .forEach(System.out::println);
```

### Meaning
- stream over employees
- keep only IT employees
- print them

### Find employees with salary greater than 50000

```java
employees.stream()
         .filter(emp -> emp.getSalary() > 50000)
         .forEach(System.out::println);
```

### Find employees age above 30

```java
employees.stream()
         .filter(emp -> emp.getAge() > 30)
         .forEach(System.out::println);
```

---

## 11. Lambda with multiple conditions

### Employees in IT department and salary above 55000

```java
employees.stream()
         .filter(emp -> emp.getDepartment().equals("IT") && emp.getSalary() > 55000)
         .forEach(System.out::println);
```

---

## 12. Lambda with sorting

Sorting is one of the most common real-world uses.

### Sort employees by name ascending

```java
employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
employees.forEach(System.out::println);
```

### Sort employees by salary ascending

```java
employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
employees.forEach(System.out::println);
```

### Sort employees by salary descending

```java
employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
employees.forEach(System.out::println);
```

### Sort employees by age

```java
employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
employees.forEach(System.out::println);
```

### Sort employees by department then name

```java
employees.sort((e1, e2) -> {
    int deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
    if (deptCompare == 0) {
        return e1.getName().compareTo(e2.getName());
    }
    return deptCompare;
});
employees.forEach(System.out::println);
```

This is a real project-style custom sort.

---

## 13. Lambda with `map()`

`map()` transforms data.

### Get only employee names

```java
employees.stream()
         .map(emp -> emp.getName())
         .forEach(System.out::println);
```

### Get only salaries

```java
employees.stream()
         .map(emp -> emp.getSalary())
         .forEach(System.out::println);
```

### Convert names to uppercase

```java
employees.stream()
         .map(emp -> emp.getName().toUpperCase())
         .forEach(System.out::println);
```

### Create formatted employee summary

```java
employees.stream()
         .map(emp -> emp.getName() + " - " + emp.getDepartment() + " - " + emp.getSalary())
         .forEach(System.out::println);
```

---

## 14. Lambda with `collect()`

`collect()` is used to store filtered or transformed results into a new collection.

### Collect IT employees into a new list

```java
import java.util.List;
import java.util.stream.Collectors;

List<Employee> itEmployees = employees.stream()
        .filter(emp -> emp.getDepartment().equals("IT"))
        .collect(Collectors.toList());

itEmployees.forEach(System.out::println);
```

### Collect employee names into list

```java
List<String> employeeNames = employees.stream()
        .map(emp -> emp.getName())
        .collect(Collectors.toList());

System.out.println(employeeNames);
```

---

## 15. Lambda with `count()`

### Count employees in IT department

```java
long count = employees.stream()
        .filter(emp -> emp.getDepartment().equals("IT"))
        .count();

System.out.println("IT Employees Count: " + count);
```

### Count employees with salary > 50000

```java
long highSalaryCount = employees.stream()
        .filter(emp -> emp.getSalary() > 50000)
        .count();

System.out.println("High Salary Employees Count: " + highSalaryCount);
```

---

## 16. Lambda with `findFirst()`

### Find first employee from IT

```java
employees.stream()
         .filter(emp -> emp.getDepartment().equals("IT"))
         .findFirst()
         .ifPresent(System.out::println);
```

---

## 17. Lambda with `anyMatch()`, `allMatch()`, `noneMatch()`

These are very useful in validations.

### Check if any employee has salary above 75000

```java
boolean anyHighSalary = employees.stream()
        .anyMatch(emp -> emp.getSalary() > 75000);

System.out.println(anyHighSalary);
```

### Check if all employees have salary above 30000

```java
boolean allAboveMin = employees.stream()
        .allMatch(emp -> emp.getSalary() > 30000);

System.out.println(allAboveMin);
```

### Check if no employee belongs to Legal department

```java
boolean noLegal = employees.stream()
        .noneMatch(emp -> emp.getDepartment().equals("Legal"));

System.out.println(noLegal);
```

---

## 18. Lambda with `max()` and `min()`

### Find employee with maximum salary

```java
employees.stream()
         .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
         .ifPresent(System.out::println);
```

### Find employee with minimum salary

```java
employees.stream()
         .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
         .ifPresent(System.out::println);
```

---

## 19. Lambda with `reduce()`

`reduce()` combines values.

### Total salary of all employees

```java
double totalSalary = employees.stream()
        .map(emp -> emp.getSalary())
        .reduce(0.0, (a, b) -> a + b);

System.out.println("Total Salary = " + totalSalary);
```

### Better shorthand

```java
double totalSalary2 = employees.stream()
        .map(Employee::getSalary)
        .reduce(0.0, Double::sum);

System.out.println(totalSalary2);
```

---

## 20. Lambda with `removeIf()`

Very useful for removing based on condition.

### Remove employees with salary below 45000

```java
employees.removeIf(emp -> emp.getSalary() < 45000);
employees.forEach(System.out::println);
```

---

## 21. Lambda with `replaceAll()`

Useful for updating collection elements.

### Increase salary by 10% for all employees

```java
employees.replaceAll(emp -> {
    emp.setSalary(emp.getSalary() + emp.getSalary() * 0.10);
    return emp;
});

employees.forEach(System.out::println);
```

---

## 22. Lambda with `Comparator.comparing()`

This is a cleaner modern style.

### Sort by employee name

```java
import java.util.Comparator;

employees.sort(Comparator.comparing(emp -> emp.getName()));
employees.forEach(System.out::println);
```

### Sort by salary

```java
employees.sort(Comparator.comparing(emp -> emp.getSalary()));
employees.forEach(System.out::println);
```

### Sort by salary descending

```java
employees.sort(Comparator.comparing(Employee::getSalary).reversed());
employees.forEach(System.out::println);
```

### Sort by department then salary

```java
employees.sort(
    Comparator.comparing(Employee::getDepartment)
              .thenComparing(Employee::getSalary)
);
employees.forEach(System.out::println);
```

---

## 23. Lambda with `Consumer`

`Consumer<T>` takes input and returns nothing.

### Print employee details

```java
import java.util.function.Consumer;

Consumer<Employee> printEmployee = emp -> System.out.println(emp);

employees.forEach(printEmployee);
```

### Real meaning
You are storing printing behavior in a variable.

---

## 24. Lambda with `Predicate`

`Predicate<T>` is used for condition checking.

### Check if employee salary > 50000

```java
import java.util.function.Predicate;

Predicate<Employee> highSalary = emp -> emp.getSalary() > 50000;

employees.stream()
         .filter(highSalary)
         .forEach(System.out::println);
```

### Predicate with multiple conditions

```java
Predicate<Employee> isIT = emp -> emp.getDepartment().equals("IT");
Predicate<Employee> salaryAbove60k = emp -> emp.getSalary() > 60000;

employees.stream()
         .filter(isIT.and(salaryAbove60k))
         .forEach(System.out::println);
```

---

## 25. Lambda with `Function`

`Function<T, R>` takes input and returns transformed output.

### Get employee names

```java
import java.util.function.Function;

Function<Employee, String> getName = emp -> emp.getName();

employees.stream()
         .map(getName)
         .forEach(System.out::println);
```

### Get yearly salary

```java
Function<Employee, Double> yearlySalary = emp -> emp.getSalary() * 12;

employees.stream()
         .map(yearlySalary)
         .forEach(System.out::println);
```

---

## 26. Lambda with `Supplier`

`Supplier<T>` provides value without input.

```java
import java.util.function.Supplier;

Supplier<Employee> defaultEmployee =
        () -> new Employee(999, "Default", "Support", 25000, 22);

System.out.println(defaultEmployee.get());
```

---

## 27. Lambda with custom functional interface

You can also create your own interface.

```java
@FunctionalInterface
interface EmployeeFormatter {
    String format(Employee emp);
}
```

### Use lambda

```java
EmployeeFormatter formatter = emp ->
        "Employee Name: " + emp.getName() + ", Department: " + emp.getDepartment();

employees.forEach(emp -> System.out.println(formatter.format(emp)));
```

---

## 28. Full combined program

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

public class EmployeeLambdaDemo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Ravi", "IT", 60000, 28));
        employees.add(new Employee(102, "Priya", "HR", 45000, 32));
        employees.add(new Employee(103, "Arun", "Finance", 70000, 35));
        employees.add(new Employee(104, "Divya", "IT", 55000, 26));
        employees.add(new Employee(105, "Karthik", "Admin", 40000, 30));
        employees.add(new Employee(106, "Meena", "IT", 80000, 38));

        System.out.println("----- All Employees -----");
        employees.forEach(System.out::println);

        System.out.println("\n----- IT Employees -----");
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .forEach(System.out::println);

        System.out.println("\n----- Salary > 50000 -----");
        employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .forEach(System.out::println);

        System.out.println("\n----- Employee Names -----");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\n----- Sort by Salary Desc -----");
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        employees.forEach(System.out::println);

        System.out.println("\n----- Max Salary Employee -----");
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("\n----- Total Salary -----");
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println(totalSalary);

        System.out.println("\n----- Count IT Employees -----");
        long count = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .count();
        System.out.println(count);

        System.out.println("\n----- Increase salary by 10% -----");
        employees.replaceAll(emp -> {
            emp.setSalary(emp.getSalary() * 1.10);
            return emp;
        });
        employees.forEach(System.out::println);

        System.out.println("\n----- Remove employees salary < 50000 -----");
        employees.removeIf(emp -> emp.getSalary() < 50000);
        employees.forEach(System.out::println);

        System.out.println("\n----- Predicate Example -----");
        Predicate<Employee> highSalary = emp -> emp.getSalary() > 60000;
        employees.stream().filter(highSalary).forEach(System.out::println);

        System.out.println("\n----- Consumer Example -----");
        Consumer<Employee> printEmp = emp -> System.out.println("Employee Name: " + emp.getName());
        employees.forEach(printEmp);

        System.out.println("\n----- Function Example -----");
        Function<Employee, String> nameAndDept =
                emp -> emp.getName() + " works in " + emp.getDepartment();

        employees.stream()
                .map(nameAndDept)
                .forEach(System.out::println);

        System.out.println("\n----- Collect IT Employees -----");
        List<Employee> itList = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .collect(Collectors.toList());

        itList.forEach(System.out::println);
    }
}
```

---

## 29. Real-world operations covered here

Using lambda with employee collection, we implemented:

- iteration
- filtering
- mapping
- sorting
- multiple condition filtering
- counting
- finding first
- matching
- max/min
- reduce
- remove
- replace/update
- predicate
- consumer
- function
- supplier
- custom functional interface
- collecting new list

---

## 30. Similarities between all lambda operations

All these lambda operations:

- reduce boilerplate code
- make collection operations cleaner
- help pass behavior as data
- are commonly used with streams and collections
- improve readability when used properly

---

## 31. Differences between major operations

| Operation | Purpose | Returns |
|---|---|---|
| `forEach()` | Perform action on each element | void |
| `filter()` | Keep matching elements | Stream |
| `map()` | Transform elements | Stream |
| `sorted()` / `sort()` | Arrange data | sorted stream/list |
| `collect()` | Store result in collection | Collection |
| `count()` | Count matching elements | long |
| `max()` / `min()` | Find largest/smallest | Optional |
| `reduce()` | Combine values | single value |
| `removeIf()` | Remove matching elements | boolean |
| `replaceAll()` | Update elements | void |

---

## 32. When to use lambda in real projects

Use lambda when you need:

- simple sorting logic
- inline filter condition
- inline business transformation
- compact iteration
- functional style coding
- collection processing
- stream-based reporting

---

## 33. When not to overuse lambda

Do not write very large complex business logic inside one lambda block.

### Bad style

```java
employees.stream().filter(emp -> {
    // 25 lines of logic
    // multiple if else
    // database calls
    return true;
});
```

Better:
- move complex logic into a method
- call method inside lambda

### Better style

```java
employees.stream()
         .filter(emp -> isEligibleForPromotion(emp))
         .forEach(System.out::println);
```

---

## 34. Easy memory trick

Remember:

- **filter** → choose
- **map** → transform
- **forEach** → act
- **sort** → arrange
- **reduce** → combine
- **collect** → store

---

## 35. Final conclusion

A **Lambda Expression** in Java is a compact way to write behavior for functional interfaces.

With Collection API, lambda is widely used for:

- filtering employee data
- sorting employee records
- mapping fields like name/salary
- counting matching records
- updating employee list
- removing unwanted records
- building clean modern Java code

It is one of the most important Java 8+ features and is heavily used in real-world projects.
