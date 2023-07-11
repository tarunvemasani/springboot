package com.example.basicapp;

import com.example.submission.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private service exampleService;

    @BeforeEach
    public void setup() {
        exampleService = new service();
    }

    @Test
    public void testGetAllData() {
        List<String> result = exampleService.getAllData();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetDataById_existingId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        String result = exampleService.getDataById(1);

        assertNotNull(result);
        assertEquals("Data 2", result);
    }

    @Test
    public void testGetDataById_invalidId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        String result = exampleService.getDataById(5);

        assertNull(result);
    }

    @Test
    public void testAddData() {
        exampleService.addData("New Data");

        List<String> result = exampleService.getAllData();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("New Data", result.get(0));
    }

    @Test
    public void testUpdateData_existingId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        exampleService.updateData(1, "Updated Data");

        List<String> result = exampleService.getAllData();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Data 1", result.get(0));
        assertEquals("Updated Data", result.get(1));
    }

    @Test
    public void testUpdateData_invalidId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        exampleService.updateData(5, "Updated Data");

        List<String> result = exampleService.getAllData();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Data 1", result.get(0));
        assertEquals("Data 2", result.get(1));
    }

    @Test
    public void testDeleteData_existingId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        exampleService.deleteData(1);

        List<String> result = exampleService.getAllData();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Data 1", result.get(0));
    }

    @Test
    public void testDeleteData_invalidId() {
        exampleService.addData("Data 1");
        exampleService.addData("Data 2");

        exampleService.deleteData(5);

        List<String> result = exampleService.getAllData();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Data 1", result.get(0));
        assertEquals("Data 2", result.get(1));
    }
}
