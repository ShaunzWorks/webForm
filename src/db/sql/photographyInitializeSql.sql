CREATE TABLE public.tb_photography
(
  vch_photo_id character varying(100000) NOT NULL,
  vch_photo_name character varying(100) NOT NULL,
  vch_photo_group character varying(50) NOT NULL,
  vch_photo_url character varying(200) NOT NULL,
  vch_photo_takeplace character varying(200) NOT NULL,
  vch_photo_camera character varying(50),
  vch_photo_focal_length character varying(50),
  vch_photo_aperture character varying(50),
  vch_photo_exposure_time character varying(50),
  vch_photo_iso character varying(50),
  vch_photo_owner character varying(100) NOT NULL,
  vch_close_flg character varying(1) NOT NULL DEFAULT 'N'::character varying,
  vch_add_usr character varying(100),
  dt_add_date timestamp without time zone,
  vch_mod_usr character varying(100),
  dt_mod_date timestamp without time zone,
  CONSTRAINT tb_photography_pkey PRIMARY KEY (vch_photo_id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public.tb_syscode
(
	vch_group_nm character varying(20),
	vch_code_nm character varying(30),
	vch_code_value character varying(30),
	vch_code_desc character varying(100),
	CONSTRAINT tb_syscode_pkey PRIMARY KEY (vch_group_nm,vch_code_nm)
);