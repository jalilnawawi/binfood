----------------Binfood Database----------------
-- Database: binfood

-- DROP DATABASE IF EXISTS binfood;

CREATE DATABASE binfood
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_Indonesia.1252'
    LC_CTYPE = 'English_Indonesia.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
------------------------------------------------

----------------User Table----------------------
-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

    CREATE TABLE IF NOT EXISTS public.users
    (
         id uuid NOT NULL,
         username "char" NOT NULL,
         email_address "char",
         password "char",
         CONSTRAINT users_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.users
        OWNER to postgres;
------------------------------------------------

----------------Merchant Table------------------
-- Table: public.merchant

-- DROP TABLE IF EXISTS public.merchant;

    CREATE TABLE IF NOT EXISTS public.merchant
    (
        id uuid NOT NULL,
        merchant_name "char" NOT NULL,
        merchant_location "char",
        open boolean,
        CONSTRAINT merch_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.merchant
        OWNER to postgres;

------------------------------------------------

----------------Product Table-------------------
-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

    CREATE TABLE IF NOT EXISTS public.product
    (
        id uuid NOT NULL,
        product_name "char" NOT NULL,
        price double precision,
        merchant_id uuid NOT NULL,
        CONSTRAINT product_pkey PRIMARY KEY (id),
        CONSTRAINT merchant_id FOREIGN KEY (merchant_id)
            REFERENCES public.merchant (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
            NOT VALID
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.product
        OWNER to postgres;
------------------------------------------------

----------------Order Table---------------------
-- Table: public.order

-- DROP TABLE IF EXISTS public."order";

    CREATE TABLE IF NOT EXISTS public."order"
    (
        id uuid NOT NULL,
        order_time timestamp without time zone NOT NULL,
        destination_address "char",
        user_id uuid NOT NULL,
        completed boolean,
        CONSTRAINT order_pkey PRIMARY KEY (id),
        CONSTRAINT user_id FOREIGN KEY (user_id)
            REFERENCES public.users (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
            NOT VALID
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public."order"
        OWNER to postgres;
------------------------------------------------

----------------Order Detail Table--------------
-- Table: public.orderdetail

-- DROP TABLE IF EXISTS public.orderdetail;

    CREATE TABLE IF NOT EXISTS public.orderdetail
    (
        id uuid NOT NULL,
        order_id uuid NOT NULL,
        product_id uuid NOT NULL,
        quantity integer NOT NULL,
        total_price double precision NOT NULL,
        CONSTRAINT orderdetail_pkey PRIMARY KEY (id),
        CONSTRAINT order_id FOREIGN KEY (id)
            REFERENCES public."order" (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
        CONSTRAINT product_id FOREIGN KEY (product_id)
            REFERENCES public.product (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.orderdetail
        OWNER to postgres;