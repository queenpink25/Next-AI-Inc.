public class NextAIInc {

    // Method to calculate total pay for a contractor
    public void calculatePay(int basePay, int hoursWorked) {
        final int MIN_BASE_PAY = 30000; // Minimum base pay
        final int MAX_HOURS = 72; // Maximum hours allowed
        final int REGULAR_HOURS_LIMIT = 48; // Regular hours limit
        final int OVERTIME_MULTIPLIER = 2; // Overtime pay multiplier

        // Check for base pay validity
        if (basePay < MIN_BASE_PAY) {
            System.out.println("Error: Base pay must not fall below UGX 30,000.");
            return;
        }

        // Check for hours worked validity
        if (hoursWorked > MAX_HOURS) {
            System.out.println("Error: Hours worked must not exceed 72 hours.");
            return;
        }

        // Calculate total pay
        int regularHours = Math.min(hoursWorked, REGULAR_HOURS_LIMIT);
        int overtimeHours = Math.max(0, hoursWorked - REGULAR_HOURS_LIMIT);
        
        int totalPay = (regularHours * basePay) + (overtimeHours * basePay * OVERTIME_MULTIPLIER);
        
        System.out.println("Total pay for the contractor: UGX " + totalPay);
    }

    public static void main(String[] args) {
        NextAIInc nextAIInc = new NextAIInc();

        // Test Case Contractor A
        System.out.println("Contractor A:");
        nextAIInc.calculatePay(30000, 51); // Expected outcome: Total pay includes 48 regular hours and 3 overtime hours.

        // Test Case Contractor B
        System.out.println("\nContractor B:");
        nextAIInc.calculatePay(20000, 40); // Expected outcome: Error message displayed due to base pay being below the minimum required rate.

        // Test Case Contractor C
        System.out.println("\nContractor C:");
        nextAIInc.calculatePay(35000, 96); // Expected outcome: Error message displayed due to hours worked exceeding the 72-hour limit.
    }
}