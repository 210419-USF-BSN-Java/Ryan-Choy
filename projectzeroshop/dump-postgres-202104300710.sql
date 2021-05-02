PGDMP         
                y           postgres    10.16    10.16                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    16393    shop    SCHEMA        CREATE SCHEMA shop;
    DROP SCHEMA shop;
             postgres    false            �            1259    16395    customer    TABLE     �   CREATE TABLE shop.customer (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    uid integer NOT NULL,
    debt money NOT NULL,
    payterm integer NOT NULL,
    weekpay money NOT NULL
);
    DROP TABLE shop.customer;
       shop         postgres    false    7            �            1259    16404    grimlist    TABLE     �  CREATE TABLE shop.grimlist (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    grimcondition character varying(50) NOT NULL,
    grimschool character varying(50) NOT NULL,
    grimstatus character varying(50) NOT NULL,
    grimnote character varying(100) DEFAULT ' '::character varying NOT NULL,
    baseprice money DEFAULT 0 NOT NULL,
    grimauthor character varying(50) DEFAULT 'Unknown'::character varying NOT NULL
);
    DROP TABLE shop.grimlist;
       shop         postgres    false    7            �            1259    16398    offer    TABLE     �  CREATE TABLE shop.offer (
    date date NOT NULL,
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
    DROP TABLE shop.offer;
       shop         postgres    false    7            �            1259    16402    offer_oid_seq    SEQUENCE     �   CREATE SEQUENCE shop.offer_oid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE shop.offer_oid_seq;
       shop       postgres    false    7    200            !           0    0    offer_oid_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE shop.offer_oid_seq OWNED BY shop.offer.oid;
            shop       postgres    false    201            �            1259    16407    shop_gid_seq    SEQUENCE     �   CREATE SEQUENCE shop.shop_gid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE shop.shop_gid_seq;
       shop       postgres    false    7    202            "           0    0    shop_gid_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE shop.shop_gid_seq OWNED BY shop.grimlist.gid;
            shop       postgres    false    203            �            1259    16409    users    TABLE     <  CREATE TABLE shop.users (
    uid integer NOT NULL,
    usertype character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    firstname character varying(30) NOT NULL,
    lastname character varying(30) NOT NULL,
    phonenumber character varying(10)
);
    DROP TABLE shop.users;
       shop         postgres    false    7            �            1259    16412    users_uid_seq    SEQUENCE     �   CREATE SEQUENCE shop.users_uid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE shop.users_uid_seq;
       shop       postgres    false    204    7            #           0    0    users_uid_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE shop.users_uid_seq OWNED BY shop.users.uid;
            shop       postgres    false    205            �
           2604    16425    grimlist gid    DEFAULT     d   ALTER TABLE ONLY shop.grimlist ALTER COLUMN gid SET DEFAULT nextval('shop.shop_gid_seq'::regclass);
 9   ALTER TABLE shop.grimlist ALTER COLUMN gid DROP DEFAULT;
       shop       postgres    false    203    202            �
           2604    16424 	   offer oid    DEFAULT     b   ALTER TABLE ONLY shop.offer ALTER COLUMN oid SET DEFAULT nextval('shop.offer_oid_seq'::regclass);
 6   ALTER TABLE shop.offer ALTER COLUMN oid DROP DEFAULT;
       shop       postgres    false    201    200            �
           2604    16426 	   users uid    DEFAULT     b   ALTER TABLE ONLY shop.users ALTER COLUMN uid SET DEFAULT nextval('shop.users_uid_seq'::regclass);
 6   ALTER TABLE shop.users ALTER COLUMN uid DROP DEFAULT;
       shop       postgres    false    205    204                      0    16395    customer 
   TABLE DATA                     shop       postgres    false    199                      0    16404    grimlist 
   TABLE DATA                     shop       postgres    false    202                      0    16398    offer 
   TABLE DATA                     shop       postgres    false    200                      0    16409    users 
   TABLE DATA                     shop       postgres    false    204            $           0    0    offer_oid_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('shop.offer_oid_seq', 1, false);
            shop       postgres    false    201            %           0    0    shop_gid_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('shop.shop_gid_seq', 6, true);
            shop       postgres    false    203            &           0    0    users_uid_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('shop.users_uid_seq', 3, true);
            shop       postgres    false    205            �
           2606    16430    offer offer_pk 
   CONSTRAINT     K   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_pk PRIMARY KEY (oid);
 6   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_pk;
       shop         postgres    false    200            �
           2606    16432    grimlist shop_pk 
   CONSTRAINT     M   ALTER TABLE ONLY shop.grimlist
    ADD CONSTRAINT shop_pk PRIMARY KEY (gid);
 8   ALTER TABLE ONLY shop.grimlist DROP CONSTRAINT shop_pk;
       shop         postgres    false    202            �
           2606    16434    users users_pk 
   CONSTRAINT     K   ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_pk PRIMARY KEY (uid);
 6   ALTER TABLE ONLY shop.users DROP CONSTRAINT users_pk;
       shop         postgres    false    204            �
           2606    16439    customer customer_fk    FK CONSTRAINT     o   ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);
 <   ALTER TABLE ONLY shop.customer DROP CONSTRAINT customer_fk;
       shop       postgres    false    199    202    2709            �
           2606    16444    customer customer_fk_1    FK CONSTRAINT     n   ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk_1 FOREIGN KEY (uid) REFERENCES shop.users(uid);
 >   ALTER TABLE ONLY shop.customer DROP CONSTRAINT customer_fk_1;
       shop       postgres    false    204    199    2711            �
           2606    16449    offer offer_fk    FK CONSTRAINT     f   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk FOREIGN KEY (uid) REFERENCES shop.users(uid);
 6   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_fk;
       shop       postgres    false    204    2711    200            �
           2606    16454    offer offer_fk_1    FK CONSTRAINT     k   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk_1 FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);
 8   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_fk_1;
       shop       postgres    false    200    202    2709               
   x���             �  x���MO�@���s�d�"�ЀZq@M	�I+*���'�6�4�n��N�$rXi�c�}�ɗ��n�r�|�i-�u�����~^�ѧ	$�'���x3#bQ|�nm��ÕiM��}c�׉	�I��,P���N�Y�fY�W>��b���3�-���t�B�A�i�B���P�X�[�`�N�$*R���T��%���f��k+x�i�(��e�T��
�p�27�� C�;�Al"L������AL�&���M���iC����b�wު�߁���v/�2!�;ۨl��}�(�o����������YJ�Tt&.w�'ܧ����À���s����	,�K��y�~��+�]�2n��L?�!X�A�Ӂ�=�q�ϾV{�����R�5T�os�hM���b��>?��ϕ�y���h��s         
   x���             �   x�����0����Y��F�~�A�\��$��۴K����}�<�iV$y�Ҭ<!}����4���@�B��OP�sM������
�s �=T�L|�0Zcw�q����60Hi���ߒ�k��N؜��$�-h�ŔF�&2[#�l��b\�qF1�!c1�p�7�V�                     0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    16393    shop    SCHEMA        CREATE SCHEMA shop;
    DROP SCHEMA shop;
             postgres    false            �            1259    16395    customer    TABLE     �   CREATE TABLE shop.customer (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    uid integer NOT NULL,
    debt money NOT NULL,
    payterm integer NOT NULL,
    weekpay money NOT NULL
);
    DROP TABLE shop.customer;
       shop         postgres    false    7            �            1259    16404    grimlist    TABLE     �  CREATE TABLE shop.grimlist (
    gid integer NOT NULL,
    grimname character varying(50) NOT NULL,
    grimcondition character varying(50) NOT NULL,
    grimschool character varying(50) NOT NULL,
    grimstatus character varying(50) NOT NULL,
    grimnote character varying(100) DEFAULT ' '::character varying NOT NULL,
    baseprice money DEFAULT 0 NOT NULL,
    grimauthor character varying(50) DEFAULT 'Unknown'::character varying NOT NULL
);
    DROP TABLE shop.grimlist;
       shop         postgres    false    7            �            1259    16398    offer    TABLE     �  CREATE TABLE shop.offer (
    date date NOT NULL,
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
    DROP TABLE shop.offer;
       shop         postgres    false    7            �            1259    16402    offer_oid_seq    SEQUENCE     �   CREATE SEQUENCE shop.offer_oid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE shop.offer_oid_seq;
       shop       postgres    false    7    200            !           0    0    offer_oid_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE shop.offer_oid_seq OWNED BY shop.offer.oid;
            shop       postgres    false    201            �            1259    16407    shop_gid_seq    SEQUENCE     �   CREATE SEQUENCE shop.shop_gid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE shop.shop_gid_seq;
       shop       postgres    false    7    202            "           0    0    shop_gid_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE shop.shop_gid_seq OWNED BY shop.grimlist.gid;
            shop       postgres    false    203            �            1259    16409    users    TABLE     <  CREATE TABLE shop.users (
    uid integer NOT NULL,
    usertype character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    firstname character varying(30) NOT NULL,
    lastname character varying(30) NOT NULL,
    phonenumber character varying(10)
);
    DROP TABLE shop.users;
       shop         postgres    false    7            �            1259    16412    users_uid_seq    SEQUENCE     �   CREATE SEQUENCE shop.users_uid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE shop.users_uid_seq;
       shop       postgres    false    204    7            #           0    0    users_uid_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE shop.users_uid_seq OWNED BY shop.users.uid;
            shop       postgres    false    205            �
           2604    16425    grimlist gid    DEFAULT     d   ALTER TABLE ONLY shop.grimlist ALTER COLUMN gid SET DEFAULT nextval('shop.shop_gid_seq'::regclass);
 9   ALTER TABLE shop.grimlist ALTER COLUMN gid DROP DEFAULT;
       shop       postgres    false    203    202            �
           2604    16424 	   offer oid    DEFAULT     b   ALTER TABLE ONLY shop.offer ALTER COLUMN oid SET DEFAULT nextval('shop.offer_oid_seq'::regclass);
 6   ALTER TABLE shop.offer ALTER COLUMN oid DROP DEFAULT;
       shop       postgres    false    201    200            �
           2604    16426 	   users uid    DEFAULT     b   ALTER TABLE ONLY shop.users ALTER COLUMN uid SET DEFAULT nextval('shop.users_uid_seq'::regclass);
 6   ALTER TABLE shop.users ALTER COLUMN uid DROP DEFAULT;
       shop       postgres    false    205    204                      0    16395    customer 
   TABLE DATA                     shop       postgres    false    199   �                  0    16404    grimlist 
   TABLE DATA                     shop       postgres    false    202   �                  0    16398    offer 
   TABLE DATA                     shop       postgres    false    200   |                 0    16409    users 
   TABLE DATA                     shop       postgres    false    204   �       $           0    0    offer_oid_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('shop.offer_oid_seq', 1, false);
            shop       postgres    false    201            %           0    0    shop_gid_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('shop.shop_gid_seq', 6, true);
            shop       postgres    false    203            &           0    0    users_uid_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('shop.users_uid_seq', 3, true);
            shop       postgres    false    205            �
           2606    16430    offer offer_pk 
   CONSTRAINT     K   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_pk PRIMARY KEY (oid);
 6   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_pk;
       shop         postgres    false    200            �
           2606    16432    grimlist shop_pk 
   CONSTRAINT     M   ALTER TABLE ONLY shop.grimlist
    ADD CONSTRAINT shop_pk PRIMARY KEY (gid);
 8   ALTER TABLE ONLY shop.grimlist DROP CONSTRAINT shop_pk;
       shop         postgres    false    202            �
           2606    16434    users users_pk 
   CONSTRAINT     K   ALTER TABLE ONLY shop.users
    ADD CONSTRAINT users_pk PRIMARY KEY (uid);
 6   ALTER TABLE ONLY shop.users DROP CONSTRAINT users_pk;
       shop         postgres    false    204            �
           2606    16439    customer customer_fk    FK CONSTRAINT     o   ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);
 <   ALTER TABLE ONLY shop.customer DROP CONSTRAINT customer_fk;
       shop       postgres    false    199    202    2709            �
           2606    16444    customer customer_fk_1    FK CONSTRAINT     n   ALTER TABLE ONLY shop.customer
    ADD CONSTRAINT customer_fk_1 FOREIGN KEY (uid) REFERENCES shop.users(uid);
 >   ALTER TABLE ONLY shop.customer DROP CONSTRAINT customer_fk_1;
       shop       postgres    false    204    199    2711            �
           2606    16449    offer offer_fk    FK CONSTRAINT     f   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk FOREIGN KEY (uid) REFERENCES shop.users(uid);
 6   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_fk;
       shop       postgres    false    204    2711    200            �
           2606    16454    offer offer_fk_1    FK CONSTRAINT     k   ALTER TABLE ONLY shop.offer
    ADD CONSTRAINT offer_fk_1 FOREIGN KEY (gid) REFERENCES shop.grimlist(gid);
 8   ALTER TABLE ONLY shop.offer DROP CONSTRAINT offer_fk_1;
       shop       postgres    false    200    202    2709           