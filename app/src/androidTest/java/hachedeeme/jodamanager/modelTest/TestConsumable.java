package hachedeeme.jodamanager.modelTest;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import hachedeeme.jodamanager.model.Consumable;
import hachedeeme.jodamanager.model.Payment;

public class TestConsumable extends TestCase{
    private Consumable consumable;

    @Override
    protected void setUp() throws Exception {
        this.consumable = new Consumable("Beer");
    }

    private void addSomePaymentToTest(){
        this.consumable.getPayments().clear();
        this.consumable.addPayment(new Payment(100D));
        this.consumable.addPayment(new Payment(50D));
        this.consumable.addPayment(new Payment(60D));
    }

    @SmallTest
    public void test_consumableName_is_beer(){
        assertEquals("Beer", consumable.getName());
    }

    @SmallTest
    public void test_addPayment(){
        Payment payment = new Payment(10D);
        // payments is empty in this time
        assertTrue(this.consumable.getPayments().isEmpty());
        // when add a payment
        this.consumable.addPayment(payment);
        // then there is an added payment
        assertFalse(this.consumable.getPayments().isEmpty());
        // and these payment is the payment that was added in first time
        assertEquals(payment, this.consumable.getPayments().get(0));
    }

    @SmallTest
    public void test_costPerAttendee(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        // with the payments already added the costPerAttendee should be 70.0
        assertEquals(70D, this.consumable.costPerAttendee());

        // if add another consumable, the costPerAttendee should be 67.5
        this.consumable.addPayment(new Payment(60D));
        assertEquals(67.5, this.consumable.costPerAttendee());
    }

    @SmallTest
    public void test_totalConsumption(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        // with the payments already added the totalConsumption should be 210.0
        assertEquals(210D, this.consumable.totalConsumption());

        // if add another consumable, the totalConsumption should be 270.0
        this.consumable.addPayment(new Payment(60D));
        assertEquals(270.0, this.consumable.totalConsumption());
    }

    @SmallTest
    public void test_amountOfConsumers(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        // with the payments already added the amountOfConsumers should be 3
        assertEquals(3, this.consumable.amountOfConsumers());

        // if add another consumable, the amountOfConsumers should be 4
        this.consumable.addPayment(new Payment(60D));
        assertEquals(4, this.consumable.amountOfConsumers());
    }

    @SmallTest
    public void test_updatePayments(){
        //TODO
    }
}
