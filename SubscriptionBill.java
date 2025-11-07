import java.util.InputMismatchException;
import java.util.Scanner;

public class SubscriptionBill {
    public static Scanner input = new Scanner(System.in);

    public static double calculateTotalAmount(String accountID, String packagePlan, double totalHours) {
        double packageACost = 9.95;
        double packageAExtra = 2.00;
        
        double packageBCost = 9.95;
        double packageBExtra = 2.00;

        double packageCCost = 9.95;
        double packageCExtra = 2.00;
        
        double finalPrice = 0;
        
        switch (packagePlan) {
            case "A" -> System.out.println("A");
            case "B" -> System.out.println("B");
            case "C" -> System.out.println("B");
            default -> throw new AssertionError("Package Not Found!");
        }
        
        return finalPrice;
    }

    public static double getHoursUsed() {
        String hoursUsed;
        try {
            System.out.println("Please Enter Hours Used.");
            hoursUsed = input.nextLine();
            double hrs;
            hrs = Double.parseDouble(hoursUsed);
            return hrs;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input - Please Enter A Valid Number.");
            return -1;
        }
    }

    public static String getPackagePlan() {
        String packagePlan;
        try {
            System.out.println("Please Enter Your Package Plan.");
            packagePlan = input.nextLine();
            if (!packagePlan.isEmpty()
                    && ("A".equals(packagePlan) || "B".equals(packagePlan) || "C".equals(packagePlan))) {
                return packagePlan;
            } else {
                throw new InputMismatchException("Invalid Input - Enter A Package Plan (A, B, C)!");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getAccountID() {
        String accountID;
        try {
            System.out.println("Please Enter Your Account Name.");
            accountID = input.nextLine();
            if (!accountID.isEmpty()) {
                return accountID;
            } else {
                throw new InputMismatchException("Invalid Input - Please Enter A Valid Username.");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // Declare Variables for Input
        String accountID = "";
        String packagePlan = "";
        double hoursUsed = 0;

        // Declare variables for loop control flow
        int section = 1;
        boolean validInput = false;

        // Declare while loop with boolean flag validInput
        while (!validInput) {
            switch (section) {
                case 1:
                    accountID = getAccountID();
                    if (accountID != null) {
                        section = 2;
                    }
                    break;
                case 2:
                    packagePlan = getPackagePlan();
                    if (packagePlan != null) {
                        section = 3;
                    }
                    break;
                case 3:
                    hoursUsed = getHoursUsed();
                      if (hoursUsed >= 0) {
                        section = 4;
                    }
                    break;
                case 4:
                    calculateTotalAmount(accountID, packagePlan, hoursUsed);
                    validInput = true;
                    break;
                default:
                    break;
            }
        }
        input.close();
    }
}
