--DDL FOR TABLE TASKS

--SEQUENCE PARA EL AUTOINCREMENTO EN IDS
DROP SEQUENCE TASKS_SEQ;
DROP SEQUENCE ESTADO_SEQ;

CREATE SEQUENCE TASKS_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE SEQUENCE ESTADO_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

DROP TABLE TASKS;
DROP TABLE ESTADO;

CREATE TABLE ESTADO(
    ID_STATUS NUMBER DEFAULT ESTADO_SEQ. NEXTVAL PRIMARY KEY NOT NULL,
    DESCRIPCION VARCHAR2(50) NOT NULL
);

CREATE TABLE TASKS(
    ID_TASKS NUMBER DEFAULT TASKS_SEQ.NEXTVAL PRIMARY KEY NOT NULL,
    TITLE VARCHAR2(50),
    DESCRIPTION_TASK VARCHAR2(150),
    ID_STATUS NUMBER,
    CREATED_AT DATE DEFAULT SYSDATE,
    UPDATED_AT DATE,
    CONSTRAINT STAT_TASK_FK FOREIGN KEY(ID_STATUS) REFERENCES ESTADO(ID_STATUS)
);

INSERT INTO ESTADO(DESCRIPCION) VALUES ('Completada');
INSERT INTO ESTADO(DESCRIPCION) VALUES ('Pendiente');

--Insertar datos para prueba del metodo get
INSERT INTO TASKS(TITLE, DESCRIPTION_TASK, ID_STATUS) 
VALUES ('TAREA1','DESCRIPCION DE LA TAREA1',2);
INSERT INTO TASKS(TITLE, DESCRIPTION_TASK, ID_STATUS) 
VALUES ('TAREA2','DESCRIPCION DE LA TAREA2',2);
COMMIT;