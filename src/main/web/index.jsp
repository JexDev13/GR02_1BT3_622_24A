<%@ page import="model.entity.Reserva" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel NewYork - Reservas</title>
    <link rel="stylesheet" href="./css/index.css"> <!-- Enlazar el archivo CSS externo -->
    <script>
        // Función para mostrar el formulario cuando se presiona el botón "Reservar"
        function mostrarFormulario(nombreHabitacion, numeroHabitacion) {
            // Obtener el formulario y el párrafo para mostrar el nombre y número de la habitación
            var formulario = document.getElementById("formulario");
            var nombreHabitacionElemento = document.getElementById("nombreHabitacion");
            var numeroHabitacionElemento = document.getElementById("numeroHabitacion");
            var numeroHabitacionInput = document.getElementById("numeroHabitacionInput");
            // Establecer el nombre y número de la habitación en los elementos correspondientes
            nombreHabitacionElemento.textContent = nombreHabitacion;
            numeroHabitacionElemento.textContent = numeroHabitacion;
            numeroHabitacionInput.value = numeroHabitacion;

            // Mostrar el formulario
            formulario.style.display = "block";
        }

        function cerrarFormulario() {
            var formulario = document.getElementById("formulario");
            formulario.style.display = "none";

            // Limpiar los campos del formulario
            document.getElementById("cedula").value = "";
            document.getElementById("checkIn").value = "";
            document.getElementById("checkOut").value = "";
            document.getElementById("cantidadPersonas").value = "";
        }

    </script>
</head>
<body>
<header>
    <!-- Encabezado de tu página -->
    <h1 id="titulo">Gran Hotel NewYork</h1>
</header>

<main>
    <!-- Contenido principal de tu página -->
    <div class="row">
        <div class="columna">
            <img src="./img/cuarto_1.avif" alt="Imagen 1">
            <p>Broadway Suite</p>
            <p>Habitación: 101</p>
            <p>Precio($): 150</p>
            <p>Capacidad: 2</p>
            <button onclick="mostrarFormulario('Broadway Suite', '101')">Reservar</button>
        </div>
        <div class="columna">
            <img src="./img/cuarto_2.webp" alt="Imagen 2">
            <p>Wall Street Loft</p>
            <p>Habitación: 102</p>
            <p>Precio($): 200</p>
            <p>Capacidad: 3</p>
            <button onclick="mostrarFormulario('Wall Street Loft', '102')">Reservar</button>
        </div>
        <div class="columna">
            <img src="./img/cuarto_3.jpg" alt="Imagen 3">
            <p>Fifth Avenue Penthouse</p>
            <p>Habitación: 103</p>
            <p>Precio($): 300</p>
            <p>Capacidad: 4</p>
            <button onclick="mostrarFormulario('Fifth Avenue Penthouse', '103')">Reservar</button>
        </div>
    </div>

    <!-- Formulario oculto para reservar habitación -->
    <div id="formulario" style="display: none;">
        <button id="cerrarFormulario" onclick="cerrarFormulario()">X</button>
        <h2>Reservar Habitacion</h2>


        <form action="reservar-servlet" method="POST"> <!-- Cambiado a ReservaServlet y método POST -->

            <p>Nombre de la habitacion: <span id="nombreHabitacion"></span></p>
            <p>Numero de la habitación: <span id="numeroHabitacion"></span></p>

            <input type="hidden" id="numeroHabitacionInput" name="numeroHabitacion">

            <label for="cedula">Cedula:</label>
            <input type="text" id="cedula" name="cedula" required><br>

            <label for="nombre">Nombre:</label> <!-- Agregado campo de nombre -->
            <input type="text" id="nombre" name="nombre" required><br>

            <label for="checkIn">Check In:</label>
            <input type="date" id="checkIn" name="checkIn" required><br>

            <label for="checkOut">Check Out:</label>
            <input type="date" id="checkOut" name="checkOut" required><br>

            <label for="cantidadPersonas">Cantidad de Personas:</label>
            <input type="number" id="cantidadPersonas" name="cantidadPersonas" min="1" required><br>

            <input type="submit" value="Reservar">
        </form>

    </div>



</main>

</body>
</html>
