package walmart;
import java.util.*;


/// check % of success or failiure for a partcular date



class PaymentTracker
{

    private Map<String,Integer> statusMap;
    private List<PaymentsDetails> transactionObjectList;

    public PaymentTracker()
    {
        this.statusMap = new HashMap<>();
        this.transactionObjectList = new ArrayList<>();
    }

    public void addTransactionalDetails(PaymentsDetails pd)
    {
        transactionObjectList.add(pd);

        if(pd.getStatus().equals("success"))
        {
            statusMap.put(pd.getDate() + "_success", statusMap.getOrDefault(pd.getDate() + "_success",0)+1);
        }
        else if(pd.getStatus().equals("inprocess"))
        {
            statusMap.put(pd.getDate() + "_inprocess", statusMap.getOrDefault(pd.getDate() + "_inprocess",0)+1);
        }
        else
        {
            statusMap.put(pd.getDate() + "_failed", statusMap.getOrDefault(pd.getDate() + "_failed",0)+1);
        }

    }


    public void checkStatusPercent(String status, String date)
    {
        String key = date + "_" + status;
        int count = statusMap.get(key);
        int listSize = transactionObjectList.size();
        System.out.println(status + " percentage : "+((double) count/listSize)*100);


    }
}

class PaymentsDetails
{

    private UUID id;
    private String processorName;
    private int amount;
    private String timeStamp;
    private String status;



    public PaymentsDetails(String processorName, int amount, String timeStamp, String status)
    {
       this.id = UUID.randomUUID();
       this.processorName = processorName;
       this.amount = amount;
       this.timeStamp = timeStamp;
       this.status = status;
    }

    public UUID getId()
    {
        return id;
    }

    public String getDate()
    {
        return this.timeStamp;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        return "PaymentDetails (" + id+", " + processorName + ", "+ timeStamp+", " + status+" )";

    }

}


public class Main {


    public static void main(String[]  args)
    {
        PaymentsDetails pd1 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd2 = new PaymentsDetails("G pay",12000, "12/03/2025","failed");
        PaymentsDetails pd3 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd4 = new PaymentsDetails("G pay",12000, "12/03/2025","failed");
        PaymentsDetails pd5 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd6 = new PaymentsDetails("G pay",12000, "12/03/2025","failed");
        PaymentsDetails pd7 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd8 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd9 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd10 = new PaymentsDetails("G pay",12000, "12/03/2025","success");
        PaymentsDetails pd11 = new PaymentsDetails("G pay",12000, "12/03/2025","success");


        PaymentTracker pt = new PaymentTracker();
        pt.addTransactionalDetails(pd1);
        pt.addTransactionalDetails(pd2);
        pt.addTransactionalDetails(pd3);
        pt.addTransactionalDetails(pd4);
        pt.addTransactionalDetails(pd5);
        pt.addTransactionalDetails(pd6);
        pt.addTransactionalDetails(pd7);
        pt.addTransactionalDetails(pd8);
        pt.addTransactionalDetails(pd9);
        pt.addTransactionalDetails(pd10);
        pt.addTransactionalDetails(pd11);

        pt.checkStatusPercent("failed","12/03/2025");
        pt.checkStatusPercent("success","12/03/2025");
    }

}
