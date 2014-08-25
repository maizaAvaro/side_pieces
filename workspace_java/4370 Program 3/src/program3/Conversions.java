package program3;

import java.nio.ByteBuffer;

/*******************************************************************************
 * @file  Conversions.java
 *
 */

/*******************************************************************************
 * This class provides methods for converting Java's primitive data types into
 * byte arrays.
 */
public class Conversions
{
    /***************************************************************************
     * Convert short into a byte array.
     * @param value  the short value to convert
     * @return  a corresponding byte array
     */
    public static byte [] short2ByteArray (short value)
    {
    	byte[] b = new byte[2];
        ByteBuffer.wrap(b).putShort(value);
        return b;
    } // short2ByteArray

    /***************************************************************************
     * Convert int into a byte array.
     * @param value  the int value to convert
     * @return  a corresponding byte array
     */
    public static byte [] int2ByteArray (int value)
    {
    	byte[] b = new byte[4];
        ByteBuffer.wrap(b).putInt(value);
        return b;
    } // int2ByteArray

    /***************************************************************************
     * Convert long into a byte array.
     * @param value  the long value to convert
     * @return  a corresponding byte array
     */
    public static byte [] long2ByteArray (long value)
    {
    	byte[] b = new byte[8];
        ByteBuffer.wrap(b).putLong(value);
        return b;
    } // long2ByteArray

    /***************************************************************************
     * Convert float into a byte array.
     * @param value  the float value to convert
     * @return  a corresponding byte array
     */
    public static byte [] float2ByteArray (float value)
    {
    	byte[] b = new byte[4];
        ByteBuffer.wrap(b).putFloat(value);
        return b;
    } // float2ByteArray

    /***************************************************************************
     * Convert double into a byte array.
     * @param value  the double value to convert
     * @return  a corresponding byte array
     */
    public static byte [] double2ByteArray (double value)
    {
    	byte[] b = new byte[8];
        ByteBuffer.wrap(b).putDouble(value);
        return b;
    } // double2ByteArray
    
    /**
     * Converts a byte array back to a short primitive type
     * @param b - the byte array
     * @return - the short primitive type
     */
    public static Short byteArray2Short (byte [] b)
    {
    	return ByteBuffer.wrap(b).getShort();
    } // byteArray2Short
    
    /**
     * Converts a byte array back to an int primitive type
     * @param b - the byte array
     * @return - the int primitive type
     */
    public static int byteArray2Int (byte [] b)
    {
    	//for(int i=0; i<b.length; ++i)
    	//	System.out.println(b[i]);
    	
    	return ByteBuffer.wrap(b).getInt();
    } // byteArray2Int
    
    /**
     * Converts a byte array back to a float primitive type
     * @param b - the byte array
     * @return - the float primitive type
     */
    public static float byteArray2Float (byte [] b)
    {
    	return ByteBuffer.wrap(b).getFloat();
    } // byteArray2Float
    
    /**
     * Converts a byte array back to a long primitive type
     * @param b - the byte array
     * @return - the long primitive type
     */
    public static long byteArray2Long (byte [] b)
    {
    	return ByteBuffer.wrap(b).getLong();
    } // byteArray2Long
    
    /**
     * Converts a byte array back to a double primitive type
     * @param b - the byte array
     * @return - the double primitive type
     */
    public static double byteArray2Double(byte [] b)
    {
    	return ByteBuffer.wrap(b).getDouble();
    } // byteArray2Double
    
    /**
     * Converts a char to a byte array
     * @param value - the char value
     * @return - a byte array
     */
    public static byte [] char2ByteArray(char value)
    {
    	byte[] b = new byte[2];
        ByteBuffer.wrap(b).putChar(value);
        return b;
    } // char2ByteArray
    
    /**
     * Converts a byte array back to a char primitive type
     * @param b - the byte array
     * @return - the char primitive type
     */
    public static char byteArray2Char(byte [] b)
    {
    	return ByteBuffer.wrap(b).getChar();
    } // byteArray2Char

} // Conversions

