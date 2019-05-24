Feature: Bomberman Moviendose

  Scenario: Bomberman se mueve a la celda Norte
    Given Un Juego con bomberman en una celda
    When Bomberman se mueve hacia la celda vacia Norte
    Then Bomberman cambia su posicion

  Scenario: Bomberman no se puede mover habiendo una celda con una pared al Norte
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Norte habiendo una pared
    Then Bomberman se queda en el lugar

  Scenario: Bomberman muere al moverse a la celda Norte habiendo un enemigo
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Norte habiendo un enemigo
    Then Bomberman muere



  Scenario: Bomberman se mueve a la celda Sur
    Given Un Juego con bomberman en una celda
    When Bomberman se mueve hacia la celda vacia Sur
    Then Bomberman cambia su posicion

  Scenario: Bomberman no se puede mover habiendo una celda con una pared al Sur
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Sur habiendo una pared
    Then Bomberman se queda en el lugar

  Scenario: Bomberman muere al moverse a la celda Sur habiendo un enemigo
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Sur habiendo un enemigo
    Then Bomberman muere



    Scenario: Bomberman se mueve a la celda Este
    Given Un Juego con bomberman en una celda
    When Bomberman se mueve hacia la celda vacia Este
    Then Bomberman cambia su posicion

  Scenario: Bomberman no se puede mover habiendo una celda con una pared al Este
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Este habiendo una pared
    Then Bomberman se queda en el lugar

  Scenario: Bomberman muere al moverse a la celda Este habiendo un enemigo
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Este habiendo un enemigo
    Then Bomberman muere


  Scenario: Bomberman se mueve a la celda Oeste
    Given Un Juego con bomberman en una celda
    When Bomberman se mueve hacia la celda vacia Oeste
    Then Bomberman cambia su posicion

  Scenario: Bomberman no se puede mover habiendo una celda con una pared al Oeste
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Oeste habiendo una pared
    Then Bomberman se queda en el lugar

  Scenario: Bomberman muere al moverse a la celda Oeste habiendo un enemigo
    Given Un Juego con bomberman en una celda
    When Bomberman intenta moverse al Oeste habiendo un enemigo
    Then Bomberman muere