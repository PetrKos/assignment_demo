CREATE SEQUENCE IF NOT EXISTS  public.match_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS  public.match_odd_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS public.match
    (
    id  bigint NOT NULL,
    description varchar(50),
    match_date  varchar(50),
    match_time  varchar(50),
    team_a  varchar(50),
    team_b  varchar(50),
    sport int,
    primary key (id)
    );

CREATE TABLE IF NOT EXISTS public.match_odd
(
    id bigint NOT NULL,
    match_id bigint,  --not null?,
    specifier char(1),
    odd real,
    primary key (id)
);

ALTER TABLE public.match
    OWNER TO postgres;
GRANT ALL ON TABLE public.match TO postgres;

ALTER TABLE public.match_odd
    OWNER TO postgres;
GRANT ALL ON TABLE public.match_odd TO postgres;

ALTER SEQUENCE public.match_seq OWNER TO postgres;
ALTER SEQUENCE public.match_odd_seq OWNER TO postgres;