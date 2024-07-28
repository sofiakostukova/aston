package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0, 56);
        Collections.addAll(scores,  35, 86, 65, 9, 0, 91, 85, 76);

        ArrayList<Integer> additionalScores = new ArrayList<>();
        Collections.addAll(additionalScores, 12, 99, 48, 74, 23, 33);

        scores.addAll(additionalScores);
        additionalScores.clear();

        try {
            if (!scores.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(scores.size());

                scores.remove(randomIndex);
                scores.remove(0);

                System.out.println("Unsorted list:              " + scores);
                ArrayList<Integer> sortedUsingCollections = new ArrayList<>(scores);
                Collections.sort(sortedUsingCollections);
                System.out.println("Sorted list (method sort()):" + sortedUsingCollections);
                quickSort(scores, 0, scores.size() - 1);
                System.out.println("Sorted list (quicksort):    " + scores);
            } else {
                System.out.println("The list is empty!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Attempted to access an index that is out of bounds.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void quickSort(ArrayList<Integer> score, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(score, low, high);
            quickSort(score, low, pivotIndex - 1);
            quickSort(score, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> score, int low, int high) {
        int middle = low + (high - low) / 2;
        int pivot = score.get(middle);
        int temp = score.get(middle);
        score.set(middle, score.get(high));
        score.set(high, temp);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ( score.get(j) < pivot) {
                i++;
                Collections.swap(score, i, j);
            }
        }
        Collections.swap(score, i + 1, high);
        return i + 1;
    }
}
