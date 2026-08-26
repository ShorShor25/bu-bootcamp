#include <stdio.h>

void swap(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

void broken_swap(int x, int y) {
    int temp = x;
    x = y;
    y = temp;
}

int main() {
    int a = 10;
    int b = 20;
    printf("Before swap: a = %d, b = %d\n", a, b);
    swap(&a, &b);
    printf("After swap: a = %d, b = %d\n", a, b);
    /* Demonstrate broken swap */
    printf("Before swap: a = %d, b = %d\n", a, b);
    broken_swap(a, b);
    printf("After broken swap: a = %d, b = %d\n", a, b);
    return 0;
}