# Map Interface in Java with Real-World Use Cases

**Project: Java FS**

Below is a detailed explanation of the **Map interface in Java**, its implementations, major built-in functions, and real-world use cases.

# 1. What is Map in Java?

`Map` in Java is a data structure used to store data in the form of:

- **key**
- **value**

That means every value is stored with a unique key.

## Syntax idea

```java
key -> value
```

## Example

```java
101 -> "Arun"
102 -> "Meena"
103 -> "Karthik"
```

Here:

- `101`, `102`, `103` are keys
- `"Arun"`, `"Meena"`, `"Karthik"` are values

---

# 2. Important point about Map

A `Map` is **not part of Collection interface directly**, but it is part of the Java Collections Framework.

## Main characteristics of Map

- stores data as **key-value pairs**
- **keys must be unique**
- values can be duplicated
- each key maps to only one value
- used for fast searching based on key

---

# 3. Real-world meaning of Map

Think about these real-world examples:

- **Employee ID → Employee Name**
- **Product Code → Product Price**
- **Username → Password**
- **Country Code → Country Name**
- **Student Roll Number → Marks**
- **Order ID → Order Details**

In all these cases, one unique key identifies one value.

So `Map` is very useful.

---

# 4. Why Map is used

Use `Map` when:

- you want to retrieve data using a unique key
- you want fast lookup
- you want to avoid duplicate keys
- your data naturally fits key-value format

---

# 5. Hierarchy of Map

Common implementations of `Map` are:

- `HashMap`
- `LinkedHashMap`
- `TreeMap`
- `Hashtable`

Also commonly used:
- `ConcurrentHashMap`

---

# 6. Main implementations of Map

## 1. HashMap
- unordered
- allows one null key
- allows multiple null values
- fast performance

## 2. LinkedHashMap
- maintains insertion order
- allows one null key
- allows multiple null values

## 3. TreeMap
- stores data in sorted order by key
- does not allow null key
- allows null values

## 4. Hashtable
- synchronized
- thread-safe in old style
- does not allow null key or null value

---

# 7. Real-world use case for each implementation

## HashMap use case
**Employee ID → Employee Name**

When order is not important, but fast lookup is needed.

## LinkedHashMap use case
**Recently added products in e-commerce admin panel**

When insertion order should be maintained.

## TreeMap use case
**Student marks report sorted by roll number**

When sorted output is needed.

## Hashtable use case
Legacy applications where synchronized map is required.

---

# 8. Basic example of Map

```java
import java.util.HashMap;
import java.util.Map;

public class MapBasicExample {
    public static void main(String[] args) {
        Map<Integer, String> employees = new HashMap<>();

        employees.put(101, "Arun");
        employees.put(102, "Meena");
        employees.put(103, "Karthik");

        System.out.println(employees);
    }
}
```

## Output

```java
{101=Arun, 102=Meena, 103=Karthik}
```

---

# 9. Important built-in methods of Map

The `Map` interface provides many useful methods.

Main methods are:

1. `put()`
2. `get()`
3. `remove()`
4. `containsKey()`
5. `containsValue()`
6. `isEmpty()`
7. `size()`
8. `clear()`
9. `keySet()`
10. `values()`
11. `entrySet()`
12. `putIfAbsent()`
13. `replace()`
14. `replaceAll()`
15. `getOrDefault()`
16. `forEach()`
17. `compute()`
18. `computeIfAbsent()`
19. `computeIfPresent()`
20. `merge()`

Now let us understand them one by one with real use case.

---

# 10. `put()`

## What it does
Adds a key-value pair into the map.

## Real-world use case
Store employee id and employee name.

```java
import java.util.HashMap;

public class PutExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Arun");
        employeeMap.put(102, "Meena");
        employeeMap.put(103, "Karthik");

        System.out.println(employeeMap);
    }
}
```

---

# 11. `get()`

## What it does
Returns the value for the given key.

## Real-world use case
Find employee name by employee id.

```java
import java.util.HashMap;

public class GetExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Arun");
        employeeMap.put(102, "Meena");

        System.out.println(employeeMap.get(101));
    }
}
```

## Output

```java
Arun
```

---

# 12. `remove()`

## What it does
Removes an entry based on key.

## Real-world use case
Remove cancelled order from system.

```java
import java.util.HashMap;

public class RemoveExample {
    public static void main(String[] args) {
        HashMap<Integer, String> orders = new HashMap<>();

        orders.put(1001, "Laptop");
        orders.put(1002, "Mouse");

        orders.remove(1002);

        System.out.println(orders);
    }
}
```

---

# 13. `containsKey()`

## What it does
Checks whether a key is present.

## Real-world use case
Check whether student roll number exists.

```java
import java.util.HashMap;

public class ContainsKeyExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        students.put(1, "Divya");
        students.put(2, "Rahul");

        System.out.println(students.containsKey(2));
    }
}
```

---

# 14. `containsValue()`

## What it does
Checks whether a value exists.

## Real-world use case
Check whether a product category already exists.

```java
import java.util.HashMap;

public class ContainsValueExample {
    public static void main(String[] args) {
        HashMap<Integer, String> products = new HashMap<>();

        products.put(1, "Mobile");
        products.put(2, "Laptop");

        System.out.println(products.containsValue("Laptop"));
    }
}
```

---

# 15. `size()`

## What it does
Returns the number of key-value pairs.

## Real-world use case
Count how many users are registered.

```java
import java.util.HashMap;

public class SizeExample {
    public static void main(String[] args) {
        HashMap<Integer, String> users = new HashMap<>();

        users.put(1, "A");
        users.put(2, "B");
        users.put(3, "C");

        System.out.println("Total Users: " + users.size());
    }
}
```

---

# 16. `isEmpty()`

## What it does
Checks whether map is empty.

## Real-world use case
Check if cart has any products.

```java
import java.util.HashMap;

public class IsEmptyExample {
    public static void main(String[] args) {
        HashMap<Integer, String> cart = new HashMap<>();

        System.out.println(cart.isEmpty());
    }
}
```

---

# 17. `clear()`

## What it does
Removes all entries from map.

## Real-world use case
Clear session data after logout.

```java
import java.util.HashMap;

public class ClearExample {
    public static void main(String[] args) {
        HashMap<Integer, String> sessionMap = new HashMap<>();

        sessionMap.put(1, "User1");
        sessionMap.put(2, "User2");

        sessionMap.clear();

        System.out.println(sessionMap);
    }
}
```

---

# 18. `keySet()`

## What it does
Returns all keys.

## Real-world use case
Get all product ids.

```java
import java.util.HashMap;
import java.util.Set;

public class KeySetExample {
    public static void main(String[] args) {
        HashMap<Integer, String> products = new HashMap<>();

        products.put(101, "Laptop");
        products.put(102, "Keyboard");
        products.put(103, "Mouse");

        Set<Integer> keys = products.keySet();

        System.out.println(keys);
    }
}
```

---

# 19. `values()`

## What it does
Returns all values.

## Real-world use case
Get all customer names.

```java
import java.util.HashMap;
import java.util.Collection;

public class ValuesExample {
    public static void main(String[] args) {
        HashMap<Integer, String> customers = new HashMap<>();

        customers.put(1, "Arun");
        customers.put(2, "Meena");
        customers.put(3, "Divya");

        Collection<String> values = customers.values();

        System.out.println(values);
    }
}
```

---

# 20. `entrySet()`

## What it does
Returns all key-value pairs as set.

## Real-world use case
Display full employee record mapping.

```java
import java.util.HashMap;
import java.util.Map;

public class EntrySetExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Arun");
        employeeMap.put(102, "Meena");

        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
```

---

# 21. `putIfAbsent()`

## What it does
Adds entry only if key is not already present.

## Real-world use case
Register user only if username is not already taken.

```java
import java.util.HashMap;

public class PutIfAbsentExample {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();

        users.put("gopi", "Admin");
        users.putIfAbsent("gopi", "Trainer");
        users.putIfAbsent("divya", "Student");

        System.out.println(users);
    }
}
```

---

# 22. `replace()`

## What it does
Replaces value of existing key.

## Real-world use case
Update employee department.

```java
import java.util.HashMap;

public class ReplaceExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeDept = new HashMap<>();

        employeeDept.put(101, "Testing");
        employeeDept.replace(101, "Java Development");

        System.out.println(employeeDept);
    }
}
```

---

# 23. `getOrDefault()`

## What it does
Returns value if key exists, otherwise returns default value.

## Real-world use case
Find product price; if not available, return 0.

```java
import java.util.HashMap;

public class GetOrDefaultExample {
    public static void main(String[] args) {
        HashMap<Integer, Integer> productPrice = new HashMap<>();

        productPrice.put(101, 25000);
        productPrice.put(102, 1500);

        System.out.println(productPrice.getOrDefault(103, 0));
    }
}
```

---

# 24. `forEach()`

## What it does
Iterates through all entries.

## Real-world use case
Display all attendance records.

```java
import java.util.HashMap;

public class ForEachExample {
    public static void main(String[] args) {
        HashMap<Integer, String> attendance = new HashMap<>();

        attendance.put(1, "Present");
        attendance.put(2, "Absent");
        attendance.put(3, "Present");

        attendance.forEach((id, status) ->
            System.out.println("Student ID: " + id + " Status: " + status));
    }
}
```

---

# 25. `computeIfAbsent()`

## What it does
Computes value only if key is absent.

## Real-world use case
Create shopping cart for a customer only if cart does not already exist.

```java
import java.util.HashMap;

public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        HashMap<Integer, String> cartMap = new HashMap<>();

        cartMap.computeIfAbsent(101, k -> "New Cart Created");
        cartMap.computeIfAbsent(101, k -> "Another Cart");

        System.out.println(cartMap);
    }
}
```

---

# 26. `computeIfPresent()`

## What it does
Updates value only if key exists.

## Real-world use case
Update order status only if order already exists.

```java
import java.util.HashMap;

public class ComputeIfPresentExample {
    public static void main(String[] args) {
        HashMap<Integer, String> orderMap = new HashMap<>();

        orderMap.put(5001, "Placed");

        orderMap.computeIfPresent(5001, (k, v) -> "Shipped");

        System.out.println(orderMap);
    }
}
```

---

# 27. `merge()`

## What it does
Merges old and new value.

## Real-world use case
Count product sales quantity.

```java
import java.util.HashMap;

public class MergeExample {
    public static void main(String[] args) {
        HashMap<String, Integer> sales = new HashMap<>();

        sales.put("Laptop", 2);
        sales.merge("Laptop", 1, Integer::sum);
        sales.merge("Mouse", 1, Integer::sum);

        System.out.println(sales);
    }
}
```

---

# 28. HashMap explained with real use case

## Real-world scenario
Store **Employee ID → Employee Name**

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Arun");
        employeeMap.put(102, "Meena");
        employeeMap.put(103, "Karthik");
        employeeMap.put(104, "Divya");

        System.out.println("Employee 102: " + employeeMap.get(102));
        System.out.println("All Employees: " + employeeMap);
    }
}
```

## Characteristics
- no guaranteed order
- fast insertion and retrieval
- good for general purpose use

---

# 29. LinkedHashMap explained with real use case

## Real-world scenario
Store **recently added courses** in insertion order.

```java
import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> courseMap = new LinkedHashMap<>();

        courseMap.put(1, "Java");
        courseMap.put(2, "Python");
        courseMap.put(3, "AWS");
        courseMap.put(4, "Azure");

        System.out.println(courseMap);
    }
}
```

## Characteristics
- maintains insertion order
- useful when display order matters

---

# 30. TreeMap explained with real use case

## Real-world scenario
Store **Student Roll Number → Student Name** in sorted order.

```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> studentMap = new TreeMap<>();

        studentMap.put(105, "Arun");
        studentMap.put(101, "Meena");
        studentMap.put(103, "Divya");
        studentMap.put(102, "Rahul");

        System.out.println(studentMap);
    }
}
```

## Output
Keys will come in sorted order.

## Characteristics
- sorted by key
- slower than HashMap
- useful when ordered output is required

---

# 31. Hashtable explained with real use case

## Real-world scenario
Legacy application storing config key-value pairs.

```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<String, String> config = new Hashtable<>();

        config.put("url", "localhost");
        config.put("port", "8080");
        config.put("mode", "production");

        System.out.println(config);
    }
}
```

## Characteristics
- synchronized
- no null key
- no null value
- legacy class

---

# 32. Difference between Map implementations

| Implementation | Order | Null Key | Null Values | Thread Safe | Sorting |
|---|---|---|---|---|---|
| HashMap | No order | One allowed | Allowed | No | No |
| LinkedHashMap | Insertion order | One allowed | Allowed | No | No |
| TreeMap | Sorted by key | Not allowed | Allowed | No | Yes |
| Hashtable | No guaranteed order | Not allowed | Not allowed | Yes | No |

---

# 33. Real-world full example using Map

## Scenario
A college wants to store:

- Student Roll Number → Student Name

and perform:
- add student
- search student
- remove student
- display all students
- check whether student exists

```java
import java.util.HashMap;
import java.util.Map;

public class StudentManagementMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> studentMap = new HashMap<>();

        // add students
        studentMap.put(101, "Arun");
        studentMap.put(102, "Meena");
        studentMap.put(103, "Divya");

        // display all students
        System.out.println("All Students: " + studentMap);

        // search by roll number
        System.out.println("Student with roll no 102: " + studentMap.get(102));

        // check existence
        System.out.println("Contains roll no 103? " + studentMap.containsKey(103));

        // remove student
        studentMap.remove(101);

        // size
        System.out.println("Total Students: " + studentMap.size());

        // iterate
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
```

---

# 34. Iterating Map in different ways

## Using `keySet()`

```java
import java.util.HashMap;

public class KeySetLoopExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");

        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
```

## Using `entrySet()`

```java
import java.util.HashMap;
import java.util.Map;

public class EntrySetLoopExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

## Using `forEach()`

```java
import java.util.HashMap;

public class ForEachLoopExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
```

---

# 35. Important rules of Map

1. Keys must be unique
2. Values can be duplicated
3. One key can have only one value
4. If same key is inserted again, old value gets replaced
5. Map is best when searching by key

---

# 36. What happens if duplicate key is added?

```java
import java.util.HashMap;

public class DuplicateKeyExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(101, "Arun");
        map.put(101, "Meena");

        System.out.println(map);
    }
}
```

## Output

```java
{101=Meena}
```

Because duplicate key replaces old value.

---

# 37. When to choose which Map?

## Use `HashMap`
When order does not matter and you want fast performance.

### Example
Employee ID → Employee Name

## Use `LinkedHashMap`
When insertion order matters.

### Example
Recent search history

## Use `TreeMap`
When sorted order is needed.

### Example
Rank list, sorted report

## Use `Hashtable`
Only if working with old legacy code requiring synchronized map

---

# 38. Interview-friendly definition

**Map interface in Java is used to store data in key-value pair format where each key is unique and maps to exactly one value. It is used when fast retrieval, update, and management of data based on unique keys is needed. Common implementations are HashMap, LinkedHashMap, TreeMap, and Hashtable.**

---

# 39. Full built-in methods summary

| Method | Purpose |
|---|---|
| `put(k,v)` | add key-value |
| `get(k)` | get value by key |
| `remove(k)` | remove by key |
| `containsKey(k)` | check key exists |
| `containsValue(v)` | check value exists |
| `size()` | number of entries |
| `isEmpty()` | check empty |
| `clear()` | remove all |
| `keySet()` | get all keys |
| `values()` | get all values |
| `entrySet()` | get all entries |
| `putIfAbsent()` | add only if key absent |
| `replace()` | replace value |
| `getOrDefault()` | return default if key absent |
| `forEach()` | iterate entries |
| `computeIfAbsent()` | compute if missing |
| `computeIfPresent()` | compute if existing |
| `merge()` | merge values |

---

# 40. Final conclusion

The `Map` interface is one of the most important parts of Java programming because many real-world applications naturally use key-value data.

Examples include:

- employee management
- product catalog
- login system
- order tracking
- configuration settings
- student records
- inventory mapping

So whenever your data looks like:

```java
unique key -> related value
```

you should think of using `Map`.
