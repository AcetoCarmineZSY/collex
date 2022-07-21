package fr.uvsq.cprog.usestreams;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ServiceTest {
    @Test
    public void testString() {
        assertEquals("SERVICE_ONE(ONE,adrONE) ", Service.SERVICE_ONE.toString());
    }
}
