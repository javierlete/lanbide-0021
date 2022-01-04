<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer class="fixed-bottom bg-dark text-light p-3 d-flex">
	<p class="me-auto">&copy;2021 Javier Lete</p>
	<p>
		<a class="text-light text-decoration-none" href="#"> <i
			class="bi bi-tiktok"></i>
		</a> <a class="text-light text-decoration-none" href="#"> <span
			class="bi bi-discord"></span>
		</a>

	</p>
</footer>

<script src="js/bootstrap.bundle.min.js"></script>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap5.min.js"></script>

<script>
	$(function() {
		$('table').DataTable({
			language : {
				url : 'json/dataTables_es_ES.json'
			}
		});
	});
</script>
<script>
	//Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict'

		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.querySelectorAll('.needs-validation')

		// Loop over them and prevent submission
		Array.prototype.slice.call(forms).forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})
	})()
</script>
</body>
</html>