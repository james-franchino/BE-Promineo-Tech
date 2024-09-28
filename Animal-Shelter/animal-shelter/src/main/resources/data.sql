-- Insert Shelters
INSERT INTO shelters (shelter_name, address, phone_number, email, capacity) VALUES
('Paws and Claws Shelter', '123 Main St, Anytown, USA', '555-0100', 'info@pawsandclaws.org', 50),
('Happy Tails Rescue', '456 Oak Rd, Somewhere City, USA', '555-0200', 'contact@happytails.org', 30),
('Furry Friends Haven', '789 Pine Ave, Anotherville, USA', '555-0300', 'hello@furryfriendsorg', 40);

-- Insert Animals
INSERT INTO animals (name, species, breed, age, gender, status, intake_date, shelter_id) VALUES
('Max', 'Dog', 'Labrador', 3, 'Male', 'AVAILABLE', '2023-01-15', 1),
('Luna', 'Cat', 'Siamese', 2, 'Female', 'AVAILABLE', '2023-02-20', 1),
('Charlie', 'Dog', 'Golden Retriever', 5, 'Male', 'ADOPTED', '2023-03-10', 1),
('Bella', 'Cat', 'Persian', 1, 'Female', 'AVAILABLE', '2023-04-05', 2),
('Rocky', 'Dog', 'German Shepherd', 4, 'Male', 'AVAILABLE', '2023-05-12', 2),
('Milo', 'Cat', 'Maine Coon', 3, 'Male', 'PENDING', '2023-06-18', 2),
('Daisy', 'Dog', 'Beagle', 2, 'Female', 'AVAILABLE', '2023-07-22', 3),
('Oliver', 'Cat', 'British Shorthair', 1, 'Male', 'AVAILABLE', '2023-08-30', 3),
('Lucy', 'Dog', 'Poodle', 6, 'Female', 'UNDER_TREATMENT', '2023-09-14', 3);

-- Insert Staff
INSERT INTO staff (first_name, last_name, role, email, phone_number, hire_date, shelter_id) VALUES
('John', 'Doe', 'Manager', 'john.doe@pawsandclaws.org', '555-0101', '2020-01-01', 1),
('Jane', 'Smith', 'Veterinarian', 'jane.smith@pawsandclaws.org', '555-0102', '2020-02-15', 1),
('Mike', 'Johnson', 'Caretaker', 'mike.johnson@pawsandclaws.org', '555-0103', '2020-03-20', 1),
('Emily', 'Brown', 'Manager', 'emily.brown@happytails.org', '555-0201', '2019-12-01', 2),
('David', 'Wilson', 'Caretaker', 'david.wilson@happytails.org', '555-0202', '2020-04-10', 2),
('Sarah', 'Lee', 'Manager', 'sarah.lee@furryfriendsorg', '555-0301', '2020-05-01', 3),
('Tom', 'Clark', 'Veterinarian', 'tom.clark@furryfriendsorg', '555-0302', '2020-06-15', 3);

-- Insert Adopters
INSERT INTO adopters (first_name, last_name, email, phone_number, address, registration_date) VALUES
('Alice', 'Johnson', 'alice.j@email.com', '555-1001', '101 Elm St, Anytown, USA', '2023-02-01'),
('Bob', 'Williams', 'bob.w@email.com', '555-1002', '202 Maple Ave, Somewhere City, USA', '2023-03-15'),
('Carol', 'Davis', 'carol.d@email.com', '555-1003', '303 Birch Rd, Anotherville, USA', '2023-04-20'),
('Daniel', 'Miller', 'daniel.m@email.com', '555-1004', '404 Cedar Ln, Anytown, USA', '2023-05-10'),
('Eva', 'Taylor', 'eva.t@email.com', '555-1005', '505 Pine St, Somewhere City, USA', '2023-06-05');

-- Insert Adoptions
INSERT INTO adoptions (adopter_id, animal_id, adoption_date, status) VALUES
(1, 3, '2023-04-15', 'COMPLETED'),
(2, 6, '2023-07-20', 'PENDING'),
(3, 1, '2023-08-05', 'PENDING'),
(4, 5, '2023-09-10', 'COMPLETED'),
(5, 8, '2023-10-01', 'PENDING');