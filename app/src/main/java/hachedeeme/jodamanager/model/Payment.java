package hachedeeme.jodamanager.model;

/**
 * Created by Hache on 03/02/2015.
 */
public class Payment {
    private Consumable consumable;
    private MeetingAttendee attendee;
    private Double costPaid;
    private Double costConsumable;

    public Payment(Double costPaid, Consumable aConsumable, MeetingAttendee anAttendee){
        this.costPaid = costPaid;
        this.costConsumable = 0D;
        this.consumable = aConsumable;
        this.attendee = anAttendee;
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

    public MeetingAttendee getAttendee() {
        return attendee;
    }

    public void setCostConsumable(Double costConsumable) {
        this.costConsumable = costConsumable;
    }
}
