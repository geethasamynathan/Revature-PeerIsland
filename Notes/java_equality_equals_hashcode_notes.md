# Equality, `equals()`, and `hashCode()` in Java

## 1. Introduction

In Java, when we compare two values or objects, the word **same** can mean different things.

For example, if we create two `Employee` objects with the same employee ID and name, we may want to know:

- Are both references pointing to the **same object in memory**?
- Or are they **different objects** that represent the **same logical employee**?

That is where these concepts come in:

- `==` → checks **reference equality** for objects
- `equals()` → checks **logical/content equality**
- `hashCode()` → helps Java store and search objects efficiently in hash-based collections like `HashMap` and `HashSet`

---

## 2. Equality in Java

In general, **equality** means checking whether two things should be treated as the same.

In Java, equality is mainly of two types:

### A. Reference equality
Checks whether both references point to the **same object in memory**.

Uses:

```java
==
```

### B. Logical equality
Checks whether two objects have the **same data or same business meaning**.

Uses:

```java
equals()
```

---

## 3. What is `==` in Java?

`==` compares:

- primitive values directly
- object references for objects

### Primitive example

```java
int a = 10;
int b = 10;

System.out.println(a == b);   // true
```

Here it compares values directly.

### Object example

```java
StringBuilder sb1 = new StringBuilder("Java");
StringBuilder sb2 = new StringBuilder("Java");

System.out.println(sb1 == sb2);   // false
```

Why `false`?

Because `sb1` and `sb2` are two different objects in memory.

So for objects, `==` means:

**Are both references pointing to the exact same object?**

---

## 4. What is `equals()` in Java?

`equals()` is a method from the `Object` class.

By default, `equals()` in `Object` behaves almost like `==`.

But many Java classes override it to compare **content equality**.

### Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);        // false
System.out.println(s1.equals(s2));   // true
```

Why?

- `s1 == s2` → different objects
- `s1.equals(s2)` → same text content

So `equals()` is used when you want to know:

**Do these two objects represent the same logical data?**

---

## 5. What is `hashCode()` in Java?

`hashCode()` is also a method from `Object`.

It returns an integer value representing the object for hashing purposes.

It is mainly used internally by:

- `HashMap`
- `HashSet`
- `Hashtable`

Java uses this value to decide in which bucket an object should be stored.

You can think of it like this:

- `equals()` tells whether two objects are logically same
- `hashCode()` helps Java locate them quickly in hash-based collections

---

## 6. Relation between `equals()` and `hashCode()`

Very important rule:

If two objects are equal according to `equals()`, then they **must** return the same `hashCode()`.

That means:

```java
if (obj1.equals(obj2)) {
    obj1.hashCode() == obj2.hashCode();   // must be true
}
```

But reverse is not always true:

Same hash code does **not always mean** objects are equal.

---

## 7. Real-world meaning

Suppose you have an `Employee` object.

```java
Employee e1 = new Employee(101, "Ravi");
Employee e2 = new Employee(101, "Ravi");
```

These are:

- two separate objects in memory
- but logically same employee record

Then:

- `e1 == e2` → false
- `e1.equals(e2)` → should be true
- `e1.hashCode()` and `e2.hashCode()` → should be same

---

## 8. Default behavior without override

```java
class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
}

public class Demo {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Ravi");
        Employee e2 = new Employee(101, "Ravi");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
```

### Output idea

```java
false
false
12345678
87654321
```

Why?

Because:

- `==` compares reference
- `equals()` is not overridden, so it behaves like reference comparison
- `hashCode()` is default object hash code, so different objects get different values

---

## 9. Override `equals()` and `hashCode()`

```java
import java.util.Objects;

class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee other = (Employee) obj;
        return empId == other.empId && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }
}

public class Demo {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Ravi");
        Employee e2 = new Employee(101, "Ravi");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
```

### Output idea

```java
false
true
2453667
2453667
```

Now:

- `==` → false because objects are different
- `equals()` → true because data is same
- `hashCode()` → same because logically equal objects must have same hash code

---

## 10. When to use `==`

Use `==` when:

### For primitive values

```java
int a = 5;
int b = 5;
System.out.println(a == b);   // true
```

### For checking same object reference

```java
Employee e1 = new Employee(101, "Ravi");
Employee e2 = e1;

System.out.println(e1 == e2);   // true
```

Use `==` when you want to know:

**Are these exactly the same object?**

---

## 11. When to use `equals()`

Use `equals()` when you want to compare:

- object content
- business identity
- logical data equality

Examples:

- two `String` values
- two `Employee` objects with same employee ID
- two `Product` objects with same product code
- two `Student` objects with same roll number

### Example

```java
String city1 = new String("Chennai");
String city2 = new String("Chennai");

System.out.println(city1.equals(city2));   // true
```

---

## 12. When to use `hashCode()`

Normally, you do not call `hashCode()` directly for business comparison.

It is mainly used when your objects are stored in:

- `HashSet`
- `HashMap`
- `LinkedHashMap`
- `Hashtable`

You override it when you override `equals()`.

Because hash-based collections depend on both methods working correctly.

---

## 13. Real-world use case: Employee in `HashSet`

Imagine an HR system should not allow duplicate employees.

```java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return empId == other.empId && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();

        employees.add(new Employee(101, "Ravi"));
        employees.add(new Employee(101, "Ravi"));

        System.out.println("Total Employees: " + employees.size());
    }
}
```

### Output

```java
Total Employees: 1
```

Because:

- `HashSet` uses `hashCode()` first
- then uses `equals()` to confirm duplicate

---

## 14. What happens if `equals()` is overridden but `hashCode()` is not?

This is a common mistake.

```java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return empId == other.empId && Objects.equals(name, other.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();

        employees.add(new Employee(101, "Ravi"));
        employees.add(new Employee(101, "Ravi"));

        System.out.println(employees.size());
    }
}
```

This may lead to unexpected behavior because equal objects may go into different hash buckets.

**Rule:** If you override `equals()`, override `hashCode()` too.

---

## 15. Contract of `equals()`

A correct `equals()` method should follow these rules:

### Reflexive
An object must be equal to itself.

```java
x.equals(x) == true
```

### Symmetric
If `x.equals(y)` is true, then `y.equals(x)` must also be true.

### Transitive
If `x.equals(y)` and `y.equals(z)` are true, then `x.equals(z)` must also be true.

### Consistent
Repeated calls should give same result if the data does not change.

### Non-null
Any object compared with `null` should return false.

```java
x.equals(null) == false
```

---

## 16. Contract of `hashCode()`

### Rules

- Calling `hashCode()` multiple times should return the same result if the object state used in hashing does not change.
- If two objects are equal, they must return the same `hashCode()`.
- Two unequal objects may still have the same `hashCode()`; this is called a collision.

---

## 17. Similarities

### Similarities between `equals()` and `hashCode()`

- both come from `Object` class
- both are commonly overridden in custom classes
- both are used for object comparison logic
- both are important for collections
- both should be based on the same significant fields

For example, if employee identity depends on:

- `empId`
- `name`

then both methods should use the same fields.

---

## 18. Differences

### `==`
- operator
- compares primitive values or object references
- does not check logical content for objects

### `equals()`
- method
- compares logical/content equality
- can be overridden

### `hashCode()`
- method
- returns integer hash value
- mainly used by hash-based collections
- should be consistent with `equals()`

---

## 19. Comparison table

| Feature | `==` | `equals()` | `hashCode()` |
|---|---|---|---|
| Type | Operator | Method | Method |
| Main purpose | Compare references / primitive values | Compare logical equality | Generate hash value |
| Used for objects | Yes | Yes | Yes |
| Can be overridden | No | Yes | Yes |
| Checks content | No | Yes | Not directly |
| Return type | boolean | boolean | int |

---

## 20. Real-world use cases

### A. Student Management System
Two students with same roll number should be treated as same student.

Use:

- `equals()` based on roll number
- `hashCode()` based on roll number

### B. E-commerce Product Catalog
Two product objects representing the same product code should be treated as same.

Use:

- `equals()` for product code
- `hashCode()` for product code

### C. Banking
Two account objects with same account number represent the same bank account.

Use:

- `equals()` based on account number
- `hashCode()` based on account number

### D. Employee attendance system
To avoid duplicate employee entries in `HashSet`, implement both methods.

---

## 21. Best real-world example: Bank Account

```java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BankAccount)) return false;
        BankAccount other = (BankAccount) obj;
        return accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(1001, "Ravi", 5000);
        BankAccount a2 = new BankAccount(1001, "Ravi Kumar", 9000);

        System.out.println("Using ==      : " + (a1 == a2));
        System.out.println("Using equals(): " + a1.equals(a2));
        System.out.println("HashCode a1   : " + a1.hashCode());
        System.out.println("HashCode a2   : " + a2.hashCode());

        Set<BankAccount> accounts = new HashSet<>();
        accounts.add(a1);
        accounts.add(a2);

        System.out.println("Total unique accounts: " + accounts.size());
        System.out.println(accounts);
    }
}
```

### Explanation

Here business identity is **account number**, not holder name or balance.

So:

- if account number is same, accounts are logically same
- `HashSet` stores only one unique account

---

## 22. Important interview points

### Can two objects have same `hashCode()` and still not be equal?
Yes.

### Can two equal objects have different `hashCode()`?
No.

### If we override `equals()`, should we override `hashCode()`?
Yes, always.

---

## 23. Common mistakes

### Mistake 1: Using `==` to compare strings

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);   // false
```

Correct:

```java
System.out.println(a.equals(b));   // true
```

### Mistake 2: Overriding only `equals()`
This causes issues in `HashSet` and `HashMap`.

### Mistake 3: Using mutable fields in `hashCode()`
If the field changes after insertion into a `HashSet`, searching/removal may fail.

Prefer stable identity fields like:

- ID
- roll number
- account number
- email

---

## 24. When to choose which one

### Use `==`
- for primitives
- for enum comparison
- to check whether two references point to the same object
- to check against `null`

Example:

```java
if (obj == null)
```

### Use `equals()`
- for logical comparison of objects
- for comparing business data
- for strings, custom entities, DTOs, and models

### Use `hashCode()`
- when object is stored in hash-based collections
- when overriding `equals()`
- when building unique object identity for collections

---

## 25. Very short summary

### `==`
Same memory object?

### `equals()`
Same logical meaning / same content?

### `hashCode()`
Same bucket identity for hash-based collections

---

## 26. Easy memory trick

**`==` checks address, `equals()` checks meaning, `hashCode()` helps fast lookup.**

---

## 27. Mini example with `String`

```java
public class Demo {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println("s1 == s2        : " + (s1 == s2));
        System.out.println("s1.equals(s2)   : " + s1.equals(s2));
        System.out.println("s1.hashCode()   : " + s1.hashCode());
        System.out.println("s2.hashCode()   : " + s2.hashCode());
    }
}
```

### Output

```java
s1 == s2        : false
s1.equals(s2)   : true
s1.hashCode()   : 69609650
s2.hashCode()   : 69609650
```

---

## 28. Final conclusion

- **Equality** in Java means checking whether two things should be treated as the same.
- **`==`** checks whether two references point to the same object.
- **`equals()`** checks whether two objects are logically equal.
- **`hashCode()`** supports efficient storage and retrieval in hash-based collections.
- In custom classes, if you override **`equals()`**, you must also override **`hashCode()`**.
