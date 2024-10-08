package projects.service;
import projects.dao.ProjectDao;
import projects.entity.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> fetchAllProjects() throws SQLException {
        return projectDao.fetchAllProjects();
    }

    public Project fetchProjectById(Integer projectId) throws SQLException {
        return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
                "Project with project ID=" + projectId + " does not exist"
        ));
    }
}
