package hachedeeme.jodamanager.modelTest;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import hachedeeme.jodamanager.model.Payment;

/**
 * Created by Hache on 02/03/2015.
 */
public class TestPayment extends TestCase {
    private Payment payment;

    @Override
    protected void setUp() throws Exception {
        this.payment = new Payment(50D);
    }

    @SmallTest
    public void testCostPaidIs50(){
        assertEquals(50D,payment.getCostPaid());
    }
}
