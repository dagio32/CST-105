Nicholas Robertson
Dennis Attawia
CST-105
March 23, 2017

Milestone #6 for the project.  This folder includes Main.java (for testing the classes) and updated versions of PlayerManager.java and NFLPlayer.java.

The NFLPlayer.java class now has an abstract superclass named NFLPlayer.  This superclass contains two new abstract methods named getPlayerType and getPlayerSpecialty, which are overridden in the child classes.  The three child classes are named OffensivePlayer, DefensivePlayer, and SpecialTeamsPlayer.  These classes each have an arrayList called SeasonStatsList, which reference an object with stat fields unique to their side of the ball.  Each one of these stats classes inherits from the abstract GenericStats.

The PlayerManager.java class has been updated to reflect the new way of referencing statistics.  There are now three separate arrays of players, separated by the type of player (offense, defense, special teams).
