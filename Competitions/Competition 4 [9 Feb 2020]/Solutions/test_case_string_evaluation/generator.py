import numpy
n = 1000000

f = open("input.txt", "w")
for i in range(0, n):
    val = numpy.random.randint(94) + 33
    # val = numpy.random.randint(26) + 97
    f.write(str(chr(val)))

f.close()
