const url = 'http://localhost:8081/ipartekify/api/';

document.addEventListener('DOMContentLoaded', async function() {
	const respuesta = await fetch(url + 'artistas');
	const artistas = await respuesta.json();

	const ulArtistas = document.getElementById("artistas");

	let liArtista;

	artistas.forEach(function(a) {
		liArtista = document.createElement('li');
		liArtista.className = 'nav-item';
		liArtista.innerHTML = `<a class="nav-link link-light" href="javascript:cargarArtista(${a.id})">${a.nombre}</a>`;

		ulArtistas.appendChild(liArtista);
	});
});

async function cargarArtista(id) {
	const respuesta = await fetch(url + 'artistas/' + id);
	const artista = await respuesta.json();

	document.querySelector('#artista > h1').innerText = artista.nombre;
	document.querySelector('#artista > p').innerText = artista.informacion;

	const respuesta2 = await fetch(url + 'artistas/' + id + '/albumes');
	const albumes = await respuesta2.json();

	const tbody = document.querySelector('#artista tbody');

	tbody.innerHTML = '';

	let tr;

	albumes.forEach(function(a) {
		tr = document.createElement('tr');
		tr.className = 'position-relative';
		tr.innerHTML = `<td>${a.id}</td>
						<td><img class="img-thumbnail" width="100" src="${a.foto}"
							alt=""></td>
						<td><a
							class="text-light stretched-link text-decoration-none"
							href="javascript:cargarAlbum(${a.id})">${a.nombre}</a></td>
						<td>${a.anno}</td>`;

		tbody.appendChild(tr);
	});

}

async function cargarAlbum(id) {
	const respuesta = await fetch(url + 'albumes/' + id);
	const album = await respuesta.json();

	document.querySelector('#album .card-title').innerText = album.nombre;
	document.querySelector('#album .card-text:first-of-type').innerText = album.anno;
	document.querySelector('#album .text-muted').innerText = album.artista.nombre;
	
	const tbody = document.querySelector('#album tbody');
	
	tbody.innerHTML = '';
	
	let tr;

	album.canciones.forEach(function(c) {
		tr = document.createElement('tr');
		tr.className = 'position-relative';
		tr.innerHTML = `<td>${c.id}</td>
						<td><a
							class="text-light stretched-link text-decoration-none"
							href="index?cancion=${c.id}">${c.nombre}</a></td>
						<td>${c.tiempoFormateado}<a
							class="text-success text-decoration-none elevado"
							href="index?cancion=${c.id}&favorito"> <i
								class="bi bi-heart${c.favorito ? '-fill': ''}"></i>
						</a>
							<div class="dropdown d-inline">
								<button class="btn btn-dark dropdown-toggle elevado"
									type="button" data-bs-toggle="dropdown" aria-expanded="false">...</button>
								<ul class="dropdown-menu bg-dark">

									<li><a class="dropdown-item link-light"
										href="index?nueva-cancion=${c.id}&amp;para-lista=l.id">l.nombre</a></li>

								</ul>
							</div> <a
							href="index?quitar-cancion=${c.id}&amp;para-lista=${-album.id}"
							class="elevado btn btn-sm btn-outline-danger"
							onclick="javascript:return confirm('¿Estás seguro de que quieres quitar ${c.nombre} de la lista ${album.nombre}?')">Quitar
								de lista</a>

						</td>`;
		tbody.appendChild(tr);
	});
}
