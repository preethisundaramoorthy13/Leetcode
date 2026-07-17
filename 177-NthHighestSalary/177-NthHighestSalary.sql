-- Last updated: 7/17/2026, 3:04:44 PM
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
   SET N = N-1;
  RETURN (
      SELECT DISTINCT salary FROM Employee 
      ORDER BY salary DESC
      LIMIT 1 OFFSET N

  );
END