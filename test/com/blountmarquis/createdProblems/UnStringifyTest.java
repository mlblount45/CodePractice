package com.blountmarquis.createdProblems;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Created by mlblount on 8/30/16.
 */
public class UnStringifyTest {

  @Test
  public void whenStringIsNullThenReturnEmptyString() {
    assertStringIsUnStringified(null, "");
  }

  @Test
  public void whenStringIsEmptyThenReturnEmptyString() {
    assertStringIsUnStringified("", "");
  }

  @Test
  public void whenStringIsValidReturnUnStringified() {
    assertStringIsUnStringified("Hello", "Hello");
  }

  @Test
  public void standingStringToConvertAsNeeded() {
    assertStringIsUnStringified(
        "select max(timestamp) as lastDetect, count(timestamp) as detectCount " +
            "from write " +
            "where docType is not missing " +
            "AND docType = 'beaconDetectRecord' " +
            "AND beacon.proximityUUID = $uuid " +
            "AND beacon.major = $major " +
            "AND beacon.minor = $minor " +
            "AND timestamp BETWEEN $startTime AND $endTime " +
            "ORDER BY timestamp desc limit 1 ",
        "select max(timestamp) as lastDetect, count(timestamp) as detectCount " +
            "from write " +
            "where docType is not missing " +
            "AND docType = 'beaconDetectRecord' " +
            "AND beacon.proximityUUID = $uuid " +
            "AND beacon.major = $major " +
            "AND beacon.minor = $minor " +
            "AND timestamp BETWEEN $startTime AND $endTime " +
            "ORDER BY timestamp desc limit 1 ");
  }

  private void assertStringIsUnStringified(String s, String result) {
    assertEquals(result, UnStringify.remove(s));
    System.out.println(UnStringify.remove(s));
  }

}