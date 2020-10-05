int main()
{
    int a[5] = { 1, 3, 5, 6 };

    ShiftRight(a, 3, 2);
}

void ShiftRight(int *a, int pos, int final)
{
    int final_minus_one = final - 1;

    int i = final_minus_one;

    while (i >= pos)
    {
        a[i + 1] = a[i];

        i--;
    }
}