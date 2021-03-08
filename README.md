# :meat_on_bone: La Reconquista Del Paladar
## [1 - Descripcion General](#Descripcion)
## [2 - Entidades Principales](#Entidades)
## [3 - Descripción Servicio Interno](#Servicio)
## [4 - Autor](#Autor)
## [5 - Capturas De Pantalla](#Capturas)
## [6 - Diagramas](#Diagramas)

## 1 - :computer: Descripción general <a name="descripcion">
Se desarrollará una aplicación web destinada a la venta de comida latinoamericana a domicilio, en la que los usuarios podrán navegar por las diferentes categorías de las comidas ofertadas sin necesidad de registrarse. Para formalizar el pedido deberán iniciar sesión con su usuario y completar su compra.

## 2 - :busts_in_silhouette: Entidades principales <a name="Entidades">
- Producto: Cada producto llevará asociado un identificador único, y contendrá datos específicos que lo describan junto al número de stock. 
- Cliente: Cada ususario tendrá su propio nombre de usuario, que será unico para cada uno, a parte de otros datos como su dirección y otros datos personales. El usuario podrá realizar de 0 a N pedidos.
- Pedido: esta entidad tendrá asociada un numero de productos y un usuario, asociandolos. Esta entidad tambien contendrá el coste final total.
- Categoría de productos: esta entidad llevará asosciado un identificador único y contendrá de 1 a N productos que se recojan en ella.

## 3 - :lock: Descripción servicio interno <a name="Servicio">
- Cuando el usuario hace un pedido se le enviará un correo electrónico con un pdf donde se incluirá el resumen de su pedido.
- Servicio de pago online.


## 4 - :trollface: Autor <a name="Autor">
#### Juan Carlos Flores Angulo
- jc.flores@alumnos.urjc.es
- GII + GIC 135
- ##### Github: [FinalBossRel](https://github.com/FinalBossRel)

## 5 - :book: Capturas De Pantalla <a name="Capturas">
## Home.html
![principal](https://user-images.githubusercontent.com/63256402/110303348-94353a80-7ffa-11eb-945d-0306e0dddb32.png)
Página principal donde se exponen algunos productos y se muestra un pequeño resumen.

## Contact.html
![contact](https://user-images.githubusercontent.com/63256402/110303627-e24a3e00-7ffa-11eb-9e3e-0cdce42ac5b2.png)
Página donde el usuario puede comunicarse con los administradores de la web(en progreso).

## Food.html
![food](https://user-images.githubusercontent.com/63256402/110303835-29383380-7ffb-11eb-9711-40d6b96086f1.png)
Página en la que se exponen las categorias que contienen los productos ofertados.
## Shoppingcart.html
![shoppingcart](https://user-images.githubusercontent.com/63256402/110304255-a5cb1200-7ffb-11eb-9b84-8c6be4e94c0c.png)
Pagina que muestra el carrito de compra con los productos añadidos por el cliente.

![carritoconcosas](https://user-images.githubusercontent.com/63256402/110384169-8f55a280-805d-11eb-8c0e-ef09b9f57b78.png)
Una vez que el cliente se registre podrá añadir productos al carrito.

## Singin.html
![account](https://user-images.githubusercontent.com/63256402/110304131-816f3580-7ffb-11eb-8e4c-04e3077cc352.png)
Página en la que el cliente debe registrarse para poder comprar

## Createaccount.html
![newUser](https://user-images.githubusercontent.com/63256402/110304372-d27f2980-7ffb-11eb-9a98-bab3d8daef9a.png)
Página para nuevos usuarios en la que se piden datos del cliente.

## DatosClient.html
![datosCliente](https://user-images.githubusercontent.com/63256402/110304536-03f7f500-7ffc-11eb-8161-54b2d0dd0d44.png)
Página que enseña los datos del cliente.

## 6 - :pencil: Diagramas <a name="Diagramas">
# Diagrama De Navegación
![diagrama de navegacion](https://user-images.githubusercontent.com/63256402/110327917-e71eea00-801a-11eb-81ff-614245881db6.jpeg)
Diagrama que muestra la navegación entre las distintas pantallas de la página web.
## Diagrama de clases UML
  
![DiagramaUml](https://user-images.githubusercontent.com/63256402/110390140-d3e53c00-8065-11eb-91e9-6db19bbdbd72.jpeg)

## Diagrama E/R
![Diagrama entidad_relacion](https://user-images.githubusercontent.com/63256402/110317622-b0da6e00-800c-11eb-9a80-ae741759024f.jpeg)
Diagrama en el que se muestra la realación estre las entidades de la pagina web.



