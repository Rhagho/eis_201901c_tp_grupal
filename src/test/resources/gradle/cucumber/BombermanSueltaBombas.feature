Feature: Bomberman Suelta Bombas

  Scenario: Bomberman pone una bomba y destruye paredes de melamina
    Given Un Juego con bomberman en una celda
    When Bomberman pone una bomba rodeado de paredes de melamina
    And Pasa "3" ticks
    Then La Bomba explota dejando vacio las celdas en un radio de 3 casilleros

  Scenario: Bomberman pone una bomba y mata al enemigo que entra en su onda expansiva
    Given Un Juego con bomberman en una celda
    When Bomberman pone una bomba rodeado de enemigos
    And Pasa "3" ticks
    Then La Bomba explota dejando vacio las celdas en un radio de 3 casilleros

  Scenario: Bomberman pone una bomba y no puede destruir paredes que son de acero
    Given Un Juego con bomberman en una celda
    When Bomberman pone una bomba rodeada de paredes de acero
    And Pasa "3" ticks
    Then La Bomba explota sin romper esas paredes de acero