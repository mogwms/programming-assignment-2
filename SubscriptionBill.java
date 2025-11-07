
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubscriptionBill {

    public static Scanner input = new Scanner(System.in);

    public static void calculateTotalAmount(String accountID, int packagePlan, double totalHours) {
        String[] packagePlans = {"A", "B", "C"};
        double[] packagePrices = {9.99, 14.95, 19.95};
        int[] packageHours = {10, 20, 0};
        double[] packageAdditional = {2.00, 1.00, 0};

        double finalAnswer;

        String plan = packagePlans[packagePlan];
        double packagePrice = packagePrices[packagePlan];
        double packageA = packageAdditional[packagePlan];
        int hours = packageHours[packagePlan];

        System.out.println("Account #:" + accountID);
        System.out.println("For package " + plan + " charged at " + packagePrice + " a month for " + totalHours + " hours");
        System.out.println("Total Hours:" + accountID);
        System.out.println("Amount Due:" + accountID);

        System.out.println("Plan:" + plan);
        System.out.println("packagePrice:" + packagePrice);
        System.out.println("packageA:" + packageA);
        System.out.println("hours: " + hours);
    
        if ((hours > 0) && (totalHours > hours)) {
            finalAnswer = packagePrice + Math.max(0,totalHours - hours) * packageA;
        } else {
            finalAnswer = packagePrice;
        }
        System.out.println(finalAnswer);
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

    public static int getPackagePlan() {
        String answer;
        try {
            System.out.println("Please Enter Package Plan.");
            answer = input.nextLine();
            int packagePlan = 0;
            switch (answer) {
                case "A" -> {
                    packagePlan = 0;
                }
                case "B" -> {
                    packagePlan = 1;
                }
                case "C" -> {
                    packagePlan = 2;
                }
            }
            return packagePlan;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input - Please Enter A Valid Number.");
            return -1;
        }
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
        int packagePlan = 0;
        double hoursUsed = 0;

        double packageACost = 9.95;
        double packageAExtra = 2.00;

        double packageBCost = 9.95;
        double packageBExtra = 2.00;

        double packageCCost = 9.95;
        double packageCExtra = 0;

        // Declare variables for loop control flow
        int section = 1;
        boolean validInput = false;

        // Declare while loop with boolean flag validInput
        while (!validInput) {
            switch (section) {
                case 1 -> {
                    accountID = getAccountID();
                    if (accountID != null) {
                        section = 2;
                    }
                }
                case 2 -> {
                    packagePlan = getPackagePlan();
                    if (packagePlan >= 0) {
                         section = 3;
                    }
                }
                case 3 -> {
                    hoursUsed = getHoursUsed();
                    if (hoursUsed >= 0) {
                        section = 4;
                    }
                }
                case 4 -> {
                    calculateTotalAmount(accountID, packagePlan, hoursUsed);
                    validInput = true;
                }
                default -> {
                }
            }
        }
        input.close();
    }
}
