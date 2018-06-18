SELECT b.Branch_Name, c.Car_ID, SUM(i.Milage) AS MilesDriven
FROM Branch b
INNER JOIN  Car c ON b.Branch_ID = c.Branch_ID
INNER JOIN Rental r ON b.Branch_ID = r.Branch_ID
INNER JOIN Invoice i ON r.Rental_ID = i.Rental_ID
GROUP BY b.Branch_Name, c.Car_ID;