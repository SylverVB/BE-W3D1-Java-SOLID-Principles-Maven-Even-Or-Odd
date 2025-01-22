# SOLID Design Principles

The SOLID principles are best practices you should follow when you are working with any OOP language.

SOLID is an acronym to remember what the principles are:

- **Single Responsibility Principle (SRP)**
- **Open/Closed Principle (OCP)**
- **Liskov Substitution Principle (LSP)**
- **Interface Segregation Principle (ISP)**
- **Dependency Inversion Principle (DIP)**

---

## 1. S - Single Responsibility Principle (SRP)

**Definition**: A class should have only one reason to change. This means a class should do only one job.

**Analogy**:  
Imagine a kitchen appliance. A toaster toasts bread, and a coffee machine makes coffee. If you combine both into one device and one part breaks, you lose both functionalities.

### Wrong Example:

```java
class Report {
    public void generateReport() {
        // Code to generate report
    }

    public void printReport() {
        // Code to print report
    }

    public void saveToDatabase() {
        // Code to save report to database
    }
}
```

**Problem**: This class does too many things — generating, printing, and saving a report. If the printing logic changes, the whole class needs modification.

### Correct Example:

```java
class ReportGenerator {
    public void generateReport() {
        // Code to generate report
    }
}

class ReportPrinter {
    public void printReport() {
        // Code to print report
    }
}

class ReportSaver {
    public void saveToDatabase() {
        // Code to save report to database
    }
}
```

**Explanation**: Each class now has a single responsibility. If printing logic changes, you only modify the `ReportPrinter` class.

---

## 2. O - Open/Closed Principle (OCP)

**Definition**: A class should be open for extension but closed for modification. You should be able to add new functionality without changing existing code.

**Analogy**:  
Think of a power strip. You can plug in new devices (extend it) without rebuilding the strip itself.

### Wrong Example:

```java
class NotificationService {
    public void sendNotification(String type) {
        if (type.equals("email")) {
            System.out.println("Send Email");
        } else if (type.equals("sms")) {
            System.out.println("Send SMS");
        }
    }
}
```

**Problem**: If you want to add a new notification type, like push notification, you must modify the method. This breaks the Open/Closed Principle.

### Correct Example:

```java
interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() {
        System.out.println("Send Email");
    }
}

class SMSNotification implements Notification {
    public void send() {
        System.out.println("Send SMS");
    }
}

class NotificationService {
    public void sendNotification(Notification notification) {
        notification.send();
    }
}
```

**Explanation**: You can add new types of notifications (e.g., `PushNotification`) without modifying the existing `NotificationService` class.

---

## 3. L - Liskov Substitution Principle (LSP)

**Definition**: Subclasses should replace their parent class without breaking functionality.

**Analogy**:  
Imagine a bird. Most birds can fly. If you create a `Penguin` class as a subtype of `Bird` and give it the ability to fly, it’s misleading because penguins don’t fly.

### Wrong Example:

```java
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

**Problem**: The `Penguin` class violates the behavior of `Bird`. A program expecting all `Bird` objects to fly will break.

### Correct Example:

```java
abstract class Bird {
    abstract void move();
}

class Sparrow extends Bird {
    public void move() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    public void move() {
        System.out.println("Penguin is walking");
    }
}
```

**Explanation**: Now, we define a generic `move` method. `Sparrow` flies and `Penguin` walks. Both can substitute the parent class without breaking behavior.

---

## 4. I - Interface Segregation Principle (ISP)

**Definition**: Don’t force classes to implement methods they don’t use. Create smaller, specific interfaces.

**Analogy**:  
Think of a restaurant menu. If you force everyone to order from a single menu with pizza, sushi, and burgers, not all chefs will prepare everything. It’s better to have separate menus for Italian, Japanese, and fast food.

### Wrong Example:

```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        // Robots don't eat, but must implement this method
        throw new UnsupportedOperationException("Robots don't eat");
    }
}
```

**Problem**: The `Robot` class is forced to implement `eat()` even though robots don’t eat.

### Correct Example:

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot working");
    }
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }
}
```

**Explanation**: The interfaces are split. `Robot` only implements what it needs (`Workable`), while `Human` implements both.

---

## 5. D - Dependency Inversion Principle (DIP)

**Definition**: High-level modules should depend on abstractions, not concrete implementations.

**Analogy**:  
Think of a light switch. You can plug it into any type of bulb (LED, CFL) as long as the switch depends on an interface for bulbs, not a specific type.

### Wrong Example:

```java
class LightBulb {
    void turnOn() {
        System.out.println("Light bulb on");
    }
}

class Switch {
    LightBulb bulb = new LightBulb();

    void operate() {
        bulb.turnOn();
    }
}
```

**Problem**: The `Switch` class directly depends on `LightBulb`. To change the bulb type, you need to modify the `Switch` class.

### Correct Example:

```java
interface Bulb {
    void turnOn();
}

class LightBulb implements Bulb {
    public void turnOn() {
        System.out.println("Light bulb on");
    }
}

class Switch {
    private Bulb bulb;

    public Switch(Bulb bulb) {
        this.bulb = bulb;
    }

    void operate() {
        bulb.turnOn();
    }
}
```

**Explanation**: `Switch` depends on the `Bulb` interface, not a specific implementation. You can plug in any bulb type (e.g., `LEDLightBulb`) without changing the `Switch` class.

---

## Summary Table:

| Principle                   | Problem                             | Solution                         |
|-----------------------------|-------------------------------------|----------------------------------|
| **SRP** (Single Responsibility) | A class does too many things.      | Split it into smaller classes.   |
| **OCP** (Open/Closed)        | Code needs frequent modification.   | Use abstractions to extend code. |
| **LSP** (Liskov Substitution) | Subclasses break behavior.          | Subclasses follow parent behavior. |
| **ISP** (Interface Segregation) | Class implements unused methods.    | Create smaller interfaces.      |
| **DIP** (Dependency Inversion) | High-level code depends on details. | Depend on abstractions.         |

---

By following these principles, your code will be more maintainable, scalable, and easier to understand!