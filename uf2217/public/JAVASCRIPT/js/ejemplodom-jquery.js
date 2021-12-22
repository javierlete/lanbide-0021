var URL = 'http://localhost:3000/personas/';

$(function () {
    cargarTabla();

    $('h1').html('Hola Mundo desde jQuery');

    $('#btn-aceptar').on('click', function () {
        $('#resultado').html('Hola ' + $('#nombre').val());
    });

    $('#formulario').on('submit', enviarFormulario);
});

function enviarFormulario(e) {
    e.preventDefault();

    var valido = true;

    $dni = $('#dni');

    if (validarDni($dni.val())) {
        if ($dni.hasClass('error')) {
            $dni.removeClass('error');

            $dni.next('span').remove();
        }
    } else {
        if (!$dni.hasClass('error')) {
            $dni.addClass('error');

            $('<span>').addClass('error').html('El DNI no es válido').insertAfter($dni);
        }
        valido = false;
    }

    var $password = $('#password');
    var $password2 = $('#password2');

    if ($password.val() === $password2.val()) {
        if ($password.hasClass('error')) {
            $password.removeClass('error');

            $password.next('span').remove();
        }
    } else {
        if (!$password.hasClass('error')) {
            $password.addClass('error');

            $('span').addClass('error').html('Las contraseñas no coinciden').insertAfter($password);
        }
        valido = false;
    }

    if (valido) {
        var persona = { dni: dni.value, email: email.value, password: password.value };

        var id = $('#id').val();

        if (id === '0') {
            insertar(persona);
        } else {
            persona.id = +id;
            actualizar(persona);
        }

        cargarTabla();

        vaciarFormulario();
    }
}

function validarDni(dni) {
    if (!dni.match(/^[\dXYZ]\d{7}[A-Z]$/)) {
        return false;
    }

    var LETRAS = 'TRWAGMYFPDXBNJZSQVHLCKET';

    var letra = dni[8];
    var numero = dni.substring(0, 8)
        .replace('X', '0')
        .replace('Y', '1')
        .replace('Z', '2');

    var resto = numero % 23;
    var letraCorrecta = LETRAS[resto];

    return letra === letraCorrecta;
}

function cargarTabla() {
    $.getJSON(URL, function (personas) {

        console.log(personas);

        $('table').DataTable().destroy();

        var $tbody = $('tbody').html('');

        $(personas).each(function () {
            insertarLineaTabla(this, $tbody);
        });

        $('table').DataTable().draw();
    });
}

function insertarLineaTabla(persona, tbody) {
    $('<tr>').html("\n        <td>".concat(persona.dni, "</td>\n        <td>").concat(persona.email, "</td>\n        <td>").concat(persona.password, "</td>\n        <td>\n            <a href=\"javascript:modificar(").concat(persona.id, ")\">Editar</a>\n            <a href=\"javascript:borrar(").concat(persona.id, ")\">Borrar</a>\n        </td>")).appendTo(tbody);
}

function insertar(persona) {
    $.ajax({
        url: URL,
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(persona)
    }).done(function (persona) {
        console.log(persona);
    });
}

async function modificar(idABuscar) {
    console.log('MODIFICAR', idABuscar);

    $.getJSON(URL + idABuscar, function (persona) {
        $('#id').val(persona.id);
        $('#dni').val(persona.dni);
        $('#email').val(persona.email);
        $('#password').val(persona.password);
        $('#password2').val(persona.password);
    });
}

function actualizar(persona) {
    $.ajax({
        url: URL + persona.id,
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(persona)
    }).done(function (persona) {
        console.log(persona);
    });
}

function vaciarFormulario() {
    $('#id').val('0');
    $('#dni').val('');
    $('#email').val('');
    $('#password').val('');
    $('#password2').val('');
}

function borrar(id) {
    console.log('BORRAR', id);

    if (!confirm('¿Estás seguro de que quieres borrar la persona?')) {
        return;
    }

    $.ajax({
        url: URL + id,
        method: 'DELETE'
    }).done(function () {
         cargarTabla();
    });
}
