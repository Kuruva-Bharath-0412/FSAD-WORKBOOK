import { useState, useEffect } from "react";

function UserList() {

const [users, setUsers] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState("");

useEffect(() => {

fetch("https://jsonplaceholder.typicode.com/users")
.then(res => res.json())
.then(data => {
setUsers(data);
setLoading(false);
})
.catch(() => {
setError("Error fetching API data");
setLoading(false);
});

}, []);

if(loading) return <p>Loading...</p>;
if(error) return <p>{error}</p>;

return (
<div>
<h2>Users API</h2>

{users.map(user => (
<div key={user.id}>
<p><b>Name:</b> {user.name}</p>
<p>Email: {user.email}</p>
<p>Phone: {user.phone}</p>
<hr/>
</div>
))}

</div>
);
}

export default UserList;