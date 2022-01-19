<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="lead">${seleccionado.nombre}</h2>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://placeimg.com/640/640/people"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${seleccionado.nombre}</h5>
				<p class="card-text">${seleccionado.email}</p>
				<p class="card-text" style="white-space: break-spaces">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas volutpat tempor urna. Phasellus sed dolor vitae dui rhoncus fermentum. Nam et posuere velit, sed pulvinar erat. Aenean efficitur viverra mattis. Donec gravida, urna pulvinar ullamcorper convallis, enim erat consequat dui, in suscipit nulla orci in lectus. In faucibus arcu nec sem consequat, quis aliquet elit varius. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque venenatis justo et vulputate vehicula.

Maecenas tempus lacinia risus non convallis. Aliquam lacinia aliquam aliquet. Praesent sed metus sit amet lorem porttitor tristique. Cras auctor at tellus eu mollis. Duis lacinia vulputate ipsum. Maecenas sollicitudin euismod libero, quis vestibulum massa vulputate vel. Morbi porta scelerisque cursus. In malesuada vestibulum lorem, et tempor mi mollis id. Etiam imperdiet turpis id vestibulum facilisis. Mauris ullamcorper dolor tempus molestie varius. Fusce facilisis semper neque sit amet congue. Nulla a mollis sem.

Cras nec commodo tortor. Vestibulum in ornare tellus. Nulla mattis dictum mauris vel eleifend. Curabitur id pharetra enim. Duis facilisis posuere odio, non ullamcorper tellus aliquet sed. In pellentesque justo at euismod tincidunt. In nec venenatis odio. Phasellus vel sollicitudin leo, ut mollis metus. In hac habitasse platea dictumst. Etiam elit enim, congue id sapien ut, dapibus rutrum risus. Fusce quis lacinia eros. Proin tincidunt laoreet massa, vitae scelerisque dui feugiat et. Sed malesuada ullamcorper ante, aliquam facilisis orci tempus at. Quisque luctus tellus et sem rutrum, ut euismod dolor elementum. Ut at feugiat eros, eget sollicitudin ante. Aliquam erat volutpat.</p>
				<p class="card-text"><small class="text-muted">${seleccionado.rol.nombre}:
					${seleccionado.rol.descripcion}</small></p>
				<a href="equipo?op=agregar&id=${seleccionado.id}" class="btn btn-primary">Añadir al equipo</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>