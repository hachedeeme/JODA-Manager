package hachedeeme.jodamanager.modelTest;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import hachedeeme.jodamanager.model.Consumable;
import hachedeeme.jodamanager.model.MeetingAttendee;

/**
 * Created by Hache on 03/03/2015.
 */
public class TestMeetingAttendee extends TestCase{
    private MeetingAttendee attendee;

    @Override
    protected void setUp() throws Exception {
        this.attendee = new MeetingAttendee("Hache");
    }

    private void addSomePaymentsToTest(){
        this.attendee.getPayments().clear();
        this.attendee.pay(20D, null);
        this.attendee.pay(100D, null);
        this.attendee.pay(30D, null);
    }


    @SmallTest
    public void test_pay_a_consumable(){
        // In the beginning the attendee haven't payments
        assertTrue(this.attendee.getPayments().isEmpty());
        // given the consumable
        Consumable consumable = new Consumable("Beer");
        // when pay
        this.attendee.pay(50D, consumable);
        // then the payment list should not be empty
        assertFalse(this.attendee.getPayments().isEmpty());
        // and the firs payment should have costPaid = 50.0 and the Consumable("Beer")
        assertEquals(50D, this.attendee.getPayments().get(0).getCostPaid());
        assertEquals(consumable, this.attendee.getPayments().get(0).getConsumable());
    }

    @SmallTest
    public void test_totalCostPaid_should_be_150(){
        this.addSomePaymentsToTest();
        // the totalCostPaid should be 150.0
        assertEquals(150D, this.attendee.totalCostPaid());
    }
}
