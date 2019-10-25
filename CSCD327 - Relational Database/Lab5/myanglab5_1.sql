-- Lab5 (continued)

-- 9)
select product_name, list_price
from products
where list_price > (select avg(list_price)
					from products
                    where list_price > 0)
					order by list_price desc;
                    
-- 10)
select category_name
from categories
where not exists(select 1 
				 from products p
                 where p.category_id = categories.category_id);
                 
-- 11)
select email_address, order_id, order_date
from customers T join orders
where order_id = (select min(order_id)
				  from orders as S
				  where T.customer_id = S.customer_id);