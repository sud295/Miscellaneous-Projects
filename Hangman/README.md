# Hangman
## Part 1
This part takes an array of 10 animal names and uses it in a game of hangman
## Part 2
This part takes a file of 74 animal names and uses it in a game of hangman
## Part 3 
This part scrapes a file off the web and uses it in a game of hangman

## Hints:
All 3 parts use dictionary.com to scrape hints if the user needs them. Any instances of the word to guess within the dictionary definition are censored.

## Example:
```
|------------------     
|                 |     
|                ---    
|               |   |   
|                ---    
|                 |     
|                 |     
|               / | \   
|              /  |  \  
|                 |     
|                 |     
|                / \    
|               /   \   
|              /     \  
|                       
------------------------
____
Guess Letter (OR type 'hint' for a hint!): a
|------------------     
|                 |     
|                ---    
|               |   |   
|                ---    
|                 |     
|                 |     
|               / | \   
|              /  |  \  
|                 |     
|                 |     
|                / \    
|               /   \   
|              /     \  
|                       
------------------------
__a_
Guess Letter (OR type 'hint' for a hint!): hint
Any of numerous agile, hollow-horned ruminants of the genus Capra, of the family Bovidae, closely related to the sheep, found native in rocky and mountainous regions of the Old World, and widely distributed in domesticated varieties. 
Guess Letter: l
|------------------     
|                 |     
|                ---    
|               |   |   
|                ---    
|                 |     
|                 |     
|                 | \   
|                 |  \  
|                 |     
|                 |     
|                / \    
|               /   \   
|              /     \  
|                       
------------------------
__a_
Guess Letter (OR type 'hint' for a hint!): g
|------------------     
|                 |     
|                ---    
|               |   |   
|                ---    
|                 |     
|                 |     
|                 | \   
|                 |  \  
|                 |     
|                 |     
|                / \    
|               /   \   
|              /     \  
|                       
------------------------
g_a_
Guess Letter (OR type 'hint' for a hint!): o
|------------------     
|                 |     
|                ---    
|               |   |   
|                ---    
|                 |     
|                 |     
|                 | \   
|                 |  \  
|                 |     
|                 |     
|                / \    
|               /   \   
|              /     \  
|                       
------------------------
goa_
Guess Letter (OR type 'hint' for a hint!): t

YOU WIN! --> goat
```
