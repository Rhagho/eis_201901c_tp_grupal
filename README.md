## Objetivos del TP grupal
tEjercitar la escritura de código en ambientes colaborativos utilizando una metodología de diseño guiada por pruebas ejecutanto un flujo de trabajo que facilite la integración frecuente de código.

### Lo que se espera

0. Leer sugerencias.
1. Implementar ATDD como técnica de diseño.
2. Implementar FeatureBranch + Forking como flujo de trabajo, creando para esto un repositorio público con cualquier servicio de versionado de fuentes (Bitbucket, GitHub, etc.)
3. Cada cambio necesita ser integrado con la mayor frecuencia posiblie, utilizando para la verificación de este un servicio de CI (Continous Integration).
4. Implementar una medición de cobertura desde el **momento inicial del desarrollo**. 
5. Generar el modelo tal que cumpla con las _Pruebas de Aceptación_ para el problema listado en la próxima sección (Descripción del Problema).
6. Completar tados de los integrantes del grupo utilizando este archivo (```README.md```)

### Integrantes

Nro | Nombre       		| Legajo | Mail
----|-------------------|--------|------
1   |Uriel Piñeyro      |41176  |uriel.pineyro@alu.unq.edu.ar
2   |Uriel Quevedo 		|  36062 |quevedouriel3@gmail.com
3   |Lautaro Laghezza	|  --    |lautariver35@gmail.com
4   |NicolasAlvarez		|  33073 |nicolas.alv3@gmail.com
5   | Jose Cassano 		|  34798 |cassanojoseluis@gmail.com

### Entrega

26 / 5 / 2019

## Descripción del Problema

El objetivo de este ejercicio es implementar parcialmente el modelo del juego [Bomberman.Bomberman][2] siguiendo los criterios listados en la sección Objetivos.

### Pruebas de aceptación

1. Bomberman.Bomberman se mueve de una celda a la contigua con los siguientes efectos:
    1. Si la celda está vacia, entonces cambia su posición.
    2. Si la celda está ocupada por una pared, entonces se queda donde está.
    3. Si la celda está ocupada por un enemigo, entonces se muere.
2. Bomberman.Bomberman suelta bomba en el sitio donde se encuentra y luego de 'n' ticks esta estalla con los siguientes efectos:
    1. Rompe aquellas paredes de melamina que están a un radio de 3 casilleros.
    2. Mata al enemigo que entra en contacto con la onda expansiva.
    3. Nunca destruye aquellas paredes que son de acero.
3. Bomberman.Bomberman suelta bomba y esta alcanza a 'Bagulaa' al morir, este suelta un poder 'lanzar bombas' entonces bomberman puede lanzar bombas. Ahora en lugar de soltar la bomba esta se lanza recorriendo 'n' casilleros y detonando luego de 'm' ticks.
4. Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto Max Jr.' al morir, este suelta un poder que le permite a bomberman saltar todo tipo de pared.
5. Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto-Max Units' al morir, este suelta un poder que le permite a bomberman saltar o lanzar varias bombas al mismo tiempo.

6. Bomberman.Bomberman puede soltar varias bombas al mismo tiempo y estas detonaran luego de 'n' ticks, dependiendo de cuando fueron lanzadas o soltadas.

NOTA: El requerimiento (6) solo aplica para aquellos grupos de 5 integrantes.

### Metodología

Programación orientada a objetos + ATDD

### Objetivos

1. Crear un repositorio público con cualquier servicio de versionado de fuentes (Bitbucket, GitHub, etc.)
2. El desarrollo se realiza utilizando la técnica ATDD
3. A la hora de integrar los cambios de varios desarrolladores, utilizar el flujo de trabajo Feature Branch simulando un repositorio privado (branching model + fork).
4. Cada cambio necesita ser integrado con la mayor frecuencia posiblie, utilizando para la verificación de este un servicio de CI (Continous Integration).
5. Implementar metrica de cobertura de código para medir cobertura del proyecto.

#### Referencias:

- Servidor de integración continua: [Travis][1]
- Cobertura de código: [Codcov][3]
- [Bomberman.Bomberman][2]

### Sugerencias:

0. Haga el fork del repo este y establezcan el repo que oficiará como ```upstream``` (no puede ser este mismo repo).
1. Implementar CI en el primer o segundo commit.
2. Completar el README.md.
3. **SEPA que no habrá reentrega ni entregas tardías**
4. Verificar que el comando ejecutado por el CI **efectivamente** corre las pruebas.


[1]: https://travis-ci.org/
[3]: https://codecov.io/gh
[2]: http://bomberman.wikia.com/wiki/Bagura
