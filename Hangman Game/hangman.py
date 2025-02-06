import random

print("Let's play hangman! You get six incorrect guesses. Good Luck!")
file = open("dictionary.txt", 'r')
li = file.readlines()
word = random.choice(li).strip()
letters = set()
c = 0
correct = "_ " * len(word)

while c <= 5 and "_ " in correct:
    print(f"Current word: {correct}")
    guess = input("Guess a letter: ").lower()

    if guess in letters:
        print("This letter was already guessed")
    elif guess in word:
        print("You got one!")
        
        correct = "".join([guess + " " if word[i] == guess else correct[i*2:i*2+2] for i in range(len(word))])
    else:
        c += 1
        if c > 5:
            print(f"You Lose! The word was {word}")
            break
        print("Not in word")
    
    letters.add(guess)

if "_ " not in correct:
    print(f"You Win! The word was {word}")