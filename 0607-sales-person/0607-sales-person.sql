# Write your MySQL query statement below
select s.name from SalesPerson s
where sales_id not in 
(select sales_id from Orders
where com_id=(select com_id from Company where name='RED'));