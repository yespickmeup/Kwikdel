update sales s set
s.date_added=(select sr.date_added from sales_dr  sr where s.session_no=sr.sales_no)
where s.payment_type_id=2;

update sales_items si set
si.date_added=(select s.date_added from sales s where s.sales_no=si.sales_no);


