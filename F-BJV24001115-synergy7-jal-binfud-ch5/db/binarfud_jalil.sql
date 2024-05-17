--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-05-17 23:19:28

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

DROP DATABASE binarfud_jalil;
--
-- TOC entry 4880 (class 1262 OID 40975)
-- Name: binarfud_jalil; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE binarfud_jalil WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';


\connect binarfud_jalil

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 228 (class 1255 OID 41058)
-- Name: product_function_select_data(character varying, character varying); Type: FUNCTION; Schema: public; Owner: -
--

CREATE FUNCTION public.product_function_select_data(productname character varying, merchantname character varying) RETURNS TABLE(id uuid, name character varying, price integer)
    LANGUAGE sql
    AS $$
    SELECT p.id, p.name, p.price
    FROM product p
    INNER JOIN merchant m ON p.merchant_id = m.id
    WHERE p.name = productName AND m.name = merchantName;
$$;


--
-- TOC entry 227 (class 1255 OID 41057)
-- Name: product_select_data(character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.product_select_data(IN "productName" character varying, IN "merchantName" character varying)
    LANGUAGE sql
    AS $$
	select * from product p
	inner join merchant m on p.merchant_id = m.id
	where p.name = "productName" AND m.name = "merchantName"
$$;


--
-- TOC entry 226 (class 1255 OID 41052)
-- Name: users_delete_data(uuid); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_delete_data(IN "ID" uuid)
    LANGUAGE sql
    AS $$
UPDATE public.users
set deleted=true where id = "ID";
$$;


--
-- TOC entry 223 (class 1255 OID 41041)
-- Name: users_insert_data(character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_insert_data(IN "Username" character varying, IN "Email" character varying, IN "Password" character varying)
    LANGUAGE sql
    AS $$
INSERT INTO public.users(
	id, created_date, deleted_date, updated_date, deleted, email_address, password, username)
	VALUES (gen_random_uuid(), now(), null, now(), false, "Email", "Password", "Username");
$$;


--
-- TOC entry 222 (class 1255 OID 41048)
-- Name: users_select_data(); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_select_data()
    LANGUAGE sql
    AS $$
SELECT username, email_address FROM 
	public.users
$$;


--
-- TOC entry 225 (class 1255 OID 41047)
-- Name: users_select_data(character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_select_data(IN "Username" character varying)
    LANGUAGE sql
    AS $$
SELECT username, email_address FROM 
	public.users
$$;


--
-- TOC entry 221 (class 1255 OID 41046)
-- Name: users_select_data(character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_select_data(IN "Username" character varying, IN "Email" character varying)
    LANGUAGE sql
    AS $$
SELECT username, email_address FROM 
	public.users
$$;


--
-- TOC entry 220 (class 1255 OID 41042)
-- Name: users_update_data(character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_update_data(IN "Username" character varying, IN "Email" character varying, IN "Password" character varying)
    LANGUAGE sql
    AS $$
UPDATE public.users
	SET updated_date=now(), deleted=false, email_address="Email", password="Password", username="Username"
	WHERE username = "username";
$$;


--
-- TOC entry 224 (class 1255 OID 41044)
-- Name: users_update_data(uuid, character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_update_data(IN "ID" uuid, IN "Username" character varying, IN "Email" character varying, IN "Password" character varying)
    LANGUAGE sql
    AS $$
UPDATE public.users
	SET updated_date=now(), deleted=false, email_address="Email", password="Password", username="Username"
	WHERE id = "ID";
$$;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 40981)
-- Name: merchant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.merchant (
    id uuid NOT NULL,
    location character varying(255),
    name character varying(255),
    open boolean NOT NULL,
    deleted boolean DEFAULT false,
    deleted_date timestamp(6) without time zone,
    created_date timestamp without time zone,
    updated_date timestamp without time zone
);


--
-- TOC entry 217 (class 1259 OID 40997)
-- Name: order_detail; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.order_detail (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    deleted boolean NOT NULL,
    quantity integer NOT NULL,
    total_price double precision,
    order_id uuid,
    product_id uuid
);


--
-- TOC entry 219 (class 1259 OID 41014)
-- Name: orders; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.orders (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    completed boolean NOT NULL,
    deleted boolean NOT NULL,
    destination_address character varying(255),
    order_time date,
    users_id uuid
);


--
-- TOC entry 215 (class 1259 OID 40976)
-- Name: product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product (
    id uuid NOT NULL,
    name character varying(255),
    price integer,
    merchant_id uuid,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    deleted boolean
);


--
-- TOC entry 218 (class 1259 OID 41002)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    deleted boolean NOT NULL,
    email_address character varying(255),
    password character varying(255),
    username character varying(255)
);


--
-- TOC entry 4871 (class 0 OID 40981)
-- Dependencies: 216
-- Data for Name: merchant; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.merchant VALUES ('75d72a76-7cfe-4a27-934f-105c02a2b230', 'Ngoresan', 'Ayam Geprek Kumlot', true, false, NULL, '2024-05-01 23:19:15.368', '2024-05-05 20:48:14.165');
INSERT INTO public.merchant VALUES ('8458308e-7552-464d-b061-ea23a9e15cfb', 'Ngoresan', 'Burjo Ababil', true, false, NULL, '2024-05-03 00:36:11.841', '2024-05-09 23:51:44.406');
INSERT INTO public.merchant VALUES ('95a2ed25-39d8-4be2-959d-17af6f22db4d', 'Gulon', 'Warung Bu Las', false, false, NULL, '2024-05-10 00:51:52.74', '2024-05-10 01:01:44.412');


--
-- TOC entry 4872 (class 0 OID 40997)
-- Dependencies: 217
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.order_detail VALUES ('8b85ceee-9b2b-49ca-be16-5a7b6da206f7', '2024-05-12 00:39:48.481', NULL, '2024-05-12 00:39:48.481', false, 2, 20000, '0a4cae6d-c20f-420c-8f17-7391254b54cb', 'f4a07aec-ff7e-4bbc-8d60-e24f143a9f4b');
INSERT INTO public.order_detail VALUES ('f714514d-86ce-4be3-941b-fc5e8ad05045', '2024-05-13 23:34:45.932', NULL, '2024-05-13 23:34:45.932', false, 3, 30000, '2035a667-104d-4950-99f9-7bb75b0e9bfd', 'f4a07aec-ff7e-4bbc-8d60-e24f143a9f4b');
INSERT INTO public.order_detail VALUES ('f4d5a100-b439-414d-ba24-18a8b18fdbb6', '2024-05-13 23:35:22.204', NULL, '2024-05-13 23:35:22.204', false, 2, 16000, '2035a667-104d-4950-99f9-7bb75b0e9bfd', '87b25d28-3a33-4eb7-a217-8da1fa267724');
INSERT INTO public.order_detail VALUES ('adde133b-deda-458f-8b62-951ba9fbefed', '2024-05-13 23:35:55.564', NULL, '2024-05-13 23:35:55.564', false, 4, 20000, '2035a667-104d-4950-99f9-7bb75b0e9bfd', '0c9e2128-5cdb-4fba-bc5b-c64fe49faeff');


--
-- TOC entry 4874 (class 0 OID 41014)
-- Dependencies: 219
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.orders VALUES ('0a4cae6d-c20f-420c-8f17-7391254b54cb', '2024-05-06 00:14:36.935', NULL, '2024-05-11 17:30:21.299', true, false, NULL, '2024-05-06', '351ed6aa-8d35-411d-a455-c465169c531c');
INSERT INTO public.orders VALUES ('2035a667-104d-4950-99f9-7bb75b0e9bfd', '2024-05-13 23:33:49.841', NULL, '2024-05-13 23:34:45.914', true, false, 'Gulon', '2024-05-13', 'ff0d00cc-fac4-47ba-b197-f7d5f3173539');


--
-- TOC entry 4870 (class 0 OID 40976)
-- Dependencies: 215
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.product VALUES ('f4a07aec-ff7e-4bbc-8d60-e24f143a9f4b', 'Nasi + Ayam Geprek', 10000, '75d72a76-7cfe-4a27-934f-105c02a2b230', '2024-05-05 22:05:16.765', NULL, '2024-05-05 22:05:16.765', false);
INSERT INTO public.product VALUES ('87b25d28-3a33-4eb7-a217-8da1fa267724', 'Nasi + Jamur Geprek', 8000, '75d72a76-7cfe-4a27-934f-105c02a2b230', '2024-05-05 22:05:47.586', NULL, '2024-05-05 22:05:47.586', false);
INSERT INTO public.product VALUES ('b192e0dd-07d6-4f25-aa68-75ce33c84849', 'Ayam Geprek', 7000, '75d72a76-7cfe-4a27-934f-105c02a2b230', '2024-05-05 22:06:13.991', NULL, '2024-05-05 22:06:13.991', false);
INSERT INTO public.product VALUES ('230cd599-f84c-46e3-81e0-e975cba7d8fe', 'Jamur Geprek', 5000, '75d72a76-7cfe-4a27-934f-105c02a2b230', '2024-05-05 22:06:44.242', NULL, '2024-05-05 22:06:44.242', false);
INSERT INTO public.product VALUES ('089a8db5-027f-44f5-920f-006516233e55', 'Nasi Goreng', 15000, '8458308e-7552-464d-b061-ea23a9e15cfb', '2024-05-05 22:47:14.376', NULL, '2024-05-05 22:47:14.376', false);
INSERT INTO public.product VALUES ('70225831-9bba-4aa4-87b0-df1671890a46', 'Mie Goreng', 13000, '8458308e-7552-464d-b061-ea23a9e15cfb', '2024-05-05 22:47:35.912', NULL, '2024-05-05 22:47:35.912', false);
INSERT INTO public.product VALUES ('d708b7d3-2de2-4eef-a0ee-3e97121e2b8d', 'Mie Rebus', 13000, '8458308e-7552-464d-b061-ea23a9e15cfb', '2024-05-05 22:48:06.056', NULL, '2024-05-05 22:48:06.056', false);
INSERT INTO public.product VALUES ('c53c857e-8aa1-4efb-b044-811903e77574', 'Nasi + Telor', 10000, '8458308e-7552-464d-b061-ea23a9e15cfb', '2024-05-05 22:48:32.651', NULL, '2024-05-05 22:48:32.651', false);
INSERT INTO public.product VALUES ('d80cc95a-3786-4a9f-b2f2-82d75ad40332', 'Es Teh Manis', 3000, '8458308e-7552-464d-b061-ea23a9e15cfb', '2024-05-06 00:43:39.539', NULL, '2024-05-06 00:43:39.539', false);
INSERT INTO public.product VALUES ('0c9e2128-5cdb-4fba-bc5b-c64fe49faeff', 'Es Susu', 5000, '75d72a76-7cfe-4a27-934f-105c02a2b230', '2024-05-06 00:44:04.079', NULL, '2024-05-06 00:44:04.079', false);
INSERT INTO public.product VALUES ('8b40ba2c-e337-42f1-8664-cecd2c67b7b0', 'Dimsum', 10000, '95a2ed25-39d8-4be2-959d-17af6f22db4d', '2024-05-10 16:05:39.591', NULL, '2024-05-10 17:19:49.286', false);
INSERT INTO public.product VALUES ('be8a6943-43f2-4882-b07e-9f8d11235c82', 'test', 5000, '95a2ed25-39d8-4be2-959d-17af6f22db4d', '2024-05-10 16:00:07.976', NULL, '2024-05-10 17:30:19.716', true);


--
-- TOC entry 4873 (class 0 OID 41002)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES ('351ed6aa-8d35-411d-a455-c465169c531c', '2024-05-04 00:09:15.300102', NULL, '2024-05-04 00:09:15.300102', false, 'user1@gmail.com', 'user1', 'user1');
INSERT INTO public.users VALUES ('4d7fef6e-962a-45d2-8e9e-f238cac0bf10', '2024-05-04 00:09:40.03415', NULL, '2024-05-04 00:09:40.03415', false, 'user2@gmail.com', 'user2', 'user2');
INSERT INTO public.users VALUES ('c909703c-eaa1-4d80-a0cd-87aabcbd7fce', '2024-05-04 00:09:59.51503', NULL, '2024-05-04 00:09:59.51503', true, 'user3@gmail.com', 'user3', 'user3');
INSERT INTO public.users VALUES ('ff0d00cc-fac4-47ba-b197-f7d5f3173539', '2024-05-10 14:08:06.9', NULL, '2024-05-10 14:28:01.435', true, 'abdul@gmail.com', 'abdul123', 'abdul');


--
-- TOC entry 4716 (class 2606 OID 40987)
-- Name: merchant merchant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);


--
-- TOC entry 4718 (class 2606 OID 41001)
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 4722 (class 2606 OID 41018)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4714 (class 2606 OID 40980)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 4720 (class 2606 OID 41008)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4724 (class 2606 OID 41009)
-- Name: order_detail fkb8bg2bkty0oksa3wiq5mp5qnc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkb8bg2bkty0oksa3wiq5mp5qnc FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 4726 (class 2606 OID 41024)
-- Name: orders fke6k45xxoin4fylnwg2jkehwjf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fke6k45xxoin4fylnwg2jkehwjf FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 4723 (class 2606 OID 40988)
-- Name: product fkk47qmalv2pg906heielteubu7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkk47qmalv2pg906heielteubu7 FOREIGN KEY (merchant_id) REFERENCES public.merchant(id);


--
-- TOC entry 4725 (class 2606 OID 41019)
-- Name: order_detail fkrws2q0si6oyd6il8gqe2aennc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES public.orders(id);


-- Completed on 2024-05-17 23:19:28

--
-- PostgreSQL database dump complete
--

