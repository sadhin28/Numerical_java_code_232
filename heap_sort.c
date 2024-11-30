#include <stdio.h>

int main() {
    int n, i, j, temp;

    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];

    printf("Enter elements: ");
    for (i = 0; i < n; i++) scanf("%d", &arr[i]);

    // Build heap
    for (i = n / 2 - 1; i >= 0; i--)
        for (j = i; 2 * j + 1 < n;) {
            int child = 2 * j + 1;
            if (child + 1 < n && arr[child] < arr[child + 1]) child++;
            if (arr[j] < arr[child]) {
                temp = arr[j];
                arr[j] = arr[child];
                arr[child] = temp;
                j = child;
            } else break;
        }

    // Sort heap
    for (i = n - 1; i > 0; i--) {
        temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        for (j = 0; 2 * j + 1 < i;) {
            int child = 2 * j + 1;
            if (child + 1 < i && arr[child] < arr[child + 1]) child++;
            if (arr[j] < arr[child]) {
                temp = arr[j];
                arr[j] = arr[child];
                arr[child] = temp;
                j = child;
            } else break;
        }
    }

    printf("Sorted array: ");
    for (i = 0; i < n; i++) printf("%d ", arr[i]);
    return 0;
}
