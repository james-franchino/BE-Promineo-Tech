-- Drop tables if they exist
DROP TABLE IF EXISTS project_category;
DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS project;

-- Create table project
CREATE TABLE project (
    project_id      INT NOT NULL AUTO_INCREMENT,
    project_name    VARCHAR(128) NOT NULL,
    estimated_hours DECIMAL(7, 2),
    actual_hours    DECIMAL(7, 2),
    difficulty      INT,
    notes           TEXT,
    PRIMARY KEY (project_id)
);

-- Create table category
CREATE TABLE category (
    category_id   INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(128) NOT NULL,
    PRIMARY KEY (category_id)
);

-- Create table material
CREATE TABLE material (
    material_id   INT NOT NULL AUTO_INCREMENT,
    project_id    INT NOT NULL,
    material_name VARCHAR(128) NOT NULL,
    num_required  INT,
    cost          DECIMAL(7, 2),
    PRIMARY KEY (material_id),
    FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);

-- Create table step
CREATE TABLE step (
    step_id    INT NOT NULL AUTO_INCREMENT,
    project_id INT NOT NULL,
    step_text  TEXT NOT NULL,
    step_order INT NOT NULL,
    PRIMARY KEY (step_id),
    FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);


-- Create table project_category
CREATE TABLE project_category (
    project_id  INT NOT NULL,
    category_id INT NOT NULL,
    UNIQUE KEY unique_project_category (project_id, category_id),
    FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
);