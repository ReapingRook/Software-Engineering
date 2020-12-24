This program achieves the facade pattern by making all the elements not relient on the GUI but in fact, 
connected to the GameEngine. By doing this the User can use different GUI as the GameEngine will initialize the board anyways,
additionally components can be swapped out as the GameEngine is the central hub for all the components anyways.  
begin application (start.main())
prompt user for number of players and turns (start.main(), UI)
initialize game engine (GameEngine() constructor)
-initialize properties, property groups, and board (GameEngine() constructor)
start game (GameEngine.startGame())
-initialize players (GameEngine.startGame());
-call GameEngine.playGame()
play game (GameEngine.playGame())
-while numTurns <= numDesiredTurns
--cycle through each player's turn
---roll and move (handled by GameEngine.takeTurn())
---trade, if desired (GameEngine.Player.trade())
----if player.inJail = true, prompt user to roll or pay 
----if player fails to roll doubles or pay, do not move
----if player fails to roll doubles three turns in a row (tracked by player.numJailEscapeAttempts), player MUST pay $50 (handled by space.spaceAction())
----if player pays or rolls doubles while in jail, player.inJail = false, but player is still on jail space. turn proceeds as normal
----if not in jail and doubles rolled for the third time (tracked by local variable doublesCounter in GameEngine.playGame()), go directly to jail and don't move. player cannot roll or pay out of jail this turn
----if not in jail, turn proceeds as normal
---land on space and trigger action (ALL space actions and subactions handled by space.spaceAction())
----owned property/utility/RR
-----if owned by player, nothing happens
-----if not owned by player, player pays appropriate rent (calculated by space.property.getRent())
----unowned property/utility/RR
-----player given option to purchase property (call property.purchaseProperty())
------if purchased, property.owner = player, player.editMoney(-price of property), check for monopoly (all handled by property.purchaseProperty())
----GO, or passing go (passing GO handled by player.move())
-----player gains $200
----parking
-----nothing happens
----luxury tax
-----player pays $75 (handled by space.spaceAction())
----go to jail
-----player.currentSpace = jail, player.inJail = true
----jail
-----nothing happens if the player is "just visiting" jail
----income
-----prompt user to pay either 10% of player.money or $200, and edit money accordingly (handled by space.spaceAction())
---trade again, if desired, and/or manage properties (NO METHOD YET for either trade or manage)
---end turn
----reset local tracking variables (doublesCounter, d1, d2, willRepeatTurn)
----if doubles rolled in move phase, player plays again (return to beginning of while loop without incrementing numTurns or moving on to the next player)
--at end of player's turn, next player has their turn (local variable j++)
-end while
finish game (GameEngine.declareWinners())
-announce winner