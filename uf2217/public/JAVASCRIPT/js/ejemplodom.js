window.onload = function () {
    const h1 = document.getElementsByTagName('h1')[0];

    h1.innerHTML = 'Hola mundo';

    const nombre = document.getElementById('nombre');
    const btnAceptar = document.getElementById('btn-aceptar');
    const resultado = document.getElementById('resultado');

    btnAceptar.onclick = function () {
        resultado.innerHTML = 'Hola ' + nombre.value;
    };

    const formulario = document.getElementById('formulario');

    formulario.onsubmit = function (e) {
        e.preventDefault();

        let valido = true;

        const dni = document.getElementById('dni');
        const email = document.getElementById('email');
        const password = document.getElementById('password');
        const password2 = document.getElementById('password2');

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

        if(password.value === password2.value) {
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

        if(valido) {
            const tbody = document.getElementsByTagName('tbody')[0];

            const tr = document.createElement('tr');

            tr.innerHTML = `<td>${dni.value}</td><td>${email.value}</td><td>${password.value}</td>`;

            tbody.appendChild(tr);
        }
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
