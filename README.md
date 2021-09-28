#Poker Hands
##Problem Description
Your job is to compare several pairs of poker hands and to indicate which, if either, has a higher gameRank.
###Poker rules description
A poker cardCombination contains 52 cardCombination - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted C, D, H, and S in the input data). Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A). For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.
A poker hand consists of 5 cardCombination dealt from the cardCombination. Poker hands are ranked by the following partial order from lowest to highest.

• High Card: Hands which do not fit any higher category are ranked by the value of their highest  If the highest cardCombination have the same value, the hands are ranked by the next highest, and so on.

• Pair: 2 of the 5 cardCombination in the hand have the same value. Hands which both contain a pair are ranked by the value of the cardCombination forming the pair. If these values are the same, the hands are ranked by the values of the cardCombination not forming the pair, in decreasing order.

• Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining 
• Three of a Kind: Three of the cardCombination in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cardCombination.

• Straight: Hand contains 5 cardCombination with consecutive values. Hands which both contain a straight are ranked by their highest 

• Flush: Hand contains 5 cardCombination of the same suit. Hands which are both flushes are ranked using the rules for High 

• Full House: 3 cardCombination of the same value, with the remaining 2 cardCombination forming a pair. Ranked by the value of the 3 cardCombination.

• Four of a kind: 4 cardCombination with the same value. Ranked by the value of the 4 cardCombination.

• Straight flush: 5 cardCombination of the same suit with consecutive values. Ranked by the highest card in the hand.

###Suggested Test Cases

####Sample input:
``` 
Black: 2H 3D 5S 9C KD   White: 2C 3H 4S 8C AH 
Black: 2H 4S 4C 2D 4H   White: 2S 8S AS QS 3S
Black: 2H 3D 5S 9C KD   White: 2C 3H 4S 8C KH
Black: 2H 3D 5S 9C KD   White: 2D 3H 5C 9S KH
```

Each row of input is a game with two players. The first five cardCombination belong to the player named “Black” and the second five cardCombination belong to the player named “White”.
###Sample output: 
``` 
White wins. - with high card: Ace 
Black wins. - with full house: 4 over 2
Black wins. - with high card: 9
Tie.
```
