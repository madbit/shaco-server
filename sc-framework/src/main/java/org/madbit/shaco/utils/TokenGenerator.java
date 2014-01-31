package org.madbit.shaco.utils;

import java.math.BigInteger;
import java.util.UUID;

public class TokenGenerator {
	
	private static final Double MIN_LONG = -9223372036854775808.00; // -2 to the power of 63
	private static final BigInteger SHIFT_VALUE = BigInteger.valueOf(MIN_LONG.longValue()).abs();

	/**
	 * Generate a random id of 64bit length
	 * @return id
	 */
	public static BigInteger generateId() {
		/*
		 * UUID uses 128 bits but we only require 64bits.
		 * Thus, the most significant bits are chosen (arbitrarily) for now.
		 * Should this create collisions, something else can be used.
		 *
		 */
		BigInteger uuid = BigInteger.valueOf(UUID.randomUUID().getMostSignificantBits()); // get 64bits out of the 128bits returned by UUID
																						  // (arbitrarily choosing the most significant bits)
		return uuid.add(SHIFT_VALUE); //shifting uuid to turn it from an signed 64bits to unsigned 64bit value.
	}
	
	public static int generateIntId() {
				
		return UUID.randomUUID().hashCode();
	}
}
