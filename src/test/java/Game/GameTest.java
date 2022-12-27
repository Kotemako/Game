package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Game registeredPlayers = new Game();

    Player player1 = new Player(1, "Tom", 600);
    Player player2 = new Player(22, "John", 100);
    Player player3 = new Player(33, "Boris", 200);
    Player player4 = new Player(4, "Dima", 50);
    Player player5 = new Player(5, "Semen", 600);

    @Test
    void shouldShowResultWhenSecondPlayerIsStronger() {
        Player player1 = new Player(11, "Petya", 10);
        Player player2 = new Player(22, "Kolya", 15);
        Player player3 = new Player(33, "Katya", 10);
        Player player4 = new Player(44, "Misha", 40);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldShowResultWhenPlayersAreEqual() {
        Player player1 = new Player(11, "Petya", 10);
        Player player2 = new Player(22, "Kolya", 15);
        Player player3 = new Player(33, "Katya", 10);
        Player player4 = new Player(44, "Misha", 40);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Petya", "Katya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldShowException() {
        Player player1 = new Player(11, "Petya", 10);
        Player player2 = new Player(22, "Kolya", 15);
        Player player3 = new Player(33, "Katya", 10);
        Player player4 = new Player(44, "Misha", 40);

        Game game = new Game();
        //game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Unregistered playerName1");
        });
    }

    @Test
    void shouldShowException1() {
        Player player1 = new Player(11, "Petya", 10);
        Player player2 = new Player(22, "Kolya", 15);
        Player player3 = new Player(33, "Katya", 10);
        Player player4 = new Player(44, "Misha", 40);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player2.getName(), "Unregistered playerName2");
        });
    }


}