package proj4_OUNV;

/**
 */
public class CellularTest {
    public static void main(String[] args) {
        System.out.println("--- תחילת בדיקות אוטומטיות ---");

        testPlanConstructorAndValidation();
        testUserAliasing();
        testPlanCalculations();
        testPlanChangeAndUsageReset();

        System.out.println("--- סיום בדיקות אוטומטיות ---");
    }

    /**
     */
    public static void testPlanConstructorAndValidation() {
        System.out.println("1. בדיקת בנאי CellularPlan ו-Validation... ");

        // ערכים שליליים נבדקים
        CellularPlan pTest = new CellularPlan("Test Plan", -10.0, -50, 1000, -0.5, 0.1);
        CellularPlan pCheck = new CellularPlan("Test Plan", 0, 0, 0, 0, 0);

//        if (pTest.equalsCellularPlan(pCheck)) {
//            System.out.println("עבר בהצלחה (נוצר אובייקט תקין, ערכים שליליים טופלו)");
//        } else {
//            System.out.println("נכשל (ערכים שליליים לא טופלו כראוי)");
//        }
        if (pTest.toString().equals(pCheck.toString())) {
            System.out.println("עבר בהצלחה-tostring (נוצר אובייקט תקין, ערכים שליליים טופלו)");
        } else {
            System.out.println("נכשל-tostring (ערכים שליליים לא טופלו כראוי)");
        }
    }

    /**
     */
    public static void testUserAliasing() {
        System.out.println("2. בדיקת הצבעה כפולה (Aliasing) ב-CellularUser... ");

        CellularPlan pOriginal = new CellularPlan("Original", 100, 100, 100, 1, 1);
        CellularUser user = new CellularUser("Tester", "0501234567", pOriginal);

        pOriginal.set_planName("OK");
        if (user.getPlan().toString().equals( pOriginal.toString())){
            System.out.println("עבר בהצלחה (המנוי מכיל עותק נפרד של החבילה)");
        } else {
            System.out.println("נכשל (התרחשה הצבעה כפולה או שגיאה ב-Copy Constructor)");
        }
    }

    public static void testPlanCalculations() {
        System.out.print("3. בדיקת חישוב עלויות (חודשי + יחסי)... ");

        // חבילה: 30 שח, 100 דק', 1000MB. חריגה: 0.5 לדקה, 0.1 ל-MB
        CellularPlan p = new CellularPlan("Calc Test", 30.0, 100, 1000, 0.5, 0.1);

        // מקרה א: חודשי מלא עם חריגה.
        // 150 דק' (50 חריגה), 1200 MB (200 חריגה)
        // עלות: 30.0 + (50 * 0.5) + (200 * 0.1) = 30.0 + 25.0 + 20.0 = 75.0
        double costFull = p.monthlyPayment(150, 1200);

        // מקרה ב: חודשי חלקי (7 ימים = 0.25). [cite: 23]
        // מכסה יחסית: 25 דק', 250 MB. מחיר בסיס יחסי: 7.5.
        // שימוש: 50 דק' (25 חריגה), 300 MB (50 חריגה)
        // עלות: 7.5 + (25 * 0.5) + (50 * 0.1) = 7.5 + 12.5 + 5.0 = 25.0
        double costPartial = p.partialPayment(50, 300, 7);

        // בדיקה עם טווח סובלנות קטן (epsilon)
        if (Math.abs(costFull - 75.0) < 0.001 && Math.abs(costPartial - 25.0) < 0.001) {
            System.out.println("עבר בהצלחה (חישוב חודשי וחלקי תקין)");
        } else {
            System.out.println("נכשל. חודשי: " + costFull + ", חלקי: " + costPartial);
        }
    }

    /**
     * 2. בדיקת שיטת planChange - .
     */
    public static void testPlanChangeAndUsageReset() {
        System.out.print("4. בדיקת החלפת חבילה ואיפוס שימוש... ");

        // חבילה ישנה: 100 שח, 100 דק', 1000MB, חריגה: 1.0 לדק', 0.1 ל-MB
        CellularPlan oldPlan = new CellularPlan("Old", 100.0, 100, 1000, 1.0, 0.1);
        CellularPlan newPlan = new CellularPlan("New", 50.0, 50, 500, 0, 0); // ללא חריגה
        CellularUser user = new CellularUser("Switcher", "0", oldPlan);

        // שימוש לפני מעבר: 200 דק', 2000 MB
        user.updateUsage(200, 2000);

        // מעבר לאחר 14 ימים (חצי חודש). מכסה יחסית: 50 דק', 500 MB. מחיר יחסי: 50 שח.
        // חוב: 50.0 + (200-50)*1.0 + (2000-500)*0.1 = 50.0 + 150.0 + 150.0 = 350.0 שח
        double expectedPayment = 350.0;

        // ביצוע ההחלפה
        double returnedPayment = user.planChange(14, newPlan);

        // בדיקה 1: האם הערך המוחזר (החוב) נכון
        boolean paymentCorrect = Math.abs(returnedPayment - expectedPayment) < 0.001;

        // בדיקה 2: האם השימוש אופס (התשלום הנוכחי אמור להיות מחיר הבסיס של החבילה החדשה: 50 שח)
        boolean usageReset = Math.abs(user.MonthlyPayment() - 50.0) < 0.001; // 50 שח כי שימוש 0

        if (paymentCorrect && usageReset) {
            System.out.println("עבר בהצלחה (חישוב חוב יחסי נכון והשימוש אופס)");
        } else {
            System.out.println("נכשל. חוב: " + returnedPayment + " (צפוי: " + expectedPayment +
                    "), איפוס: " + usageReset);
        }
    }
}