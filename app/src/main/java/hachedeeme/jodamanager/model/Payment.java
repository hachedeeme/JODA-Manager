package hachedeeme.jodamanager.model;

/**
 * Created by Hache on 03/02/2015.
 */
public class Payment {
    private Consumable consumable;
    private Double costPaid;

    public Payment(Double costPaid){
        this.costPaid = costPaid;
    }

    //*** ACCESSORS ***//
    public Consumable getConsumable() {
        return consumable;
    }

    public Double getCostPaid() {
        return costPaid;
    }
}
