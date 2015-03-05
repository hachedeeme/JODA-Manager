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
        this.attendee.pay(20D, new Consumable("Beer"));
        this.attendee.pay(100D, new Consumable("Ice Cream"));
        this.attendee.pay(30D, new Consumable("Vegetables"));
    }

    @SmallTest
    public void test_create_MeetingAttendee(){
        // give an attendee created in the set up
        // the name should be "Hache"
        assertEquals("Hache", this.attendee.getName());
        // the totalCost should be 0D
        assertEquals(0D, this.attendee.getTotalCost());
        // the finalCost should be 0D
        assertEquals(0D, this.attendee.getFinalCost());
        // and the list of payments should be empty
        assertTrue(this.attendee.getPayments().isEmpty());
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
        // and the unique payment that have the consumable is costPaid = 50.0
        assertEquals(50D, consumable.getPayments().get(0).getCostPaid());
    }

    @SmallTest
    public void test_totalCostPaid_should_be_150(){
        this.addSomePaymentsToTest();
        // the totalCostPaid should be 150.0
        assertEquals(150D, this.attendee.totalCostPaid());
    }

    @SmallTest
    public void test_totalCost_should_be_150(){
        // Given some payments added
        this.addSomePaymentsToTest();
        // the totalConsumablesCost should be 150.0
        assertEquals(150D, this.attendee.getTotalCost());
    }

    @SmallTest
    public void test_finalCost_should_be_0(){
        // Given some payments added
        this.addSomePaymentsToTest();
        // the totalConsumablesCost should be 120.0
        assertEquals(0D, this.attendee.getFinalCost());
    }

    @SmallTest
    public void test_totalCost_and_totalCost_large_case(){
        // Given some Consumables
        Consumable salad    = new Consumable("Salad");
        Consumable barbecue = new Consumable("Barbecue");
        Consumable wine     = new Consumable("Wine");
        Consumable grenadine= new Consumable("Grenadine");
        Consumable cheese   = new Consumable("Cheese ");
        // and some attendees who pay
        MeetingAttendee hache = new MeetingAttendee("Hache");
        hache.pay(20D, salad);
        hache.pay(100D, barbecue);
        hache.pay(30D, wine);

        MeetingAttendee sol = new MeetingAttendee("Sol");
        sol.pay(10D, salad);
        sol.pay(0D, barbecue);
        sol.pay(30D, cheese);
        sol.pay(30D, grenadine);

        MeetingAttendee leo = new MeetingAttendee("Leo");
        leo.pay(0D, salad);
        leo.pay(0D, cheese);
        leo.pay(0D, grenadine);

        hache.updateAttendee();
        sol.updateAttendee();
        leo.updateAttendee();

        // then hache's totalCostPaid should be 150.0
        assertEquals(150D, hache.totalCostPaid());
        // then hache's totalCost should be 90.0
        assertEquals(90D, hache.getTotalCost());
        // then hache's finalCost should be -60.0
        assertEquals(-60D, hache.getFinalCost());

        // then sol's totalCostPaid should be 150.0
        assertEquals(70D, sol.totalCostPaid());
        // then sol's totalCost should be 90.0
        assertEquals(90D, sol.getTotalCost());
        // then sol's finalCost should be -60.0
        assertEquals(20D, sol.getFinalCost());

        // then leo's totalCostPaid should be 150.0
        assertEquals(0D, leo.totalCostPaid());
        // then leo's totalCost should be 90.0
        assertEquals(40D, leo.getTotalCost());
        // then leo's finalCost should be -60.0
        assertEquals(40D, leo.getFinalCost());
    }
}
