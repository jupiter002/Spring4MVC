-- 회원 테이블
-- mariadb는 한글 2byte
-- create, alter, 제약조건 구문
create table member(
    mno         int         auto_increment,
    userid      varchar2(18) unique,
    passwd      varchar2(18) not null ,
    username    varchar2(10) not null,
    useremail   varchar2(50) not null,
    regdate     datetime     default current_timestamp,
    primary key (mno)
);
-- 게시판 테이블
-- foreign key 만드는 이유: 데이터의 무결성을 위해서
create table board(
    bno      int            auto_increment,
    usesrid  varchar2(18)   not null ,
    title    varchar2(100)  not null,
    contents text           not null,
    entdate  datetime default current_timestamp,
    views    int            default 0,
    primary key (bno),
    foreign key (usesrid) references member(userid)
);