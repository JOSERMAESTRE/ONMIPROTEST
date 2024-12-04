# ID: TC001
Feature: Registro de usuario
  Como usuario del sistema
  Quiero registrar una nueva cuenta
  Para poder acceder a todas las funcionalidades de la plataforma

  Background:
    Given el usuario está en la página de registro

  Scenario Outline: Registro exitoso de un usuario
    When el usuario ingresa su información:
      | Género  | Nombre | Apellido | Email           | Contraseña | Confirmar Contraseña |
      | <género> | <nombre> | <apellido> | <email> | <contraseña> | <confirmar_contraseña> |
    And el usuario hace clic en el botón "Registrarse"
    Then el sistema muestra un mensaje de éxito "Registro completado exitosamente"

    Examples:
      | género | nombre | apellido | email           | contraseña | confirmar_contraseña |
      | Male   | jose   | maestre  | joserm@gmail.com | 123456     | 123456              |

# ID: TC002
Feature: Inicio de sesión de usuario
  Como usuario registrado en el sistema
  Quiero iniciar sesión con mis credenciales
  Para acceder a mi cuenta y funcionalidades del sistema

  Background:
    Given el usuario está en la página de inicio de sesión
    And el usuario está registrado en el sistema con las siguientes credenciales:
      | Email           | Contraseña |
      | joserm@gmail.com | 123456     |

  Scenario Outline: Inicio de sesión exitoso con credenciales válidas
    When el usuario ingresa sus credenciales:
      | Email           | Contraseña |
      | <email>         | <contraseña> |
    And el usuario hace clic en el botón "Iniciar Sesión"
    Then el sistema muestra el mensaje de bienvenida "Bienvenido, <email>"
    And el usuario es redirigido a la página principal de su cuenta

    Examples:
      | email            | contraseña |
      | joserm@gmail.com | 123456     |


# ID: TC003
Feature: Compra de un producto como invitado
  Como usuario no registrado
  Quiero buscar un producto, agregarlo al carrito y comprarlo como invitado
  Para adquirir el producto sin necesidad de registrarme

  Background:
    Given el usuario está en la página principal del sitio web

  Scenario: Realizar una compra como invitado
    When el usuario busca un producto en la barra de búsqueda
    And selecciona el producto deseado de los resultados
    And agrega el producto al carrito
    And procede al checkout desde el carrito
    And selecciona la opción "Comprar como invitado"
    And completa las siguientes secciones con sus datos:
      | Sección    |
      | Address    |
      | Shipping   |
      | Payment    |
      | Confirm    |
    Then el sistema muestra el mensaje de éxito "Compra completada exitosamente"
    And el usuario ve un resumen de su pedido con el número de orden


# ID: TC004
Feature: Navegación en modo responsive para iPhone XR
  Como usuario que navega desde un dispositivo móvil
  Quiero interactuar con el menú hamburguesa en modo responsive
  Para acceder a la sección de computadores de escritorio correctamente

  Background:
    Given el navegador está configurado en modo responsive para iPhone XR
    And el usuario está en la página principal del sitio web

  Scenario: Navegar a la sección de computadores de escritorio
    When el usuario hace clic en el menú hamburguesa
    And selecciona el menú "Computadores"
    And hace clic en la opción "Desktop"
    Then el sistema redirige al usuario a la pantalla de computadores de escritorio

# ID: TC005
Feature: Proceso de compra en modo responsive para iPhone XR
  Como usuario que navega desde un dispositivo móvil
  Quiero seleccionar un producto, configurarlo y agregarlo al carrito
  Para completar la compra con éxito

  Background:
    Given el navegador está configurado en modo responsive para iPhone XR
    And el usuario está en la página principal del sitio web

  Scenario: Agregar un producto personalizado al carrito
    When el usuario hace clic en el producto "Build your own computer" en la página de inicio
    And selecciona las siguientes opciones:
      | Processor              | 2.5 GHz Intel Pentium Dual-Core E2200 [+15.00] |
      | RAM                    | 8GB [+60.00]                                     |
      | HDD                    | 320 GB [+0.00]                                  |
      | OS                     | Ubuntu [+50.00]                                 |
      | Software               | Microsoft Office [+50.00], Acrobat Reader [+10.00] |
    And hace clic en el botón "Add to cart"
    Then el sistema muestra el mensaje de confirmación

    # ID: TC006
Feature: Realizar una búsqueda avanzada en modo responsive para iPhone XR
  Como usuario navegando desde un dispositivo móvil
  Quiero realizar una búsqueda avanzada para encontrar productos específicos
  Para facilitar la selección y compra

  Background:
    Given el navegador está configurado en modo responsive para iPhone XR
    And el usuario está en la página principal del sitio web

  Scenario Outline: Realizar una búsqueda avanzada de productos
    When el usuario escribe "<palabra_clave>" en la barra principal de búsqueda
    And selecciona la opción "Advanced search"
    And selecciona la categoría "<categoría>"
    And marca "<buscar_subcategorías>"
    And selecciona "<fabricante>" en el campo "Manufacturer"
    And ingresa el rango de precios "From <rango_inferior> to <rango_superior>"
    And marca "<buscar_descripciones>" en "Search in product descriptions"
    And presiona el botón "Search"
    Then el sistema muestra los resultados de búsqueda correspondientes a los criterios ingresados

  Examples:
    | palabra_clave | categoría  | buscar_subcategorías | fabricante | rango_inferior | rango_superior | buscar_descripciones |
    | computer       | Computers  | Yes                 | All        | 800            | 1200           | Yes                  |


