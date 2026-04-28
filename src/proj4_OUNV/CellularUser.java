package proj4_OUNV;

/**
 * Write a description of class CellularUser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CellularUser
{
    // instance variables - replace the example below with your own
    private String _name;
    private String _phone;
    private CellularPlan _plan;
    private int _minutes;
    private int _mbs;

    /**
     * Constructor for objects of class CellularUser
     */
    public CellularUser(String name, String phone, CellularPlan plan)
    {
        _name = name;
        _phone = phone;
        _plan = new CellularPlan(plan);
        _minutes = 0;
        _mbs = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  min mbs  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void updateUsage(int min, int mbs)
    {
        _minutes+=min;
        _mbs += mbs;
    }
    public double MonthlyPayment()
    {
        double payment = _plan.monthlyPayment(_minutes, _mbs);
        return payment;
        
    }
    public double planChange(int days, CellularPlan plan_new)
    {
        double payment = _plan.partialPayment(_minutes, _mbs, days);
        _plan = new CellularPlan(plan_new);
        _minutes = 0;
        _mbs = 0;
        return payment;
    }
    public String toString()
    {
        return _name + " (tel) "+_phone + "\nPlan: " + _plan+"\nUsage: " + _minutes+" minutes, "+_mbs+ " MBS";
    }
    public CellularPlan getPlan()
    {
        return new CellularPlan(_plan);

    }
}