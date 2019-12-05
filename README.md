## Blackjack!

### G4C Week 4 Project

This is a Spring MVC Project to play Blackjack. 

#### Class Structure

Classes are in Capital letters unless otherwise specified as Enums.

1) A Game has a Player and House (otherwise know as a dealer) 
2) A Game has Deck comprised of 52 Cards
3) A Card is either a NumberCard (value of 2 - 10), FaceCard (value of 10) or AceCard (value of either 1 or 11). More on the Ace below
4) Each Card has a Suit. These are associated with an Enum (Suits) to determine its appropriate value
5) Each FaceCard has a Face. These are associated with an Enum (Faces) to determine what face it has. Value is always a 10 for these Cards
6) A Hand is the construction of the Cards which either the Player or House has at any moment in the Game
7) A Wallet is the amount of money that a Player has at any time in the Game. It is updated based on the rules around whether a player won or lost a hand

#### Game Play

* Play starts on a Bet screen (bet.html). User input is stored as a Double. It is immediately removed from the Wallet and assumed as lost until won back with a winning hand or a push.
* Clicking the Place A Bet button moves the user to a second view (play.html). In the Controller, a hand is setup (hand.getHand()) and the objects needed are added ot the view
* 2 cards are dealt to a Player and 2 to a Dealer. In order to hide the second card, a separate view in mustache is setup to only display a stack.peek(0) for the Dealer Hand until the gameOn boolean is set to true by doing a Hit or a Stay. Once this is met, the view opens up with the full hand that the dealer has
* The Hit button runs a method that does a stack.pop off the deck or cards and a stack.push to move the card into the Players hand. This can be selected until the player has Busted (gone over 21)
* The Stay button increments cards into the Dealer's hand until they hit the minimum amount (over 16) or Bust (over 21).
* Once the Hit action is complete, the Winner is calculated and the Payouts are given to the Player (if any). 
* A Play Again button appears, allowing the user to run the betting cycle again

#### Game Styling

Styling is fairly minimal, but is driven by the static/css/app.css file

#### Unit Tests

Unit Tests for models were written for: 

1) Testing Payout values
2) Testing Hand values

