import { useState, useEffect } from "react";

function LocalUserList() {

const [users, setUsers] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState("");

useEffect(() => {

fetch("/users.json")
.then(res => res.json())
.then(data => {
setUsers(data);
setLoading(false);
})
.catch(() => {
setError("Error loading users");
setLoading(false);
});

}, []);

if(loading) return <p>Loading...</p>;
if(error) return <p>{error}</p>;

return (
<div>
<h2>Local Users</h2>

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

export default LocalUserList;