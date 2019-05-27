Feature: Bomberman Esta Muerto No Hace Nada

    Scenario: Bomberman muerto se mueve a la celda Norte
       Given Un Juego con bomberman en una celda
       And Bomberman esta muerto
       When Bomberman se mueve hacia la celda vacia Norte
       Then Bomberman se queda en el lugar

    Scenario: Bomberman muerto no tiene ningun estado de poder
       Given Un Juego con bomberman en una celda
       When Bomberman se muere
       Then Bomberman no tiene ningun estadoDePoder

    Scenario: Bomberman muerto al accionar bomba no pasa nada
       Given Un Juego con bomberman en una celda
       When Bomberman se muere
       And Bomberman deja bomba
       Then No hay ninguna bomba activa

#Refactorizar el null en ExceptionEstaMuerto()
    Scenario: Bomberman muerto al cambiar donde mira
       Given Un Juego con bomberman en una celda
       When Bomberman se muere
       And Bomberman mira al Norte
       Then La direccion donde mira bomberman es null