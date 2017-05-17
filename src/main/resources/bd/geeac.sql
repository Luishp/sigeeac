DROP TABLE "ARCHIVO" CASCADE CONSTRAINTS;
DROP TABLE "BITACORA" CASCADE CONSTRAINTS;
DROP TABLE "CARACTERISTICA" CASCADE CONSTRAINTS;
DROP TABLE "CONFIGURACION_SISTEMA" CASCADE CONSTRAINTS;
DROP TABLE "EMPRESA_SERVICIO" CASCADE CONSTRAINTS;
DROP TABLE "EQUIPO_ELECTRICO" CASCADE CONSTRAINTS;
DROP TABLE "INSTITUCION_CONFIGURACION" CASCADE CONSTRAINTS;
DROP TABLE "INSTITUCION_EMP_SERVICIO" CASCADE CONSTRAINTS;
DROP TABLE "INSTITUCION_GUBERNAMENTAL" CASCADE CONSTRAINTS;
DROP TABLE "LISTA_CARACTERISTICA" CASCADE CONSTRAINTS;
DROP TABLE "MANTENIMIENTO" CASCADE CONSTRAINTS;
DROP TABLE "MENU" CASCADE CONSTRAINTS;
DROP TABLE "ORDEN_COMPRA" CASCADE CONSTRAINTS;
DROP TABLE "ORDEN_COMPRA_DET" CASCADE CONSTRAINTS;
DROP TABLE "ROL" CASCADE CONSTRAINTS;
DROP TABLE "TECNICO" CASCADE CONSTRAINTS;
DROP TABLE "TIPO_COMPRA" CASCADE CONSTRAINTS;
DROP TABLE "TIPO_EQUIPO_ELECTRICO" CASCADE CONSTRAINTS;
DROP TABLE "TIPO_MANTENIMIENTO" CASCADE CONSTRAINTS;
DROP TABLE "TIPO_SERVICIO" CASCADE CONSTRAINTS;
DROP TABLE "UNIDAD_ADMINISTRATIVA" CASCADE CONSTRAINTS;
DROP TABLE "USUARIO" CASCADE CONSTRAINTS;
DROP TABLE "ALERTAS_MANTENIMIENTO" CASCADE CONSTRAINTS;
DROP TABLE "EQUIPO_TRABAJO" CASCADE CONSTRAINTS;
DROP TABLE "PERMISO" CASCADE CONSTRAINTS;
DROP TABLE "SERVICIO_OFRECIDO" CASCADE CONSTRAINTS;
DROP TABLE "RESTRINGE_MONTO_COMPRA" CASCADE CONSTRAINTS;
DROP TABLE "TECNICO_BLOQUEADO" CASCADE CONSTRAINTS;
DROP TABLE "VALOR_CARACTERISTICA" CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: "ARCHIVO"                                             */
/*==============================================================*/
CREATE TABLE "ARCHIVO" 
(
   "ARC_ID"              INTEGER              NOT NULL,
   "ARC_MTT_ID"           INTEGER              NOT NULL,
   "ARC_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "ARC_ARCHIVO"         VARCHAR2(250)        NOT NULL,
   "ARC_TIPO"            VARCHAR2(5)          NOT NULL,
   "ARC_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_ARCHIVO PRIMARY KEY ("ARC_ID")
);


/*==============================================================*/
/* Table: "BITACORA"                                            */
/*==============================================================*/
CREATE TABLE "BITACORA" 
(
   "BIT_ID"              INTEGER              NOT NULL,
   "BIT_NOMBRE_TABLA"     VARCHAR2(80)         NOT NULL,
   "BIT_ESTADO_ANTERIOR"  VARCHAR2(4000)       NOT NULL,
   "BIT_ESTADO_NUEVO"     VARCHAR2(4000)       NOT NULL,
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_BITACORA PRIMARY KEY ("BIT_ID")
);

/*==============================================================*/
/* Table: "CONFIGURACION_SISTEMA"                                */
/*==============================================================*/
CREATE TABLE "CONFIGURACION_SISTEMA" 
(
   "CFG_ID"              INTEGER              NOT NULL,
   "CFG_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "CFG_VALOR"           VARCHAR2(80)         NOT NULL,
   "CFG_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_CONFIGURACION_SISTEMA PRIMARY KEY ("CFG_ID")
);

/*==============================================================*/
/* Table: "EMPRESASERVICIO"                                     */
/*==============================================================*/
CREATE TABLE "EMPRESA_SERVICIO" 
(
   "EMP_ID"              INTEGER              NOT NULL,
   "EMP_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "EMP_DIRECCION"       VARCHAR2(250)        NOT NULL,
   "EMP_NOMBRE_CONTACTO"  VARCHAR2(80)         NOT NULL,
   "EMP_TEL_CONTACTO"     VARCHAR2(20)         NOT NULL,
   "EMP_CORREO_ELECTRONICO" VARCHAR2(100)        NOT NULL,
   "EMP_NIT"             VARCHAR2(17)         NOT NULL,
   "EMP_LOGO"            VARCHAR2(250),
   "EMP_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_EMPRESA_SERVICIO PRIMARY KEY ("EMP_ID")
);

/*==============================================================*/
/* Table: "EQUIPOELECTRICO"                                     */
/*==============================================================*/
CREATE TABLE "EQUIPO_ELECTRICO" 
(
   "EQE_ID"              INTEGER              NOT NULL,
   "EQE_CMD_ID"           INTEGER,
   "EQE_UAD_ID"           INTEGER,
   "EQE_TEQ_ID"           INTEGER              NOT NULL,
   "EQE_NUM_INVENTARIO"   VARCHAR2(20)         NOT NULL,
   "EQE_MARCA"           VARCHAR2(80)         NOT NULL,
   "EQE_MODELO"          VARCHAR2(80)         NOT NULL,
   "EQE_FEC_FABRICACION"  TIMESTAMP            NOT NULL,
   "EQE_FOTO"            VARCHAR2(250),
   "EQE_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_EQUIPO_ELECTRICO PRIMARY KEY ("EQE_ID")
);

/*==============================================================*/
/* Table: "INSTITUCIONGUBERNAMENTAL"                            */
/*==============================================================*/
CREATE TABLE "INSTITUCION_GUBERNAMENTAL" 
(
   "ING_ID"              INTEGER              NOT NULL,
   "ING_CODIGO"          VARCHAR2(20)         NOT NULL,
   "ING_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "ING_DIRECCION"       VARCHAR2(250)        NOT NULL,
   "ING_TELEFONO"        VARCHAR2(20)         NOT NULL,
   "ING_CORREO_ELECTRONICO" VARCHAR2(100)        NOT NULL,
   "ING_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_INSTITUCION_GUBERNAMENTAL PRIMARY KEY ("ING_ID")
);

/*==============================================================*/
/* Table: "LISTACARACTERISTICAS"                                */
/*==============================================================*/
CREATE TABLE "LISTA_CARACTERISTICA" 
(
   "LSC_ID"              INTEGER              NOT NULL,
   "LSC_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "LSC_TIPO_VALOR"       VARCHAR2(20)         NOT NULL,
   "LSC_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_LISTA_CARACTERISTICAS PRIMARY KEY ("LSC_ID")
);

/*==============================================================*/
/* Table: "MANTENIMIENTO"                                       */
/*==============================================================*/
CREATE TABLE "MANTENIMIENTO" 
(
   "MTT_ID"              INTEGER              NOT NULL,
   "MTT_EMP_ID"           INTEGER              NOT NULL,
   "MTT_EQE_ID"           INTEGER              NOT NULL,
   "MTT_TMT_ID"           INTEGER              NOT NULL,
   "MTT_FEC_INICIO"       TIMESTAMP            NOT NULL,
   "MTT_FEC_FIN"          TIMESTAMP,
   "MTT_ESTADO_EQUIPO_INICIO" VARCHAR2(4000)       NOT NULL,
   "MTT_ESTADO_EQUIPO_FIN" VARCHAR2(4000),
   "MTT_ESTADO_MANTENIMIENTO" NUMBER(1)            NOT NULL,
   "MTT_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_MANTENIMIENTO PRIMARY KEY ("MTT_ID")
);


/*==============================================================*/
/* Table: "MENU"                                                */
/*==============================================================*/
CREATE TABLE "SMENU" 
(
   "MNU_ID"              INTEGER              NOT NULL,
   "MNU_PADRE_ID"         INTEGER,
   "MNU_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "MNU_MENU_PADRE"       VARCHAR2(250),
   "MNU_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_MENU PRIMARY KEY ("MNU_ID")
);


/*==============================================================*/
/* Table: "ORDENCOMPRA"                                         */
/*==============================================================*/
CREATE TABLE "ORDEN_COMPRA" 
(
   "CMP_ID"              INTEGER              NOT NULL,
   "CMP_TPC_ID"           INTEGER              NOT NULL,
   "CMP_ING_ID"           INTEGER              NOT NULL,
   "CMP_EMP_ID"           INTEGER,
   "CMP_USR_ID"           INTEGER              NOT NULL,
   "CMP_FECHA_COMPRA"     TIMESTAMP            NOT NULL,
   "CMP_NUMERO_COMPROBANTE" VARCHAR2(20)         NOT NULL,
   "CMP_LUGAR"           VARCHAR2(250)        NOT NULL,
   "CMP_FORMA_PAGO"       VARCHAR2(80)         NOT NULL,
   "CMP_NUM_REQUERIMIENTO" VARCHAR2(20)         NOT NULL,
   "CMP_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_ORDEN_COMPRA PRIMARY KEY ("CMP_ID")
);


/*==============================================================*/
/* Table: "ORDENCOMPRADET"                                      */
/*==============================================================*/
CREATE TABLE "ORDEN_COMPRA_DET" 
(
   "CMD_ID"              INTEGER              NOT NULL,
   "CMD_CMP_ID"           INTEGER,
   "CMD_CANTIDAD"        NUMBER               NOT NULL,
   "CMD_PRECIO_UNITARIO"  NUMBER(10,6)         NOT NULL,
   "CMD_GARANTIA"        NUMBER               NOT NULL,
   "CMD_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_ORDEN_COMPRA_DET PRIMARY KEY ("CMD_ID")
);



/*==============================================================*/
/* Table: "ROL"                                                 */
/*==============================================================*/
CREATE TABLE "SROL" 
(
   "ROL_ID"              INTEGER              NOT NULL,
   "ROL_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "ROL_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_ROL PRIMARY KEY ("ROL_ID")
);

/*==============================================================*/
/* Table: "TECNICO"                                             */
/*==============================================================*/
CREATE TABLE "TECNICO" 
(
   "TEC_ID"              INTEGER              NOT NULL,
   "TEC_EMP_ID"           INTEGER,
   "TEC_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "TEC_APELLIDO"        VARCHAR2(80)         NOT NULL,
   "TEC_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TECNICO PRIMARY KEY ("TEC_ID")
);


/*==============================================================*/
/* Table: "TIPOCOMPRA"                                          */
/*==============================================================*/
CREATE TABLE "TIPO_COMPRA" 
(
   "TPC_ID"              INTEGER              NOT NULL,
   "TPC_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "TPC_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TIPO_COMPRA PRIMARY KEY ("TPC_ID")
);

/*==============================================================*/
/* Table: "TIPOEQUIPOELECTRICO"                                 */
/*==============================================================*/
CREATE TABLE "TIPO_EQUIPO_ELECTRICO" 
(
   "TEQ_ID"              INTEGER              NOT NULL,
   "TEQ_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "TEQ_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TIPO_EQUIPO_ELECTRICO PRIMARY KEY ("TEQ_ID")
);

/*==============================================================*/
/* Table: "TIPOMANTENIMIENTO"                                   */
/*==============================================================*/
CREATE TABLE "TIPO_MANTENIMIENTO" 
(
   "TMT_ID"              INTEGER              NOT NULL,
   "TMT_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "TMT_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TIPO_MANTENIMIENTO PRIMARY KEY ("TMT_ID")
);

/*==============================================================*/
/* Table: "TIPOSERVICIO"                                       */
/*==============================================================*/
CREATE TABLE "TIPO_SERVICIO" 
(
   "TPS_ID"              INTEGER              NOT NULL,
   "TPS_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "TPS_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TIPO_SERVICIO PRIMARY KEY ("TPS_ID")
);

/*==============================================================*/
/* Table: "UNIDADADMINISTRATIVA"                                */
/*==============================================================*/
CREATE TABLE "UNIDAD_ADMINISTRATIVA" 
(
   "UAD_ID"              INTEGER              NOT NULL,
   "UAD_ING_ID"           INTEGER              NOT NULL,
   "UAD_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "UAD_DEPARTAMENTO"    VARCHAR2(80)         NOT NULL,
   "UAD_MUNICIPIO"       VARCHAR2(80)         NOT NULL,
   "UAD_JEFE_UNIDAD"      VARCHAR2(80)         NOT NULL,
   "UAD_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_UNIDAD_ADMINISTRATIVA PRIMARY KEY ("UAD_ID")
);

/*==============================================================*/
/* Table: "USUARIO"                                             */
/*==============================================================*/
CREATE TABLE "SUSUARIO" 
(
   "USR_ID"              INTEGER              NOT NULL,
   "USR_ROL_ID"           INTEGER              NOT NULL,
   "USR_ING_ID"           INTEGER              NOT NULL,
   "USR_CARNET"          VARCHAR2(6)          NOT NULL,
   "USR_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "USR_APELLIDO"        VARCHAR2(80)         NOT NULL,
   "USR_DUI"             VARCHAR2(10),
   "USR_NIT"             VARCHAR2(17),
   "USR_TELEFONO"        VARCHAR2(20),
   "USR_CELULAR"         VARCHAR2(20),
   "USR_CORREO_ELECTRONICO" VARCHAR2(100)        NOT NULL,
   "USR_USUARIO"         VARCHAR2(6)          NOT NULL,
   "USR_CONTRASENIA"     VARCHAR2(20)         NOT NULL,
   "USR_FOTO"            VARCHAR2(250),
   "USR_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_USUARIO PRIMARY KEY ("USR_ID")
);



/*==============================================================*/
/* Table: "ALERTASMANTENIMIENTO"                                */
/*==============================================================*/
CREATE TABLE "ALERTAS_MANTENIMIENTO" 
(
   "ALR_ID"              INTEGER              NOT NULL,
   "ALR_ING_ID"           INTEGER              NOT NULL,
   "ALR_TEQ_ID"           INTEGER              NOT NULL,
   "ALR_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "ALR_VALOR"           VARCHAR2(20)         NOT NULL,
   "ALR_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_ALERTAS_MANTENIMIENTO PRIMARY KEY ("ALR_ID")
);



/*==============================================================*/
/* Table: "CARACTERISTICAS"                                     */
/*==============================================================*/
CREATE TABLE "CARACTERISTICA" 
(
   "CTE_ID"              INTEGER              NOT NULL,
   "CTE_TEQ_ID"           INTEGER              NOT NULL,
   "CTE_LSC_ID"           INTEGER              NOT NULL,
   "CTE_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_CARACTERISTICA PRIMARY KEY ("CTE_ID")
);


/*==============================================================*/
/* Table: "PARTICIPA"                                           */
/*==============================================================*/
CREATE TABLE "EQUIPO_TRABAJO" 
(
   "EQT_ID"              INTEGER              NOT NULL,
   "EQT_TEC_ID"           INTEGER              NOT NULL,
   "EQT_MTT_ID"           INTEGER              NOT NULL,
   "EQT_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "EQT_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_EQUIPO_TRABAJO PRIMARY KEY ("EQT_ID")
);



/*==============================================================*/
/* Table: "PERMISO"                                            */
/*==============================================================*/
CREATE TABLE "SPERMISO" 
(
   "PER_ID"              INTEGER              NOT NULL,
   "PER_ROL_ID"           INTEGER              NOT NULL,
   "PER_MNU_ID"           INTEGER              NOT NULL,
   "PER_NOMBRE"          VARCHAR2(80)         NOT NULL,
   "PER_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_PERMISO PRIMARY KEY ("PER_ID")
);


/*==============================================================*/
/* Table: "PRESTA"                                              */
/*==============================================================*/
CREATE TABLE "SERVICIO_OFRECIDO" 
(
   "SRO_ID"              INTEGER              NOT NULL,
   "SRO_EMP_ID"           INTEGER              NOT NULL,
   "SRO_TPS_ID"           INTEGER              NOT NULL,
   "SRO_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_SERVICIO_OFRECIDO PRIMARY KEY ("SRO_ID")
);



/*==============================================================*/
/* Table: "PRESTASERVICIO"                                      */
/*==============================================================*/
CREATE TABLE "INSTITUCION_EMP_SERVICIO" 
(
   "IES_ID"              INTEGER              NOT NULL,
   "IES_EMP_ID"           INTEGER              NOT NULL,
   "IES_ING_ID"           INTEGER              NOT NULL,
   "IES_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_INSTITUCION_EMP_SERVICIO PRIMARY KEY ("IES_ID")
);



/*==============================================================*/
/* Table: "RESTRINGEMONTOCOMPRA"                                */
/*==============================================================*/
CREATE TABLE "RESTRINGE_MONTO_COMPRA" 
(
   "RMC_ID"              INTEGER              NOT NULL,
   "RMC_ING_ID"           INTEGER              NOT NULL,
   "RMC_EMP_ID"           INTEGER              NOT NULL,
   "RMC_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_RESTRINGE_MONTO_COMPRA PRIMARY KEY ("RMC_ID")
);


/*==============================================================*/
/* Table: "TECNICOBLOQUEADO"                                    */
/*==============================================================*/
CREATE TABLE "TECNICO_BLOQUEADO" 
(
   "TCB_ID"              INTEGER              NOT NULL,
   "TCB_ING_ID"           INTEGER              NOT NULL,
   "TCB_TEC_ID"           INTEGER              NOT NULL,
   "TCB_DESCRIPCION"     VARCHAR2(4000),
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_TECNICO_BLOQUEADO PRIMARY KEY ("TCB_ID")
);


/*==============================================================*/
/* Table: "TIENE"                                               */
/*==============================================================*/
CREATE TABLE "INSTITUCION_CONFIGURACION" 
(
   "INC_ID"              INTEGER              NOT NULL,
   "INC_ING_ID"           INTEGER              NOT NULL,
   "INC_CFG_ID"           INTEGER              NOT NULL,
   "INC_DESCRIPCION"     INTEGER,
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_INSTITUCION_CONFIGURACION PRIMARY KEY ("INC_ID")
);



/*==============================================================*/
/* Table: "VALORCARACTERISTICA"                                 */
/*==============================================================*/
CREATE TABLE "VALOR_CARACTERISTICA" 
(
   "VCA_ID"              INTEGER              NOT NULL,
   "VCA_EQE_ID"           INTEGER              NOT NULL,
   "VCA_LSC_ID"           INTEGER              NOT NULL,
   "FEC_CREA"            TIMESTAMP            NOT NULL,
   "USU_CREA"            VARCHAR2(6)          NOT NULL,
   "FEC_MODI"            TIMESTAMP,
   "USU_MODI"            VARCHAR2(6),
   "REG_ACTIVO"          NUMBER(1)            NOT NULL,
   CONSTRAINT PK_VALOR_CARACTERISTICA PRIMARY KEY ("VCA_ID")
);



ALTER TABLE "ARCHIVO"
   ADD CONSTRAINT FK_ARC_MTT FOREIGN KEY ("ARC_MTT_ID")
      REFERENCES "MANTENIMIENTO" ("MTT_ID");

ALTER TABLE "EQUIPO_ELECTRICO"
   ADD CONSTRAINT FK_EQE_TEQ FOREIGN KEY ("EQE_TEQ_ID")
      REFERENCES "TIPO_EQUIPO_ELECTRICO" ("TEQ_ID");

ALTER TABLE "EQUIPO_ELECTRICO"
   ADD CONSTRAINT FK_EQE_UAD FOREIGN KEY ("EQE_UAD_ID")
      REFERENCES "UNIDAD_ADMINISTRATIVA" ("UAD_ID");

ALTER TABLE "EQUIPO_ELECTRICO"
   ADD CONSTRAINT FK_EQWE_CMD FOREIGN KEY ("EQE_CMD_ID")
      REFERENCES "ORDEN_COMPRA_DET" ("CMD_ID");

ALTER TABLE "MANTENIMIENTO"
   ADD CONSTRAINT FK_MTT_TMT FOREIGN KEY ("MTT_TMT_ID")
      REFERENCES "TIPO_MANTENIMIENTO" ("TMT_ID");

ALTER TABLE "MANTENIMIENTO"
   ADD CONSTRAINT FK_MTT_EMP FOREIGN KEY ("MTT_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "MANTENIMIENTO"
   ADD CONSTRAINT FK_MTT_EQE FOREIGN KEY ("MTT_EQE_ID")
      REFERENCES "EQUIPO_ELECTRICO" ("EQE_ID");

ALTER TABLE "SMENU"
   ADD CONSTRAINT FK_MNU_MNU_PADRE FOREIGN KEY ("MNU_PADRE_ID")
      REFERENCES "SMENU" ("MNU_ID");

ALTER TABLE "ORDEN_COMPRA"
   ADD CONSTRAINT FK_CMP_TPC FOREIGN KEY ("CMP_TPC_ID")
      REFERENCES "TIPO_COMPRA" ("TPC_ID");

ALTER TABLE "ORDEN_COMPRA"
   ADD CONSTRAINT FK_CMP_ING FOREIGN KEY ("CMP_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "ORDEN_COMPRA"
   ADD CONSTRAINT FK_CMP_USR FOREIGN KEY ("CMP_USR_ID")
      REFERENCES "SUSUARIO" ("USR_ID");

ALTER TABLE "ORDEN_COMPRA"
   ADD CONSTRAINT FK_CMP_EMP FOREIGN KEY ("CMP_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "ORDEN_COMPRA_DET"
   ADD CONSTRAINT FK_CMD_CMP FOREIGN KEY ("CMD_CMP_ID")
      REFERENCES "ORDEN_COMPRA" ("CMP_ID");

ALTER TABLE "TECNICO"
   ADD CONSTRAINT FK_TEC_EMP FOREIGN KEY ("TEC_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "UNIDAD_ADMINISTRATIVA"
   ADD CONSTRAINT FK_UAD_ING FOREIGN KEY ("UAD_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "SUSUARIO"
   ADD CONSTRAINT FK_USR_ROL FOREIGN KEY ("USR_ROL_ID")
      REFERENCES "SROL" ("ROL_ID");

ALTER TABLE "SUSUARIO"
   ADD CONSTRAINT FK_USR_ING FOREIGN KEY ("USR_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "ALERTAS_MANTENIMIENTO"
   ADD CONSTRAINT FK_ALR_ING FOREIGN KEY ("ALR_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "ALERTAS_MANTENIMIENTO"
   ADD CONSTRAINT FK_ALT_TEQ FOREIGN KEY ("ALR_TEQ_ID")
      REFERENCES "TIPO_EQUIPO_ELECTRICO" ("TEQ_ID");

ALTER TABLE "CARACTERISTICA"
   ADD CONSTRAINT FK_CTE_LSC FOREIGN KEY ("CTE_LSC_ID")
      REFERENCES "LISTA_CARACTERISTICA" ("LSC_ID");

ALTER TABLE "CARACTERISTICA"
   ADD CONSTRAINT FK_CTE_TEQ FOREIGN KEY ("CTE_TEQ_ID")
      REFERENCES "TIPO_EQUIPO_ELECTRICO" ("TEQ_ID");

ALTER TABLE "EQUIPO_TRABAJO"
   ADD CONSTRAINT FK_EQT_MTT FOREIGN KEY ("EQT_MTT_ID")
      REFERENCES "MANTENIMIENTO" ("MTT_ID");

ALTER TABLE "EQUIPO_TRABAJO"
   ADD CONSTRAINT FK_EQT_TEC FOREIGN KEY ("EQT_TEC_ID")
      REFERENCES "TECNICO" ("TEC_ID");

ALTER TABLE "SPERMISO"
   ADD CONSTRAINT FK_PER_MNU FOREIGN KEY ("PER_MNU_ID")
      REFERENCES "SMENU" ("MNU_ID");

ALTER TABLE "SPERMISO"
   ADD CONSTRAINT FK_PER_ROL FOREIGN KEY ("PER_ROL_ID")
      REFERENCES "SROL" ("ROL_ID");

ALTER TABLE "SERVICIO_OFRECIDO"
   ADD CONSTRAINT FK_SRO_EMP FOREIGN KEY ("SRO_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "SERVICIO_OFRECIDO"
   ADD CONSTRAINT FK_SRO_TPS FOREIGN KEY ("SRO_TPS_ID")
      REFERENCES "TIPO_SERVICIIO" ("TPS_ID");

ALTER TABLE "INSTITUCION_EMP_SERVICIO"
   ADD CONSTRAINT FK_IES_EMP FOREIGN KEY ("IES_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "INSTITUCION_EMP_SERVICIO"
   ADD CONSTRAINT FK_IES_ING FOREIGN KEY ("IES_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "RESTRINGE_MONTO_COMPRA"
   ADD CONSTRAINT FK_RMC_EMP FOREIGN KEY ("RMC_EMP_ID")
      REFERENCES "EMPRESA_SERVICIO" ("EMP_ID");

ALTER TABLE "RESTRINGE_MONTO_COMPRA"
   ADD CONSTRAINT FK_RMC_ING FOREIGN KEY ("RMC_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "TECNICO_BLOQUEADO"
   ADD CONSTRAINT FK_TCB_ING FOREIGN KEY ("TCB_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "TECNICO_BLOQUEADO"
   ADD CONSTRAINT FK_TCB_TEC FOREIGN KEY ("TCB_TEC_ID")
      REFERENCES "TECNICO" ("TEC_ID");

ALTER TABLE "INSTITUCION_CONFIGURACION"
   ADD CONSTRAINT FK_ING_CFG FOREIGN KEY ("INC_CFG_ID")
      REFERENCES "CONFIGURACION_SISTEMA" ("CFG_ID");

ALTER TABLE "INSTITUCION_CONFIGURACION"
   ADD CONSTRAINT FK_INC_ING FOREIGN KEY ("INC_ING_ID")
      REFERENCES "INSTITUCION_GUBERNAMENTAL" ("ING_ID");

ALTER TABLE "VALOR_CARACTERISTICA"
   ADD CONSTRAINT FK_VCA_EQE FOREIGN KEY ("VCA_EQE_ID")
      REFERENCES "EQUIPO_ELECTRICO" ("EQE_ID");

ALTER TABLE "VALOR_CARACTERISTICA"
   ADD CONSTRAINT FK_VCA_LSC FOREIGN KEY ("VCA_LSC_ID")
      REFERENCES "LISTA_CARACTERISTICA" ("LSC_ID");

