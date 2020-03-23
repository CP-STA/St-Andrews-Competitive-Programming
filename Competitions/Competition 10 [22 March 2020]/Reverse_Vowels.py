import random


def reverse_vowels(s):
    vowels = {'a', 'e', 'i', 'o', 'u'}

    vowel_indices = []
    # storing indices where each vowel occurs
    for i, x in enumerate(s):
        if x in vowels:
            vowel_indices.append(i)

    l = len(vowel_indices)

    # converting to list due to immutable nature of strings in python
    list_str = list(s)

    # swapping first vowel with last vowel, second vowel with second last ...
    for j in range(l // 2):
        index = vowel_indices[j]
        swap_index = vowel_indices[-j - 1]

        # swapping
        char1, char2 = list_str[index], list_str[swap_index]
        list_str[index] = char2
        list_str[swap_index] = char1

    return "".join(list_str)


num_test_cases = 20

samples = ["hello", "paeikouq", "uvbnmoaeu"]
print(chr(97 + 25))
for i in range(num_test_cases + 3):

    length = random.randint(1, 1000)

    input_file_name = "input" + str(i) + ".txt"
    output_file_name = "output" + str(i) + ".txt"

    rnd_str = ""

    if i < 3:
        rnd_str = samples[i]
    else:
        for j in range(length):
            rnd_str += chr(97 + random.randint(0, 25))

    input_file = open("Reverse_Vowels_Testcases/input/" + input_file_name, 'w')
    output_file = open("Reverse_Vowels_Testcases/output/" + output_file_name, 'w')

    input_file.write(str(rnd_str))
    output_file.write(str(reverse_vowels(rnd_str)))
