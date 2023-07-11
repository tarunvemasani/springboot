package com.example.basicapp;

import com.example.submission.dependency;
import com.example.submission.service;
import org.apache.catalina.Service;
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
public class DependencyTest {

    @Mock
    private service exampleService;

    @InjectMocks
    private com.example.submission.dependency dependency;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllData() {
        List<String> expectedData = new ArrayList<>();
        expectedData.add("Data 1");
        expectedData.add("Data 2");

        when(exampleService.getAllData()).thenReturn(expectedData);

        List<String> result = dependency.getAllData();

        assertEquals(expectedData, result);
        verify(exampleService, times(1)).getAllData();
    }

    @Test
    public void testGetDataById() {
        int id = 1;
        String expectedData = "Data 1";

        when(exampleService.getDataById(id)).thenReturn(expectedData);

        String result = dependency.getDataById(id);

        assertEquals(expectedData, result);
        verify(exampleService, times(1)).getDataById(id);
    }

    @Test
    public void testAddData() {
        String data = "New Data";

        dependency.addData(data);

        verify(exampleService, times(1)).addData(data);
    }

    @Test
    public void testUpdateData() {
        int id = 1;
        String data = "Updated Data";

        dependency.updateData(id, data);

        verify(exampleService, times(1)).updateData(id, data);
    }

    @Test
    public void testDeleteData() {
        int id = 1;

        dependency.deleteData(id);

        verify(exampleService, times(1)).deleteData(id);
    }
}
