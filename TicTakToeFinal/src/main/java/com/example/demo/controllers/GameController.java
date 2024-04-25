package com.example.demo.controllers;



import com.example.demo.exceptions.InvalidMoveException;
import com.example.demo.models.Game;
import com.example.demo.models.GameState;
import com.example.demo.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        // Validate if 2 players have the same symbol or not
        boolean hasDuplicateSymbols = false;
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getSymbol().equals(players.get(j).getSymbol())) {
                    hasDuplicateSymbols = true;
                    break;
                }
            }
            if (hasDuplicateSymbols) {
                break;
            }
        }

        if (hasDuplicateSymbols) {
            throw new IllegalArgumentException("Two players cannot have the same symbol.");
        }

        // Create and return the new Game instance
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}

