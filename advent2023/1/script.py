f = open('input.txt', 'r', encoding="utf-8")

sum = 0

for line in f.readlines():
    i = 0
    j = len(line) - 1

    while i <= j:
        i_char = line[i]
        j_char = line[j]

        a_found = False
        b_found = False

        if i_char.isnumeric():
            a_found = True
            
        if j_char.isnumeric():
            b_found = True
        
        if b_found and a_found:
            line_sum = int(i_char + j_char)
            sum += line_sum
            # print(line_sum)

            break

        if not a_found:
            i += 1
        if not b_found:
            j -= 1

# print()
print(sum)
