-- Lab 5

-- 1)
select BOOKS.Title, BOOKS.Retail
from BOOKS
where BOOKS.Retail < (select avg(BOOKS.Retail)
					  from BOOKS);

-- 2)
select a.Title, b.Category, a.Cost
from BOOKS a, (select BOOKS.Category, avg(BOOKS.Cost) averagecost 
			   from BOOKS 
			   group by BOOKS.Category) b
where a.Category = b.Category
and a.Cost < b.averagecost;

-- 3)
select ORDERS.Order_num
from ORDERS
where ORDERS.ShipState = (select ORDERS.ShipState
						  from ORDERS
						  where ORDERS.Order_num = 1014);
                          
-- 4)
select ORDERITEMS.Order_num, sum(ORDERITEMS.Quantity * ORDERITEMS.PaidEach) as total_order_amount
from ORDERITEMS
group by ORDERITEMS.Order_num
having sum(ORDERITEMS.Quantity * ORDERITEMS.PaidEach) > (select sum(ORDERITEMS.Quantity * ORDERITEMS.PaidEach)
														 from ORDERITEMS
														 where ORDERITEMS.Order_num = 1002);
                                                         
-- 5)
select BOOKS.Title
from BOOKS
where BOOKS.Category in(select distinct BOOKS.Category
						from BOOKS join ORDERITEMS using(ISBN)
						join ORDERS using(Order_num)
                        where ORDERS.Customer_num = 1007)
						and ISBN not in(select ISBN
										from ORDERS join ORDERITEMS using(Order_num)
										where ORDERS.Customer_num = 1007);

-- 6)
select ORDERS.ShipCity, ORDERS.ShipState
from ORDERS
where ORDERS.ShipDate - ORDERS.OrderDate = (select MAX(datediff(ORDERS.ShipDate, ORDERS.OrderDate))
							  from ORDERS);
                              
-- 7)
select CUSTOMERS.Customer_num
from CUSTOMERS join ORDERS using(Customer_num)
join ORDERITEMS using(Order_num)
join BOOKS using(ISBN)
where retail = (select min(retail)
				from BOOKS);

-- 8)
select count(distinct ORDERS.Customer_num)
from ORDERS join ORDERITEMS using(Order_num)
where ISBN in(select ISBN
			  from ORDERITEMS join BOOKAUTHOR using(ISBN)
			  join AUTHOR using(Authorid)
              where fname = 'JAMES' and lname = 'AUSTIN');