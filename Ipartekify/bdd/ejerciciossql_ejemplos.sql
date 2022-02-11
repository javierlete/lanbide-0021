SELECT 
    (SELECT 
            MAX(nDIEmp)
        FROM
            empleado) AS MaxIdEmpleado,
    (SELECT 
            MIN(codDepto)
        FROM
            departamento) AS MinIdDepto;

SELECT 
    'Máximo' AS Campo, MAX(nDIEmp) AS Dato
FROM
    empleado 
UNION SELECT 
    'Mínimo', MIN(codDepto)
FROM
    departamento;

SELECT 
    cargoE, AVG(salEmp) AS Media
FROM
    empleado
WHERE
    salEmp > (SELECT 
            AVG(salEmp)
        FROM
            empleado)
GROUP BY cargoE
ORDER BY Media DESC;

SELECT 
    *
FROM
    (SELECT 
        cargoE, AVG(salEmp) AS Media
    FROM
        empleado
    GROUP BY cargoE) AS empleados,
    (SELECT 'a' AS letra UNION SELECT 'b') AS Chorrada
ORDER BY letra;

SELECT 
    *
FROM
    (SELECT 
        *
    FROM
        media_salarios_por_cargo) AS empleados,
    (SELECT 'a' AS letra UNION SELECT 'b') AS Chorrada
ORDER BY letra;

SELECT 
    J.nDIEmp, J.nomEmp
FROM
    Empleado J,
    (SELECT 
        S.jefeID
    FROM
        Empleado E, Empleado S
    WHERE
        E.nDIEmp = S.jefeID
    GROUP BY S.jefeID
    HAVING COUNT(S.nDIEmp) >= 1) P
WHERE
    J.nDIEmp = P.jefeID;

SELECT 
    J.nDIEmp, J.nomEmp
FROM
    Empleado J
WHERE
    J.nDIEmp IN (SELECT 
            S.jefeID
        FROM
            Empleado E,
            Empleado S
        WHERE
            E.nDIEmp = S.jefeID
        GROUP BY S.jefeID
        HAVING COUNT(S.nDIEmp) >= 1);

