;WITH Miles AS(
SELECT Invoice_ID, Customer_ID, Milage
FROM Invoice
WHERE Milage > 100
)
SELECT m.Invoice_ID, m.Milage, c.FName, c.LName
FROM Customer c
INNER JOIN Miles m on m.Customer_ID = c.Customer_ID;