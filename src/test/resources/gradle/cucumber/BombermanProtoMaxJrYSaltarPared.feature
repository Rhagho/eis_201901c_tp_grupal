Feature: Bomberman mata a Proto Max Jr y puede obtener poder Saltar Pared
    
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