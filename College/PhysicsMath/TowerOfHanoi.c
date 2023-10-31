// Move the disk 1 from S to D
// Move the disk 2 from S to A
// Move the disk 1 from D to A
// Move the disk 3 from S to D
// Move the disk 1 from A to S
// Move the disk 2 from A to D
// Move the disk 1 from S to D

#include <stdio.h>

// Assuming n-th disk is the bottom disk (count down)
void tower(int n, char sourcePole, char destinationPole, char auxiliaryPole)
{
    // Base case (termination condition)
    if (n == 0)
        return;

    // Move first n-1 disks from source pole
    // to auxiliary pole using destination as
    // temporary pole
    tower(n - 1, sourcePole, auxiliaryPole, destinationPole);

    // Move the remaining disk from source
    // pole to destination pole
    printf("Move the disk %d from %c to %c\n", n, sourcePole, destinationPole);

    // Move the n-1 disks from auxiliary (now
    // source) pole to destination pole using
    // source pole as temporary (auxiliary)
    // pole
    tower(n - 1, auxiliaryPole, destinationPole, sourcePole);
}

int main()
{
    tower(3, 'S', 'D', 'A');
    return 0;
}
