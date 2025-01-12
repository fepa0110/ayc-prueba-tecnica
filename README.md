# Lectura de código de barras de producto

## Requerimientos

Desarrolle un servicio siguiendo el protocolo RESTful que reciba como único parámetro la cadena
leída y retorne un JSON con los siguientes campos:  

```json
{
    "codigo_scanner": "0001E401ACME" // el string original
    "lote_extendido": "0001E4", // primeros 6 caracteres
    "bulto": "01"  // 2 o 3 caracteres, según corresponda  
}  
```

Los códigos de barra serán del tipo *CODE39*.  
La cadena leída tiene el siguiente formato:
- Lote: 4 dígitos
- Mes: 1 caracter
- Año: 1 Dígito
- Bulto: 2 o 3 dígitos
- ACME: Palabra fija ACME  

El largo mínimo es **12**, el máximo es **13**. En todos los casos debe contener la palabra **ACME** al final.

## Instrucciones de ejecución

- Abrir un terminal
  
- Dentro del repositorio, posicionarse en el directorio del proyecto
    ```bash
    cd ./lectorcodigobarras
    ```

- Compilar el proyecto
    ```bash
    ./gradlew build
    ```

- Compilar y ejecutar el servicio
    ```bash
    ./gradlew bootRun
    ```

- Presionar ***Ctrl+C*** para apagar el servicio

## Documentación

El servicio cuenta con un único endpoint del tipo ***GET*** 
que recibe como parametro el código de barras leido 
y retorna la información del mismo decodificada.

- Dirección del endpoint ***GET***
    ```
    http://localhost:8080/codigoBarras/codigo/{codigo}
    ```
- Formato de la respuesta

    ```ts
    {
        "codigo_scanner": string, 
        "lote_extendido": string,
        "bulto": string
    }  
    ```
     - **codigo_scanner:** código original. Debe contener la palabra ACME al final y debe tener entre 12 y 13 carácteres.
     - **lote_extendido:** Información del lote correspondiente a los primeros 6 carácteres, en el que se incluyen lote (4 caracteres), mes (1 digito) y año (1 digito).  
     - **bulto:** Información correspondiente al valor de bulto del producto.  

- Por ejemplo:

    - Consulta
        ```
        http://localhost:8080/codigoBarras/codigo/0001E4012ACME
        ```

    - Se obtendra la siguiente respuesta
        ```json
        {
            "codigo_scanner": "0001E4012ACME",
            "lote_extendido": "0001E4",
            "bulto": "012"
        }
        ```

