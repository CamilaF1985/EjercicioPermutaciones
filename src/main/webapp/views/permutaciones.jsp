<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Generador de Permutaciones</title>

<!-- Enlace a Bootstrap v5.0.2 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>

<body>
	<!-- Formulario de Generación de permutaciones, es responsivo a distintos tamaños de pantalla -->
	<div class="container mt-5">
		<h1 class="text-center">Generador de Permutaciones</h1>

		<div class="row justify-content-center">
			<!-- Crear una fila de Bootstrap y centrar su contenido horizontalmente -->
			<div class="col-md-6">
				<!-- Crear una columna de Bootstrap con un ancho medio en dispositivos medianos -->
				<form id="permutationsForm"
					action="/ejercicioPermutacion/PermutacionesServlet" method="post"
					accept-charset="UTF-8">
					<!-- Crear un formulario con un ID y una acción para enviar datos al servlet -->
					<div class="form-group">
						<!-- Crear un grupo de formulario para el etiqueta y el campo de entrada -->
						<label for="word">Introduzca una palabra:</label>
						<!-- Etiqueta para el campo de entrada -->
						<input type="text" class="form-control" id="word" name="word"
							required>
						<!-- Campo de entrada de texto -->
					</div>
					<button type="submit" class="btn btn-primary mt-4">Generar
						Permutaciones</button>
					<!-- Botón de envío del formulario -->
				</form>
			</div>
		</div>

		<!-- Div donde se mostrarán las permutaciones -->
		<div id="permutationsResult" class="mt-4 col-md-6"
			style="border: 1px solid #ccc; max-width: 800px; padding: 10px; margin: 0 auto;"></div>
	</div>

	<!-- JavaScript para obtener y mostrar permutaciones -->
	<script>
		// Escuchar el evento de envío del formulario
		document.getElementById('permutationsForm').addEventListener('submit',
				function(event) {
					event.preventDefault(); // Evita que el formulario se envíe automáticamente
					showPermutations(); // Llama a la función para mostrar permutaciones
				});

		// Función para obtener y mostrar permutaciones
		function showPermutations() {
			// Obtén la palabra ingresada por el usuario
			var word = document.getElementById('word').value;

			// Realiza una solicitud POST al servlet utilizando el formulario
			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'PermutacionesServlet', true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded; charset=UTF-8');
			xhr.onload = function() {
				if (xhr.status === 200) {
					// Muestra las permutaciones en el div
					document.getElementById('permutationsResult').innerHTML = xhr.responseText;
				}
			};

			// Codifica la palabra para enviarla correctamente
			var formData = 'word=' + encodeURIComponent(word);

			// Envía la solicitud
			xhr.send(formData);
		}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



