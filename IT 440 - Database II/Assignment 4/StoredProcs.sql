CREATE PROC Under100
AS
SELECT c.FName, c.LName, SUM(i.Milage) AS TotalMiles
FROM Invoice i
INNER JOIN Customer c ON i.Customer_ID = c.Customer_ID
GROUP BY c.FName, c.LName
HAVING SUM(i.Milage) < 100;