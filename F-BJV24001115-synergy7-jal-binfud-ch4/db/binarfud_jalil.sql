--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-05-08 00:20:26

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

DROP DATABASE binarfud;
--
-- TOC entry 4873 (class 1262 OID 41110)
-- Name: binarfud; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE binarfud WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';


\connect binarfud

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
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 222 (class 1255 OID 41167)
-- Name: users_delete_data(uuid); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_delete_data(IN id uuid)
    LANGUAGE sql
    AS $$
update users set deleted = true where id="id";
$$;


--
-- TOC entry 220 (class 1255 OID 41160)
-- Name: users_insert_data(character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_insert_data(IN "Username" character varying, IN "Email" character varying, IN "Password" character varying)
    LANGUAGE sql
    AS $$
INSERT INTO public.users
(id, created_date, deleted_date, updated_date, deleted, email_address, "password", username)
VALUES(gen_random_uuid(), now(), null, now(), false, "Email", "Password", "Username");
$$;


--
-- TOC entry 221 (class 1255 OID 41166)
-- Name: users_update_data(uuid, character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.users_update_data(IN id uuid, IN "Username" character varying, IN "Email" character varying, IN "Password" character varying)
    LANGUAGE sql
    AS $$
update public.users
set username = "Username", email_address = "Email", password = "Password"
where id = "id";
$$;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 41111)
-- Name: merchant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.merchant (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    deleted boolean NOT NULL,
    location character varying(255),
    name character varying(255),
    open boolean NOT NULL
);


--
-- TOC entry 216 (class 1259 OID 41118)
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
-- TOC entry 217 (class 1259 OID 41123)
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
-- TOC entry 218 (class 1259 OID 41128)
-- Name: product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    deleted boolean NOT NULL,
    name character varying(255),
    price integer NOT NULL,
    merchant_id uuid
);


--
-- TOC entry 219 (class 1259 OID 41133)
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
-- TOC entry 4863 (class 0 OID 41111)
-- Dependencies: 215
-- Data for Name: merchant; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.merchant VALUES ('e7e69d68-533f-4b11-aefe-a0f1fd15571c', '2024-05-08 00:05:17.98225', NULL, '2024-05-08 00:05:17.98225', false, 'Solo', 'Warteg Bahari', true);
INSERT INTO public.merchant VALUES ('d2cf5add-6685-46a3-b961-83181a1476c1', '2024-05-08 00:05:17.98225', NULL, '2024-05-08 00:05:17.98225', false, 'Klaten', 'Burjo Berkah', true);
INSERT INTO public.merchant VALUES ('6b061b7f-39cb-49a4-add1-1777b59fe8cf', '2024-05-08 00:05:17.98225', NULL, '2024-05-08 00:05:17.98225', false, 'Boyolali', 'Ayam Penyet Andara', false);


--
-- TOC entry 4864 (class 0 OID 41118)
-- Dependencies: 216
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.order_detail VALUES ('8768d115-2d56-42c5-87df-3882b746ebde', '2024-05-08 00:18:24.022', NULL, '2024-05-08 00:18:24.022', false, 2, NULL, '3b9d998e-089a-4702-9f40-d469108af521', 'a5847f23-f64a-492c-8ebf-d33dec2c1a2d');
INSERT INTO public.order_detail VALUES ('b3e992b4-0d74-4b01-9235-6bc1ec106349', '2024-05-08 00:18:30.226', NULL, '2024-05-08 00:18:30.226', false, 1, NULL, '3b9d998e-089a-4702-9f40-d469108af521', '529ecfad-1c62-4bb6-b99e-f4099c2ded71');
INSERT INTO public.order_detail VALUES ('9fc82b72-3f1c-41d7-84aa-a97c9dd47f9e', '2024-05-08 00:18:40.976', NULL, '2024-05-08 00:18:40.976', false, 3, NULL, '3b9d998e-089a-4702-9f40-d469108af521', '2e3de2a9-64d6-4f1a-b531-fe9c15f23455');


--
-- TOC entry 4865 (class 0 OID 41123)
-- Dependencies: 217
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.orders VALUES ('dcfe0b5b-eb40-4b3f-b91b-fbfb4f59e23e', '2024-05-08 00:13:40.421', NULL, '2024-05-08 00:13:40.421', false, false, NULL, '2024-05-08', '4d3e9782-18d0-4f9b-b085-7b8655fc18a4');
INSERT INTO public.orders VALUES ('3b9d998e-089a-4702-9f40-d469108af521', '2024-05-08 00:18:14.317', NULL, '2024-05-08 00:18:14.317', false, false, NULL, '2024-05-08', '4d3e9782-18d0-4f9b-b085-7b8655fc18a4');


--
-- TOC entry 4866 (class 0 OID 41128)
-- Dependencies: 218
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.product VALUES ('c91368a8-7df6-4226-8df8-1047f739a20e', '2024-05-08 00:08:15.17028', NULL, '2024-05-08 00:08:15.17028', false, 'Nasi Goreng', 15000, 'e7e69d68-533f-4b11-aefe-a0f1fd15571c');
INSERT INTO public.product VALUES ('0c90420b-ca8a-4a49-8fc8-f2fbc15b2ff3', '2024-05-08 00:08:15.17028', NULL, '2024-05-08 00:08:15.17028', false, 'Mie Goreng', 13000, 'e7e69d68-533f-4b11-aefe-a0f1fd15571c');
INSERT INTO public.product VALUES ('e19517bf-05b5-4f79-a9d2-b983cf38236b', '2024-05-08 00:08:15.17028', NULL, '2024-05-08 00:08:15.17028', false, 'Nasi + Ayam', 15000, 'e7e69d68-533f-4b11-aefe-a0f1fd15571c');
INSERT INTO public.product VALUES ('0a2f2142-60e2-4b16-9e62-1ee6fb5a07c2', '2024-05-08 00:08:15.17028', NULL, '2024-05-08 00:08:15.17028', false, 'Es Teh Manis', 3000, 'e7e69d68-533f-4b11-aefe-a0f1fd15571c');
INSERT INTO public.product VALUES ('a5847f23-f64a-492c-8ebf-d33dec2c1a2d', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Indomie Goreng', 10000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('a42fcfb0-0674-432e-bd3e-50a222605edf', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Indomie Rebus', 10000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('930f931f-81c3-4982-8de4-a98f973c345e', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Mi Dok Dok', 11000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('529ecfad-1c62-4bb6-b99e-f4099c2ded71', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Magelangan', 13000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('c1d9603d-92d3-47eb-a4d9-17cc561d94db', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Es Teh Tarik', 10000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('2e3de2a9-64d6-4f1a-b531-fe9c15f23455', '2024-05-08 00:10:35.523903', NULL, '2024-05-08 00:10:35.523903', false, 'Es Nutrisari', 10000, 'd2cf5add-6685-46a3-b961-83181a1476c1');
INSERT INTO public.product VALUES ('840bb334-1777-4dd0-af84-33ae2a397a4d', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Ayam Goreng', 15000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');
INSERT INTO public.product VALUES ('7586d2f1-8112-46e2-9693-a62a4f7d22a2', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Ayam Bakar', 18000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');
INSERT INTO public.product VALUES ('32df3989-72d6-4595-9bc2-c3e4657200d4', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Lele Goreng', 10000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');
INSERT INTO public.product VALUES ('f82a8bf9-acf0-49bd-8473-a0ab8bc376f8', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Lele Bakar', 15000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');
INSERT INTO public.product VALUES ('6f0194cd-1586-4080-8cb7-a3cc92c727cc', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Es Jeruk', 4000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');
INSERT INTO public.product VALUES ('c6da28b6-d74d-49ef-9320-b85e87aaeb6d', '2024-05-08 00:12:34.541628', NULL, '2024-05-08 00:12:34.541628', false, 'Es Susu', 5000, '6b061b7f-39cb-49a4-add1-1777b59fe8cf');


--
-- TOC entry 4867 (class 0 OID 41133)
-- Dependencies: 219
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES ('7d53b39c-3c2e-41c6-a769-8041f1e60e7e', '2024-05-07 23:11:49.547079', NULL, '2024-05-07 23:11:49.547079', true, 'nawawi@mail.com', 'nawawi123', 'nawawi2');
INSERT INTO public.users VALUES ('4d3e9782-18d0-4f9b-b085-7b8655fc18a4', '2024-05-07 23:37:34.460075', NULL, '2024-05-07 23:37:34.460075', false, 'abduljalil@gmail.com', 'abduljalil', 'abduljalil');
INSERT INTO public.users VALUES ('f6659166-6767-48b4-9afb-bf1314e29c37', '2024-05-07 23:38:18.886131', NULL, '2024-05-07 23:38:18.886131', false, 'abdulhamid@gmail.com', 'abdulhamid', 'abdulhamid');
INSERT INTO public.users VALUES ('cfef1654-ac68-4d73-89c6-e342f8354982', '2024-05-07 23:40:51.677652', NULL, '2024-05-07 23:40:51.677652', false, 'abdulkarim@gmail.com', 'abdulkarim', 'abdulkarim');
INSERT INTO public.users VALUES ('620b61f2-382c-439a-830f-391efe87d368', '2024-05-07 23:42:44.974835', NULL, '2024-05-07 23:42:44.974835', false, 'abdulhakim@gmail.com', 'abdulhakim', 'abdulhakim');
INSERT INTO public.users VALUES ('a0fd6840-7600-43c7-a845-1b2276caca7a', '2024-05-07 23:42:44.974835', NULL, '2024-05-07 23:42:44.974835', false, 'abdulghani@gmail.com', 'abdulghani', 'abdulghani');
INSERT INTO public.users VALUES ('f55cd87d-c701-435f-a6bb-87d697e928bf', '2024-05-07 23:42:44.974835', NULL, '2024-05-07 23:42:44.974835', false, 'abdulqadir@gmail.com', 'abdulqadir', 'abdulqadir');
INSERT INTO public.users VALUES ('e38e3bf5-d93e-459c-a98b-50674abdba05', '2024-05-07 23:42:44.974835', NULL, '2024-05-07 23:42:44.974835', false, 'abdunnaum@gmail.com', 'abdunnaum', 'abdunnaum');
INSERT INTO public.users VALUES ('1ad3e974-ae62-43a3-81a0-967f06143aae', '2024-05-07 23:45:09.243714', NULL, '2024-05-07 23:45:09.243714', false, 'user1@gmail.com', 'user1', 'user1');
INSERT INTO public.users VALUES ('6ad30a1b-f122-48ea-b685-2cb644d1beb1', '2024-05-07 23:45:09.243714', NULL, '2024-05-07 23:45:09.243714', false, 'user2@gmail.com', 'user2', 'user2');
INSERT INTO public.users VALUES ('7704bedf-8da5-4afd-9ab8-4953a15ab374', '2024-05-07 23:45:09.243714', NULL, '2024-05-07 23:45:09.243714', false, 'user3@gmail.com', 'user3', 'user3');


--
-- TOC entry 4707 (class 2606 OID 41117)
-- Name: merchant merchant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);


--
-- TOC entry 4709 (class 2606 OID 41122)
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 4711 (class 2606 OID 41127)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4713 (class 2606 OID 41132)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 4715 (class 2606 OID 41139)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4716 (class 2606 OID 41145)
-- Name: order_detail fkb8bg2bkty0oksa3wiq5mp5qnc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkb8bg2bkty0oksa3wiq5mp5qnc FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 4718 (class 2606 OID 41150)
-- Name: orders fke6k45xxoin4fylnwg2jkehwjf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fke6k45xxoin4fylnwg2jkehwjf FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 4719 (class 2606 OID 41155)
-- Name: product fkk47qmalv2pg906heielteubu7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkk47qmalv2pg906heielteubu7 FOREIGN KEY (merchant_id) REFERENCES public.merchant(id);


--
-- TOC entry 4717 (class 2606 OID 41140)
-- Name: order_detail fkrws2q0si6oyd6il8gqe2aennc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES public.orders(id);


-- Completed on 2024-05-08 00:20:26

--
-- PostgreSQL database dump complete
--

