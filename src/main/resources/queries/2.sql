SELECT
  projects_developers.project_id,
  project_name,
  SUM(salary) total_price
FROM developers, projects, projects_developers
WHERE developers.developer_id = projects_developers.developer_id
      AND projects.project_id = projects_developers.project_id
GROUP BY project_id
ORDER BY total_price DESC
LIMIT 1;