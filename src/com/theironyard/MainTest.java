package com.theironyard;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Ben on 5/25/16.
 */
public class MainTest {

    static final String TEST_FILE = "test.json";
    @Test
    public void saveAndLoad() {
        Specs specs = new Specs();
        specs.brand = "Test Brand";
        specs.screen = 1.1;
        specs.weight = 1.2;
        specs.OS = "Test OS";
        specs.year = 2000;

        Main.saveSpecs(specs, TEST_FILE);
        Specs newSpecs = Main.loadSpecs(TEST_FILE);

        File f = new File(TEST_FILE);
        f.delete();

        assertTrue(newSpecs != null);
        assertTrue(newSpecs.brand.equals(specs.brand));
        assertTrue(newSpecs.screen == (specs.screen));
        assertTrue(newSpecs.weight == (specs.weight));
        assertTrue(newSpecs.OS.equals(specs.OS));
        assertTrue(newSpecs.year == specs.year);

    }
}