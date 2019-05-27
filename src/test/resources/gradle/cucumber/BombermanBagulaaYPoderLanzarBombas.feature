Feature: Bomberman mata a Bagulaa y puede obtener poder Lanzar Bombas

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