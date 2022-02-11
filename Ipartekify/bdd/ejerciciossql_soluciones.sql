-- 1. Obtener los datos completos de los empleados.

SELECT 
    *
FROM
    empleado;

-- 2. Obtener los datos completos de los departamentos

SELECT 
    *
FROM
    departamento;

-- 3. Obtener los datos de los empleados con cargo 'Secretaria'.

SELECT 
    *
FROM
    empleado
WHERE
    cargoE = 'Secretaria';

-- 4. Obtener el nombre y salario de los empleados.

SELECT 
    nomEmp, salEmp
FROM
    empleado;

-- 5. Obtener los datos de los empleados vendedores, ordenado por nombre.

SELECT 
    *
FROM
    empleado
WHERE
    cargoE = 'Vendedor'
ORDER BY nomEmp;

-- 6. Listar el nombre de los departamentos

SELECT DISTINCT
    nombreDpto
FROM
    departamento;

-- 7. Listar el nombre de los departamentos, ordenado por nombre

SELECT DISTINCT
    nombreDpto
FROM
    departamento
ORDER BY nombreDpto;

-- 8. Listar el nombre de los departamentos, ordenado por ciudad

SELECT DISTINCT
    nombreDpto, ciudad
FROM
    departamento
ORDER BY ciudad;

-- 9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso

SELECT DISTINCT
    nombreDpto, ciudad
FROM
    departamento
ORDER BY ciudad DESC;

-- 10. Obtener el nombre y cargo de todos los empleados, ordenado por salario

SELECT 
    nomEmp, cargoE, salEmp
FROM
    empleado
ORDER BY salEmp;

-- 11. Obtener el nombre y cargo de todos los empleados, ordenado por cargo y por salario

SELECT DISTINCT
    nomEmp, cargoE, salEmp
FROM
    empleado
ORDER BY cargoE , salEmp;

-- 12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo

SELECT DISTINCT
    nomEmp, cargoE
FROM
    empleado
ORDER BY cargoE DESC;

-- 13. Listar los salarios y comisiones de los empleados del departamento 2000

SELECT 
    salEmp, comisionE
FROM
    empleado
WHERE
    codDepto = 2000;

-- 14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión

SELECT 
    salEmp, comisionE
FROM
    empleado
WHERE
    codDepto = 2000
ORDER BY comisionE

-- 15. Listar todas las comisiones

SELECT 
    comisionE
FROM
    empleado

-- 16. Listar las comisiones que sean diferentes, ordenada por valor

SELECT DISTINCT
    comisionE
FROM
    empleado
ORDER BY comisionE

-- 17. Listar los diferentes salarios

SELECT DISTINCT
    salEmp
FROM
    empleado

-- 18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
-- bonificación de $500.000, en orden alfabético del empleado

SELECT 
    nomEmp, salEmp + comisionE + 500000 AS pagar
FROM
    empleado
WHERE
    codDepto = 3000
ORDER BY nomEmp

-- 19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.

SELECT 
    *
FROM
    empleado
WHERE
    comisionE > salEmp;

-- 20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.

SELECT 
    *
FROM
    empleado
WHERE
    comisionE <= salEmp * 0.3;

-- 21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para
-- cada empleado

SELECT 
    'Nombre', nomEmp, 'Cargo', cargoE
FROM
    empleado;

-- 22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es
-- superior al '19.709.802'

SELECT 
    CAST(REPLACE(nDIEmp, '.', '') AS UNSIGNED) AS id,
    nDIEmp,
    salEmp,
    comisionE
FROM
    empleado
WHERE
    CAST(REPLACE(nDIEmp, '.', '') AS UNSIGNED) > 19709802
ORDER BY id;
SELECT 
    CORREGIRNDIEMP(nDIEmp) AS id, nDIEmp, salEmp, comisionE
FROM
    empleado
WHERE
    CORREGIRNDIEMP(nDIEmp) > 19709802
ORDER BY id;
SELECT 
    *
FROM
    (SELECT 
        CAST(REPLACE(nDIEmp, '.', '') AS UNSIGNED) AS id,
            nDIEmp,
            salEmp,
            comisionE
    FROM
        empleado) corregida
WHERE
    id > 19709802
ORDER BY id;

SELECT 
    *
FROM
    (SELECT 
        CORREGIRNDIEMP(nDIEmp) AS id, nDIEmp, salEmp, comisionE
    FROM
        empleado) corregida
WHERE
    id > 19709802
ORDER BY id;

SELECT 
    *
FROM
    empleados
WHERE
    id > 19709802
ORDER BY id;

-- 23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión

SELECT 
    *
FROM
    empleado
WHERE
    salEmp <= comisionE * 0.4;

-- 24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra Z.
-- Liste estos empleados y su cargo por orden alfabético.

SELECT 
    nomEmp, cargoE
FROM
    empleado
WHERE
    nomEmp LIKE 'J%Z'
ORDER BY nomEmp;
SELECT 
    nomEmp, cargoE
FROM
    empleado
WHERE
    nomEmp BETWEEN 'J' AND 'zzzzzzzzz'
ORDER BY nomEmp;

-- 25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
-- empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
-- informe por el número del documento de identidad

SELECT 
    salEmp,
    comisionE,
    salEmp + comisionE AS salario_total,
    nDIEmp,
    nomEmp
FROM
    empleado
WHERE
    comisionE > 1000000
ORDER BY CORREGIRNDIEMP(nDIEmp);

-- 26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión

SELECT 
    salEmp,
    comisionE,
    salEmp + comisionE AS salario_total,
    nDIEmp,
    nomEmp
FROM
    empleado
WHERE
	comisionE = 0
ORDER BY CORREGIRNDIEMP(nDIEmp);

-- 27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como jefe al
-- empleado con documento de identidad '31.840.269'

SELECT 
    nomEmp, salEmp
FROM
    empleado
WHERE
    salEmp > 1000000
        AND jefeID = '31.840.269';

-- 28. Hallar el conjunto complementario del resultado del ejercicio anterior.

SELECT 
    nomEmp, salEmp
FROM
    empleado
WHERE
    NOT (salEmp > 1000000
        AND jefeID = '31.840.269')
        OR jefeID IS NULL;
SELECT 
    nomEmp, salEmp
FROM
    empleado
WHERE
    salEmp <= 1000000
        OR jefeID <> '31.840.269'
        OR jefeID IS NULL;

-- 29. Hallar los empleados cuyo nombre no contiene la cadena “MA”

SELECT 
    *
FROM
    empleado
WHERE
    nomEmp NOT LIKE '%MA%';

-- 30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
-- ‘MANTENIMIENTO’, ordenados por ciudad.

SELECT 
    nombreDpto
FROM
    departamento
WHERE
    nombreDpto NOT IN ('Ventas' , 'Investigación', 'Mantenimiento')
ORDER BY ciudad;

-- 31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o 'Vendedor', que
-- no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a $1.000.000,
-- ordenados por fecha de incorporación.

SELECT 
    nomEmp, nombreDpto, cargoE, salEmp
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
WHERE
    cargoE IN ('Secretaria' , 'Vendedor')
        AND nombreDpto <> 'Producción'
        AND salEmp > 1000000
ORDER BY fecIncorporacion;

-- 32. Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres

SELECT 
    nomEmp
FROM
    empleado
WHERE
    nomEmp LIKE '___________';

-- 33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres

SELECT 
    nomEmp
FROM
    empleado
WHERE
    nomEmp LIKE '___________%';

-- 34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000
-- o reciben comisión y trabajan para el departamento de 'VENTAS'

SELECT 
    *
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
WHERE
    nomEmp LIKE 'M%'
        AND (salEmp > 800000 OR comisionE > 0)
        AND nombreDpto = 'Ventas';

-- 35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la
-- mitad de la comisión la propia comisión

SELECT 
    nomEmp, salEmp, comisionE
FROM
    empleado
WHERE
    salEmp BETWEEN comisionE / 2 AND comisionE;

-- 36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los empleados, su
-- salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión

SELECT 
    nomEmp,
    salEmp,
    salEmp * 1.07,
    comisionE > 0 AS tiene_comision
FROM
    empleado;

-- 37. Obtener la información disponible del empleado cuyo número de documento de identidad sea:
-- '31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'

SELECT 
    *
FROM
    empleado
WHERE
    nDIEmp IN ('31.178.144' , '16.759.060',
        '1.751.219',
        '768.782',
        '737.689',
        '19.709.802',
        '31.174.099',
        '1.130.782');

-- 38. Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro del
-- departamento.

SELECT 
    *
FROM
    empleado
ORDER BY codDepto , nomEmp;

-- 39. Entregar el salario más alto de la empresa.

SELECT 
    MAX(salEmp)
FROM
    empleado;

SELECT 
    *
FROM
    empleado
WHERE
    salEMP = (SELECT 
            MAX(salEmp)
        FROM
            empleado);
SELECT 
    *
FROM
    empleado
ORDER BY salEmp DESC
LIMIT 1;

-- 40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben.

SELECT SUM(comisionE), COUNT(comisionE) FROM empleado WHERE comisionE > 0;

-- 41. Entregar el nombre del último empleado de la lista por orden alfabético.

SELECT 
    MAX(nomEmp)
FROM
    empleado;

SELECT 
    *
FROM
    empleado
ORDER BY nomEmp DESC
LIMIT 1;

-- 42. Hallar el salario más alto, el más bajo y la diferencia entre ellos.

SELECT 
    MAX(salEmp) AS maximo,
    MIN(salEmp) AS minimo,
    MAX(salEmp) - MIN(salEmp) AS diff
FROM
    empleado;

-- 43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto
-- y más bajo. Cuanto suman estos salarios?

SELECT 
    nomEmp, salEmp
FROM
    empleado
WHERE
    salEmp = (SELECT 
            MAX(salEmp)
        FROM
            empleado)
        OR salEmp = (SELECT 
            MIN(salEmp)
        FROM
            empleado) 
UNION SELECT 
    'SUMA', MAX(salEmp) + MIN(salEmp)
FROM
    empleado;

-- 44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento.

SELECT 
    e.codDepto,
    nombreDpto,
    CASE
        WHEN sexEmp = 'F' THEN 'Mujeres'
        WHEN sexEmp = 'M' THEN 'Hombres'
        ELSE 'Otro'
    END AS genero,
    COUNT(sexEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
GROUP BY e.codDepto , sexEmp
ORDER BY e.codDepto;

-- 45. Hallar el salario promedio por departamento.

SELECT 
    nombreDpto, AVG(salEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
GROUP BY nombreDpto
ORDER BY AVG(salEmp) DESC;

SELECT 
    e.codDepto, nombreDpto, ciudad, AVG(salEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
GROUP BY codDepto
ORDER BY AVG(salEmp) DESC;

-- 46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario supera
-- $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del
-- departamento.

SELECT 
    e.codDepto, nombreDpto, ciudad, AVG(salEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
WHERE
    salEmp > 900000 AND salEmp < 5750000
GROUP BY e.codDepto
ORDER BY e.codDepto;

-- 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
-- Ordenarlo por departamento.

SELECT 
    *
FROM
    empleado
WHERE
    salEmp >= (SELECT 
            AVG(salEmp)
        FROM
            empleado)
ORDER BY codDepto;

-- 48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de empleados de
-- esos departamentos.

SELECT 
    nombreDpto, COUNT(nDIEmp)
FROM
    departamento d
        JOIN
    empleado e ON d.codDepto = e.codDepto
GROUP BY e.codDepto
HAVING COUNT(nDIEmp) > 3;

-- 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe
-- inversamente por el nombre.

SELECT 
    j.nomEmp, COUNT(e.jefeID)
FROM
    empleado j
JOIN empleado e ON e.jefeID = j.nDIEmp
GROUP BY j.nomEmp;

-- 50. Hallar los departamentos que no tienen empleados

SELECT 
    d.codDepto, nombreDpto, ciudad
FROM
    departamento d
        LEFT JOIN
    empleado e ON e.codDepto = d.codDepto
WHERE
    e.codDepto IS NULL;

-- 51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de salario
-- de cada uno. Indique el nombre del departamento en el resultado.

SELECT 
    nombreDpto, COUNT(cargoE), IFNULL(AVG(salEmp), 0)
FROM
    departamento d
        LEFT JOIN
    empleado e ON d.codDepto = e.codDepto
GROUP BY d.nombreDpto;

SELECT 
    nombreDpto, ciudad, COUNT(cargoE), IFNULL(AVG(salEmp), 0)
FROM
    departamento d
        LEFT JOIN
    empleado e ON d.codDepto = e.codDepto
GROUP BY d.codDepto;

-- 52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la
-- suma.

SELECT 
    nombreDpto, SUM(salEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
GROUP BY nombreDpto
ORDER BY SUM(salEmp) DESC
LIMIT 1;

SELECT 
    d.codDepto, nombreDpto, ciudad, SUM(salEmp)
FROM
    empleado e
        JOIN
    departamento d ON e.codDepto = d.codDepto
GROUP BY d.codDepto
ORDER BY SUM(salEmp) DESC
LIMIT 1;

-- 53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que dirige.
-- Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de
-- ellos dejando los valores restantes en NULL.

SELECT DISTINCT
    j.nDIEmp, j.nomEmp, COUNT(e.nDIEmp)
FROM
    empleado j
        RIGHT JOIN
    empleado e ON j.nDIEmp = e.jefeID
GROUP BY j.nDIEmp;
