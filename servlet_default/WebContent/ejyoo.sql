CREATE TABLE MEMBER(
    USER_ID VARCHAR2(10)
    ,USER_PW VARCHAR2(10)
    ,USER_PHONE VARCHAR2(10)
    ,USER_EMAIL VARCHAR2(10)
);

-- ID찾기
SELECT count(*)
FROM MEMBER 
WHERE USER_ID = 'ejyoo';

-- ID에 해당하는 pw 확인 일치하는지 확인
SELECT count(*)
FROM MEMBER 
WHERE USER_ID = 'ejyoo' AND USER_PW = 'dmswl123';

-- 로그인 목록 값 반환
SELECT 
    USER_ID
    ,USER_PW
    ,USER_PHONE
    ,USER_EMAIL
FROM MEMBER 
WHERE USER_ID = 'ejyoo' AND USER_PW = 'dmswl123';

SELECT 
    USER_ID userId
    ,USER_PW userPw
    ,USER_PHONE userPhone
    ,USER_EMAIL userEmail
FROM MEMBER;

INSERT INTO MEMBER(
    USER_ID
    ,USER_PW
    ,USER_PHONE
    ,USER_EMAIL
)VALUES(
    'ejyoo2'
    ,'dmswl123'
    ,'010-7620-3585'
    ,'o3k1@gmail.com'
);

UPDATE MEMBER SET 
    USER_PHONE = '010-0000-0000'
    ,USER_EMAIL = 'o3k1@nate.com'
WHERE USER_ID = 'ejyoo1';

DELETE FROM MEMBER 
WHERE USER_ID = 'ejyoo2';