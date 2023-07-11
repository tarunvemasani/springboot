package com.example.basicapp;

import com.example.submission.SubmissionForm;
import com.example.submission.SubmissionInterface;
import com.example.submission.SubmissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SubmissionRepositoryTest {

    private SubmissionInterface submissionRepository;

    @BeforeEach
    public void setup() {
        submissionRepository = new SubmissionRepository();
    }

    @Test
    public void testPostSubmission() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");
        submissionForm.setVendorName("Example Vendor");
        submissionForm.setRate(5);

        SubmissionForm result = submissionRepository.postSubmission(submissionForm);

        assertNotNull(result.getId());
        assertEquals("John", result.getName());
        assertEquals("Example Vendor", result.getVendorName());
        assertEquals(5, result.getRate());
    }

    @Test
    public void testGetSubmissionFormById_existingId() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");
        submissionForm.setVendorName("Example Vendor");
        submissionForm.setRate(5);
        SubmissionForm savedForm = submissionRepository.postSubmission(submissionForm);

        SubmissionForm result = submissionRepository.getSubmissionFormById(savedForm.getId());

        assertNotNull(result);
        assertEquals(savedForm.getId(), result.getId());
        assertEquals("John", result.getName());
        assertEquals("Example Vendor", result.getVendorName());
        assertEquals(5, result.getRate());
    }

    @Test
    public void testGetSubmissionFormById_invalidId() {
        SubmissionForm result = submissionRepository.getSubmissionFormById("invalidId");

        assertNull(result);
    }

    @Test
    public void testGetAllSubmissions() {
        SubmissionForm submissionForm1 = new SubmissionForm();
        submissionForm1.setName("John");
        submissionForm1.setVendorName("Vendor 1");
        submissionForm1.setRate(5);
        SubmissionForm savedForm1 = submissionRepository.postSubmission(submissionForm1);

        SubmissionForm submissionForm2 = new SubmissionForm();
        submissionForm2.setName("Alice");
        submissionForm2.setVendorName("Vendor 2");
        submissionForm2.setRate(4);
        SubmissionForm savedForm2 = submissionRepository.postSubmission(submissionForm2);

        List<SubmissionForm> result = submissionRepository.getallSubmissions();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(savedForm1));
        assertTrue(result.contains(savedForm2));
    }

    @Test
    public void testEditSubmission_existingId() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");
        submissionForm.setVendorName("Example Vendor");
        submissionForm.setRate(5);
        SubmissionForm savedForm = submissionRepository.postSubmission(submissionForm);

        savedForm.setName("Updated Name");
        savedForm.setVendorName("Updated Vendor");
        savedForm.setRate(3);

        SubmissionForm result = submissionRepository.editSubmission(savedForm);

        assertNotNull(result);
        assertEquals(savedForm.getId(), result.getId());
        assertEquals("Updated Name", result.getName());
        assertEquals("Updated Vendor", result.getVendorName());
        assertEquals(3, result.getRate());
    }

    @Test
    public void testEditSubmission_invalidId() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setId("invalidId");

        SubmissionForm result = submissionRepository.editSubmission(submissionForm);

        assertNotNull(result);
    }

    @Test
    public void testDeleteSubmission_existingId() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");
        submissionForm.setVendorName("Example Vendor");
        submissionForm.setRate(5);
        SubmissionForm savedForm = submissionRepository.postSubmission(submissionForm);

        List<SubmissionForm> result = submissionRepository.deleteSubmission(savedForm.getId());

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testDeleteSubmission_invalidId() {
        List<SubmissionForm> result = submissionRepository.deleteSubmission("invalidId");

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
