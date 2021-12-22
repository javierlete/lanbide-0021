const URL = 'http://localhost:3000/personas/';

let id;
let dni;
let email;
let password;
let password2;

window.onload = function () {
    id = document.getElementById('id');
    dni = document.getElementById('dni');
    email = document.getElementById('email');
    password = document.getElementById('password');
    password2 = document.getElementById('password2');

    cargarTabla();

    const h1 = document.getElementsByTagName('h1')[0];

    h1.innerHTML = 'Hola mundo';

    const nombre = document.getElementById('nombre');
    const btnAceptar = document.getElementById('btn-aceptar');
    const resultado = document.getElementById('resultado');

    btnAceptar.onclick = function () {
        resultado.innerHTML = 'Hola ' + nombre.value;
    };

    const formulario = document.getElementById('formulario');

    formulario.onsubmit = enviarFormulario;
}

function enviarFormulario(e) {
    e.preventDefault();

    let valido = true;

    if (validarDni(dni.value)) {
        if (dni.classList.contains('error')) {
            dni.classList.remove('error');

            dni.nextElementSibling.remove();
        }
    } else {
        if (!dni.classList.contains('error')) {
            dni.classList.add('error');

            const error = document.createElement('span');
            error.className = 'error';
            error.innerHTML = 'El DNI no es válido';

            dni.parentNode.appendChild(error);

        }
        valido = false;
    }

    if (password.value === password2.value) {
        if (password.classList.contains('error')) {
            password.classList.remove('error');

            password.nextElementSibling.remove();
        }
    } else {
        if (!password.classList.contains('error')) {
            password.classList.add('error');

            const error = document.createElement('span');
            error.className = 'error';
            error.innerHTML = 'Las contraseñas no coinciden';

            password.parentNode.appendChild(error);

        }
        valido = false;
    }

    if (valido) {
        const tbody = document.getElementsByTagName('tbody')[0];

        const persona = { dni: dni.value, email: email.value, password: password.value };

        if (id.value === '0') {
            insertar(persona);
        } else {
            persona.id = +id.value;
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

    const LETRAS = 'TRWAGMYFPDXBNJZSQVHLCKET';

    const letra = dni[8];
    const numero = dni.substring(0, 8)
        .replace('X', '0')
        .replace('Y', '1')
        .replace('Z', '2');

    const resto = numero % 23;
    const letraCorrecta = LETRAS[resto];

    return letra === letraCorrecta;
}

async function cargarTabla() {
    // fetch(URL).then(respuesta => respuesta.json()).then(personas => console.log(personas));
    const respuesta = await fetch(URL);
    const personas = await respuesta.json();
    console.log(personas);

    $('table').DataTable().destroy();

    const tbody = document.getElementsByTagName('tbody')[0];

    tbody.innerHTML = '';

    personas.forEach(persona => {
        insertarLineaTabla(persona, tbody);
    });

    $('table').DataTable().draw();
}

function insertarLineaTabla(persona, tbody) {
    const tr = document.createElement('tr');

    tr.innerHTML = `
        <td>${persona.dni}</td>
        <td>${persona.email}</td>
        <td>${persona.password}</td>
        <td>
            <a href="javascript:modificar(${persona.id})">Editar</a>
            <a href="javascript:borrar(${persona.id})">Borrar</a>
        </td>`;

    tbody.appendChild(tr);
}

async function insertar(persona) {
    const respuesta = await fetch(URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(persona)
    });

    const resultado = await respuesta.json();

    console.log(resultado);
}

async function modificar(idABuscar) {
    console.log('MODIFICAR', idABuscar);

    const respuesta = await fetch(URL + idABuscar);
    const persona = await respuesta.json();

    id.value = persona.id;
    dni.value = persona.dni;
    email.value = persona.email;
    password.value = persona.password;
    password2.value = persona.password;
}

async function actualizar(persona) {
    const respuesta = await fetch(URL + persona.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(persona)
    });

    const resultado = await respuesta.json();

    console.log(resultado);
}

function vaciarFormulario() {
    id.value = '0';
    dni.value = '';
    email.value = '';
    password.value = '';
    password2.value = '';
}

async function borrar(id) {
    console.log('BORRAR', id);

    if (!confirm('¿Estás seguro de que quieres borrar la persona?')) {
        return;
    }

    const respuesta = await fetch(URL + id, {
        method: 'DELETE'
    });

    console.log(respuesta);

    cargarTabla();
}