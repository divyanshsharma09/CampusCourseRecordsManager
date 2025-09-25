# Course and Classroom Management (CCRM) System

## Table of Contents
1. [Project Overview & Setup](#project-overview--setup)
2. [Evolution of Java](#evolution-of-java)
3. [Java Platform Editions](#java-platform-editions)
4. [Java Architecture](#java-architecture)
5. [Windows & Eclipse Setup](#windows--eclipse-setup)
6. [Project Implementation Map](#project-implementation-map)
7. [Assertions Guide](#assertions-guide)

A comprehensive Java-based application for managing student enrollment, courses, and grades in an educational institution. Built with modern Java features and solid object-oriented design principles.

## Project Structure

```
ccrm-java-project/
├── data/               # CSV data files
├── screenshots/        # Application screenshots
└── src/               # Source code
    └── edu/
        └── ccrm/      # Main package
            ├── domain/     # Domain classes
            ├── service/    # Business logic
            ├── io/        # File operations
            ├── cli/       # User interface
            ├── config/    # Configuration
            ├── util/      # Utilities
            └── exception/ # Custom exceptions
```

## Features

### Core Functionality
- Student management (add, update, view, delete)
- Course management with capacity control
- Enrollment system with grade tracking
- Semester-based course offerings
- Comprehensive data validation

### Data Management
- CSV-based data persistence
- Automated backup system
- Import/Export functionality
- Data validation and error handling

### Technical Features
- Modern Java NIO.2 file operations
- Stream API for data processing
- Date/Time API for temporal operations
- Robust error handling and logging
- Configurable application settings

## Architecture

### Design Patterns
- Singleton Pattern (AppConfig)
- Builder Pattern (Course creation)
- Service Layer Pattern
- Data Access Object Pattern

### OOP Principles
- Inheritance (Person → Student/Instructor)
- Interface-based design
- Encapsulation of data and behavior
- Polymorphic service implementations

## Project Overview

### Introduction
The Campus Course & Records Manager (CCRM) is a comprehensive Java application designed for educational institutions to manage student enrollment, course offerings, and academic records. It demonstrates modern Java development practices and object-oriented principles.

### Key Features
- Student enrollment management
- Course catalog administration
- Grade tracking and GPA calculation
- Semester-based course scheduling
- Data persistence using CSV files
- Automated backup system

### Running the Application

#### Prerequisites
- JDK 17 or higher
- Read/Write permissions for data directory
- Command-line interface access (PowerShell or Command Prompt)

#### Building and Running the Project
1. Create the bin directory:
   ```powershell
   mkdir bin
   ```

2. Compile the source code (all Java files):
   ```powershell
   javac -d bin src\edu\ccrm\CCRMApp.java src\edu\ccrm\cli\*.java src\edu\ccrm\config\*.java src\edu\ccrm\domain\*.java src\edu\ccrm\exception\*.java src\edu\ccrm\io\*.java src\edu\ccrm\service\*.java src\edu\ccrm\util\*.java
   ```

3. Run the application:
   ```powershell
   java -cp bin edu.ccrm.CCRMApp
   ```

4. To clean the project (remove compiled files):
   ```powershell
   Remove-Item -Path bin -Recurse -Force
   ```

5. To run with assertions enabled:
   ```powershell
   java -ea -cp bin edu.ccrm.CCRMApp
   ```

#### Project Structure Explanation
- `src/edu/ccrm/`: Core package directory
  - `domain/`: Domain model classes (Student, Course, etc.)
  - `service/`: Business logic implementation
  - `cli/`: Command-line interface components
  - `io/`: Data persistence and file operations
  - `util/`: Utility classes and helpers

#### Startup Configuration
1. Ensure data directory exists:
   ```bash
   mkdir -p data
   ```

2. Default configuration is loaded from:
   ```
   src/edu/ccrm/config/app.properties
   ```

#### First-time Setup
1. Application will create necessary directories
2. Initial data files will be generated
3. Default admin credentials will be displayed

## Evolution of Java
- 1995: Java 1.0
  - First release by Sun Microsystems
  - "Write Once, Run Anywhere" principle
  - Basic OOP features and AWT

- 1998: Java 2 (1.2)
  - Introduction of the Java platform editions
  - J2SE, J2EE, and J2ME split
  - Swing GUI framework
  
- 2000: Java 1.3
  - HotSpot JVM included
  - Java Sound framework
  - JNDI included in core

- 2002: Java 1.4
  - Assert keyword
  - Regular expressions
  - Exception chaining
  - IPv6 support

- 2004: Java 5 (1.5)
  - Generics
  - Annotations
  - Enumerations
  - Enhanced for loop
  - Autoboxing/unboxing

- 2006: Java 6
  - Performance improvements
  - Scripting language support
  - JDBC 4.0
  - JAX-WS 2.0

- 2011: Java 7
  - Try-with-resources
  - Diamond operator
  - Multi-catch blocks
  - NIO.2 file API

- 2014: Java 8 (Major Release)
  - Lambda expressions
  - Stream API
  - Optional class
  - New Date/Time API
  - Default methods

- 2018: Java 11 (LTS)
  - Local variable type inference
  - HTTP client API
  - Single-file source code
  - Dynamic class-file constants

- 2021: Java 17 (LTS)
  - Sealed classes
  - Pattern matching for switch
  - Strong encapsulation of JDK internals
  - Context-specific deserialization filters

- 2023: Java 21 (LTS)
  - Virtual threads
  - Pattern matching for switch
  - Record patterns
  - Sequenced collections

### Java Platform Editions

#### Java ME (Micro Edition)
- **Purpose**: Embedded and mobile devices
- **Key Features**:
  - Minimal memory footprint
  - Optimized for limited resources
  - Subset of SE APIs
- **Use Cases**:
  - IoT devices
  - Mobile phones
  - Embedded systems
- **Specifications**:
  - Connected Limited Device Configuration (CLDC)
  - Connected Device Configuration (CDC)
  - Mobile Information Device Profile (MIDP)

#### Java SE (Standard Edition)
- **Purpose**: Core platform functionality
- **Key Features**:
  - Complete core Java APIs
  - Desktop and command-line capabilities
  - Base for other editions
- **Use Cases**:
  - Desktop applications (like this CCRM)
  - Command-line tools
  - Standard libraries
- **Core Components**:
  - Language fundamentals
  - Collections framework
  - I/O and NIO
  - Concurrency utilities
  - Security features

#### Java EE (Enterprise Edition)
- **Purpose**: Large-scale enterprise applications
- **Key Features**:
  - Built on top of SE
  - Enterprise-scale capabilities
  - Distributed computing
- **Use Cases**:
  - Web applications
  - Enterprise systems
  - Microservices
- **Technologies**:
  - Servlets and JSP
  - Enterprise JavaBeans (EJB)
  - Java Persistence API (JPA)
  - WebSocket and REST support
  - Dependency Injection

### Java Architecture

#### Component Hierarchy
```
┌─────────────────────────────────────────────┐
│                    JDK                      │
│ ┌─────────────────────────────────────────┐ │
│ │               Development               │ │
│ │               Tools (javac)             │ │
│ │ ┌─────────────────────────────────────┐ │ │
│ │ │              JRE                    │ │ │
│ │ │ ┌─────────────────────────────────┐ │ │ │
│ │ │ │             JVM                 │ │ │ │
│ │ │ │ - Bytecode Verifier             │ │ │ │
│ │ │ │ - Class Loader                  │ │ │ │
│ │ │ │ - Execution Engine              │ │ │ │
│ │ │ └─────────────────────────────────┘ │ │ │
│ │ │           Class Libraries           │ │ │
│ │ └─────────────────────────────────────┘ │ │
│ └─────────────────────────────────────────┘ │
└─────────────────────────────────────────────┘
```

#### JDK (Java Development Kit)
- **Purpose**: Complete development environment
- **Components**:
  - Development Tools
    - javac (compiler)
    - jar (archiver)
    - javadoc (documentation)
    - jdb (debugger)
  - JRE (for running applications)
  - API Documentation
  - Source Code

#### JRE (Java Runtime Environment)
- **Purpose**: Minimum environment to run Java applications
- **Components**:
  - Java Class Libraries
    - Core Classes
    - Extension Classes
    - Standard Libraries
  - JVM
  - Supporting Files

#### JVM (Java Virtual Machine)
- **Purpose**: Abstract computing machine providing platform independence
- **Key Components**:
  - Class Loader Subsystem
    - Loading
    - Linking
    - Initialization
  - Runtime Data Areas
    - Method Area
    - Heap
    - Stack
    - PC Registers
    - Native Method Stack
  - Execution Engine
    - Interpreter
    - JIT Compiler
    - Garbage Collector

#### Execution Flow
1. Java source code (.java) is compiled to bytecode (.class)
2. Class loader loads, links, and initializes the bytecode
3. Bytecode verifier ensures code safety
4. JVM executes the bytecode using:
   - Interpreter for immediate execution
   - JIT compiler for optimized performance
5. Garbage collector manages memory automatically

## Requirements

### Technical Requirements
- Java 17 or higher
- CSV file support
- Command-line interface
- Read/Write file system permissions

### Documentation Requirements
- Comprehensive Java platform documentation
- Detailed architectural explanations
- Evolution of Java documentation
- Platform comparison details
- Educational content for Java concepts

## Windows & Eclipse Setup

### Installing Java on Windows
1. Download JDK 17
   - Visit [Oracle's JDK download page](https://www.oracle.com/java/technologies/downloads/#java17)
   - Select Windows x64 Installer
   ![JDK Download](screenshots/jdk_download.png)

2. Run the Installer
   - Execute the downloaded installer
   - Follow installation wizard
   - Note the installation directory
   ![JDK Install](c:\skills\java\CCRM-Java-Project\screenshots\img.png)

3. Set JAVA_HOME
   - Open System Properties → Advanced → Environment Variables
   - Add new System Variable JAVA_HOME pointing to JDK installation
   ![Java Home](screenshots/java_home.png)

4. Update PATH
   - Edit System PATH variable
   - Add %JAVA_HOME%\\bin
   ![Path Setup](screenshots/path_setup.png)

5. Verify Installation
   ```cmd
   java --version
   javac --version
   ```

### Eclipse Setup
1. Download Eclipse
   - Visit [Eclipse Downloads](https://www.eclipse.org/downloads/)
   - Choose "Eclipse IDE for Java Developers"
   ![Eclipse Download](screenshots/eclipse_download.png)

2. Install Eclipse
   - Run Eclipse Installer
   - Select "Eclipse IDE for Java Developers"
   - Choose installation directory
   ![Eclipse Install](screenshots/eclipse_install.png)

3. Import CCRM Project
   - File → Import → Existing Java Project
   - Navigate to ccrm-java-project directory
   - Configure build path if needed
   ![Project Import](screenshots/project_import.png)

## Project Implementation Map

| Syllabus Topic | Implementation Location | Description |
|----------------|------------------------|-------------|
| Abstract Classes | `src/edu/ccrm/domain/Person.java` | Base class demonstrating abstraction |
| Inheritance | `src/edu/ccrm/domain/Student.java`<br>`src/edu/ccrm/domain/Instructor.java` | Extends Person class |
| Interfaces | `src/edu/ccrm/service/Persistable.java`<br>`src/edu/ccrm/service/Searchable.java` | Generic service contracts |
| Collections | `src/edu/ccrm/service/StudentServiceImpl.java` | ConcurrentHashMap usage |
| Stream API | `src/edu/ccrm/service/EnrollmentServiceImpl.java` | Data processing with streams |
| File I/O | `src/edu/ccrm/io/ImportExportService.java` | NIO.2 file operations |
| Exception Handling | `src/edu/ccrm/exception/` | Custom exceptions |
| Generics | `src/edu/ccrm/service/Persistable.java` | Generic type parameters |
| Lambda Expressions | `src/edu/ccrm/util/CourseComparator.java` | Functional interfaces |
| Date/Time API | `src/edu/ccrm/util/DateTimeUtil.java` | Modern date operations |

## Assertions Guide

### Enabling Assertions
1. Command-line:
   ```cmd
   java -ea -cp bin edu.ccrm.CCRMApp
   ```

2. Eclipse:
   - Right-click project → Run As → Run Configurations
   - Arguments tab → VM arguments: `-ea`

### Sample Assertion Usage
```java
// Validate student registration
public void enrollStudent(Student student, Course course) {
    // Pre-conditions
    assert student != null : "Student cannot be null";
    assert course != null : "Course cannot be null";
    assert student.isActive() : "Student must be active";
    
    // Process enrollment
    // ...
    
    // Post-conditions
    assert student.getEnrolledCourses().contains(course) : "Enrollment failed";
}
```

### Key Assertion Locations
- Domain object validation
- Service layer pre/post conditions
- Data integrity checks
- Business rule enforcement

### Running with Assertions
```cmd
# Run specific test with assertions
java -ea -cp bin edu.ccrm.test.EnrollmentTest

# Run all tests with assertions
java -ea -cp bin edu.ccrm.test.TestSuite

# Run main application with assertions
java -ea -cp bin edu.ccrm.CCRMApp
```
- CSV file support
- Command-line interface
- Read/Write file system permissions

## Quick Setup

1. Install JDK 17 or higher
2. Open PowerShell in the project directory
3. Create bin directory and compile:
   ```powershell
   mkdir bin
   javac -d bin src\edu\ccrm\CCRMApp.java src\edu\ccrm\cli\*.java src\edu\ccrm\config\*.java src\edu\ccrm\domain\*.java src\edu\ccrm\exception\*.java src\edu\ccrm\io\*.java src\edu\ccrm\service\*.java src\edu\ccrm\util\*.java
   ```
4. Run the application:
   ```powershell
   java -cp bin edu.ccrm.CCRMApp
   ```

See [USAGE.md](USAGE.md) for detailed operation instructions.

