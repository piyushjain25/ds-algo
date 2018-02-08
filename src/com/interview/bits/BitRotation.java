package com.interview.bits;

/* Bit Rotation: A rotation (or circular shift) is an operation similar to shift except that the bits that fall off at one end are put back to the other end.
 * In left rotation, the bits that fall off at left end are put back at right end.
 * In right rotation, the bits that fall off at right end are put back at left end.
 * 
 * http://www.geeksforgeeks.org/rotate-bits-of-an-integer/
 */
public class BitRotation {

    public byte rotateLeft(byte num, int d){
        return (byte)((num << d) | (num >>> (8-d)));
    }
    
    public static void main(String args[]){
        BitRotation br = new BitRotation();
        System.out.println(br.rotateLeft((byte)28, 2));
    }
}
