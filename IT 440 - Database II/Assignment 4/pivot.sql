SELECT [1] AS West, [2] AS East, [3] AS North, [4] AS South
FROM 
(SELECT Initial_Milage, Branch_ID
FROM Car) c
PIVOT
(
SUM(Initial_Milage)
FOR Branch_ID IN
([1],[2],[3],[4])
) AS pvt