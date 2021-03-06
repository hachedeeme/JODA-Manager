package hachedeeme.jodamanager.model;

import java.util.ArrayList;
import java.util.List;

import hachedeeme.jodamanager.utils.MathUtils;

/**
 * Created by Hache on 03/02/2015.
 */
public class Consumable {
    private String name;
    private List<Payment> payments;

    public Consumable(String name) {
        this.name = name;
        this.payments = new ArrayList<Payment>();
    }

    //***************//
    //*** METHODS ***//
    //***************//
    /**
     * Add a Payment to the consumable
     * @param aPayment
     */
    public void addPayment(Payment aPayment){
        this.payments.add(aPayment);
    }

    /**
     * Returns the cost per attendee of the consumable.
     * costPerAttendee = totalConsumption / amountOfConsumers
     * @return
     */
    public Double costPerAttendee(){
        return this.payments.isEmpty() ?
                0D :
                MathUtils.roundTwoDecimals(this.totalConsumption()/this.amountOfConsumers());
    }

    /**
     * Returns the total cost of a consumable.
     * @return
     */
    public Double totalConsumption(){
        Double result = 0D;
        for (Payment payment : this.payments){
            result += payment.getCostPaid();
        }
        return result;
    }

    /**
     * Returns how many attendee consume the consumable.
     * @return
     */
    public int amountOfConsumers(){
        return this.payments.size();
    }

    /**
     * All the payments of a consumable set the costOfConsume variable
     * whit the costPerAttendee.
     */
    public void updatePayments(){
        Double costConsumable = this.costPerAttendee();
        for (Payment payment : this.payments){
            payment.setCostConsumable(costConsumable);
            payment.getAttendee().updateAttendee();
        }
    }

    //*****************//
    //*** ACCESSORS ***//
    //*****************//
    public String getName() {
        return name;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
