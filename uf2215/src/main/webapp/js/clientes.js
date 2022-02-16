const url = "http://localhost:8081/uf2215/api/clientes/";

window.onload = async function() {

	pedirClientes();

	const formulario = document.getElementById("formulario-clientes");

	formulario.onsubmit = async function(e) {
		e.preventDefault();

		const cliente = Object.fromEntries(new FormData(formulario));

		const respuesta = await fetch(url, {
			method: 'POST',
			body: JSON.stringify(cliente),
			headers: {
				'Content-Type': 'application/json'
			}
		});

		console.log(formulario);
		console.log(cliente);
		console.log(respuesta);

		pedirClientes();
	}
};

async function pedirClientes() {
	const tbody = document.querySelector("#tabla-clientes tbody");

	tbody.innerHTML = '';

	const respuesta = await fetch(url);
	const clientes = await respuesta.json();

	console.log(tbody);
	console.log(respuesta);
	console.log(clientes);

	let fila;

	for (let cliente of clientes) {
		fila = document.createElement("tr");
		fila.innerHTML = `<th>${cliente.id}</th><td>${cliente.nombre}</td><td>${cliente.apellido}</td>`;
		tbody.appendChild(fila);
	}
}