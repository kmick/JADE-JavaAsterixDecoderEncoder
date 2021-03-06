/* 
* Created by dan-geabunea on 4/27/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.asterix.cat062.item380;

import jlg.jade.asterix.AsterixItemLength;
import jlg.jade.asterix.FixedLengthAsterixData;
import jlg.jade.common.Constants;

/**
 * Item 380 Subfield #3 - Magnetic Heading
 * Unit of measure: 360° / 2^16 (0.0055 degrees)
 */
public class Item380Subfield3 extends FixedLengthAsterixData {
    private int magneticHeading;

    @Override
    protected int setSizeInBytes() {
        return AsterixItemLength.TWO_BYTES.getValue();
    }

    @Override
    protected void decodeFromByteArray(byte[] input, int offset) {
        this.magneticHeading =
                Byte.toUnsignedInt(input[offset]) * 256 +
                Byte.toUnsignedInt(input[offset+1]);

        appendItemDebugMsg("Magnetic heading", this.magneticHeading);
        appendItemDebugMsg("Magnetic heading (deg)", this.getMagneticHeadingDegrees());
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected String setDisplayName() {
        return "Item380Subfield3 - Magnetic Heading";
    }

    /**
     * Get magnetic heading in Asterix unit of measure
     */
    public int getMagneticHeading() {
        return magneticHeading;
    }

    /**
     * Get the magnetic heading converted in integer degrees
     */
    public int getMagneticHeadingDegrees() {
        return (int) (this.magneticHeading * Constants.FROM_ASTERIX_MAGENTIC_HEADING_TO_DEGREES);
    }
}
