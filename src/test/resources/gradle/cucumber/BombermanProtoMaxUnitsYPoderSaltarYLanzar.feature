Feature: Bomberman mata a Proto Max Units y puede obtener Poder Saltar y Lanzar Bombas

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