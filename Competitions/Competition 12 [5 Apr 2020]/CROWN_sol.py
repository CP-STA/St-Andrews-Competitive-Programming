def CROWN (a, b):
    # Generate all of the palindromes between 0 and 100000000.
    # Start with a list of the 'easier' ones, stored as strings.
    # Also store '0' and '00' so that a 'base case' for numbers of the form a00a exists.
    palindrome_str_list = ["0","1","2","3","4","5","6","7","8","9", "00", "11","22","33","44","55","66","77","88","99"]
    i = 0
    # Loop through the palindrome string list, adding newly-generated
    # palindromes based on older ones by adding the same
    # digit to both the start of a given palindromic string and
    # the end. This technique works because we know that if a
    #string of length l is a palindrome, then the string of length
    # l-2 obtained by removing both the first character and the
    # final character must also be a palindrome.
    while i < len (palindrome_str_list):
        cur_palindrome_str = str (palindrome_str_list[i])
        str_len = len (cur_palindrome_str)
        for j in range (10):
            new_palindrome_str = str (j)
            new_palindrome_str += cur_palindrome_str
            new_palindrome_str += str (j)
            new_palindrome = int (new_palindrome_str)
            if new_palindrome <= 100000000 and len (new_palindrome_str) <= 9:
                palindrome_str_list.append (new_palindrome_str)
        i += 1
    ans = 0
    # Loop through the list of generated palindromic strings,
    # and select the ones whose numeric values are within
    # the required range.
    for i in range (len (palindrome_str_list)):
        palindrome = int (palindrome_str_list[i])
        if palindrome >= a and palindrome <= b and palindrome_str_list[i][0] != '0':
            ans += 1
    return ans

input_list = list (map (int, input ().split ()))
print (CROWN (input_list[0], input_list[1]))
