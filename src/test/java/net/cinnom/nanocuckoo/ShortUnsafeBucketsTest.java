/*
 * Copyright 2017 Randall Jones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.cinnom.nanocuckoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * ShortUnsafeBuckets tests.
 */
public class ShortUnsafeBucketsTest {

	@Test
	public void multiEntriesBucketsTest() {

		final int entries = 4;
		final long buckets = 32;
		final boolean counting = false;

		final ShortUnsafeBuckets shortUnsafeBuckets = new ShortUnsafeBuckets( entries, buckets, counting, 0 );

		for ( int e = 0; e < entries; e++ ) {
			for ( int b = 0; b < buckets; b++ ) {

				int value = ( 23 + e * b );
				shortUnsafeBuckets.putValue( e, b, value );
				Assert.assertEquals( value, shortUnsafeBuckets.getValue( e, b ) );
			}
		}

		shortUnsafeBuckets.close();
	}
}
