CREATE SEQUENCE usuario_acceso_usuario_acceso_id_seq INCREMENT 1 START 1
;

CREATE TABLE usuario_acceso ( 
	usuario_acceso_id bigint DEFAULT nextval(('usuario_acceso_usuario_acceso_id_seq'::text)::regclass) NOT NULL,
	usuario_id bigint NOT NULL,
	acceso_id integer NOT NULL
)
;

CREATE SEQUENCE perfil_acceso_perfil_acceso_id_seq INCREMENT 1 START 1
;

CREATE TABLE perfil_acceso ( 
	perfil_acceso_id bigint DEFAULT nextval(('perfil_acceso_perfil_acceso_id_seq'::text)::regclass) NOT NULL,
	perfil_id bigint NOT NULL,
	acceso_id integer NOT NULL
)
;

CREATE TABLE acceso ( 
	acceso_id integer NOT NULL,
	nombre varchar(50) NOT NULL,
	url varchar(50),
	secuencia integer,
	modulo_id integer NOT NULL
)
;

CREATE TABLE modulo ( 
	modulo_id integer NOT NULL,
	nombre varchar(50) NOT NULL,
	secuencia integer
)
;

CREATE SEQUENCE perfil_perfil_id_seq INCREMENT 1 START 1
;

CREATE TABLE perfil ( 
	perfil_id bigint DEFAULT nextval(('perfil_perfil_id_seq'::text)::regclass) NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(100),
	estado boolean DEFAULT 't' NOT NULL
)
;

CREATE SEQUENCE usuario_usuario_id_seq INCREMENT 1 START 1
;

CREATE TABLE usuario ( 
	usuario_id bigint DEFAULT nextval(('usuario_usuario_id_seq'::text)::regclass) NOT NULL,
	nombres varchar(150) NOT NULL,
	username varchar(50) NOT NULL,
	password varchar(200) NOT NULL,
	ci varchar(10) NOT NULL,
	email varchar(50),
	telefono varchar(10),
	estado boolean DEFAULT 't' NOT NULL,
	perfil_id bigint NOT NULL
)
;

CREATE TABLE bitacora ( 
	fecha timestamp NOT NULL,
	usuario varchar(50),
	formulario varchar(50),
	accion varchar(200),
	direccion_ip varchar(50)
)
;


ALTER TABLE usuario_acceso ADD CONSTRAINT PK_usuario_acceso 
	PRIMARY KEY (usuario_acceso_id)
;


ALTER TABLE perfil_acceso ADD CONSTRAINT PK_perfil_acceso 
	PRIMARY KEY (perfil_acceso_id)
;


ALTER TABLE acceso ADD CONSTRAINT PK_acceso 
	PRIMARY KEY (acceso_id)
;


ALTER TABLE modulo ADD CONSTRAINT PK_modulo 
	PRIMARY KEY (modulo_id)
;


ALTER TABLE perfil ADD CONSTRAINT PK_perfil 
	PRIMARY KEY (perfil_id)
;


ALTER TABLE usuario ADD CONSTRAINT PK_usuario 
	PRIMARY KEY (usuario_id)
;


ALTER TABLE bitacora ADD CONSTRAINT PK_bitacora 
	PRIMARY KEY (fecha)
;



ALTER TABLE usuario
	ADD CONSTRAINT UQ_usuario_ci UNIQUE (ci)
;
ALTER TABLE usuario
	ADD CONSTRAINT UQ_usuario_username UNIQUE (username)
;

ALTER TABLE usuario_acceso ADD CONSTRAINT FK_usuario_acceso_acceso 
	FOREIGN KEY (acceso_id) REFERENCES acceso (acceso_id)
;

ALTER TABLE usuario_acceso ADD CONSTRAINT FK_usuario_acceso_usuario 
	FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
;

ALTER TABLE perfil_acceso ADD CONSTRAINT FK_perfil_acceso_acceso 
	FOREIGN KEY (acceso_id) REFERENCES acceso (acceso_id)
;

ALTER TABLE perfil_acceso ADD CONSTRAINT FK_perfil_acceso_perfil 
	FOREIGN KEY (perfil_id) REFERENCES perfil (perfil_id)
;

ALTER TABLE acceso ADD CONSTRAINT FK_acceso_modulo 
	FOREIGN KEY (modulo_id) REFERENCES modulo (modulo_id)
;

ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil 
	FOREIGN KEY (perfil_id) REFERENCES perfil (perfil_id)
;
