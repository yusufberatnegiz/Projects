import random

def guess(x):
    number=random.randint(1,x)
    guess=0
    while guess!=number:
        guess=int(input("Pick a number between 1 and {}: ".format(x)))
        if guess>number:
            print("Wrong! (Hint: Your guess {} is bigger)".format(guess))
        elif guess<number:
            print(f"Wrong! (Hint: Your guess {guess} is smaller)")
    print("Congrats! Your guess {} is correct!".format(guess))
guess(20)

def computer_guess(y):
    low=1
    high=y
    check=""
    while check!="C":
        if low!=high:
            num=random.randint(low,high)
        else:
            num=high
        check=input("Is the number {} lower(L) or higher(H): ".format(num)).upper()
        if check=="L":
            low=num+1
        elif check=="H":
            high=num-1
    print(f"Congrats Computer! Your guess {num} is correct!")
computer_guess(15)
    

