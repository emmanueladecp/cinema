/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ADMIN
 * Created: Jul 6, 2019
 */

/**
DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer (
  cust_id CHAR(6) PRIMARY KEY,
  cust_name VARCHAR(250) NOT NULL,
  cust_phone VARCHAR(15) DEFAULT NULL,
  cust_email VARCHAR(100) DEFAULT NULL
);
 */

INSERT INTO customer (id, name, phone, email) VALUES
  (1,'Dangote', '012345678','-'),
  (2,'Gates', '05465455','asdasd@sdfsd.com'),
  (3,'Alakija', '546852132','-')
;

/**
DROP TABLE IF EXISTS m_ticket;
 
CREATE TABLE m_ticket (
  ticket_id CHAR(6)  PRIMARY KEY,
  ticket_movie VARCHAR(250) NOT NULL,
  ticket_date DATE NOT NULL,
  ticket_starttime TIME NOT NULL,
  ticket_endtime TIME NOT NULL,
  ticket_remainqty INT DEFAULT 0  
);
*/

INSERT INTO ticket (id, name, date, starttime, endtime, qty)  VALUES
  (1, 'SPIDERMAN FAR FROM HOME', '2019-07-06','10:00:00','11:00:00',20),
  (2, 'SPIDERMAN FAR FROM HOME', '2019-07-06','11:30:00','12:30:00',40),
  (3, 'SPIDERMAN FAR FROM HOME', '2019-07-06','12:00:00','13:00:00',35),
  (4, 'ANABELLE COMES HOME', '2019-07-06','13:30:00','14:30:00',10),
  (5, 'ANABELLE COMES HOME', '2019-07-06','15:30:00','16:00:00',5),
  (6, 'ANABELLE COMES HOME', '2019-07-06','16:30:00','17:30:00',2),

  (7, 'SPIDERMAN FAR FROM HOME', '2019-07-07','10:00:00','11:00:00',100),
  (8, 'SPIDERMAN FAR FROM HOME', '2019-07-07','11:30:00','12:30:00',100),
  (9, 'SPIDERMAN FAR FROM HOME', '2019-07-07','12:00:00','13:00:00',100),
  (10, 'ANABELLE COMES HOME', '2019-07-07','13:30:00','14:30:00',200),
  (11, 'ANABELLE COMES HOME', '2019-07-07','15:30:00','16:00:00',200),
  (12, 'ANABELLE COMES HOME', '2019-07-07','16:30:00','17:30:00',200)
;

