--Query objective: obtain name and mileage of SUVs

SELECT c.Car_ID, suv.Make, suv.Model, c.Initial_Milage, SUM(i.Milage) AS MilesDriven, c.Initial_Milage + SUM(i.Milage) AS TotalMiles
FROM SUV suv
INNER JOIN Car c ON c.Car_ID = suv.Car_ID
INNER JOIN Rental r ON c.Car_ID = r.Car_ID
INNER JOIN Invoice i ON i.Rental_ID = r.Rental_ID
GROUP BY c.Car_ID,suv.Make,suv.Model, c.Initial_Milage