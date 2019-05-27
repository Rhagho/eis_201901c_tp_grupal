Feature: Bomberman suelta o lanza varias bombas a la vez

#Prueba de aceptacion 6:
 #BOMBERMAN PUEDE SOLTAR O LANZAR VARIAS BOMBAS A LA VEZ.


#HAY UN ERROR CON EL THEN TOMANDO 4 PARAMETROS ENTONCES HARDCODIO EL 4 LAMENTABLEMENTE
     Scenario: Bomberman con poder "lanzarBombas" lanza 2 bombas donde una a 4 celdas de longitud al Norte y otra a 4 celdas de longitud al Este
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        And Luego bomberman lanza bomba mirando al Este
        Then Hay dos bombas una en 4 celdas al Norte y otra 4 celdas al Este de la posicion de bomberman

     Scenario: Bomberman sin poderes deja una bomba en el lugar y otra al Norte
        Given Un Juego con bomberman en una celda
        When Bomberman deja una bomba
        And Bomberman se mueve hacia el Norte
        And Bomberman deja bomba
        Then Hay una bomba en la posicion anterior de bomberman y otra bomba en la posicion actual

     Scenario: Bomberman con poder "lanzarBombas" lanza 2 bombas con 4 ticks de explosion donde tira una a 4 celdas de longitud al Norte y pasan 2 ticks Luego tira otra a 4 celdas de longitud al Este y pasan 2 ticks mas explotando la primera que lanzo
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        And Pasa "2" ticks
        And Luego bomberman lanza bomba mirando al Este
        And Pasa "2" ticks
        Then La bomba del Norte explota y una esta en 4 celdas al Este de la posicion de bomberman

     Scenario: Bomberman sin poderes deja una bomba en el lugar y pasan 1 tick y pone otra al Norte y pasan 2 ticks como consecuencia la primera explota y la ultima sigue en la posicion actual
        Given Un Juego con bomberman en una celda
        When Bomberman deja una bomba
        And Pasa "1" ticks
        And Bomberman se mueve hacia el Norte
        And Bomberman deja bomba
        And Pasa "2" ticks
        Then En la posicion anterior de bomberman la bomba exploto y la otra bomba sigue en la posicion actual