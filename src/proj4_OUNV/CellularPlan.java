package proj4_OUNV;

/**
 * Write a description of class CellularPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CellularPlan
{
    // instance variables - replace the example below with your own
    private String _planName;          // שם החבילה
    private double _basePrice;          // מחיר בסיסי
    private int _includedMinutes;       // מספר דקות כלולות
    private int _includedMB;             // מספר MB כלולים
    private double _extraMinutePrice;   // מחיר לדקת חריגה
    private double _extraMBPrice;        // מחיר ל-MB חריגה

    /**
     * Constructor for objects of class CellularPlan
     */
    public CellularPlan(String planName, double basePrice, int includedMinutes, int includedMB,
        double extraMinutePrice, double extraMBPrice)
    {
        if(planName.isEmpty())
            _planName= "TEST";
        else
           _planName = planName;          // שם החבילה
       
        if(_basePrice <= 0)
            _basePrice = 100;          // מחיר בסיסי
        else
            _basePrice = basePrice;
         
        if(_includedMinutes <=0)
            _includedMinutes = 100;
        else
            _includedMinutes = includedMinutes;       // מספר דקות כלולות
       
        if (_includedMB <= 0 )
            _includedMB = 100;
        else
            _includedMB = includedMB;
            // מספר MB כלולים
       
        if(_extraMinutePrice < 0)
            _extraMinutePrice = 10;
        else
            _extraMinutePrice = extraMinutePrice;   // מחיר לדקת חריגה
       
        if( _extraMBPrice < 0)
            _extraMBPrice = 10;
        else
            _extraMBPrice = extraMBPrice; 
       
    }
    
    
    public CellularPlan(CellularPlan other) {
        _planName = other._planName;
        _basePrice = other._basePrice;
        _includedMinutes = other._includedMinutes;
        _includedMB = other._includedMB;
        _extraMinutePrice = other._extraMinutePrice;
        _extraMBPrice = other._extraMBPrice;
    }
    
    public String toString()
    {
        return _planName + " BasePrice: " + _basePrice + " , Minutes: " + _includedMinutes + " , MB: " 
        + _includedMB + " Extra Munites Price: " + _extraMinutePrice + " Extra MB Price: " + _extraMBPrice;
    }
    
    
    public double monthlyPayment(int min, int mb)
    {
        double payment =0;
        
        return payment;
    }

    public double partialPayment(int min, int mb, int days)
    {
        double payment =0;
        
        return payment;
    }
    
    public boolean equalsCellularPlan(CellularPlan p)
    {
        boolean flag =true;
        
        return flag;
    }
    
    public boolean expensiveCellularPlan(CellularPlan p)
    {
        boolean flag =true;
        
        return flag;
    }
    
     public boolean cheaperCellularPlan(CellularPlan p)
    {
        boolean flag =true;
        
        return flag;
    }
    
    public boolean expensiveCellularPlanExpected(CellularPlan p)
    {
        boolean flag =true;
        
        return flag;
    }
    
     public boolean cheaperCellularPlanExpected(CellularPlan p)
    {
        boolean flag =true;
        
        return flag;
    }

    public void set_planName(String _planName) {
        this._planName = _planName;
    }
}