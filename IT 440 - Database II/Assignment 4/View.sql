CREATE VIEW CarMiles AS
SELECT c.Car_ID, c.Initial_Milage + SUM(i.Milage) AS TotalMiles
FROM Car c
LEFT OUTER JOIN Rental r ON c.Car_ID = r.Car_ID
INNER JOIN Invoice i ON r.Rental_ID = i.Rental_ID
GROUP BY c.Car_ID, c.Initial_Milage;