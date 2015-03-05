package hachedeeme.jodamanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hache on 03/02/2015.
 */
public class MeetingAttendee {
    public String name;
    public Double totalCost;
    public Double finalCost;
    public List<Payment> payments;

    public MeetingAttendee(String aName){
        this.name = aName;
        this.totalCost = 0D;
        this.finalCost = 0D;
        this.payments = new ArrayList<Payment>();
    }

    //***************//
    //*** METHODS ***//
    //***************//
    /**
     * Returns the total cost of all payments paid.
     * @return
     */
    public Double totalCostPaid(){
        Double result = 0D;
        for (Payment payment : this.payments){
            result += payment.getCostPaid();
        }
        return result;
    }

    /**
     * Pay a consumable.
     * @param aCost
     * @param aConsumable
     */
    public void pay(Double aCost, Consumable aConsumable){
        Payment payment = new Payment(aCost, aConsumable);
        aConsumable.addPayment(payment);
        aConsumable.updatePayments();
        this.addPayment(payment);
        this.totalCost = totalConsumablesCost();
        this.finalCost = calculateFinalCost();
    }

    public void updateAttendee(){
        this.totalCost = totalConsumablesCost();
        this.finalCost = calculateFinalCost();
    }

    /**
     * Returns the total of all consumables cost.
     * @return
     */
    private Double totalConsumablesCost(){
        Double totalConsumableCost = 0D;
        for (Payment payment : this.payments){
            totalConsumableCost += payment.getCostConsumable();
        }
        return totalConsumableCost;
    }

    /**
     * Returns the final cost to pay.
     * @return
     */
    private Double calculateFinalCost(){
        return this.getTotalCost() - totalCostPaid();
    }

    //***********//
    //*** AUX ***//
    //***********//
    private void addPayment(Payment aPayment){
        this.payments.add(aPayment);
    }

    //*****************//
    //*** ACCESSORS ***//
    //*****************//
    public String getName() {
        return name;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Double getFinalCost() {
        return finalCost;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
