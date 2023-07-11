package com.example.basicapp;

import com.example.submission.SubmissionForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubmissionFormTest {

    @Test
    public void testGetId() {
        SubmissionForm form = new SubmissionForm();
        form.setId("12345");

        String result = form.getId();

        assertEquals("12345", result);
    }

    @Test
    public void testSetId() {
        SubmissionForm form = new SubmissionForm();
        form.setId("12345");

        assertEquals("12345", form.Id);
    }

    @Test
    public void testDefaultValues() {
        SubmissionForm form = new SubmissionForm();

        assertNull(form.Name);
        assertNull(form.getId());
        assertNull(form.VendorName);
        assertEquals(0, form.rate);
        assertNull(form.leadName);
        assertNull(form.Technology);
    }
}
