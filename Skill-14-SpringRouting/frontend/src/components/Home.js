import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Home.css';

const Home = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);

    useEffect(() => {
        const userId = localStorage.getItem('userId');
        if (!userId) {
            navigate('/');
        } else {
            // Fetch user data for display
            fetch(`http://localhost:8080/api/users/${userId}`)
                .then(res => res.json())
                .then(data => setUser(data))
                .catch(err => console.error('Error fetching user:', err));
        }
    }, [navigate]);

    const handleLogout = () => {
        localStorage.removeItem('userId');
        window.location.href = '/';
    };

    return (
        <div className="home-container">
            <div className="home-card">
                <h2>🏠 Welcome Home!</h2>
                {user && (
                    <div className="user-info">
                        <p><strong>Username:</strong> {user.username}</p>
                        <p><strong>Email:</strong> {user.email}</p>
                    </div>
                )}
                <p className="welcome-text">
                    You have successfully logged in! This is a protected route.
                </p>
                <div className="button-group">
                    <button onClick={() => navigate('/profile')} className="btn-profile">
                        View Profile
                    </button>
                    <button onClick={handleLogout} className="btn-logout">
                        Logout
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Home;
