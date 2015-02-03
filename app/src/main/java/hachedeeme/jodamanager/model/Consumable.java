package hachedeeme.jodamanager.model;

import java.util.ArrayList;
import java.util.List;

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

    public String getName() {
        return name;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
