-- STUDENTS TBL
CREATE TABLE students (
                          student_id SERIAL PRIMARY KEY ,
                          student_name VARCHAR(100) NOT NULL ,
                          email VARCHAR UNIQUE NOT NULL ,
                          phone_number VARCHAR
);

-- ADD DATA TO STUDENTS TBL
INSERT INTO students (student_name, email, phone_number) VALUES
                                                             ('David Miller', 'david@example.com', '098-123-456'),
                                                             ('Emma Wilson', 'emma@example.com', '097-234-567'),
                                                             ('Frank Anderson', 'frank@example.com', '096-345-678'),
                                                             ('Grace Thomas', 'grace@example.com', '095-456-789'),
                                                             ('Henry Martinez', 'henry@example.com', '099-567-890'),
                                                             ('Ivy Robinson', 'ivy@example.com', '093-678-901'),
                                                             ('Jack Lee', 'jack@example.com', '092-789-012'),
                                                             ('Kelly Walker', 'kelly@example.com', '091-890-123'),
                                                             ('Leo Harris', 'leo@example.com', '090-901-234'),
                                                             ('Mia Carter', 'mia@example.com', '089-012-345');


SELECT * FROM students ORDER BY student_id;


-- INSTRUCTORS TBL
CREATE TABLE instructors (
                             instructor_id SERIAL PRIMARY KEY ,
                             instructor_name VARCHAR(100) NOT NULL ,
                             email VARCHAR NOT NULL
);

-- ADD DATA TO INSTRUCTORS TBL
INSERT INTO instructors (instructor_name, email) VALUES
                                                     ('Dr. Emily Carter', 'emily.carter@example.com'),
                                                     ('Prof. John Williams', 'john.williams@example.com'),
                                                     ('Dr. Sarah Johnson', 'sarah.johnson@example.com'),
                                                     ('Prof. Michael Brown', 'michael.brown@example.com'),
                                                     ('Dr. Olivia Davis', 'olivia.davis@example.com');


SELECT * FROM instructors;


-- COURSES TBL
CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY ,
                         course_name VARCHAR(100) NOT NULL ,
                         description VARCHAR NOT NULL ,
                         instructor_id INTEGER NOT NULL
                             CONSTRAINT fk_instructor
                                 REFERENCES instructors
                                 ON UPDATE CASCADE ON DELETE CASCADE
);

-- ADD DATA TO COURSES TBL
INSERT INTO courses (course_name, description, instructor_id) VALUES
                                                                  ('Database Management', 'Learn about relational databases and SQL', 1),
                                                                  ('Web Development', 'HTML, CSS, and JavaScript for beginners', 2),
                                                                  ('Data Structures', 'Understanding arrays, linked lists, and trees', 1),
                                                                  ('Machine Learning', 'Introduction to AI and ML algorithms', 3),
                                                                  ('Cybersecurity Basics', 'Fundamentals of online security and encryption', 4),
                                                                  ('Software Engineering', 'Best practices for designing and developing software', 5);


SELECT * FROM courses;


-- STUDENT_COURSES TBL
CREATE TABLE student_course (
                                id SERIAL PRIMARY KEY ,
                                student_id INTEGER NOT NULL
                                    CONSTRAINT fk_student
                                        REFERENCES students
                                        ON UPDATE CASCADE ON DELETE CASCADE ,
                                course_id INTEGER NOT NULL
                                    CONSTRAINT fk_course
                                        REFERENCES courses
                                        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ADD DATA TO STUDENT_COURSES TBL
INSERT INTO student_course (student_id, course_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 2),
                                                       (2, 3),
                                                       (3, 1),
                                                       (3, 3),
                                                       (4, 1),
                                                       (4, 4),
                                                       (5, 2),
                                                       (5, 5),
                                                       (6, 3),
                                                       (6, 6);


SELECT * FROM student_course;

