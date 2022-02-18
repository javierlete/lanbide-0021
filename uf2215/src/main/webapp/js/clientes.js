const url = "http://localhost:8081/uf2215/api/clientes/";

let formulario;
let nombre;
let apellido;

window.onload = function() {

	console.log('onload', 'ANTES DE PEDIR CLIENTES');

	pedirClientes();

	console.log('onload', 'DESPUÉS DE PEDIR CLIENTES');

	formulario = document.getElementById("formulario-clientes");
	nombre = document.getElementById("nombre");
	apellido = document.getElementById("apellido");

	formulario.onsubmit = envioFormulario;
};

async function envioFormulario(e) {
	e.preventDefault();

	const cliente = Object.fromEntries(new FormData(formulario));

	cliente.id = +formulario.dataset.id;

	console.log('envioFormulario', cliente);

	if (cliente.id) {
		await modificar(cliente);
	} else {
		await insertar(cliente);
	}

	limpiar();

	pedirClientes();
}

async function pedirClientes() {
	console.log('pedirClientes', 'INICIO');
	const tbody = document.querySelector("#tabla-clientes tbody");

	tbody.innerHTML = '';

	const respuesta = await fetch(url).catch(respuesta => respuesta);

	if (respuesta.ok) {
		mostrarAlerta('success', 'Clientes recibidos');
	} else {
		mostrarAlerta('danger', 'No se han podido obtener los clientes');
		return;
	}

	const clientes = await respuesta.json();

	console.log('pedirClientes', clientes);

	let fila;

	for (let cliente of clientes) {
		fila = document.createElement("tr");
		fila.innerHTML = `
			<th>${cliente.id}</th>
			<td>${cliente.nombre}</td>
			<td>${cliente.apellido}</td>
			<td>
				<a class="btn btn-primary btn-sm" href="javascript:editar(${cliente.id})">Editar</a>
				<a class="btn btn-danger btn-sm" href="javascript:borrar(${cliente.id})">Borrar</a>
			</td>`;
		tbody.appendChild(fila);
	}
}

async function insertar(cliente) {
	console.log('insertar', cliente);

	const respuesta = await fetch(url, {
		method: 'POST',
		body: JSON.stringify(cliente),
		headers: {
			'Content-Type': 'application/json'
		}
	}).catch(respuesta => respuesta);

	if (respuesta.ok) {
		mostrarAlerta('success', 'Cliente insertado');
	} else {
		mostrarAlerta('danger', 'No se ha podido insertar el cliente');
		return;
	}

	console.log('insertar', respuesta);
}

async function editar(id) {
	console.log('editar', id);

	const respuesta = await fetch(url + id);
	const cliente = await respuesta.json();

	nombre.value = cliente.nombre;
	apellido.value = cliente.apellido;

	formulario.dataset['id'] = cliente.id;
}

async function modificar(cliente) {
	console.log('modificar', cliente);

	const respuesta = await fetch(url + cliente.id, {
		method: 'PUT',
		body: JSON.stringify(cliente),
		headers: {
			'Content-Type': 'application/json'
		}
	});

	console.log('modificar', respuesta);
}

async function borrar(id) {
	console.log('borrar', id);

	const respuesta = await fetch(url + id, { method: 'DELETE' });

	console.log(respuesta);

	pedirClientes();
}

function limpiar() {
	nombre.value = '';
	apellido.value = '';
	delete formulario.dataset.id;
}

function mostrarAlerta(nivel, texto) {
	const contenido = `
		${texto}
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>`;

	const alerta = document.createElement('div');
	alerta.className = `alert alert-${nivel} alert-dismissible fade show`;
	alerta.role = 'alert';
	alerta.innerHTML = contenido;

	document.body.insertBefore(alerta, document.body.firstChild); 
}