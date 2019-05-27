Feature: Bomberman Suelta Bombas
#Prueba de Aceptacion 2:

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

#Prueba de Aceptacion 3:
    #Bomberman.Bomberman suelta bomba y esta alcanza a 'Bagulaa' al morir, este suelta un poder 'lanzar bombas' entonces bomberman puede lanzar bombas.
     Scenario: Bomberman pone una bomba y mata a "Bagulaa" que entra en su onda expansiva
        Given Un Juego con bomberman en una celda
        And Esta "Bagulaa" en la celda de al lado de bomberman Norte
        When Bomberman deja una bomba
        And Pasa "3" ticks
        Then La Bomba explota donde estaba "Bagulaa" soltando poder "lanzarBombas" en la celda Norte

     Scenario: Bomberman se mueve en una celda donde hay poder "lanzarBombas" y cambia su poder
        Given Un Juego con bomberman en una celda
        And La celda Norte donde esta bomberman hay poder "lanzarBombas"
        When Bomberman se mueve sobre esa celda Norte
        Then Bomberman obtiene el poder "lanzarBombas"

     Scenario: Bomberman con poder "lanzarBombas" lanza bomba a 4 celdas de longitud al Norte
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        Then La bomba se pone "4" celdas al Norte de la posicion de Bomberman

     Scenario: Bomberman lanza bomba a 4 celda de longitud y al pasar 4 ticks explota
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        And Pasa "4" ticks
        Then La bomba explota

     Scenario: Bomberman lanza bomba a 4 celdas al Oeste y esta se queda en la posicion de bomberman al no existir celdas al Oeste
        Given Un Juego con bomberman en una celda
        And Bomberman se mueve hacia el Oeste
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Oeste
        Then La bomba se pone en la celda que esta bomberman

     Scenario: Bomberman con poder "lanzarBombas" lanza bomba a 4 celdas de longitud al Oeste y esta alcanza la celda proxima mas lejana al Oeste
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Oeste
        Then La bomba se pone "1" celdas al Oeste de la posicion de Bomberman

#Prueba de aceptacion 4:
#Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto Max Jr.' al morir, este suelta un poder que le permite a bomberman saltar toddo tipo de pared.


     Scenario: Bomberman pone una bomba y mata a "ProtoMaxJr" que entra en su onda expansiva
         Given Un Juego con bomberman en una celda
         And Esta "ProtoMaxJr" en la celda de al lado de bomberman Sur
         When Bomberman deja una bomba
         And Pasa "3" ticks
         Then La Bomba explota donde estaba "ProtoMaxJr" soltando poder "saltarPared" en la celda Sur

     Scenario: Bomberman se mueve en una celda donde hay poder "saltarPared" y cambia su poder
        Given Un Juego con bomberman en una celda
        And La celda Sur donde esta bomberman hay poder "saltarPared"
        When Bomberman se mueve sobre esa celda Sur
        Then Bomberman obtiene el poder "saltarPared"

     Scenario: Bomberman con poder "saltarPared" salta la Pared Norte
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarPared"
        When Bomberman se mueve al Norte habiendo "paredNormal" en la celda
        Then Bomberman cambia su posicion

     Scenario: Bomberman con poder "saltarPared" salta la Pared Este
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarPared"
        When Bomberman se mueve al Este habiendo "paredAcero" en la celda
        Then Bomberman cambia su posicion


#Prueba de aceptacion 5:
   #Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto-Max Units' al morir, este suelta un poder que le permite a bomberman saltar o lanzar varias bombas al mismo tiempo.

     Scenario: Bomberman pone una bomba y mata a "ProtoMaxUnits" que entra en su onda expansiva
         Given Un Juego con bomberman en una celda
         And Esta "ProtoMaxUnits" en la celda de al lado de bomberman Este
         When Bomberman deja una bomba
         And Pasa "3" ticks
         Then La Bomba explota donde estaba "ProtoMaxUnits" soltando poder "saltarYLanzar" en la celda Este

     Scenario: Bomberman se mueve en una celda donde hay poder "saltarYLanzar" y cambia su poder
        Given Un Juego con bomberman en una celda
        And La celda Oeste donde esta bomberman hay poder "saltarYLanzar"
        When Bomberman se mueve sobre esa celda Oeste
        Then Bomberman obtiene el poder "saltarYLanzar"

     Scenario: Bomberman con poder "saltarYLanzar" salta la Pared Norte
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarYLanzar"
        When Bomberman se mueve al Norte habiendo "paredNormal" en la celda
        Then Bomberman cambia su posicion

     Scenario: Bomberman con poder "saltarYLanzar" salta la Pared Este
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarYLanzar"
        When Bomberman se mueve al Este habiendo "paredAcero" en la celda
        Then Bomberman cambia su posicion

     Scenario: Bomberman con poder "saltarYLanzar" lanza bomba a 4 celdas de longitud al Norte
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarYLanzar"
        When Bomberman lanza bomba mirando al Norte
        Then La bomba se pone "4" celdas al Norte de la posicion de Bomberman

     Scenario: Bomberman lanza bomba a 4 celda de longitud y al pasar 4 ticks explota
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarYLanzar"
        When Bomberman lanza bomba mirando al Norte
        And Pasa "4" ticks
        Then La bomba explota

     Scenario: Bomberman lanza bomba a 4 celdas al Oeste y esta se queda en la posicion de bomberman al no existir celdas al Oeste
        Given Un Juego con bomberman en una celda
        And Bomberman se mueve hacia el Oeste
        And Bomberman con poder "saltarYLanzar"
        When Bomberman lanza bomba mirando al Oeste
        Then La bomba se pone en la celda que esta bomberman

     Scenario: Bomberman con poder "saltarYLanzar" lanza bomba a 4 celdas de longitud al Oeste y esta alcanza la celda proxima mas lejana al Oeste
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "saltarYLanzar"
        When Bomberman lanza bomba mirando al Oeste
        Then La bomba se pone "1" celdas al Oeste de la posicion de Bomberman



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