<%@ page import="model.entity.Reserva" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel SUMAK KAWSAY HOTELS</title>
    <link rel="icon" href="./img/logo.ico">
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


        <% if (request.getAttribute("mensajeExito") != null) { %>
        <p><%= request.getAttribute("mensajeExito") %></p>
        <% } %>

    <!-- Contenido principal de tu página -->
    <div class="">
        <img src="./img/Logo_Hotel.png" alt="Img" style="display: block; margin: 0 auto; width: 600px; background-color: #f4f4f4;">
        <div class="reservation-form">
            <input type="date" placeholder="Llegada" id="llegada" class="fecha">
            <input type="date" placeholder="Salida" id="salida" class="fecha">
            <select id="huespedes">
                <option value="selected"selected>No. Huespedes</option>
                <option value="2">2 Huéspedes</option>
                <option value="3">3 Huéspedes</option>
                <option value="4">4 Huéspedes</option>
            </select>
            <select id="tipo-habitacion">
                <option value="selected" selected>Tipo Habitación</option>
                <option value="deluxe">Deluxe Access</option>
                <option value="premium">Premium Access</option>
                <option value="vip">Vip Access</option>
            </select>
            <select id="Ubicacion">
                <option value="selected" selected>Ubicacion</option>
                <option value="Quito">Quito</option>
                <option value="Guayaquil">Guayaquil</option>
                <option value="Cuenca">Cuenca</option>
            </select>
            </select>
            <button id="reservar-ahora">BUSCAR</button>
            <button id="reservar-resetear">BORRAR</button>
        </div>
    </div>


    <div class="row room-list">
        <div class="columna deluxe 2Huesped room-item Guayaquil">
            <img src="./img/cuarto_1.avif" alt="Imagen de la Broadway Suite">
            <div class="room-details">
                <h3>Broadway Suite</h3>
                <div class="room-info">
                    <p>Habitación: 101 - Ubicación (Guayaquil)</p>
                    <p>Precio: $250 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 2 personas</p>
                    <p>Categoría: Deluxe</p>
                </div>
                <p>Nuestras habitaciones <strong>Deluxe Access</strong> ofrecen un confort excepcional con una elegante decoración y modernas comodidades. Están equipadas con una cama king-size, TV de pantalla plana, minibar y un espacioso baño privado con artículos de aseo premium. Disfruta de una estancia relajante con vistas impresionantes y acceso a Wi-Fi de alta velocidad.</p>
                <button onclick="mostrarFormulario('Broadway Suite', '101')">Reservar</button>
            </div>
        </div>
        <div class="columna premium 3Huesped room-item Quito">
            <img src="./img/cuarto_2.webp" alt="Imagen de Wall Street Loft">
            <div class="room-details">
                <h3>Wall Street Loft</h3>
                <div class="room-info">
                    <p>Habitación: 102 - Ubicación (Quito)</p>
                    <p>Precio: $200 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 3 personas</p>
                    <p>Categoría: Premiun</p>
                </div>
                <p>Nuestras habitaciones <strong>Premium Access</strong> ofrecen una experiencia de lujo y comodidad. Equipadas con una cama king-size, TV de alta definición, minibar y baño lujoso, estas habitaciones son perfectas para aquellos que buscan un nivel superior de confort durante su estancia. Además, los huéspedes disfrutan de acceso exclusivo a nuestro Club Lounge, donde pueden disfrutar de desayunos gratuitos y bebidas durante todo el día.</p>
                <button onclick="mostrarFormulario('Wall Street Loft', '102')">Reservar</button>
            </div>
        </div>
        <div class="columna vip 4Huesped room-item Cuenca">
            <img src="./img/cuarto_3.jpg" alt="Imagen de Fifth Avenue Penthouse">
            <div class="room-details">
                <h3>Fifth Avenue Penthouse - Ubicación (Cuenca)</h3>
                <div class="room-info">
                    <p>Habitación: 103</p>
                    <p>Precio: $150 por noche</p>
                </div>
                <div class="room-info">
                    <p>Capacidad: 4 personas</p>
                    <p>Categoría: Vip</p>
                </div>
                <p>Las habitaciones <strong>VIP Access</strong> son la cúspide del lujo y la exclusividad. Con amplios espacios y servicios personalizados, estas habitaciones ofrecen una experiencia inigualable. Equipadas con una cama king-size, TV inteligente, minibar y baño de lujo, las habitaciones VIP Access son perfectas para aquellos que buscan un servicio excepcional y atención dedicada durante su estancia.</p>
                <button onclick="mostrarFormulario('Fifth Avenue Penthouse', '103')">Reservar</button>
            </div>
        </div>
    </div>



    <!-- Formulario oculto para reservar habitación -->
    <div id="formulario" style="display: none;">
        <button id="cerrarFormulario" onclick="cerrarFormulario()">X</button>
        <h2>Reservar Habitación</h2>

        <form action="reservar-servlet" method="POST" onsubmit="return validarFormulario();">
            <p>Nombre de la habitación: <span id="nombreHabitacion">Wall Street Loft</span></p>
            <p>Número de la habitación: <span id="numeroHabitacion">102</span></p>

            <input type="hidden" id="numeroHabitacionInput" name="numeroHabitacion" value="102">

            <div class="form-group">
                <label for="cedula">Cédula:</label>
                <input type="text" id="cedula" name="cedula" required>
            </div>

            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>

            <div class="form-group">
                <label for="checkIn">Check In:</label>
                <input type="date" id="checkIn" name="checkIn" required>
            </div>

            <div class="form-group">
                <label for="checkOut">Check Out:</label>
                <input type="date" id="checkOut" name="checkOut" required>
            </div>

            <div class="form-group">
                <label for="cantidadPersonas">Cantidad de Personas:</label>
                <input type="number" id="cantidadPersonas" name="cantidadPersonas" min="1" required>
            </div>

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
            var tipoHabitacion = document.getElementById('tipo-habitacion').value.replace(' ', '_');
            var ubicacion = document.getElementById('Ubicacion').value;

            var habitaciones = document.querySelectorAll('.row .columna');
            habitaciones.forEach(function(habitacion) {
                var esTipoCorrecto = tipoHabitacion !== 'selected' ? habitacion.classList.contains(tipoHabitacion) : true;
                var esHuespedesCorrecto = huespedes !== 'selected' ? habitacion.classList.contains(huespedes + 'Huesped') : true;
                var esUbicacionCorrecta = ubicacion !== 'selected' ? habitacion.classList.contains(ubicacion) : true;

                if (esTipoCorrecto && esHuespedesCorrecto && esUbicacionCorrecta) {
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
            document.getElementById('Ubicacion').value = 'selected';

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
