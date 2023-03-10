PGDMP                          {            springdb    15.1    15.1                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            !           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            "           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            #           1262    24576    springdb    DATABASE     ?   CREATE DATABASE springdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United Kingdom.932';
    DROP DATABASE springdb;
                postgres    false            $           0    0    springdb    DATABASE PROPERTIES     0   ALTER DATABASE springdb CONNECTION LIMIT = 100;
                     postgres    false                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            %           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2                        3079    24591    pgcrypto 	   EXTENSION     <   CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;
    DROP EXTENSION pgcrypto;
                   false            &           0    0    EXTENSION pgcrypto    COMMENT     <   COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';
                        false    3            ?            1259    24583    user    TABLE     ?   CREATE TABLE public."user" (
    id integer NOT NULL,
    username text NOT NULL,
    password text NOT NULL,
    realname text,
    address text,
    carlicensestatus boolean,
    motorcyclelicensestatus boolean,
    employment text
);
    DROP TABLE public."user";
       public         heap    postgres    false            ?            1259    24582    user_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.user_id_seq;
       public          postgres    false    217            '           0    0    user_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;
          public          postgres    false    216            ?           2604    24586    user id    DEFAULT     d   ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);
 8   ALTER TABLE public."user" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217                      0    24583    user 
   TABLE DATA           ?   COPY public."user" (id, username, password, realname, address, carlicensestatus, motorcyclelicensestatus, employment) FROM stdin;
    public          postgres    false    217   ?       (           0    0    user_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.user_id_seq', 6, true);
          public          postgres    false    216            ?           2606    24590    user user_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (username);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    217               P  x?}?K??0??u?.\?????ZȠh???"????ۯ?D3q1??|??=#?[?0??P??7????	?]8??G?C?QU??*
?4?7?n?=?k	???	c?_?S??k?7=b??_?J?嵎E	?ʌ?R?ңJg??>?܄???78????ľ?*?hn>?i??*vL??,??4?'ܺ????Q?	J?l?#&?%/wNc????n?/?MwEԡ7fВ8?ߝ?m4?6̗??}i?E?L???f?s?e?iA`-?*?
2?"??+??W?M,???5??t+??{:%۱??2?-1?ʹ??Τ.??Jj???ޖw?d??nDA~ m͕j     