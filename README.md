# ChallengeConversor
Conversor de Divisas con Java

# Conversor de Divisas App

## Descripción
Esta aplicación es un conversor de divisas desarrollado en Java utilizando principios de programación orientada a objetos. Permite convertir entre diversas monedas como el Dólar estadounidense (USD), el Peso argentino (ARS), el Real brasileño (BRL) y el Peso colombiano (COP). La aplicación utiliza la API de ExchangeRate para obtener tasas de conversión actualizadas en tiempo real.

## Características
- Conversión entre las siguientes monedas:
  - Dólar (USD) a Peso argentino (ARS) y viceversa.
  - Dólar (USD) a Real brasileño (BRL) y viceversa.
  - Dólar (USD) a Peso colombiano (COP) y viceversa.
- Menú interactivo para seleccionar la conversión deseada.
- Validación de entradas del usuario.
- Modularidad y escalabilidad gracias a una arquitectura orientada a objetos.

## Estructura del Proyecto

### Clases Principales

1. **`ConversorDeDivisasApp`**
   - Punto de entrada de la aplicación. Crea las instancias necesarias y ejecuta el flujo principal.

2. **`InterfazDeUsuario`**
   - Responsable de manejar la interacción con el usuario. Presenta el menú, captura las entradas y muestra los resultados.

3. **`ConversorDeDivisas`**
   - Encapsula la lógica de negocio para gestionar los pares de divisas, obtener tasas de conversión desde la API y calcular los valores convertidos.
   - Proporciona métodos para configurar y manejar pares de divisas, así como para realizar conversiones.

## Requisitos
- **Java 11** o superior.
- Conexión a internet para obtener tasas de conversión actualizadas.
- API Key válida para la API de ExchangeRate (incluida en el código como ejemplo).

## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-divisas-app.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd conversor-de-divisas-app
   ```

3. Compila el código fuente:
   ```bash
   javac -d bin src/*.java
   ```

4. Ejecuta la aplicación:
   ```bash
   java -cp bin ConversorDeDivisasApp
   ```

## Uso
1. Ejecuta el programa desde la terminal.
2. Selecciona una opción del menú (por ejemplo, convertir de Dólar a Peso argentino).
3. Ingresa la cantidad que deseas convertir.
4. Obtén el resultado con la cantidad convertida y la moneda destino.
5. Repite el proceso o elige la opción "Salir" para finalizar.

## Ejemplo
### Entrada
```
Sea bienvenido/a al Conversor de Moneda =]
1) Dólar => Peso argentino
2) Peso argentino => Dólar
...
Elija una opción válida: 1
Ingrese el valor que desea convertir: 100
```

### Salida
```
El valor 100.00 [USD] corresponde al valor final => 27,800.00 [ARS]
```

## Extensión
Para agregar más monedas o nuevas funcionalidades:
1. Modifica el método `inicializarParesDeDivisas` en la clase `ConversorDeDivisas` para incluir nuevos pares de monedas.
2. Ajusta la clase `InterfazDeUsuario` para manejar nuevas opciones en el menú.

## Dependencias
- [Gson](https://github.com/google/gson): Para procesar las respuestas JSON de la API.

## Notas
- Este proyecto utiliza una clave de API proporcionada en el código como ejemplo. Reemplázala con tu propia clave para usar en producción.
- Si necesitas soporte adicional para monedas, verifica las opciones disponibles en la documentación de la API de ExchangeRate.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Contribución
Si deseas contribuir al proyecto, por favor crea un fork, realiza tus cambios y envía un pull request. Todas las contribuciones son bienvenidas.

