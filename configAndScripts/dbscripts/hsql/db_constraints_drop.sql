/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_APLICACIONES
**************************************************************************************************************************************/
ALTER TABLE SEGT_APLICACIONES DROP CONSTRAINT APLICACIONES_PK;
ALTER TABLE SEGT_APLICACIONES DROP CONSTRAINT APLICACIONES_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_MODULOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_MODULOS DROP CONSTRAINT MODULOS_PK;
ALTER TABLE SEGT_MODULOS DROP CONSTRAINT MODULOS_APLICACION_FK;
ALTER TABLE SEGT_MODULOS DROP CONSTRAINT MODULOS_PADRE_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_RECURSOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_RECURSOS DROP CONSTRAINT RECURSOS_PK;
ALTER TABLE SEGT_RECURSOS DROP CONSTRAINT RECURS_APLICACION_FK;
ALTER TABLE SEGT_RECURSOS DROP CONSTRAINT RECURS_MODULO_FK;
ALTER TABLE SEGT_RECURSOS DROP CONSTRAINT RECURS_RUTA_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_ROLES
**************************************************************************************************************************************/
ALTER TABLE SEGT_ROLES DROP CONSTRAINT ROLES_PK;
ALTER TABLE SEGT_ROLES DROP CONSTRAINT ROLES_APLICACION_FK;
ALTER TABLE SEGT_ROLES DROP CONSTRAINT ROLES_NOMBRE_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_RECURSOS_X_ROLES
**************************************************************************************************************************************/
ALTER TABLE SEGT_RECURSOS_X_ROLES DROP CONSTRAINT RECURSOS_X_ROLES_PK;
ALTER TABLE SEGT_RECURSOS_X_ROLES DROP CONSTRAINT RECXROL_ROL_FK;
ALTER TABLE SEGT_RECURSOS_X_ROLES DROP CONSTRAINT RECXROL_RECURSO_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_USUARIOS
**************************************************************************************************************************************/
ALTER TABLE SEGT_USUARIOS DROP CONSTRAINT USUARIOS_PK;
ALTER TABLE SEGT_USUARIOS DROP CONSTRAINT USR_LOGIN_UK;
ALTER TABLE SEGT_USUARIOS DROP CONSTRAINT USR_ACTIVO_CK;
ALTER TABLE SEGT_USUARIOS DROP CONSTRAINT USR_ESBLOQU_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla SEGT_ROLES_X_USUARIO
**************************************************************************************************************************************/
ALTER TABLE SEGT_ROLES_X_USUARIO DROP CONSTRAINT ROLES_X_USUARIO_PK;
ALTER TABLE SEGT_ROLES_X_USUARIO DROP CONSTRAINT ROLXUSR_USR_FK;
ALTER TABLE SEGT_ROLES_X_USUARIO DROP CONSTRAINT ROLXUSR_ROL_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_PAISES
**************************************************************************************************************************************/
ALTER TABLE MAT_PAISES DROP CONSTRAINT PAISES_PK;
ALTER TABLE MAT_PAISES DROP CONSTRAINT PAISES_COD_DANE_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_DEPARTAMENTOS
**************************************************************************************************************************************/
ALTER TABLE MAT_DEPARTAMENTOS DROP CONSTRAINT DEPARTAMENTOS_PK;
ALTER TABLE MAT_DEPARTAMENTOS DROP CONSTRAINT DEPART_IDPAIS_FK;
ALTER TABLE MAT_DEPARTAMENTOS DROP CONSTRAINT DEPART_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_CIUDADES
**************************************************************************************************************************************/
ALTER TABLE MAT_CIUDADES DROP CONSTRAINT CIUDADES_PK;
ALTER TABLE MAT_CIUDADES DROP CONSTRAINT CIUD_IDDEPART_FK;
ALTER TABLE MAT_CIUDADES DROP CONSTRAINT CIUD_COD_UK;



/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_BANCOS
**************************************************************************************************************************************/
ALTER TABLE MAT_BANCOS DROP CONSTRAINT BANCOS_PK;
ALTER TABLE MAT_BANCOS DROP CONSTRAINT BANCO_COD_UK;
ALTER TABLE MAT_BANCOS DROP CONSTRAINT BANCO_VIGENTE_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_DIRECCIONES
**************************************************************************************************************************************/
ALTER TABLE MAT_DIRECCIONES DROP CONSTRAINT DIRECCIONES_PK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_AGRUPADOR_ESTADOS
**************************************************************************************************************************************/
ALTER TABLE MAT_AGRUPADOR_ESTADOS DROP CONSTRAINT AGRUPADOR_ESTADOS_PK;
ALTER TABLE MAT_AGRUPADOR_ESTADOS DROP CONSTRAINT AGRUPEST_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_ESTADOS
**************************************************************************************************************************************/
ALTER TABLE MAT_ESTADOS DROP CONSTRAINT ESTADOS_PK;
ALTER TABLE MAT_ESTADOS DROP CONSTRAINT ESTD_AGRUPADOR_FK;
ALTER TABLE MAT_ESTADOS DROP CONSTRAINT ESTD_COD_UK;
ALTER TABLE MAT_ESTADOS DROP CONSTRAINT ESTD_ACTIVO_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_MAESTRAS
**************************************************************************************************************************************/
ALTER TABLE MAT_MAESTRAS DROP CONSTRAINT MAESTRAS_PK;
ALTER TABLE MAT_MAESTRAS DROP CONSTRAINT MAESTR_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_DATOS_MAESTRAS
**************************************************************************************************************************************/
ALTER TABLE MAT_DATOS_MAESTRAS DROP CONSTRAINT DATOS_MAESTRAS_PK;
ALTER TABLE MAT_DATOS_MAESTRAS DROP CONSTRAINT DAT_MAESTR_MAESTRA_FK;
ALTER TABLE MAT_DATOS_MAESTRAS DROP CONSTRAINT DAT_MAESTR_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_TIPOS_CONTRIBUYENTE
**************************************************************************************************************************************/
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPOS_CONTRIBUYENTE_PK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_COD_UK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_RRENTA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_RIVA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_RICA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_RCREE_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_DCLRENTA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_DCLIVA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_DCLICA_APLIC_CK;
ALTER TABLE MAT_TIPOS_CONTRIBUYENTE DROP CONSTRAINT TIPO_CONTRIB_DCLCREE_APLIC_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_GRUPOS_TARIFA_ACTI_ECONOM
**************************************************************************************************************************************/
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM DROP CONSTRAINT GRUPOS_TARIFA_ACTI_ECONOM_PK;
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM DROP CONSTRAINT GRUPTARIF_COD_UK;
ALTER TABLE MAT_GRUPOS_TARIFA_ACTI_ECONOM DROP CONSTRAINT GRUPTARIF_RUBRO_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_ACTIVIDADES_ECONOMICAS
**************************************************************************************************************************************/
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS DROP CONSTRAINT ACTIVIDADES_ECONOMICAS_PK;
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS DROP CONSTRAINT ACTI_ECON_COD_UK;
ALTER TABLE MAT_ACTIVIDADES_ECONOMICAS DROP CONSTRAINT ACTI_ECON_GRUPO_TAR_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_TIPOS_IDENTIFICACION
**************************************************************************************************************************************/
ALTER TABLE MAT_TIPOS_IDENTIFICACION DROP CONSTRAINT TIPOS_IDENTIFICACION_PK;
ALTER TABLE MAT_TIPOS_IDENTIFICACION DROP CONSTRAINT TIPO_IDENT_COD_UK;
ALTER TABLE MAT_TIPOS_IDENTIFICACION DROP CONSTRAINT TIPO_IDENT_NOMBRE_UK;



/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_GRUPOS_EMPRESARIALES
**************************************************************************************************************************************/
ALTER TABLE MAT_GRUPOS_EMPRESARIALES DROP CONSTRAINT GRUPOS_EMPRESARIALES_PK;
ALTER TABLE MAT_GRUPOS_EMPRESARIALES DROP CONSTRAINT GRUP_EMPRE_NIT_UK;
ALTER TABLE MAT_GRUPOS_EMPRESARIALES DROP CONSTRAINT GRUP_EMPRE_CIUD_FK;
ALTER TABLE MAT_GRUPOS_EMPRESARIALES DROP CONSTRAINT GRUP_EMPRE_DIRECC_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_EMPRESAS
**************************************************************************************************************************************/
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRESAS_PK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_NIT_UK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_TIPOPERIO_CK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_ID_GRUPO_FK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_CIUD_FK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_DIRECC_FK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_TIPO_CONTR_FK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_ACT_ECONOM_FK;
ALTER TABLE MAT_EMPRESAS DROP CONSTRAINT EMPRE_BANCO_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_CONCEPTOS_PAGO
**************************************************************************************************************************************/
ALTER TABLE MAT_CONCEPTOS_PAGO DROP CONSTRAINT CONCEPTOS_PAGO_PK;
ALTER TABLE MAT_CONCEPTOS_PAGO DROP CONSTRAINT COCEPTS_APLICEMPL_CK;
ALTER TABLE MAT_CONCEPTOS_PAGO DROP CONSTRAINT COCEPTS_APLICPROV_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_CONFIG_RETENCIONES
**************************************************************************************************************************************/
ALTER TABLE MAT_CONFIG_RETENCIONES DROP CONSTRAINT CONFIG_RETENCIONES_PK;
ALTER TABLE MAT_CONFIG_RETENCIONES DROP CONSTRAINT CONFRET_CONCEPTO_FK;
ALTER TABLE MAT_CONFIG_RETENCIONES DROP CONSTRAINT CONFRET_TIPO_PERS_CK;
ALTER TABLE MAT_CONFIG_RETENCIONES DROP CONSTRAINT CONFRET_TIPO_RETENC_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_TERCEROS
**************************************************************************************************************************************/
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERCEROS_PK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_CIUDAD_FK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_DIRECCION_FK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_TIPO_CONTR_FK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_ACT_ECONOM_FK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_TIPO_ID_FK;
ALTER TABLE MAT_TERCEROS DROP CONSTRAINT TERC_TIPO_PERS_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_PARAMETROS_CONFIG
**************************************************************************************************************************************/
ALTER TABLE MAT_PARAMETROS_CONFIG DROP CONSTRAINT ARAMETROS_CONFIG_PK;
ALTER TABLE MAT_PARAMETROS_CONFIG DROP CONSTRAINT PARAMCONF_CODCOF_CODAPP_UK;
ALTER TABLE MAT_PARAMETROS_CONFIG DROP CONSTRAINT PARAMCONF_CODAPP_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_EPSS
**************************************************************************************************************************************/
ALTER TABLE MAT_EPSS DROP CONSTRAINT EPSS_PK;
ALTER TABLE MAT_EPSS DROP CONSTRAINT EPS_COD_UK;
ALTER TABLE MAT_EPSS DROP CONSTRAINT EPS_VIGENTE_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_AFPS
**************************************************************************************************************************************/
ALTER TABLE MAT_AFPS DROP CONSTRAINT AFPS_PK;
ALTER TABLE MAT_AFPS DROP CONSTRAINT AFP_COD_UK;
ALTER TABLE MAT_AFPS DROP CONSTRAINT AFP_VIGENTE_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_ARLS
**************************************************************************************************************************************/
ALTER TABLE MAT_ARLS DROP CONSTRAINT ARLS_PK;
ALTER TABLE MAT_ARLS DROP CONSTRAINT ARL_COD_UK;
ALTER TABLE MAT_ARLS DROP CONSTRAINT ARL_VIGENTE_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla MAT_CCFS
**************************************************************************************************************************************/
ALTER TABLE MAT_CCFS DROP CONSTRAINT CCFS_PK;
ALTER TABLE MAT_CCFS DROP CONSTRAINT CCF_COD_UK;
ALTER TABLE MAT_CCFS DROP CONSTRAINT CCF_VIGENTE_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_CARGOS
**************************************************************************************************************************************/
ALTER TABLE GPT_CARGOS DROP CONSTRAINT CARGOS_PK;
ALTER TABLE GPT_CARGOS DROP CONSTRAINT CARGOS_COD_UK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_MOTIVOS_TERMINAC_CONTRATO
**************************************************************************************************************************************/
ALTER TABLE GPT_MOTIVOS_TERMINAC_CONTRATO DROP CONSTRAINT MOTIVOS_TERMINAC_CONTRATO_PK;
ALTER TABLE GPT_MOTIVOS_TERMINAC_CONTRATO DROP CONSTRAINT MOT_TERMI_OBLIDEMN_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_EMPLEADOS
**************************************************************************************************************************************/
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPLEADOS_PK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_IDTERC_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_EPS_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_AFP_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_ESTADO_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_GENERO_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_PROFESION_FK;
ALTER TABLE GPT_EMPLEADOS DROP CONSTRAINT EMPL_EMPR_FK;



/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_CONTRATOS_LABORALES
**************************************************************************************************************************************/
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRATOS_LABORALES_PK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_EMPRESA_FK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_EMPLEADO_FK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_CARGO_FK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_MOTIVOTERM_FK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_ESVIGENT_CK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_ESSAL_INTEGR_CK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_DERECH_RECARG_CK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_REPORTT_RECARG_CK;
ALTER TABLE GPT_CONTRATOS_LABORALES DROP CONSTRAINT CONTRAT_TIPOTERMINO_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_PROVEEDORES
**************************************************************************************************************************************/
ALTER TABLE GPT_PROVEEDORES DROP CONSTRAINT PROVEEDORES_PK;
ALTER TABLE GPT_PROVEEDORES DROP CONSTRAINT PROVEED_IDTERC_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_CLIENTES
**************************************************************************************************************************************/
ALTER TABLE GPT_CLIENTES DROP CONSTRAINT CLIENTES_PK;
ALTER TABLE GPT_CLIENTES DROP CONSTRAINT CLIENT_IDTERC_FK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_PERIODO_LIQUID_NOMINA
**************************************************************************************************************************************/
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA DROP CONSTRAINT PERIODO_LIQUID_NOMINA_PK;
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA DROP CONSTRAINT PERINOMI_EMPR_FK;
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA DROP CONSTRAINT PERINOMI_EMPRFEC_UK;
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA DROP CONSTRAINT PERINOMI_RANGFECHAS_CK;
ALTER TABLE GPT_PERIODO_LIQUID_NOMINA DROP CONSTRAINT PERINOMI_TIPOPERIO_CK;


/**************************************************************************************************************************************
* Borrado de Constraints para tabla GPT_REPORTE_TIEMPO
**************************************************************************************************************************************/
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTE_TIEMPO_PK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_PERIODO_FK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_EMPLEADO_FK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_RANGOHORA_CK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_ESTURNO_CK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_TIPTURNO_CK;
ALTER TABLE GPT_REPORTE_TIEMPO DROP CONSTRAINT REPORTMP_ESDESC_CK;
