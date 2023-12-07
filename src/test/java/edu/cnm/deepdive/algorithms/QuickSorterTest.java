package edu.cnm.deepdive.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSorterTest {

  QuickSorter sorter;
  Random rng;
  int[] data;

  @BeforeEach
  void setUp() {
    rng = new Random();
    data = IntStream.generate(rng::nextInt)
        .limit(10_000_000)
        .toArray();
    sorter = new QuickSorter();
  }

  @Test
  void sort() {
    sorter.sort(data);
    //noinspection ResultOfMethodCallIgnored
    IntStream.of(data)
        .reduce(Integer.MIN_VALUE, (a, b) -> {
          if (a > b) {
            fail();
          }
          return b;
        });
  }

}