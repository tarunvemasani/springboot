package com.example.basicapp;

import com.example.submission.SubmissionForm;
import com.example.submission.SubmissionInterface;
import com.example.submission.SubmissionRepository;
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
import static org.mockito.Mockito.*;

@SpringBootTest
public class SubmissionServiceTest {

    @Mock
    private SubmissionRepository submissionRepository;

    @InjectMocks
    private SubmissionService submissionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostSubmission() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setName("John");

        when(submissionRepository.postSubmission(submissionForm)).thenReturn(submissionForm);

        SubmissionForm result = submissionService.postSubmission(submissionForm);

        assertEquals(submissionForm, result);
        verify(submissionRepository, times(1)).postSubmission(submissionForm);
    }

    @Test
    public void testGetSubmissionFormById() {
        String id = "12345";
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setId(id);

        when(submissionRepository.getSubmissionFormById(id)).thenReturn(submissionForm);

        SubmissionForm result = submissionService.getSubmissionFormById(id);

        assertEquals(submissionForm, result);
        verify(submissionRepository, times(1)).getSubmissionFormById(id);
    }

    @Test
    public void testGetAllSubmissions() {
        List<SubmissionForm> submissionForms = new ArrayList<>();
        submissionForms.add(new SubmissionForm());
        submissionForms.add(new SubmissionForm());

        when(submissionRepository.getallSubmissions()).thenReturn(submissionForms);

        List<SubmissionForm> result = submissionService.getallSubmissions();

        assertEquals(submissionForms, result);
        verify(submissionRepository, times(1)).getallSubmissions();
    }

    @Test
    public void testEditSubmission() {
        SubmissionForm submissionForm = new SubmissionForm();
        submissionForm.setId("12345");
        submissionForm.setName("John");

        when(submissionRepository.editSubmission(submissionForm)).thenReturn(submissionForm);

        SubmissionForm result = submissionService.editSubmission(submissionForm);

        assertEquals(submissionForm, result);
        verify(submissionRepository, times(1)).editSubmission(submissionForm);
    }

    @Test
    public void testDeleteSubmission() {
        String id = "12345";
        List<SubmissionForm> submissionForms = new ArrayList<>();
        submissionForms.add(new SubmissionForm());

        when(submissionRepository.deleteSubmission(id)).thenReturn(submissionForms);

        List<SubmissionForm> result = submissionService.deleteSubmission(id);

        assertEquals(submissionForms, result);
        verify(submissionRepository, times(1)).deleteSubmission(id);
    }
}

