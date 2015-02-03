package hachedeeme.jodamanager.model;

import java.util.List;

/**
 * Created by Hache on 03/02/2015.
 */
public class MeetingAttendee {
    public String name;
    public Integer totalCost;
    public Integer finalCost;
    public List<Payment> payments;



    public String getName() {
        return name;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public Integer getFinalCost() {
        return finalCost;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
