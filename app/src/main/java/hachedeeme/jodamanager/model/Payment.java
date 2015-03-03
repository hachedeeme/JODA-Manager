package hachedeeme.jodamanager.model;

/**
 * Created by Hache on 03/02/2015.
 */
public class Payment {
    private Consumable consumable;
    private Double costPaid;
    private Double costConsumable;

    public Payment(Double costPaid, Consumable aConsumable){
        this.costPaid = costPaid;
        this.costConsumable = 0D;
        this.consumable = aConsumable;
    }

    //*****************//
    //*** ACCESSORS ***//
    //*****************//
    public Consumable getConsumable() {
        return consumable;
    }

    public Double getCostPaid() {
        return costPaid;
    }

    public Double getCostConsumable() {
        return costConsumable;
    }

    public void setCostConsumable(Double costConsumable) {
        this.costConsumable = costConsumable;
    }
}
