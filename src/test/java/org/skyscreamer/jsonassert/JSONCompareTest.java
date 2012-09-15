package org.skyscreamer.jsonassert;

import static org.junit.Assert.assertTrue;
import static org.skyscreamer.jsonassert.JSONCompare.compareJSON;
import static org.skyscreamer.jsonassert.JSONCompareMode.LENIENT;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

import org.json.JSONException;
import org.junit.Test;

/**
 * Unit tests for {@code JSONCompare}.
 */
public class JSONCompareTest {
    @Test
    public void missingExpectedKey() throws JSONException {
        JSONCompareResult result = compareJSON("{\"name\":\"Sue\"}", "{}", LENIENT);
        assertTrue(result.getMissingFields().iterator().next().equals("name"));
    }

    @Test
    public void unexpectedKey() throws JSONException {
        JSONCompareResult result = compareJSON("{}", "{\"name\":\"Sue\"}", STRICT);
        assertTrue(result.getUnexpectedFields().iterator().next().equals("name"));
    }
}
