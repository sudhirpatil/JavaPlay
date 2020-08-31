ValidParenthesis:
Missed important edge case with odd number of characters with * in between
    Look through few use cases carefully, always plan design keeping them in mind
Using 2 stack, one for ( and another for star
stacks need not always contain characters, saving sequence number saved using complex data structures
Stack could contain object with both character and sequence number if neededK

RearrangeStringCoderpad:
Discarded that characters can just be placed adjacent to each other and just like abcabc diff characters at a time in seq
    Consider simple case and write down if solution is possible or not before discarding, should not have ignored just placing chars alternative
    e.g abacbc for aabbcc
    Using array instead of strigBuffer
Incorrect Choice of data structures
    for character counts arr[char - 'a'] is easier & better option than Map<Character, count(int)>
    looping through map & removing elements can be done only by looping through iterators
    struggled to create loop map multiple times

