package proj4_OUNV;

import java.util.Scanner;

/**
 */
public class CellularCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1.
        CellularPlan basic = new CellularPlan("בסיסית", 29.0, 150, 2000, 0.4, 0.08);
        CellularPlan popular = new CellularPlan("פופולרית", 49.0, 500, 10000, 0.2, 0.05);
        CellularPlan unlimited = new CellularPlan("ללא הגבלה", 89.0, 5000, 50000, 0.0, 0.0);

        // 2.
        System.out.println("--- חבילות סלולר זמינות ---");
        System.out.println("1. " + basic);
        System.out.println("2. " + popular);
        System.out.println("3. " + unlimited);

        // 3.
        System.out.println("\n--- המלצת חבילה אישית ---");
        System.out.print("הכנס צפי דקות שיחה לחודש: ");
        int expectedMin = scanner.nextInt();
        System.out.print("הכנס צפי גלישה (MB) לחודש: ");
        int expectedMb = scanner.nextInt();

        // 4.
        CellularPlan bestPlan = basic;
        if (popular.cheaperCellularPlanExpected(bestPlan)) {
            bestPlan = popular;
        }
        if (unlimited.cheaperCellularPlanExpected(bestPlan)) {
            bestPlan = unlimited;
        }

        // 5.
        scanner.nextLine(); // ניקוי ה-Buffer
        System.out.print("\nהכנס את שמך המלא: ");
        String name = scanner.nextLine();
        System.out.print("הכנס מספר טלפון: ");
        String phone = scanner.nextLine();

        // 6.
        CellularUser user = new CellularUser(name, phone, bestPlan);
        System.out.println("\n--- פרטי המנוי החדש ---");
        System.out.println(user);

        // 7.
        System.out.print("\nהכנס דקות שיחה שבוצעו עד כה: ");
        int uMin = scanner.nextInt();
        System.out.print("הכנס גלישה (MB) שנוצלה עד כה: ");
        int uMb = scanner.nextInt();

        // 8. ]
        user.updateUsage(uMin, uMb);
        System.out.println("\n--- סטטוס מנוי מעודכן ---");
        System.out.println(user);

        // 9.
        System.out.println("\n--- החלפת חבילה (מעבר ל'פופולרית') ---");
        System.out.print("הכנס מספר ימים שהיית בחבילה הנוכחית: ");
        int days = scanner.nextInt();

        // 10.
        double oldPlanPayment = user.planChange(days, popular);


        // 11.
        System.out.println("\n--- סטטוס מנוי לאחר החלפה ---");
        System.out.println(user);

        // 12.
        System.out.print("\nהכנס דקות שיחה נוספות בחבילה החדשה: ");
        int newMin = scanner.nextInt();
        System.out.print("הכנס גלישה נוספת (MB) בחבילה החדשה: ");
        int newMb = scanner.nextInt();

        // 13.
        user.updateUsage(newMin, newMb);
        System.out.println("\n--- סטטוס מנוי סופי ---");
        System.out.println(user);

        // 14.
        System.out.printf("\nסכום לתשלום עבור החודש הנוכחי (חבילה חדשה): %.2f שח\n", user.MonthlyPayment());

        scanner.close();
    }
}