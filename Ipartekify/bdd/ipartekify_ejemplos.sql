SELECT 
    id,
    nombre,
    tiempo,
    mp3,
    usuarios_id IS NOT NULL
        AND usuarios_id = 1 AS favorito,
    cf.*
FROM
    canciones c
        LEFT JOIN
    canciones_favoritas cf ON c.id = cf.canciones_id
WHERE
    albumes_id = 2;

SELECT 
    id,
    nombre,
    tiempo,
    mp3,
    IFNULL((SELECT 
                    TRUE
                FROM
                    canciones_favoritas
                WHERE
                    usuarios_id = 1 AND canciones_id = c.id),
            FALSE) AS favorito
FROM
    canciones c
WHERE
    albumes_id = 1;

SELECT 
    *
FROM
    canciones c
        JOIN
    canciones_favoritas cf ON c.id = cf.canciones_id
WHERE
    usuarios_id = 1;
