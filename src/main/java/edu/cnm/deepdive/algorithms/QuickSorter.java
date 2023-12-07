/*
 *  Copyright 2023 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.algorithms;

import java.util.Random;

public class QuickSorter implements Sorter {

  private final Random rng = new Random();

  @Override
  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  private void sort(int[] data, int fromIndex, int toIndex) {

    if (toIndex > fromIndex + 1) {

      int pivotIndex = rng.nextInt(toIndex - fromIndex) + fromIndex;
      int pivotValue = data[pivotIndex];

      data[pivotIndex] = data[fromIndex];
      data[fromIndex] = pivotValue;

      int destinationIndex = fromIndex + 1;

      for (int currentIndex = fromIndex + 1; currentIndex < toIndex; currentIndex++) {

        int currentValue = data[currentIndex];

        if (currentValue <= pivotValue) {

          if (currentIndex > destinationIndex) {
            data[currentIndex] = data[destinationIndex];
            data[destinationIndex] = currentValue;
          }

          destinationIndex++;

        }

      }

      data[fromIndex] = data[destinationIndex - 1];
      data[destinationIndex - 1] = pivotValue;

      sort(data, fromIndex, destinationIndex - 1);
      sort(data, destinationIndex, toIndex);

    }
  }

}
