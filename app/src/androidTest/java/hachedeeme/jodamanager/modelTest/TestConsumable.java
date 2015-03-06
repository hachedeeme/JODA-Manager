package hachedeeme.jodamanager.modelTest;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import hachedeeme.jodamanager.model.Consumable;
import hachedeeme.jodamanager.model.Meeting;
import hachedeeme.jodamanager.model.MeetingAttendee;
import hachedeeme.jodamanager.model.Payment;

public class TestConsumable extends TestCase{
    private Consumable consumable;
    private MeetingAttendee attendee;

    @Override
    protected void setUp() throws Exception {
        this.consumable = new Consumable("Beer");
        this.attendee = new MeetingAttendee("hache");
    }

    private void addSomePaymentToTest(){
        this.consumable.getPayments().clear();
        this.consumable.addPayment(new Payment(100D, null, this.attendee));
        this.consumable.addPayment(new Payment(50D,  null, this.attendee));
        this.consumable.addPayment(new Payment(60D,  null, this.attendee));
    }

    @SmallTest
    public void test_consumableName_should_be_beer(){
        assertEquals("Beer", consumable.getName());
    }

    @SmallTest
    public void test_addPayment(){
        Payment payment = new Payment(10D, null, this.attendee);
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
        this.consumable.addPayment(new Payment(60D, null, this.attendee));
        assertEquals(67.5, this.consumable.costPerAttendee());
    }

    @SmallTest
    public void test_totalConsumption(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        // with the payments already added the totalConsumption should be 210.0
        assertEquals(210D, this.consumable.totalConsumption());

        // if add another consumable, the totalConsumption should be 270.0
        this.consumable.addPayment(new Payment(60D, null, this.attendee));
        assertEquals(270.0, this.consumable.totalConsumption());
    }

    @SmallTest
    public void test_amountOfConsumers(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        // with the payments already added the amountOfConsumers should be 3
        assertEquals(3, this.consumable.amountOfConsumers());

        // if add another consumable, the amountOfConsumers should be 4
        this.consumable.addPayment(new Payment(60D, null, this.attendee));
        assertEquals(4, this.consumable.amountOfConsumers());
    }

    @SmallTest
    public void test_updatePayments(){
        // add some payments to the consumable
        this.addSomePaymentToTest();
        this.consumable.updatePayments();
        // the costConsumable of all payments should be 70.0
        for (Payment payment : this.consumable.getPayments()){
            assertEquals(70D, payment.getCostConsumable());
        }
    }
}
