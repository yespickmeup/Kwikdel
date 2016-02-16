
drop table if exists test_increment_no ;
create table test_increment_no(
id int auto_increment primary key
,sales_no varchar(100)
,date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

alter table test_increment_no DROP PRIMARY KEY, ADD PRIMARY KEY(id,sales_no);
alter table test_increment_no ADD UNIQUE(sales_no);
insert into test_increment_no(sales_no)values
('000001')
,('000001')
;


select sales_no from sales GROUP BY sales_no HAVING COUNT(*) > 1;
select sales_no from sales_dr GROUP BY sales_no HAVING COUNT(*) > 1;

update sales set sales_no='0000000000009521N' where id=810;
update sales_items set sales_no='0000000000009521N' where id=1176;

update sales set sales_no='0000000000074229N' where id=8894;
update sales_items set sales_no='0000000000074229N' where id=9857;


alter table sales ADD UNIQUE(sales_no);
alter table sales_dr ADD UNIQUE(sales_no);


alter table sales DROP PRIMARY KEY, ADD PRIMARY KEY(id,sales_no);



alter table sales_dr DROP PRIMARY KEY, ADD PRIMARY KEY(id,sales_no);


