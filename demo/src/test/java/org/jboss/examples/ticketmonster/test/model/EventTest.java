package org.jboss.examples.ticketmonster.model;

import org.junit.Test;
import org.junit.Assert;

public class EventTest {

    @Test
    public void testGetId() {
        Event event = new Event();
        event.setId(1L);
        Long expected = 1L;
        Assert.assertEquals(expected, event.getId());
    }
}
