<%@ page import="model.entity.Reserva" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel NewYork - Reservas</title>
    <link rel="stylesheet" href="./css/index.css"> <!-- Enlazar el archivo CSS externo -->
    <script>
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

        function validarFormulario() {
            var checkIn = document.getElementById("checkIn");
            var checkOut = document.getElementById("checkOut");
            var cedula = document.getElementById("cedula");

            // Obtener la fecha actual
            var fechaActual = new Date();
            fechaActual.setHours(0, 0, 0, 0); // Asegurarse de que la hora sea 00:00:00

            // Validar que el checkIn no sea anterior a la fecha actual
            if (new Date(checkIn.value) < fechaActual) {
                alert("La fecha de entrada no puede ser anterior a la fecha actual.");
                return false;
            }

            // Validar que el checkOut no sea menor o igual al checkIn
            if (new Date(checkOut.value) <= new Date(checkIn.value)) {
                alert("La fecha de salida no puede ser menor o igual a la fecha de entrada.");
                return false;
            }

            // Validar que la cédula solo contenga números
            if (!/^\d+$/.test(cedula.value)) {
                alert("Cédula es Invalida.");
                return false;
            }

            return true;
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

       window.onload = function() {
           var habitaciones = document.querySelectorAll('.row .columna');
           habitaciones.forEach(function(habitacion) {
               habitacion.style.display = 'none';
           });
       };
    </script>
</head>
<body>
<header>
    <!-- Encabezado de tu página --<h1 id="titulo">Gran Hotel NewYork</h1>-->
</header>

<main>
    <!-- Contenido principal de tu página -->
    <div class="">
        <img src="./img/Logo_Hotel.png" alt="Img" style="display: block; margin: 0 auto; width: 600px; background-color: #f4f4f4;">
        <div class="reservation-form">
            <input type="date" placeholder="Llegada" id="llegada" class="fecha">
            <input type="date" placeholder="Salida" id="salida" class="fecha">
            <select id="huespedes">
                <option value="selected"selected>Seleccione</option>
                <option value="2">2 Huéspedes</option>
                <option value="3">3 Huéspedes</option>
                <option value="4">4 Huéspedes</option>
            </select>
            <select id="tipo-habitacion">
                <option value="selected" selected>Seleccione</option>
                <option value="individual">Individual</option>
                <option value="doble">Doble</option>
                <option value="suite">Suite</option>
            </select>
            <button id="reservar-ahora">BUSCAR</button>
            <button id="reservar-resetear">BORRAR</button>
        </div>
    </div>


    </form>
    <div class="row room-list">
        <div class="columna individual 2Huesped room-item" >
            <img src="./img/cuarto_1.avif" alt="Imagen de la Broadway Suite">
            <div class="room-details">
                <h3>Broadway Suite</h3>
                <div class="room-info">
                    <p>Habitación: 101</p>
                    <p>Precio: $150 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 2 personas</p>
                    <p>Categoría: Individual</p>
                </div>
                <p>Descripción: Disfruta de la elegancia y comodidad en nuestra Broadway Suite, equipada con todas las comodidades modernas, incluyendo WiFi gratuito, televisión por cable y un minibar. Perfecta para viajeros de negocios o una escapada romántica.</p>
                <button onclick="mostrarFormulario('Broadway Suite', '101')">Reservar</button>
            </div>
        </div>
        <div class="columna doble 3Huesped room-item">
            <img src="./img/cuarto_2.webp" alt="Imagen de Wall Street Loft">
            <div class="room-details">
                <h3>Wall Street Loft</h3>
                <div class="room-info">
                    <p>Habitación: 102</p>
                    <p>Precio: $200 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 3 personas</p>
                    <p>Categoría: Doble</p>
                </div>
                <p>Descripción: Experimenta el estilo contemporáneo en nuestro Wall Street Loft. Con un diseño moderno y espacioso, esta habitación ofrece WiFi gratuito, televisión de pantalla plana y un escritorio de trabajo, ideal para familias pequeñas o grupos de amigos.</p>
                <button onclick="mostrarFormulario('Wall Street Loft', '102')">Reservar</button>
            </div>
        </div>
        <div class="columna suite 4Huesped room-item">
            <img src="./img/cuarto_3.jpg" alt="Imagen de Fifth Avenue Penthouse">
            <div class="room-details">
                <h3>Fifth Avenue Penthouse</h3>
                <div class="room-info">
                    <p>Habitación: 103</p>
                    <p>Precio: $300 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 4 personas</p>
                    <p>Categoría: Suite</p>
                </div>
                <p>Descripción: Vive el lujo en nuestro Fifth Avenue Penthouse. Esta suite cuenta con espacios amplios, decoración elegante, y vistas impresionantes de la ciudad. Incluye WiFi gratuito, una cocina completamente equipada y un baño de lujo, perfecto para familias grandes o estancias prolongadas.</p>
                <button onclick="mostrarFormulario('Fifth Avenue Penthouse', '103')">Reservar</button>
            </div>
        </div>
    </div>



    <!-- Formulario oculto para reservar habitación -->
    <div id="formulario" style="display: none;">
        <button id="cerrarFormulario" onclick="cerrarFormulario()">X</button>
        <h2>Reservar Habitacion</h2>


        <form action="reservar-servlet" method="POST" onsubmit="return validarFormulario();">

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

<script>
    document.addEventListener('DOMContentLoaded', (event) => {
        document.getElementById('reservar-ahora').addEventListener('click', function(event) {
            event.preventDefault();

            var llegada = document.getElementById('llegada').value;
            var salida = document.getElementById('salida').value;
            var huespedes = document.getElementById('huespedes').value;
            var tipoHabitacion = document.getElementById('tipo-habitacion').value;

            var habitaciones = document.querySelectorAll('.row .columna');
            habitaciones.forEach(function(habitacion) {
                var esTipoCorrecto = tipoHabitacion !== 'selected' ? habitacion.classList.contains(tipoHabitacion) : false;
                var esHuespedesCorrecto = huespedes !== 'selected' ? habitacion.classList.contains(huespedes + 'Huesped') : false;
                if ((esTipoCorrecto && esHuespedesCorrecto) || (tipoHabitacion === 'selected' && esHuespedesCorrecto) || (huespedes === 'selected' && esTipoCorrecto) || (tipoHabitacion === 'selected' && huespedes === 'selected')) {
                    habitacion.style.display = 'block';
                } else {
                    habitacion.style.display = 'none';
                }
            });
        });

        document.getElementById('reservar-resetear').addEventListener('click', function(event) {
            event.preventDefault();

            // Restablecer los valores de los campos de búsqueda
            document.getElementById('llegada').value = '';
            document.getElementById('salida').value = '';
            document.getElementById('huespedes').value = 'selected';
            document.getElementById('tipo-habitacion').value = 'selected';

            // Ocultar todas las habitaciones
            var habitaciones = document.querySelectorAll('.row .columna');
            habitaciones.forEach(function(habitacion) {
                habitacion.style.display = 'none';
            });
        });

    });
</script>

</body>
</html>
