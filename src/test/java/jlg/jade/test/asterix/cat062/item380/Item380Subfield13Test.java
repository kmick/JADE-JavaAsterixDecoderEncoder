/* 
* Created by dan-geabunea on 4/29/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062.item380;

import jlg.jade.asterix.cat062.item380.Item380Subfield13;
import jlg.jade.test.utils.MandatoryFixedLengthAsterixTests;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Item380Subfield13Test extends MandatoryFixedLengthAsterixTests<Item380Subfield13> {
    @Override
    protected int setExpectedItemSizeInBytes() {
        return 2;
    }

    @Override
    protected Item380Subfield13 setFixedLengthAsterixDataInstance() {
        return new Item380Subfield13();
    }

    @Test
    @Parameters({"0,10,10", "255,255,-1"})
    public void the_decode_method_should_correctly_decode_data(int firstOctet, int secondOctet, int expected) {
        //arrange
        byte[] input = {(byte) firstOctet, (byte) secondOctet};
        int offset = 0;
        Item380Subfield13 subfield = new Item380Subfield13();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertEquals("Barometric vertical rate not decoded correctlt", expected, subfield.getBarometricVerticalRate());
    }

    @Test
    public void the_decode_method_should_set_valid_flag_to_true() {
        //arrange
        byte[] input = {0, 10};
        int offset = 0;
        Item380Subfield13 subfield = new Item380Subfield13();

        //act
        subfield.decode(input, offset, input.length);

        //assert
        assertTrue(subfield.isValid());
    }
}
