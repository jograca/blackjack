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
7) A Wallet is the amount of money that a Player has at any time in the Game. It is updated based on the rules around whether a player won or lost a han


#### Game Play

#### Controller

#### Game Styling

Styling is fairly minimal, but is driven by the static/css/app.css file

#### Unit Tests

Unit Tests for models were written for: 

1) Testing Payout values
2) Testing Hand values