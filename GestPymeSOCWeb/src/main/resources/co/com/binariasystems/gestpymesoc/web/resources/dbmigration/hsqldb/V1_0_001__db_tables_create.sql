/********************************************************************************************
*						GestPymeSOC - DataBase Schemas and Objects Script
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* Prefijo MAT_, para tablas maestras que apliquen para cualquier aplicacion ademas de GestPymeSOC,
* Prefijo GPT_, para tablas del modelo propio de GestPymeSOC
* Prefijo SEGT_, paratablas del modelo de Seguridad Centralizado
* ----------------------------------------------------------------------------------------------------------------------------
* Usar el prefijo ID_, concatenado con el sufijo de la tabla, para columnas de tipo Clave primaria numerica
* Ejemplo: Tabla MAT_PAISES, tiene el sufijo "PAISES" por tanto la columna de clave primaria se llama ID_PAIS
* ----------------------------------------------------------------------------------------------------------------------------
* Para columnas que representen codigos estandar establecidos por entidades gubernamentales o como codificacion
* propia definida internamente, se usa el prefijo COD_
* ----------------------------------------------------------------------------------------------------------------------------
* Para columnas que hacen referencia a valores cuantitativos, por ejemplo Valor de compra, se usa el prefijo
* VLR_, seguido del sufijo correspondiente
*********************************************************************************************/

CREATE CACHED TABLE GPT_DUAL(
	DUMMY VARCHAR(32) NOT NULL,
	CONSTRAINT DUAL_DUMMY_UK UNIQUE(DUMMY),
	CONSTRAINT DUAL_DUMMY_CK CHECK (DUMMY IN ('X'))
);


CREATE CACHED TABLE GPT_CARGOS(
	ID_CARGO INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	COD_CARGO VARCHAR(15) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	DESCRIPCION VARCHAR(256),
	VLR_SALARIO_BASE NUMERIC(16,2),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP
);

CREATE CACHED TABLE GPT_MOTIVOS_TERMINAC_CONTRATO(
	ID_MOTIVO_TERMINACION INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	DESCRIPCION VARCHAR(256),
	OBLIGA_INDEMNIZACION VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP
);

CREATE CACHED TABLE GPT_EMPLEADOS(
	ID_EMPLEADO INTEGER NOT NULL,
	ID_EPS INTEGER NOT NULL,
	ID_AFP INTEGER NOT NULL,
	ID_ESTADO INTEGER NOT NULL,
	ID_GENERO INTEGER  NOT NULL,
	ID_PROFESION INTEGER,
	ID_EMPRESA  INTEGER NOT NULL
);

CREATE CACHED TABLE GPT_CONTRATOS_LABORALES(
	ID_CONTRATO INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	ID_EMPRESA	INTEGER NOT NULL,
	ID_EMPLEADO INTEGER NOT NULL,
	ID_CARGO INTEGER NOT NULL,
	VLR_SALARIO_BASE NUMERIC(16,2) NOT NULL,
	ES_VIGENTE VARCHAR(1),
	ES_SALARIO_INTEGRAL VARCHAR(1),
	DERECHO_RECARGOS VARCHAR(1),
	FEC_INICIO DATE NOT NULL,
	FEC_TERMINACION DATE,
	COD_TIPO_TERMINO VARCHAR(15) NOT NULL,
	ID_MOTIVO_TERMINACION INTEGER,
	REPORTA_TIEMPO VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP
);

CREATE CACHED TABLE GPT_PROVEEDORES(
	ID_PROVEEDOR INTEGER NOT NULL
);

CREATE CACHED TABLE GPT_CLIENTES(
	ID_CLIENTE INTEGER NOT NULL
);

CREATE CACHED TABLE GPT_PERIODO_LIQUID_NOMINA(
	ID_PERIODO_NOMINA INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	ID_EMPRESA INTEGER NOT NULL,
	DESCRIPCION VARCHAR(128),
	COD_TIPO_PERIODO_NOMINA VARCHAR(30) NOT NULL,
	FEC_INICIO_PERIODO DATE NOT NULL,
	FEC_FIN_PERIODO DATE NOT NULL,
	ES_LIQUIDADO VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP
);

CREATE CACHED TABLE GPT_REPORTE_TIEMPO(
	ID_PERIODO_NOMINA INTEGER NOT NULL,
	ID_EMPLEADO INTEGER NOT NULL,
	FECHA DATE NOT NULL,
	HORA_ENTRADA TIMESTAMP NOT NULL,
	HORA_SALIDA TIMESTAMP NOT NULL,
	ES_TURNO VARCHAR(1),
	COD_TIPO_TURNO VARCHAR(15),
	ES_DESCANSO VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP
);


/*******************************************************
*	TIPOS ENUMERADOS
*	TIPOS_PERSONA(PERSONA_NATURAL PERSONA_JURIDICA)
*	CONCEPTOS_RETENCION_IVA(COMPRAS, SERVICIOS)
*	CONCEPTOS_RETENCION_RENTA(COMPRAS, SERVICIOS, ARRENDAMIENTOS)
*	TIPOS_RETEFUENTE(RETEFUENTE_RENTA, RETEFUENTE_IVA, RETEFUENTE_ICA, RETEFUENTE_CREE)
*	RUBRO_ECONOMICO(INDUSTRIAL, COMERCIAL, SERVICIOS, FINANCIERO, EXCENTO)
*	TIPO_TERMINO_CONTRATO(FIJO, INDEFINIDO)
*	TIPO_PERIODO_NOMINA(SEMANAL,QUINCENAL, MENSUAL
*	TIPO_TURNO_REPORTTIEMPO(DIURNO, NOCTURNO)
*******************************************************/

