#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)
            return mid;         // Target found
        else if (arr[mid] < target)
            left = mid + 1;     // Search in the right half
        else
            right = mid - 1;    // Search in the left half
    }
    return -1;                  // Target not found
}

// Function to sort the array (bubble sort)
void sortArray(int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int size, target;

    printf("Enter the number of elements: ");
    scanf("%d", &size);

    int arr[size];
    printf("Enter %d elements: ", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    // Sort the array
    sortArray(arr, size);

    printf("Enter the element to search: ");
    scanf("%d", &target);

    int result = binarySearch(arr, size, target);
    if (result != -1)
        printf("Element found at index %d (in sorted array)\n", result);
    else
        printf("Element not found\n");

    return 0;
}
