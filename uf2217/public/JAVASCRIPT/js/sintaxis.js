'use strict';

// basico();

// funciones();

// arrays();

objetos();

function objetos() {
    let objeto = new Object();

    // alert(objeto);
    console.log(objeto);

    objeto.propiedad = 'Valor';
    objeto.loQueMeDeLaGana = 'Lo que quiera';
    objeto['clave'] = 'Otro valor';

    objeto.metodo = function () {
        console.log(this.propiedad, this.loQueMeDeLaGana, this.clave);
    };

    console.log(objeto);
    objeto.metodo();

    function Persona(id, nombre, apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    Persona.prototype.nombreCompleto = function () {
        return this.nombre + ' ' + this.apellidos;
    };

    const persona = new Persona(1, 'Pepe', 'García');

    persona.sueldo = 10000;

    console.log(persona, typeof persona);

    const javier = new Persona(2, 'Javier', 'Lete');

    console.log(javier);

    console.log(javier.nombreCompleto());

    console.log('Hola'.toUpperCase());
    
    String.prototype.toUpperCase = function () {
        return 'TE HE TROLEADO';
    };
    
    console.log('Hola'.toUpperCase());

    Date.prototype.saludar = () => 'Olakease';

    console.log(new Date().saludar());
}

function arrays() {
    const arr = [1, 3, 5, 7, 9]; // new Array(5);

    console.log(arr, arr.length);

    arr[0] = 2;

    console.log(arr[0], arr);

    arr[5] = 10;

    arr[10] = 15;

    arr[7] = 'Pepe';

    arr[15] = new Date();

    arr[20] = function () {
        console.log('Hola');
    }

    arr[20]();

    arr['texto'] = 'Text';

    arr.casa = 'Home';

    console.log(arr.texto);

    arr.push('Nuevo');

    console.log(arr);

    for (let i = 0; i < arr.length; i++) {
        console.log(i, arr[i]);
    }

    for (let dato of arr) {
        console.log(dato);
    }

    for (let clave in arr) {
        console.log(clave, arr[clave]);
    }
}

function funciones() {
    function suma(a, b) {
        return a + b;
    }

    var resta = function (a, b) {
        return a - b;
    };

    var multiplicacion = (a, b) => a * b;

    console.log(suma(5, 3));
    console.log(resta(5, 3));
    console.log(multiplicacion(5, 3));

    var operacion = resta;

    console.log(operacion(5, 3));

    operacion = suma;

    console.log(operacion(5, 3));

    // Ejemplo calculadora

    let a = 5; // Introducimos un número

    operacion = multiplicacion; // Seleccionamos una operación ('*')

    let b = 3; // Introducimos el segundo número

    console.log(operacion(a, b)); // Ejecutamos la operación ('=')
}

function basico() {

    alert('Dentro del fichero');
    var sino = confirm('¿Estás seguro?');

    console.log(sino);

    console.log(typeof sino);

    // if (sino = true) { // Error de asignación dentro del if
    if (sino === true) {
        alert('Sí');
    } else {
        alert('No');
    }

    sino = 5;

    console.log(typeof sino);

    console.log(mivariable);

    var mivariable = 5;

    // ES2015 let y const

    let nombreCompleto;

    const nombre = prompt('Introduce tu nombre');

    console.log(nombre);

    console.log(typeof nombre);

    nombreCompleto = nombre;

    const apellidos = prompt('Introduce tus apellidos');

    nombreCompleto = nombre + ' ' + apellidos;

    // ES2015 Template String

    nombreCompleto = `${nombre} ${apellidos}`;

    console.log(nombreCompleto);

    const fecha = new Date();

    console.log(fecha.toISOString());

    console.log(typeof fecha);

    // Conversiones

    const numero = parseInt(prompt('Dame un número'));

    console.log(numero, typeof numero);

    if (isNaN(numero)) {
        console.log('No has introducido un número');
    } else {

        // if( numero = 10) { // ERROR AL MODIFICAR CONST
        if (numero === 10) {
            console.log('El número es 10');
        }

        const operacion = numero + 5;

        console.log('El número + 5 es ' + operacion);
    }
}