package com.example.basicapp;

import com.example.submission.SubmissionForm;
import com.example.submission.SubmissionInterface;
import com.example.submission.SubmissionResource;
import com.example.submission.SubmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SubmissionResourceTest {

    @Mock
    private SubmissionService submissionService;

    @InjectMocks
    private SubmissionResource submissionResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostSubmission() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");

        when(submissionService.postSubmission(submissionForm)).thenReturn(submissionForm);

        SubmissionForm result = submissionResource.postSubmission(submissionForm);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(submissionService, times(1)).postSubmission(submissionForm);
    }

    @Test
    public void testGetSubmissionFormById() {
        String id = "12345";
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setId(id);
        submissionForm.setName("John");

        when(submissionService.getSubmissionFormById(id)).thenReturn(submissionForm);

        SubmissionForm result = submissionResource.getSubmissionFormById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("John", result.getName());
        verify(submissionService, times(1)).getSubmissionFormById(id);
    }

    @Test
    public void testGetAllSubmissions() {
        List<SubmissionForm> submissionForms = new ArrayList<>();
        submissionForms.add(new SubmissionForm());
        submissionForms.add(new SubmissionForm());

        when(submissionService.getallSubmissions()).thenReturn(submissionForms);

        List<SubmissionForm> result = submissionResource.getallSubmissions();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(submissionService, times(1)).getallSubmissions();
    }

    @Test
    public void testEditSubmission() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setId("12345");
        submissionForm.setName("John");

        when(submissionService.editSubmission(submissionForm)).thenReturn(submissionForm);

        SubmissionForm result = submissionResource.editSubmission(submissionForm);

        assertNotNull(result);
        assertEquals("12345", result.getId());
        assertEquals("John", result.getName());
        verify(submissionService, times(1)).editSubmission(submissionForm);
    }

    @Test
    public void testDeleteSubmission() {
        String id = "12345";
        List<SubmissionForm> submissionForms = new ArrayList<>();
        submissionForms.add(new SubmissionForm());

        when(submissionService.deleteSubmission(id)).thenReturn(submissionForms);

        List<SubmissionForm> result = submissionResource.deleteSubmission(id);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(submissionService, times(1)).deleteSubmission(id);
    }
}
