number_of_terms = 100
list_of_terms = []


def factorial(n):
    f = 1
    for i in range(1, n + 1):
        f = f * i
    return f


def sin(x):
    n = 0
    while n < number_of_terms:
        a = (-1) ** n
        b = (2 * n) + 1
        c = int(x) ** (b)
        d = int(factorial(b))
        e = a * (c / d)
        list_of_terms.append(e)
        n += 1
    return (sum(list_of_terms))
a = 0
while a != 1:
    l = input("Enter: ")

    print(sin(l))
