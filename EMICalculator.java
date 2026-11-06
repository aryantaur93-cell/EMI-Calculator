import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * ============================================================================
 * College Project: EMI Calculator Desktop Application
 * Developed using: Java Swing & AWT
 * 
 * Features Demonstrated:
 * 1. GUI Components: JFrame, JPanel, JLabel, JTextField, JButton
 * 2. Layout Managers: BorderLayout, GridLayout, FlowLayout
 * 3. Event Handling: ActionListener interface implementation
 * 4. Dialog Boxes: JOptionPane for input validation error messages
 * 5. Mathematical computation of Equated Monthly Installment (EMI)
 * ============================================================================
 */
public class EMICalculator extends JFrame implements ActionListener {

    // --- GUI Components Declaration ---
    // Text fields for user input
    private JTextField txtLoanAmount;
    private JTextField txtInterestRate;
    private JTextField txtTenure;

    // Action buttons
    private JButton btnCalculate;
    private JButton btnReset;

    // Result labels for output display
    private JLabel lblMonthlyEMI;
    private JLabel lblTotalInterest;
    private JLabel lblTotalPayment;

    // Formatter for currency and two-decimal output
    private final DecimalFormat currencyFormat = new DecimalFormat("₹ #,##,##0.00");

    /**
     * Constructor: Initializes and sets up the GUI components, layout, and event listeners.
     */
    public EMICalculator() {
        // Step 1: Set up the main window (JFrame) properties
        setTitle("EMI Calculator");
        setSize(480, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window on screen
        setResizable(false);          // Keep fixed, neat layout
        setLayout(new BorderLayout()); // Root layout manager

        // Define a clean, modern color palette
        Color primaryBlue    = new Color(30, 58, 138);  // Navy Blue (#1E3A8A)
        Color accentBlue     = new Color(37, 99, 235);  // Royal Blue (#2563EB)
        Color resetRed       = new Color(220, 38, 38);  // Soft Red (#DC2626)
        Color backgroundColor= new Color(248, 250, 252);// Off-white background
        Color cardColor      = Color.WHITE;
        Color textDark       = new Color(15, 23, 42);   // Slate Dark
        Color textMuted      = new Color(100, 116, 139); // Slate Muted
        Color borderSubtle   = new Color(226, 232, 240); // Soft grey border

        // Step 2: Create Header Panel (North)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(primaryBlue);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("EMI Calculator");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Plan your loan repayment easily");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSubtitle.setForeground(new Color(219, 234, 254)); // Soft light blue
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(lblTitle);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(lblSubtitle);
        add(headerPanel, BorderLayout.NORTH);

        // Step 3: Create Main Container Panel (Center)
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(backgroundColor);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(20, 25, 20, 25));

        // --- SECTION A: Inputs Card ---
        JPanel inputCard = new JPanel(new GridLayout(3, 2, 10, 14));
        inputCard.setBackground(cardColor);
        inputCard.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderSubtle, 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);

        // 1. Loan Amount
        JLabel lblLoan = new JLabel("Loan Amount (₹):");
        lblLoan.setFont(labelFont);
        lblLoan.setForeground(textDark);
        txtLoanAmount = new JTextField();
        txtLoanAmount.setFont(inputFont);

        // 2. Interest Rate
        JLabel lblRate = new JLabel("Annual Interest Rate (%):");
        lblRate.setFont(labelFont);
        lblRate.setForeground(textDark);
        txtInterestRate = new JTextField();
        txtInterestRate.setFont(inputFont);

        // 3. Loan Tenure
        JLabel lblTenure = new JLabel("Loan Tenure (Years):");
        lblTenure.setFont(labelFont);
        lblTenure.setForeground(textDark);
        txtTenure = new JTextField();
        txtTenure.setFont(inputFont);

        // Add components to Input Card
        inputCard.add(lblLoan);
        inputCard.add(txtLoanAmount);
        inputCard.add(lblRate);
        inputCard.add(txtInterestRate);
        inputCard.add(lblTenure);
        inputCard.add(txtTenure);

        centerPanel.add(inputCard);
        centerPanel.add(Box.createVerticalStrut(15));

        // --- SECTION B: Buttons Panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        btnCalculate = new JButton("Calculate EMI");
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCalculate.setBackground(accentBlue);
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFocusPainted(false);
        btnCalculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalculate.setPreferredSize(new Dimension(150, 38));
        btnCalculate.addActionListener(this); // Register ActionListener

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setBackground(resetRed);
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.setPreferredSize(new Dimension(110, 38));
        btnReset.addActionListener(this); // Register ActionListener

        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnReset);

        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(15));

        // --- SECTION C: Results Output Card ---
        JPanel resultCard = new JPanel(new GridLayout(3, 2, 10, 12));
        resultCard.setBackground(new Color(239, 246, 255)); // Soft subtle blue tint (#EFF6FF)
        resultCard.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(191, 219, 254), 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));

        Font resTitleFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font resValueFont = new Font("Segoe UI", Font.BOLD, 14);

        // Result 1: Monthly EMI (Highlighted)
        JLabel lblEMITitle = new JLabel("Monthly EMI:");
        lblEMITitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblEMITitle.setForeground(primaryBlue);

        lblMonthlyEMI = new JLabel("₹ 0.00");
        lblMonthlyEMI.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblMonthlyEMI.setForeground(primaryBlue);

        // Result 2: Total Interest
        JLabel lblTotalIntTitle = new JLabel("Total Interest:");
        lblTotalIntTitle.setFont(resTitleFont);
        lblTotalIntTitle.setForeground(textDark);

        lblTotalInterest = new JLabel("₹ 0.00");
        lblTotalInterest.setFont(resValueFont);
        lblTotalInterest.setForeground(textDark);

        // Result 3: Total Payment
        JLabel lblTotalPayTitle = new JLabel("Total Payment:");
        lblTotalPayTitle.setFont(resTitleFont);
        lblTotalPayTitle.setForeground(textDark);

        lblTotalPayment = new JLabel("₹ 0.00");
        lblTotalPayment.setFont(resValueFont);
        lblTotalPayment.setForeground(textDark);

        resultCard.add(lblEMITitle);
        resultCard.add(lblMonthlyEMI);
        resultCard.add(lblTotalIntTitle);
        resultCard.add(lblTotalInterest);
        resultCard.add(lblTotalPayTitle);
        resultCard.add(lblTotalPayment);

        centerPanel.add(resultCard);

        add(centerPanel, BorderLayout.CENTER);

        // Step 4: Create Footer Panel (South)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(backgroundColor);
        footerPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

        JLabel lblFooter = new JLabel("Formula: EMI = [P × r × (1+r)^n] / [(1+r)^n – 1]");
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblFooter.setForeground(textMuted);
        footerPanel.add(lblFooter);

        add(footerPanel, BorderLayout.SOUTH);
    }

    /**
     * Event Handling method from ActionListener interface.
     * Invoked when user clicks either "Calculate EMI" or "Reset".
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            calculateEMI();
        } else if (e.getSource() == btnReset) {
            resetFields();
        }
    }

    /**
     * Validates user inputs and calculates EMI, Total Interest, and Total Payment.
     */
    private void calculateEMI() {
        String strAmount = txtLoanAmount.getText().trim();
        String strRate   = txtInterestRate.getText().trim();
        String strTenure = txtTenure.getText().trim();

        // 1. Validation: Check for empty input fields
        if (strAmount.isEmpty() || strRate.isEmpty() || strTenure.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all input fields.",
                    "Input Missing",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        double principal;
        double annualRate;
        double tenureYears;

        // 2. Validation: Check if inputs are valid numeric values
        try {
            principal   = Double.parseDouble(strAmount);
            annualRate  = Double.parseDouble(strRate);
            tenureYears = Double.parseDouble(strTenure);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input! Please enter valid numeric numbers only.",
                    "Number Format Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 3. Validation: Logical range checks
        if (principal <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Loan Amount must be greater than zero.",
                    "Invalid Loan Amount",
                    JOptionPane.ERROR_MESSAGE
            );
            txtLoanAmount.requestFocus();
            return;
        }

        if (annualRate < 0 || annualRate > 100) {
            JOptionPane.showMessageDialog(
                    this,
                    "Annual Interest Rate must be between 0% and 100%.",
                    "Invalid Interest Rate",
                    JOptionPane.ERROR_MESSAGE
            );
            txtInterestRate.requestFocus();
            return;
        }

        if (tenureYears <= 0 || tenureYears > 50) {
            JOptionPane.showMessageDialog(
                    this,
                    "Loan Tenure must be between 1 and 50 years.",
                    "Invalid Loan Tenure",
                    JOptionPane.ERROR_MESSAGE
            );
            txtTenure.requestFocus();
            return;
        }

        // --- Standard EMI Calculation ---
        // n = Total number of monthly installments
        double n = tenureYears * 12;

        double emi;
        double totalPayment;
        double totalInterest;

        // If interest rate is 0%, simple division
        if (annualRate == 0) {
            emi = principal / n;
            totalPayment = principal;
            totalInterest = 0.0;
        } else {
            // r = Monthly interest rate (annual rate divided by 12 months and converted to decimal)
            double r = (annualRate / 12.0) / 100.0;

            // EMI Formula: EMI = [P * r * (1 + r)^n] / [(1 + r)^n - 1]
            double ratePower = Math.pow(1 + r, n);
            emi = (principal * r * ratePower) / (ratePower - 1);

            totalPayment = emi * n;
            totalInterest = totalPayment - principal;
        }

        // Display results formatted to 2 decimal places with currency symbol
        lblMonthlyEMI.setText(currencyFormat.format(emi));
        lblTotalInterest.setText(currencyFormat.format(totalInterest));
        lblTotalPayment.setText(currencyFormat.format(totalPayment));
    }

    /**
     * Clears all input text fields and resets result labels back to default.
     */
    private void resetFields() {
        txtLoanAmount.setText("");
        txtInterestRate.setText("");
        txtTenure.setText("");

        lblMonthlyEMI.setText("₹ 0.00");
        lblTotalInterest.setText("₹ 0.00");
        lblTotalPayment.setText("₹ 0.00");

        // Set cursor back to the first text field
        txtLoanAmount.requestFocus();
    }

    /**
     * Main method: Program entry point.
     * Launches the GUI on the Event Dispatch Thread (standard Swing practice).
     */
    public static void main(String[] args) {
        // Set Look and Feel to System Look and Feel for clean native appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Default look and feel is used as fallback
        }

        // Launch GUI safely on Swing's Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EMICalculator().setVisible(true);
            }
        });
    }
}
