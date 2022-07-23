DROP TABLE IF EXISTS public.centri_vaccinali CASCADE;
CREATE TABLE public.centri_vaccinali (
    nomecentro character varying NOT NULL,
    indirizzo character varying,
    tipologia character varying
);

DROP TABLE IF EXISTS public.cittadini_registrati CASCADE;
CREATE TABLE public.cittadini_registrati (
    nome character varying,
    cognome character varying,
    cf character varying,
    email character varying,
    userid character varying NOT NULL,
    password character varying,
    idvaccinazione smallint
);

DROP TABLE IF EXISTS public.eventi_avversi CASCADE;
CREATE TABLE public.eventi_avversi (
    evento character varying,
    importanza smallint,
    note character varying(256),
    idvaccinazione smallint,
    nomecentro character varying
);

DROP TABLE IF EXISTS public.operatori_sanitari CASCADE;
CREATE TABLE public.operatori_sanitari (
    nome character varying,
    cognome character varying,
    id character varying NOT NULL,
    email character varying,
    password character varying
);

DROP TABLE IF EXISTS public.registrazioni_vaccinazioni CASCADE;
CREATE TABLE public.registrazioni_vaccinazioni (
    nomecentro character varying,
    cf character varying(16) NOT NULL,
    dataprenotazione date
);

ALTER TABLE ONLY public.centri_vaccinali
    ADD CONSTRAINT centri_vaccinali_pkey PRIMARY KEY (nomecentro);

ALTER TABLE ONLY public.cittadini_registrati
    ADD CONSTRAINT cittadini_registrati_cf_key UNIQUE (cf);

ALTER TABLE ONLY public.cittadini_registrati
    ADD CONSTRAINT cittadini_registrati_idvaccinazione_key UNIQUE (idvaccinazione);

ALTER TABLE ONLY public.cittadini_registrati
    ADD CONSTRAINT cittadini_registrati_pkey PRIMARY KEY (userid);

ALTER TABLE ONLY public.operatori_sanitari
    ADD CONSTRAINT operatori_sanitari_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.registrazioni_vaccinazioni
    ADD CONSTRAINT registrazioni_vaccinazioni_pkey PRIMARY KEY (cf);

ALTER TABLE ONLY public.eventi_avversi
    ADD CONSTRAINT "idVaccinazione" FOREIGN KEY (idvaccinazione) REFERENCES public.cittadini_registrati(idvaccinazione) NOT VALID;
