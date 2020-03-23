import math


def slash_pattern(num):

    # different number of spaces to be printed

    # the number of spaces to be printed in a line before printing any non whitespace characters
    spaces1 = num * 2

    # spaces between back slash and forward slash
    spaces2 = 1

    # number of spaces between 2 numbers
    spaces3 = -1

    # refers to the number that will be printed
    c = 1

    # counter will be run num times and each run it will print 2 * num lines, last line will be printed outside this
    # loop
    k = 0

    while k < num:

        # number of spaces to be left before printing information on line
        print(" " * spaces1, end="")

        # printing first line, first line will always be 1, 1 will be the only number on that line
        if k == 0:
            print(c)

        else:
            print(c, end="")

            # printing spaces between 2 numbers
            print(" " * (spaces3 - 1), end="")

            if c < 10:
                print(end=" ")

            c += 1
            print(c)

        # Printing slashes after digits have been printed on previous line

        # printing spaces and forward slash followed by spaces
        print(" " * (spaces1 - 1), end="/")

        # printing spaces and back slash followed by spaces
        print(" " * spaces2, end="\\")

        print()

        k += 1
        c += 1

        spaces2 += 4
        spaces1 -= 2
        spaces3 += 4

    print(" " * spaces1, end="")

    # printing last row
    for i in range(num + 1):

        print(c + i, end="")

        # number of dashes between digits, fewer dashes for larger numbers
        n = 3 - int(math.log(c + i, 10))

        if i < num:
            print('-' * n, end="")


for _ in range(30, 31):
    slash_pattern(_)
    print()
