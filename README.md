# EMI Calculator - Desktop Application (Java Swing)

A clean, modern, and user-friendly Equated Monthly Installment (EMI) Calculator desktop application built using **Java Swing** and **AWT** for college academic projects and lab examinations.

---

## 📌 Project Overview
This application allows users to quickly calculate their monthly loan repayment amount (EMI), total interest payable, and overall total payment based on:
1. **Loan Amount (₹)**
2. **Annual Interest Rate (%)**
3. **Loan Tenure (Years)**

The project is designed to strictly satisfy academic syllabus requirements for Object-Oriented Programming with Java, GUI development, and Event-Driven Programming.

---

## 🎨 UI & Design Features
* **Modern Color Palette**: Professional Deep Navy Blue header, soft off-white background, and high-contrast readable cards.
* **Responsive Card Layout**: Clean visual separation between User Inputs and Output Results.
* **Formatted Currency**: Results formatted with Indian Rupee symbol (`₹`) and two decimal places (e.g., `₹ 24,320.50`).
* **Input Validation & Alerts**: Informative popup dialogs (`JOptionPane`) for missing or invalid values.
* **One-Click Reset**: Resets all fields and brings focus back to the first input.

---

## 🎓 Java Syllabus Topics Demonstrated

| Syllabus Concept | How it is used in the code |
| :--- | :--- |
| **AWT & Swing Basics** | Inherits from `javax.swing.JFrame` and imports AWT/Swing packages. |
| **Top-Level Container** | `JFrame` with configured title, size, close operation, and position. |
| **Containers & Panels** | Multiple `JPanel` instances acting as layout sections (Header, Inputs Card, Buttons, Results Card, Footer). |
| **GUI Controls / Widgets** | `JLabel` (text display), `JTextField` (user inputs), and `JButton` (actions). |
| **Layout Managers** | `BorderLayout` (main frame), `GridLayout` (input and result grids), `FlowLayout` (buttons and footer), and `BoxLayout` (vertical stacking). |
| **Event Handling** | Implements `java.awt.event.ActionListener` and handles button click events in `actionPerformed(ActionEvent e)`. |
| **Dialog Boxes** | `JOptionPane.showMessageDialog()` for validation warnings and error notifications. |
| **Thread Safety** | Uses `SwingUtilities.invokeLater()` to launch the GUI on the Event Dispatch Thread (EDT). |

---

## 🧮 EMI Calculation Formula

The standard mathematical formula used for calculating EMI is:

$$\text{EMI} = \frac{P \times r \times (1 + r)^n}{(1 + r)^n - 1}$$

Where:
* **$P$** = Principal Loan Amount
* **$r$** = Monthly Interest Rate $= \frac{\text{Annual Interest Rate}}{12 \times 100}$
* **$n$** = Loan Tenure in Months $= \text{Tenure in Years} \times 12$

### Associated Calculations:
* **Total Payment** $= \text{EMI} \times n$
* **Total Interest** $= \text{Total Payment} - P$

> **Edge Case Handled:** If the interest rate is 0%, $\text{EMI} = \frac{P}{n}$, $\text{Total Payment} = P$, and $\text{Total Interest} = 0.00$.

---

## 🧪 Sample Test Case
To verify calculations during lab evaluation:

| Input Field | Test Value |
| :--- | :--- |
| **Loan Amount (₹)** | `1000000` (10 Lakhs) |
| **Annual Interest Rate (%)** | `8.5` |
| **Loan Tenure (Years)** | `5` |

**Expected Output:**
* **Monthly EMI:** `₹ 20,516.53`
* **Total Interest:** `₹ 2,30,991.54`
* **Total Payment:** `₹ 12,30,991.54`

---

## 🚀 How to Run the Application

### Method 1: Using Command Line (Terminal / Command Prompt)

1. Ensure JDK (Java Development Kit) version 8 or higher is installed.
2. Open your command line and navigate to the project directory:
   ```bash
   cd "C:\Users\Admin\.gemini\antigravity\scratch\EMICalculator"
   ```
3. Compile the Java file:
   ```bash
   javac EMICalculator.java
   ```
4. Run the program:
   ```bash
   java EMICalculator
   ```

---

### Method 2: In IDEs (VS Code, Eclipse, IntelliJ, NetBeans)

* **IntelliJ IDEA**: Open the `EMICalculator` folder, right-click `EMICalculator.java`, and select **Run 'EMICalculator.main()'**.
* **Eclipse**: Create a New Java Project, drop `EMICalculator.java` into `src`, right-click and choose **Run As > Java Application**.
* **VS Code**: Open folder, install the "Extension Pack for Java", open `EMICalculator.java` and click the **Run** button at the top right.
* **NetBeans**: Open or create a project, paste `EMICalculator.java`, and press `Shift + F6` to run the file.

---

## 💬 Viva / Oral Examination Questions & Answers

1. **Q: Why use `SwingUtilities.invokeLater()` in `main()`?**
   * *A:* Swing GUI components are not thread-safe. `SwingUtilities.invokeLater()` schedules the initialization code on the Event Dispatch Thread (EDT) to prevent thread concurrency issues.

2. **Q: How does `ActionListener` work here?**
   * *A:* The class implements the `ActionListener` interface. Both buttons register the current object using `addActionListener(this)`. When a button is clicked, the `actionPerformed(ActionEvent e)` callback is triggered, where `e.getSource()` checks which button was clicked.

3. **Q: What is the purpose of `BorderLayout` and `GridLayout` in this UI?**
   * *A:* `BorderLayout` divides the window into 5 regions (North, South, East, West, Center) to arrange the header, center content, and footer. `GridLayout` arranges labels and text fields into structured rows and columns.

4. **Q: How are non-numeric inputs handled?**
   * *A:* `Double.parseDouble()` is wrapped in a `try-catch` block that catches `NumberFormatException`. If the user types characters or leaves values malformed, a `JOptionPane` error dialog is displayed.
