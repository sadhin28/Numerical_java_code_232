#include <stdio.h>
#include <stdlib.h>

// Function to calculate the SCAN Disk Scheduling
void scanDiskScheduling(int requests[], int n, int head, int diskSize) {
    int totalMovement = 0;
    int i, j;

    // Sort the requests array
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (requests[j] > requests[j + 1]) {
                int temp = requests[j];
                requests[j] = requests[j + 1];
                requests[j + 1] = temp;
            }
        }
    }

    // Print the track movements
    printf("\nTrack movements of R/W head:\n");
    printf("Initial Head Position: %d\n", head);

    // Move from right to left (downward) and service requests
    int currentIndex = 0;
    while (currentIndex < n && requests[currentIndex] < head) {
        currentIndex++;
    }

    // Move downward and service requests
    for (i = currentIndex - 1; i >= 0; i--) {
        printf("Moved from %d to %d (distance: %d)\n", head, requests[i], abs(head - requests[i]));
        totalMovement += abs(head - requests[i]);
        head = requests[i];
    }
    
    // If the head doesn't stop at the first track, go to the start of the disk (0)
    if (head != 0) {
        printf("Moved from %d to 0 (distance: %d)\n", head, abs(head - 0));
        totalMovement += abs(head - 0);
        head = 0;
    }

    // Now, move to the right (upward) and service the remaining requests
    for (i = currentIndex; i < n; i++) {
        printf("Moved from %d to %d (distance: %d)\n", head, requests[i], abs(head - requests[i]));
        totalMovement += abs(head - requests[i]);
        head = requests[i];
    }

    // Print the total head movement
    printf("\nTotal head movement in cylinders: %d\n", totalMovement);
}

int main() {
    int requests[] = {98, 137, 122, 183, 14, 133, 65, 78};
    int n = sizeof(requests) / sizeof(requests[0]);
    int head = 54;
    int diskSize = 200;  // You can adjust this as needed for your disk size

    printf("Request queue: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", requests[i]);
    }
    printf("\nDisk size: %d\nInitial head position: %d\n", diskSize, head);

    // Call SCAN Disk Scheduling Function
    scanDiskScheduling(requests, n, head, diskSize);

    return 0;
}
