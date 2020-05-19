package com.newrelic.jfr.tosummary;

import jdk.jfr.consumer.RecordedEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LongSummarizerTest {

    @Test
    void testAccept() {
        RecordedEvent ev = mock(RecordedEvent.class);

        String fieldName = "theGoodData";
        when(ev.getLong(fieldName)).thenReturn(11L, 12L);

        LongSummarizer testClass = new LongSummarizer(fieldName);
        testClass.accept(ev);
        testClass.accept(ev);

        assertEquals(2, testClass.getCount());
        assertEquals(23, testClass.getSum());
        assertEquals(11, testClass.getMin());
        assertEquals(12, testClass.getMax());
    }

    @Test
    void testDefaultState() {
        RecordedEvent ev = mock(RecordedEvent.class);

        String fieldName = "theGoodData";

        LongSummarizer testClass = new LongSummarizer(fieldName);

        assertEquals(0, testClass.getCount());
        assertEquals(0, testClass.getSum());
        assertEquals(Long.MAX_VALUE, testClass.getMin());
        assertEquals(Long.MIN_VALUE, testClass.getMax());
    }

    @Test
    void testReset() {
        RecordedEvent ev = mock(RecordedEvent.class);

        String fieldName = "theGoodData";
        when(ev.getLong(fieldName)).thenReturn(101L, 102L);

        LongSummarizer testClass = new LongSummarizer(fieldName);
        testClass.accept(ev);
        testClass.reset();
        testClass.accept(ev);

        assertEquals(1, testClass.getCount());
        assertEquals(102, testClass.getSum());
        assertEquals(102, testClass.getMin());
        assertEquals(102, testClass.getMax());
    }
}