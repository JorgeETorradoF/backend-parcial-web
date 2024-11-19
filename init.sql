CREATE TABLE public.contratos (
    
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    identificador VARCHAR(255),

    precio NUMERIC(10,2),

    nombre_contratante VARCHAR(255),

    documento_contratante VARCHAR(255),

    nombre_contratantista VARCHAR(255),

    documento_contratantista VARCHAR(255),

    fecha_inicial TIMESTAMP NOT NULL,

    fecha_final TIMESTAMP NOT NULL

);
