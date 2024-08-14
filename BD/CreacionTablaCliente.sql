CREATE SEQUENCE seq_cliente
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
CREATE TABLE CLIENTE (
    id_cliente NUMBER PRIMARY KEY,
    tipo_identificacion VARCHAR2(20) NOT NULL,
    numero_identificacion VARCHAR2(20) NOT NULL UNIQUE,
    nombres VARCHAR2(100),
    apellidos VARCHAR2(100),
    fecha_creacion DATE DEFAULT SYSDATE
);
CREATE OR REPLACE TRIGGER trg_cliente_id
BEFORE INSERT ON CLIENTE
FOR EACH ROW
WHEN (NEW.id_cliente IS NULL)
BEGIN
    SELECT seq_cliente.NEXTVAL INTO :NEW.id_cliente FROM dual;
END;
/
SELECT * FROM CLIENTE;

DELETE FROM CLIENTE WHERE  numero_identificacion = 'string';

INSERT INTO CLIENTE  (TIPO_IDENTIFICACION,NUMERO_IDENTIFICACION,NOMBRES,APELLIDOS,FECHA_CREACION) values ('cc','1000000002','Carlos','Mendez Garcia',to_date('14/08/24','DD/MM/RR'));
DROP TABLE CLIENTE;
