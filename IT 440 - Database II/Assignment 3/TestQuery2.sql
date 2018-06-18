SELECT c.Car_ID, SUM(DATEDIFF(DAY,r.Start_Date,r.End_Date)) AS DaysRented, (c.Price_Per_Day*SUM(DATEDIFF(DAY,r.Start_Date,r.End_Date))) AS TotalRevenue
FROM Car c
INNER JOIN Rental r ON c.Car_ID = r.Car_ID
GROUP BY c.Car_ID,c.Price_Per_Day