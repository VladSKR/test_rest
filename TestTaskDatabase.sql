--
-- PostgreSQL database dump
--

-- Dumped from database version 10.20
-- Dumped by pg_dump version 10.20

-- Started on 2022-04-11 21:34:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2809 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16396)
-- Name: colleagues; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.colleagues (
    id integer NOT NULL,
    firstname character varying(30),
    lastname character varying(30),
    fathersname character varying(30),
    jobposition character varying(30),
    dateofbirth date,
    city character varying(30)
);


--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: colleagues_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.colleagues_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2810 (class 0 OID 0)
-- Dependencies: 196
-- Name: colleagues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.colleagues_id_seq OWNED BY public.colleagues.id;


--
-- TOC entry 198 (class 1259 OID 16402)
-- Name: weather; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.weather (
    colleagueid integer,
    temperature integer,
    description character varying(30),
    lastupdatetime timestamp without time zone,
    updatestatus boolean
);


--
-- TOC entry 2674 (class 2604 OID 16399)
-- Name: colleagues id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.colleagues ALTER COLUMN id SET DEFAULT nextval('public.colleagues_id_seq'::regclass);


--
-- TOC entry 2800 (class 0 OID 16396)
-- Dependencies: 197
-- Data for Name: colleagues; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.colleagues (id, firstname, lastname, fathersname, jobposition, dateofbirth, city) FROM stdin;
2	Анатолий	Пашков	Григорьевич	Директор	1984-05-12	Москва
1	Дмитрий	Писков	Андреевич	Разработчик	1991-05-12	Киев
\.


--
-- TOC entry 2801 (class 0 OID 16402)
-- Dependencies: 198
-- Data for Name: weather; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.weather (colleagueid, temperature, description, lastupdatetime, updatestatus) FROM stdin;
1	-5	snow	2022-03-28 15:36:38	t
2	-3	sunny	2022-03-28 20:36:38	f
\.


--
-- TOC entry 2811 (class 0 OID 0)
-- Dependencies: 196
-- Name: colleagues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.colleagues_id_seq', 9, true);


--
-- TOC entry 2676 (class 2606 OID 16401)
-- Name: colleagues colleagues_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.colleagues
    ADD CONSTRAINT colleagues_pkey PRIMARY KEY (id);


--
-- TOC entry 2677 (class 2606 OID 16405)
-- Name: weather weather_colleagueid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.weather
    ADD CONSTRAINT weather_colleagueid_fkey FOREIGN KEY (colleagueid) REFERENCES public.colleagues(id);


-- Completed on 2022-04-11 21:34:18

--
-- PostgreSQL database dump complete
--

