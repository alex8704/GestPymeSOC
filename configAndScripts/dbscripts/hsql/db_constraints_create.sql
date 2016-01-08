/********************************************************************************************
*					GestPymeSOC - DataBase Constraints Creation
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* Convencion de Nombramiento de constraints
* [ABREVIACION_TABLA]_[ABREVIACION_CAMPOS_IMPLICADOS]_[SUFIJO]
*
* Sufijos Validos:
* FOREIGN KEY:		_FK
* UNIQUE:			_UK
* CHECK:			_CK
* PRIMARY KEY:		_PK
*
* Ejemplo: Tabla SGT_USUARIOS tiene un campo llamado LOGIN_ALIAS que debe ser UNICO
*
* El constraint se llamaria asi:
* ABREVIACION TABLA: USRS
* ABREVIACION_CAMPOS_IMPLICADOS: LOGIN
* SUFIJO: _UK
*
* Resultado: USRS_LOGIN_UK
*
*********************************************************************************************/

/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_APLICACIONES
**************************************************************************************************************************************/
ALTER TABLE SEGT_APLICACIONES ADD CONSTRAINT APLICACIONES_PK PRIMARY KEY (ID_APLICACION);
ALTER TABLE SEGT_APLICACIONES ADD CONSTRAINT APLICACIONES_COD_UK UNIQUE (COD_APLICACION);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_MODULOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_MODULOS ADD CONSTRAINT MODULOS_PK PRIMARY KEY (ID_MODULO);
ALTER TABLE SEGT_MODULOS ADD CONSTRAINT MODULOS_APLICACION_FK FOREIGN KEY (ID_APLICACION) REFERENCES SEGT_APLICACIONES (ID_APLICACION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_MODULOS ADD CONSTRAINT MODULOS_PADRE_FK FOREIGN KEY (ID_MODULO_PADRE) REFERENCES SEGT_MODULOS (ID_MODULO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_RECURSOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_RECURSOS ADD CONSTRAINT RECURSOS_PK PRIMARY KEY (ID_RECURSO);
ALTER TABLE SEGT_RECURSOS ADD CONSTRAINT RECURS_APLICACION_FK FOREIGN KEY (ID_APLICACION) REFERENCES SEGT_APLICACIONES (ID_APLICACION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_RECURSOS ADD CONSTRAINT RECURS_MODULO_FK FOREIGN KEY (ID_MODULO) REFERENCES SEGT_MODULOS (ID_MODULO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_RECURSOS ADD CONSTRAINT RECURS_RUTA_UK UNIQUE (RUTA_RECURSO);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_ROLES
**************************************************************************************************************************************/
ALTER TABLE SEGT_ROLES ADD CONSTRAINT ROLES_PK PRIMARY KEY (ID_ROL);
ALTER TABLE SEGT_ROLES ADD CONSTRAINT ROLES_APLICACION_FK FOREIGN KEY (ID_APLICACION) REFERENCES SEGT_APLICACIONES (ID_APLICACION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_ROLES ADD CONSTRAINT ROLES_NOMBRE_UK UNIQUE (NOMBRE);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_RECURSOS_X_ROLES
**************************************************************************************************************************************/
ALTER TABLE SEGT_RECURSOS_X_ROLES ADD CONSTRAINT RECURSOS_X_ROLES_PK PRIMARY KEY (ID_ROL, ID_RECURSO);
ALTER TABLE SEGT_RECURSOS_X_ROLES ADD CONSTRAINT RECXROL_ROL_FK FOREIGN KEY (ID_ROL) REFERENCES SEGT_ROLES (ID_ROL) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_RECURSOS_X_ROLES ADD CONSTRAINT RECXROL_RECURSO_FK FOREIGN KEY (ID_RECURSO) REFERENCES SEGT_RECURSOS (ID_RECURSO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_USUARIOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_USUARIOS ADD CONSTRAINT USUARIOS_PK PRIMARY KEY (ID_USUARIO);
ALTER TABLE SEGT_USUARIOS ADD CONSTRAINT USR_LOGIN_UK UNIQUE (LOGIN_ALIAS);
ALTER TABLE SEGT_USUARIOS ADD CONSTRAINT USR_ACTIVO_CK CHECK (ES_ACTIVO IN('N','S'));
ALTER TABLE SEGT_USUARIOS ADD CONSTRAINT USR_ESBLOQU_CK CHECK (ES_BLOQUEDADO_REINTENTOS IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla SEGT_ROLES_X_USUARIO
**************************************************************************************************************************************/
ALTER TABLE SEGT_ROLES_X_USUARIO ADD CONSTRAINT ROLES_X_USUARIO_PK PRIMARY KEY (ID_USUARIO,ID_ROL);
ALTER TABLE SEGT_ROLES_X_USUARIO ADD CONSTRAINT ROLXUSR_USR_FK FOREIGN KEY (ID_USUARIO) REFERENCES SEGT_USUARIOS (ID_USUARIO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE SEGT_ROLES_X_USUARIO ADD CONSTRAINT ROLXUSR_ROL_FK FOREIGN KEY (ID_ROL) REFERENCES SEGT_ROLES (ID_ROL) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_PAISES
**************************************************************************************************************************************/
ALTER TABLE MAT_PAISES ADD CONSTRAINT PAISES_PK PRIMARY KEY (ID_PAIS);
ALTER TABLE MAT_PAISES ADD CONSTRAINT PAISES_COD_DANE_UK UNIQUE (COD_DANE);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_DEPARTAMENTOS
**************************************************************************************************************************************/
ALTER TABLE MAT_DEPARTAMENTOS ADD CONSTRAINT DEPARTAMENTOS_PK PRIMARY KEY (ID_DEPARTAMENTO);
ALTER TABLE MAT_DEPARTAMENTOS ADD CONSTRAINT DEPART_IDPAIS_FK FOREIGN KEY (ID_PAIS) REFERENCES MAT_PAISES (ID_PAIS) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_DEPARTAMENTOS ADD CONSTRAINT DEPART_COD_UK UNIQUE (ID_PAIS,COD_DEPARTAMENTO);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_CIUDADES
**************************************************************************************************************************************/
ALTER TABLE MAT_CIUDADES ADD CONSTRAINT CIUDADES_PK PRIMARY KEY (ID_CIUDAD);
ALTER TABLE MAT_CIUDADES ADD CONSTRAINT CIUD_IDDEPART_FK FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES MAT_DEPARTAMENTOS (ID_DEPARTAMENTO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_CIUDADES ADD CONSTRAINT CIUD_COD_UK UNIQUE (ID_DEPARTAMENTO,COD_CIUDAD);



/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_BANCOS
**************************************************************************************************************************************/
ALTER TABLE MAT_BANCOS ADD CONSTRAINT BANCOS_PK PRIMARY KEY (ID_BANCO);
ALTER TABLE MAT_BANCOS ADD CONSTRAINT BANCO_COD_UK UNIQUE(COD_BANCO);
ALTER TABLE MAT_BANCOS ADD CONSTRAINT BANCO_VIGENTE_CK CHECK (ES_VIGENTE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_DIRECCIONES
**************************************************************************************************************************************/
ALTER TABLE MAT_DIRECCIONES ADD CONSTRAINT DIRECCIONES_PK PRIMARY KEY (ID_DIRECCION);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_AGRUPADOR_ESTADOS
**************************************************************************************************************************************/
ALTER TABLE MAT_AGRUPADOR_ESTADOS ADD CONSTRAINT AGRUPADOR_ESTADOS_PK PRIMARY KEY (ID_AGRUPADOR);
ALTER TABLE MAT_AGRUPADOR_ESTADOS ADD CONSTRAINT AGRUPEST_COD_UK UNIQUE (COD_AGRUPADOR);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_ESTADOS
**************************************************************************************************************************************/
ALTER TABLE MAT_ESTADOS ADD CONSTRAINT ESTADOS_PK PRIMARY KEY (ID_ESTADO);
ALTER TABLE MAT_ESTADOS ADD CONSTRAINT ESTD_AGRUPADOR_FK FOREIGN KEY (ID_AGRUPADOR) REFERENCES MAT_AGRUPADOR_ESTADOS (ID_AGRUPADOR) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_ESTADOS ADD CONSTRAINT ESTD_COD_UK UNIQUE (COD_ESTADO);
ALTER TABLE MAT_ESTADOS ADD CONSTRAINT ESTD_ACTIVO_CK CHECK (ES_ACTIVO IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_MAESTRAS
**************************************************************************************************************************************/
ALTER TABLE MAT_MAESTRAS ADD CONSTRAINT MAESTRAS_PK PRIMARY KEY (ID_MAESTRA);
ALTER TABLE MAT_MAESTRAS ADD CONSTRAINT MAESTR_COD_UK UNIQUE (COD_MAESTRA);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_DATOS_MAESTRAS
**************************************************************************************************************************************/
ALTER TABLE MAT_DATOS_MAESTRAS ADD CONSTRAINT DATOS_MAESTRAS_PK PRIMARY KEY (ID_DATO_MAESTRA);
ALTER TABLE MAT_DATOS_MAESTRAS ADD CONSTRAINT DAT_MAESTR_MAESTRA_FK FOREIGN KEY (ID_MAESTRA) REFERENCES MAT_MAESTRAS (ID_MAESTRA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_DATOS_MAESTRAS ADD CONSTRAINT DAT_MAESTR_COD_UK UNIQUE (ID_MAESTRA,  COD_DATO_MAESTRA);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_TIPOS_CONTRIBUYENTE
**************************************************************************************************************************************/
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPOS_CONTRIBUYENTE_PK PRIMARY KEY (ID_TIPO_CONTRIBUYENTE);
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_COD_UK UNIQUE (COD_TIPO_CONTRIBUYENTE);
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_RRENTA_APLIC_CK CHECK (RETEFUENTE_RENTA_APLICABLE IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_RIVA_APLIC_CK CHECK (RETEFUENTE_IVA_APLICABLE IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_RICA_APLIC_CK CHECK (RETEFUENTE_ICA_APLICABLE IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_RCREE_APLIC_CK CHECK (RETEFUENTE_CRE_APLICABLE IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_DCLRENTA_APLIC_CK CHECK (DECLARA_RENTA IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_DCLIVA_APLIC_CK CHECK (DECLARA_IVA IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_DCLICA_APLIC_CK CHECK (DECLARA_ICA IN('N','S'));
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE ADD CONSTRAINT TIPO_CONTRIB_DCLCREE_APLIC_CK CHECK (DECLARA_CREE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_GRUPOS_TARIFA_ACTI_ECONOM
**************************************************************************************************************************************/
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM ADD CONSTRAINT GRUPOS_TARIFA_ACTI_ECONOM_PK PRIMARY KEY (ID_GRUPO_TARIFARIO);
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM ADD CONSTRAINT GRUPTARIF_COD_UK UNIQUE (COD_GRUPO_TARIFARIO);
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM ADD CONSTRAINT GRUPTARIF_RUBRO_CK CHECK (COD_RUBRO_ECONOMICO IN('INDUSTRIAL', 'COMERCIAL', 'SERVICIOS', 'FINANCIERO', 'EXCENTO'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_ACTIVIDADES_ECONOMICAS
**************************************************************************************************************************************/
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS ADD CONSTRAINT ACTIVIDADES_ECONOMICAS_PK PRIMARY KEY (ID_ACTIVIDAD_ECONOMICA);
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS ADD CONSTRAINT ACTI_ECON_COD_UK UNIQUE (COD_ACTIVIDAD_CIIU);
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS ADD CONSTRAINT ACTI_ECON_GRUPO_TAR_FK FOREIGN KEY (ID_GRUPO_TARIFARIO) REFERENCES MAT_GRUPOS_TARIFA_ACTI_ECONOM (ID_GRUPO_TARIFARIO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_TIPOS_IDENTIFICACION
**************************************************************************************************************************************/
ALTER TABLE MAT_TIPOS_IDENTIFICACION ADD CONSTRAINT TIPOS_IDENTIFICACION_PK PRIMARY KEY (ID_TIPO_IDENTIFICACION);
ALTER TABLE MAT_TIPOS_IDENTIFICACION ADD CONSTRAINT TIPO_IDENT_COD_UK UNIQUE (COD_TIPO_IDENTIFICACION);
ALTER TABLE MAT_TIPOS_IDENTIFICACION ADD CONSTRAINT TIPO_IDENT_NOMBRE_UK UNIQUE (NOMBRE_CORTO);



/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_GRUPOS_EMPRESARIALES
**************************************************************************************************************************************/
ALTER TABLE MAT_GRUPOS_EMPRESARIALES ADD CONSTRAINT GRUPOS_EMPRESARIALES_PK PRIMARY KEY (ID_GRUPO_EMPRESARIAL);
ALTER TABLE MAT_GRUPOS_EMPRESARIALES ADD CONSTRAINT GRUP_EMPRE_NIT_UK UNIQUE (IDENTIFICACION_TRIBUTARIA);
ALTER TABLE MAT_GRUPOS_EMPRESARIALES ADD CONSTRAINT GRUP_EMPRE_CIUD_FK FOREIGN KEY (ID_CIUDAD) REFERENCES MAT_CIUDADES (ID_CIUDAD) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_GRUPOS_EMPRESARIALES ADD CONSTRAINT GRUP_EMPRE_DIRECC_FK FOREIGN KEY (ID_DIRECCION) REFERENCES MAT_DIRECCIONES (ID_DIRECCION) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_EMPRESAS
**************************************************************************************************************************************/
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRESAS_PK PRIMARY KEY (ID_EMPRESA);
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_NIT_UK UNIQUE (IDENTIFICACION_TRIBUTARIA);
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_TIPOPERIO_CK CHECK (COD_TIPO_PERIODO_NOMINA IN('SEMANAL','QUINCENAL', 'MENSUAL'));
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_ID_GRUPO_FK FOREIGN KEY (ID_GRUPO_EMPRESARIAL) REFERENCES MAT_GRUPOS_EMPRESARIALES (ID_GRUPO_EMPRESARIAL) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_CIUD_FK FOREIGN KEY (ID_CIUDAD) REFERENCES MAT_CIUDADES (ID_CIUDAD) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_DIRECC_FK FOREIGN KEY (ID_DIRECCION) REFERENCES MAT_DIRECCIONES (ID_DIRECCION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_TIPO_CONTR_FK FOREIGN KEY (ID_TIPO_CONTRIBUYENTE) REFERENCES MAT_TIPOS_CONTRIBUYENTE (ID_TIPO_CONTRIBUYENTE) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_ACT_ECONOM_FK FOREIGN KEY (ID_ACTIVIDAD_ECONOMICA) REFERENCES MAT_ACTIVIDADES_ECONOMICAS (ID_ACTIVIDAD_ECONOMICA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_EMPRESAS ADD CONSTRAINT EMPRE_BANCO_FK FOREIGN KEY (ID_BANCO_CONVENIO_NOMINA) REFERENCES MAT_BANCOS (ID_BANCO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_CONCEPTOS_PAGO
**************************************************************************************************************************************/
ALTER TABLE MAT_CONCEPTOS_PAGO ADD CONSTRAINT CONCEPTOS_PAGO_PK PRIMARY KEY (ID_CONCEPTO_PAGO);
ALTER TABLE MAT_CONCEPTOS_PAGO ADD CONSTRAINT COCEPTS_APLICEMPL_CK CHECK (APLICA_EMPLEADOS IN('N','S'));
ALTER TABLE MAT_CONCEPTOS_PAGO ADD CONSTRAINT COCEPTS_APLICPROV_CK CHECK (APLICA_PROVEEDORES IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_CONFIG_RETENCIONES
**************************************************************************************************************************************/
ALTER TABLE MAT_CONFIG_RETENCIONES ADD CONSTRAINT CONFIG_RETENCIONES_PK PRIMARY KEY (ID_CONFIG_RETENCION);
ALTER TABLE MAT_CONFIG_RETENCIONES ADD CONSTRAINT CONFRET_CONCEPTO_FK FOREIGN KEY (ID_CONCEPTO_PAGO) REFERENCES MAT_CONCEPTOS_PAGO (ID_CONCEPTO_PAGO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_CONFIG_RETENCIONES ADD CONSTRAINT CONFRET_TIPO_PERS_CK CHECK (COD_TIPO_PERSONA IN('PERSONA_NATURAL','PERSONA_JURIDICA'));
ALTER TABLE MAT_CONFIG_RETENCIONES ADD CONSTRAINT CONFRET_TIPO_RETENC_CK CHECK (COD_TIPO_PERSONA IN('RETEFUENTE_RENTA', 'RETEFUENTE_IVA', 'RETEFUENTE_ICA', 'RETEFUENTE_CREE'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_TERCEROS
**************************************************************************************************************************************/
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERCEROS_PK PRIMARY KEY (ID_TERCERO);
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_CIUDAD_FK FOREIGN KEY (ID_CIUDAD) REFERENCES MAT_CIUDADES (ID_CIUDAD) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_DIRECCION_FK FOREIGN KEY (ID_DIRECCION) REFERENCES MAT_DIRECCIONES (ID_DIRECCION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_TIPO_CONTR_FK FOREIGN KEY (ID_TIPO_CONTRIBUYENTE) REFERENCES MAT_TIPOS_CONTRIBUYENTE (ID_TIPO_CONTRIBUYENTE) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_ACT_ECONOM_FK FOREIGN KEY (ID_ACTIVIDAD_ECONOMICA) REFERENCES MAT_ACTIVIDADES_ECONOMICAS (ID_ACTIVIDAD_ECONOMICA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_TIPO_ID_FK FOREIGN KEY (ID_TIPO_IDENTIFICACION) REFERENCES MAT_TIPOS_IDENTIFICACION (ID_TIPO_IDENTIFICACION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE MAT_TERCEROS ADD CONSTRAINT TERC_TIPO_PERS_CK CHECK (COD_TIPO_PERSONA IN('PERSONA_NATURAL','PERSONA_JURIDICA'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_PARAMETROS_CONFIG
**************************************************************************************************************************************/
ALTER TABLE MAT_PARAMETROS_CONFIG ADD CONSTRAINT ARAMETROS_CONFIG_PK PRIMARY KEY (ID_PARAM_CONFIG);
ALTER TABLE MAT_PARAMETROS_CONFIG ADD CONSTRAINT PARAMCONF_CODCOF_CODAPP_UK UNIQUE(COD_PARAM_CONFIG,COD_APLICACION);
ALTER TABLE MAT_PARAMETROS_CONFIG ADD CONSTRAINT PARAMCONF_CODAPP_CK CHECK (COD_APLICACION IN('GESTPYMESOC'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_EPSS
**************************************************************************************************************************************/
ALTER TABLE MAT_EPSS ADD CONSTRAINT EPSS_PK PRIMARY KEY (ID_EPS);
ALTER TABLE MAT_EPSS ADD CONSTRAINT EPS_COD_UK UNIQUE(COD_EPS);
ALTER TABLE MAT_EPSS ADD CONSTRAINT EPS_VIGENTE_CK CHECK (ES_VIGENTE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_AFPS
**************************************************************************************************************************************/
ALTER TABLE MAT_AFPS ADD CONSTRAINT AFPS_PK PRIMARY KEY (ID_AFP);
ALTER TABLE MAT_AFPS ADD CONSTRAINT AFP_COD_UK UNIQUE(COD_AFP);
ALTER TABLE MAT_AFPS ADD CONSTRAINT AFP_VIGENTE_CK CHECK (ES_VIGENTE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_ARLS
**************************************************************************************************************************************/
ALTER TABLE MAT_ARLS ADD CONSTRAINT ARLS_PK PRIMARY KEY (ID_ARL);
ALTER TABLE MAT_ARLS ADD CONSTRAINT ARL_COD_UK UNIQUE(COD_ARL);
ALTER TABLE MAT_ARLS ADD CONSTRAINT ARL_VIGENTE_CK CHECK (ES_VIGENTE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla MAT_CCFS
**************************************************************************************************************************************/
ALTER TABLE MAT_CCFS ADD CONSTRAINT CCFS_PK PRIMARY KEY (ID_CCF);
ALTER TABLE MAT_CCFS ADD CONSTRAINT CCF_COD_UK UNIQUE(COD_CCF);
ALTER TABLE MAT_CCFS ADD CONSTRAINT CCF_VIGENTE_CK CHECK (ES_VIGENTE IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_CARGOS
**************************************************************************************************************************************/
ALTER TABLE GPT_CARGOS ADD CONSTRAINT CARGOS_PK PRIMARY KEY (ID_CARGO);
ALTER TABLE GPT_CARGOS ADD CONSTRAINT CARGOS_COD_UK UNIQUE(COD_CARGO);


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_MOTIVOS_TERMINAC_CONTRATO
**************************************************************************************************************************************/
ALTER TABLE GPT_MOTIVOS_TERMINAC_CONTRATO ADD CONSTRAINT MOTIVOS_TERMINAC_CONTRATO_PK PRIMARY KEY (ID_MOTIVO_TERMINACION);
ALTER TABLE GPT_MOTIVOS_TERMINAC_CONTRATO ADD CONSTRAINT MOT_TERMI_OBLIDEMN_CK CHECK(OBLIGA_INDEMNIZACION IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_EMPLEADOS
**************************************************************************************************************************************/
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPLEADOS_PK PRIMARY KEY (ID_EMPLEADO);
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_IDTERC_FK FOREIGN KEY (ID_EMPLEADO) REFERENCES MAT_TERCEROS (ID_TERCERO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_EPS_FK FOREIGN KEY (ID_EPS) REFERENCES MAT_EPSS (ID_EPS) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_AFP_FK FOREIGN KEY (ID_AFP) REFERENCES MAT_AFPS (ID_AFP) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_ESTADO_FK FOREIGN KEY (ID_ESTADO) REFERENCES MAT_ESTADOS (ID_ESTADO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_GENERO_FK FOREIGN KEY (ID_GENERO) REFERENCES MAT_DATOS_MAESTRAS (ID_DATO_MAESTRA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_PROFESION_FK FOREIGN KEY (ID_PROFESION) REFERENCES MAT_DATOS_MAESTRAS (ID_DATO_MAESTRA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_EMPLEADOS ADD CONSTRAINT EMPL_EMPR_FK FOREIGN KEY (ID_EMPRESA) REFERENCES MAT_EMPRESAS (ID_EMPRESA) ON UPDATE NO ACTION ON DELETE NO ACTION;



/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_CONTRATOS_LABORALES
**************************************************************************************************************************************/
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRATOS_LABORALES_PK PRIMARY KEY (ID_CONTRATO);
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_EMPRESA_FK FOREIGN KEY (ID_EMPRESA) REFERENCES MAT_EMPRESAS (ID_EMPRESA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_EMPLEADO_FK FOREIGN KEY (ID_EMPLEADO) REFERENCES GPT_EMPLEADOS (ID_EMPLEADO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_CARGO_FK FOREIGN KEY (ID_CARGO) REFERENCES GPT_CARGOS (ID_CARGO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_MOTIVOTERM_FK FOREIGN KEY (ID_MOTIVO_TERMINACION) REFERENCES GPT_MOTIVOS_TERMINAC_CONTRATO (ID_MOTIVO_TERMINACION) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_ESVIGENT_CK CHECK(ES_VIGENTE IN('N','S'));
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_ESSAL_INTEGR_CK CHECK(ES_SALARIO_INTEGRAL IN('N','S'));
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_DERECH_RECARG_CK CHECK(DERECHO_RECARGOS IN('N','S'));
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_REPORTT_RECARG_CK CHECK(REPORTA_TIEMPO IN('N','S'));
ALTER TABLE GPT_CONTRATOS_LABORALES ADD CONSTRAINT CONTRAT_TIPOTERMINO_CK CHECK(DERECHO_RECARGOS IN('FIJO','INDEFINIDO'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_PROVEEDORES
**************************************************************************************************************************************/
ALTER TABLE GPT_PROVEEDORES ADD CONSTRAINT PROVEEDORES_PK PRIMARY KEY (ID_PROVEEDOR);
ALTER TABLE GPT_PROVEEDORES ADD CONSTRAINT PROVEED_IDTERC_FK FOREIGN KEY (ID_PROVEEDOR) REFERENCES MAT_TERCEROS (ID_TERCERO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_CLIENTES
**************************************************************************************************************************************/
ALTER TABLE GPT_CLIENTES ADD CONSTRAINT CLIENTES_PK PRIMARY KEY (ID_CLIENTE);
ALTER TABLE GPT_CLIENTES ADD CONSTRAINT CLIENT_IDTERC_FK FOREIGN KEY (ID_CLIENTE) REFERENCES MAT_TERCEROS (ID_TERCERO) ON UPDATE NO ACTION ON DELETE NO ACTION;


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_PERIODO_LIQUID_NOMINA
**************************************************************************************************************************************/
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERIODO_LIQUID_NOMINA_PK PRIMARY KEY (ID_PERIODO_NOMINA);
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERINOMI_EMPR_FK FOREIGN KEY (ID_EMPRESA) REFERENCES MAT_EMPRESAS (ID_EMPRESA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERINOMI_EMPRFEC_UK UNIQUE(ID_EMPRESA,COD_TIPO_PERIODO_NOMINA,FEC_INICIO_PERIODO,FEC_FIN_PERIODO);
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERINOMI_RANGFECHAS_CK CHECK (FEC_INICIO_PERIODO < FEC_FIN_PERIODO);
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERINOMI_TIPOPERIO_CK CHECK (COD_TIPO_PERIODO_NOMINA IN('SEMANAL','QUINCENAL', 'MENSUAL'));
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA ADD CONSTRAINT PERINOMI_ESLIQUID_CK CHECK (ES_LIQUIDADO IN('N','S'));


/**************************************************************************************************************************************
* Creacion de Constraints para tabla GPT_REPORTE_TIEMPO
**************************************************************************************************************************************/
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTE_TIEMPO_PK PRIMARY KEY (ID_PERIODO_NOMINA,ID_EMPLEADO,FECHA);
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_PERIODO_FK FOREIGN KEY (ID_PERIODO_NOMINA) REFERENCES GPT_PERIODO_LIQUID_NOMINA (ID_PERIODO_NOMINA) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_EMPLEADO_FK FOREIGN KEY (ID_EMPLEADO) REFERENCES GPT_EMPLEADOS (ID_EMPLEADO) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_RANGOHORA_CK CHECK(HORA_ENTRADA < HORA_SALIDA);
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_ESTURNO_CK CHECK(ES_TURNO IN('N','S'));
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_TIPTURNO_CK CHECK(COD_TIPO_TURNO IN('DIURNO','NOCTURNO'));
ALTER TABLE GPT_REPORTE_TIEMPO ADD CONSTRAINT REPORTMP_ESDESC_CK CHECK(ES_DESCANSO IN('N','S'));
