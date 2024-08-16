package projects.service;
import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> fetchAllProjects() throws SQLException {
        // formatter:off
        return projectDao.fetchAllProjects()
                .stream()
                .sorted((p1, p2) -> p1.getProjectId() - p2.getProjectId())
                .collect(Collectors.toList());
        // formatter:on
    }

    public Project fetchProjectById(Integer projectId) throws SQLException {
        return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
                "Project with project ID=" + projectId + " does not exist"
        ));
    }

    public void modifyProjectDetails(Project project) {
        if (!projectDao.modifyProjectDetails(project)) {
            throw new DbException("Project with ID=" + project.getProjectId() + " does not exist");
        }
    }

    public void deleteProject(Integer projectId) {
        if (!projectDao.deleteProject(projectId)) {
            throw new DbException("Project with ID=" + projectId + " does not exist");
        }
    }
}
