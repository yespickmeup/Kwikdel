create table deposits(
id int auto_increment primary key
,user_name varchar(100)
,user_id varchar(100)
,date_added datetime
,status int
,customer_id varchar(100)
,customer_name varchar(100)
,qty double
,barcode varchar(100)
,description varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,unit varchar(100)
,conversion double
,selling_price double
,vatable int
,discount_amount double
,addtl_amount double
,location_name varchar(100)
,location_id varchar(100)
);

create table deposit_returns(
id int auto_increment primary key
,deposit_id varchar(100)
,user_name varchar(100)
,user_id varchar(100)
,date_added datetime
,status int
,customer_id varchar(100)
,customer_name varchar(100)
,qty double
,barcode varchar(100)
,description varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,unit varchar(100)
,conversion double
,selling_price double
,vatable int
,discount_amount double
,addtl_amount double
,location_name varchar(100)
,location_id varchar(100)
);
