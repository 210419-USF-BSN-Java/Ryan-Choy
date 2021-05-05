--
-- PostgreSQL database dump
--

-- Dumped from database version 10.16
-- Dumped by pg_dump version 10.16

-- Started on 2021-05-05 07:25:24

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
-- TOC entry 7 (class 2615 OID 16393)
-- Name: shop; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA shop;


ALTER SCHEMA shop OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16395)
-- Name: customer; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.customer (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    uid integer NOT NULL,
    debt money NOT NULL,
    payterm integer NOT NULL,
    weekpay money NOT NULL
);


ALTER TABLE shop.customer OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16404)
-- Name: grimlist; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.grimlist (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    grimcondition character varying(50) NOT NULL,
    grimschool character varying(50) NOT NULL,
    grimstatus character varying(50) NOT NULL,
    grimnote character varying(100) DEFAULT ' '::character varying NOT NULL,
    baseprice money DEFAULT 0 NOT NULL,
    grimauthor character varying(50) DEFAULT 'Unknown'::character varying NOT NULL
);


ALTER TABLE shop.grimlist OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16398)
-- Name: offer; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.offer (
    date character varying(15) NOT NULL,
    oid integer NOT NULL,
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    uid integer NOT NULL,
    firstname character varying(30) NOT NULL,
    lastname character varying(30) NOT NULL,
    offer money NOT NULL,
    payterm integer NOT NULL,
    offerstatus character varying(50) DEFAULT 'Pending'::character varying NOT NULL
);


ALTER TABLE shop.offer OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16402)
-- Name: offer_oid_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.offer_oid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.offer_oid_seq OWNER TO postgres;

--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 201
-- Name: offer_oid_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.offer_oid_seq OWNED BY shop.offer.oid;


--
-- TOC entry 203 (class 1259 OID 16407)
-- Name: shop_gid_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.shop_gid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.shop_gid_seq OWNER TO postgres;

--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 203
-- Name: shop_gid_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.shop_gid_seq OWNED BY shop.grimlist.gid;


--
-- TOC entry 204 (class 1259 OID 16409)
-- Name: users; Type: TABLE; Schema: shop; Owner: postgres
--

CREATE TABLE shop.users (
    uid integer NOT NULL,
    usertype character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    firstname character varying(30) NOT NULL,
    lastname character varying(30) NOT NULL,
    phonenumber character varying(10)
);


ALTER TABLE shop.users OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16412)
-- Name: users_uid_seq; Type: SEQUENCE; Schema: shop; Owner: postgres
--

CREATE SEQUENCE shop.users_uid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shop.users_uid_seq OWNER TO postgres;

--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 205
-- Name: users_uid_seq; Type: SEQUENCE OWNED BY; Schema: shop; Owner: postgres
--

ALTER SEQUENCE shop.users_uid_seq OWNED BY shop.users.uid;


--
-- TOC entry 2701 (class 2604 OID 16425)
-- Name: grimlist gid; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.grimlist ALTER COLUMN gid SET DEFAULT nextval('shop.shop_gid_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 16424)
-- Name: offer oid; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.offer ALTER COLUMN oid SET DEFAULT nextval('shop.offer_oid_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 16426)
-- Name: users uid; Type: DEFAULT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users ALTER COLUMN uid SET DEFAULT nextval('shop.users_uid_seq'::regclass);


--
-- TOC entry 2839 (class 0 OID 16395)
-- Dependencies: 199
-- Data for Name: customer; Type: TABLE DATA; Schema: shop; Owner: postgres
--



--
-- TOC entry 2842 (class 0 OID 16404)
-- Dependencies: 202
-- Data for Name: grimlist; Type: TABLE DATA; Schema: shop; Owner: postgres
--

INSERT INTO shop.grimlist VALUES (3, 'May''s Book of Barriers', 'Lightly Damaged', 'Conjuration', 'For Sale', '', '$2,400.00', 'May');
INSERT INTO shop.grimlist VALUES (2, 'Summoning and You', 'Good', 'Conjuration', 'Not For Sale', 'Restricted to licensed practitioners', '$5,000.00', 'Unknown');
INSERT INTO shop.grimlist VALUES (5, 'How to summon flowers', 'Tattered', 'Enchantment', 'For Sale', 'It''s not written by the real Merlin...right?', '$1,000.00', 'Merlin(?)');
INSERT INTO shop.grimlist VALUES (4, 'Illusions, Mirrors, and Eyes', 'Good', 'Enchantment', 'Sold', '', '$894,000.00', 'John Maskelyne');
INSERT INTO shop.grimlist VALUES (6, 'Book of the Dead', 'Good', 'Necromancy', 'For Sale', 'Illegal in most countries', '$6,000,000,000.00', 'Unknown');
INSERT INTO shop.grimlist VALUES (1, 'Beginner''s Guide to the Inferno', 'Perfect', 'Elementalism', 'For Sale', 'It''s covered in dust', '$0.00', 'Big Fire');


--
-- TOC entry 2840 (class 0 OID 16398)
-- Dependencies: 200
-- Data for Name: offer; Type: TABLE DATA; Schema: shop; Owner: postgres
--

INSERT INTO shop.offer VALUES ('2000-10-08', 4, 2, 'test', 2, 'test', 'test', '$100,000.00', 4, 'Pending');


--
-- TOC entry 2844 (class 0 OID 16409)
-- Dependencies: 204
-- Data for Name: users; Type: TABLE DATA; Schema: shop; Owner: postgres
--

INSERT INTO shop.users VALUES (3, 'Employee', 'ryan@gmail.com', 'password', 'Ryan', 'Boi', '4862414487');
INSERT INTO shop.users VALUES (1, 'Customer', 'bob@gmail.com', 'bobobobo', 'Bob', 'Dob', '1234567891');
INSERT INTO shop.users VALUES (2, 'Customer', 'dab@gmail.com', 'dadododo', 'Dab', 'Sab', '4576652144');
INSERT INTO shop.users VALUES (4, 'Manager', 'kevin@gmail.com', 'kevikevi', 'Kevin', 'Big', '4563217777');


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 201
-- Name: offer_oid_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.offer_oid_seq', 4, true);


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 203
-- Name: shop_gid_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.shop_gid_seq', 6, true);


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 205
-- Name: users_uid_seq; Type: SEQUENCE SET; Schema: shop; Owner: postgres
--

SELECT pg_catalog.setval('shop.users_uid_seq', 4, true);


--
-- TOC entry 2707 (class 2606 OID 16430)
-- Name: offer offer_pk; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_pk PRIMARY KEY (oid);


--
-- TOC entry 2709 (class 2606 OID 16432)
-- Name: grimlist shop_pk; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.grimlist
    ADD CONSTRAINT shop_pk PRIMARY KEY (gid);


--
-- TOC entry 2711 (class 2606 OID 16503)
-- Name: users users_pk; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_pk PRIMARY KEY (uid);


--
-- TOC entry 2713 (class 2606 OID 16505)
-- Name: users users_un; Type: CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_un UNIQUE (usertype, email, firstname, lastname);


--
-- TOC entry 2714 (class 2606 OID 16511)
-- Name: customer customer_fk; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk FOREIGN KEY (uid) REFERENCES shop.users(uid);


--
-- TOC entry 2715 (class 2606 OID 16516)
-- Name: customer customer_fk_1; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk_1 FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);


--
-- TOC entry 2717 (class 2606 OID 16506)
-- Name: offer offer_fk; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk FOREIGN KEY (uid) REFERENCES shop.users(uid);


--
-- TOC entry 2716 (class 2606 OID 16454)
-- Name: offer offer_fk_1; Type: FK CONSTRAINT; Schema: shop; Owner: postgres
--

ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk_1 FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);


-- Completed on 2021-05-05 07:25:24

--
-- PostgreSQL database dump complete
--

