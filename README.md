# La Reconquista Del Paladar

## Descripción general
Se desarrollará una aplicación web destinada a la venta de comida latinoamericana a domicilio, en la que los usuarios podrán navegar por las diferentes categorías de las comidas ofertadas sin necesidad de registrarse. Para formalizar el pedido deberán iniciar sesión con su usuario y completar su compra.

## Entidades principales
- Producto: Cada producto llevará asociado un identificador único, y contendrá datos específicos que lo describan junto al número de stock. 
- Cliente: Cada ususario tendrá su propio nombre de usuario, que será unico para cada uno, a parte de otros datos como su dirección y otros datos personales. El usuario podrá realizar de 0 a N pedidos.
- Pedido: esta entidad tendrá asociada un numero de productos y un usuario, asociandolos. Esta entidad tambien contendrá el coste final total.
- Categoría de productos: esta entidad llevará asosciado un identificador único y contendrá de 1 a N productos que se recojan en ella.

## Descripción servicio interno
\- Cuando el usuario hace un pedido se le enviará un correo electrónico con un pdf donde se incluirá el resumen de su pedido.

\- Servicio de pago online.


## Autor

#### Juan Carlos Flores Angulo
- jc.flores@alumnos.urjc.es
- GII + GIC 135
- ##### Github: [FinalBossRel](https://github.com/FinalBossRel)

## Home
![principal](https://user-images.githubusercontent.com/63256402/110303348-94353a80-7ffa-11eb-945d-0306e0dddb32.png)
Página principal donde se exponen algunos productos y se muestra un pequeño resumen.

## Contact
![contact](https://user-images.githubusercontent.com/63256402/110303627-e24a3e00-7ffa-11eb-9e3e-0cdce42ac5b2.png)
Página donde el usuario puede comunicarse con los administradores de la web.
