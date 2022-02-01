<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>

<script src="js/bootstrap.bundle.min.js"></script>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap5.min.js"></script>

<script>
	$(function() {
		$('table.admin').DataTable({
			language : {
				url : 'json/dataTables_es_ES.json'
			}
		});
	});
</script>

</body>
</html>