import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  const [students, setStudents] = useState([
    { id: 1, name: "Rahul", course: "CSE" },
    { id: 2, name: "Priya", course: "ECE" },
    { id: 3, name: "Amit", course: "IT" },
    { id: 4, name: "Sneha", course: "EEE" },
    { id: 5, name: "Ravi", course: "MECH" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);

    setNewStudent({
      id: "",
      name: "",
      course: ""
    });
  };

  const deleteStudent = (id) => {
    const updatedStudents = students.filter((s) => s.id !== id);
    setStudents(updatedStudents);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <input
        type="text"
        name="id"
        placeholder="ID"
        value={newStudent.id}
        onChange={handleChange}
      />

      <input
        type="text"
        name="name"
        placeholder="Name"
        value={newStudent.name}
        onChange={handleChange}
      />

      <input
        type="text"
        name="course"
        placeholder="Course"
        value={newStudent.course}
        onChange={handleChange}
      />

      <button onClick={addStudent}>Add Student</button>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table border="1">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => deleteStudent(s.id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;