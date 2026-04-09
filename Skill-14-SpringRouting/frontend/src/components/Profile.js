import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Profile.css';

const Profile = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const userId = localStorage.getItem('userId');
        if (!userId) {
            navigate('/');
        } else {
            axios.get(`http://localhost:8080/api/users/${userId}`)
                .then(res => {
                    setUser(res.data);
                    setLoading(false);
                })
                .catch(err => {
                    console.error('Error fetching profile:', err);
                    setLoading(false);
                });
        }
    }, [navigate]);

    const handleLogout = () => {
        localStorage.removeItem('userId');
        window.location.href = '/';
    };

    if (loading) {
        return (
            <div className="profile-container">
                <div className="loading">Loading...</div>
            </div>
        );
    }

    return (
        <div className="profile-container">
            <div className="profile-card">
                <h2>👤 User Profile</h2>
                
                {user ? (
                    <div className="profile-details">
                        <div className="profile-item">
                            <label>ID:</label>
                            <span>{user.id}</span>
                        </div>
                        <div className="profile-item">
                            <label>Username:</label>
                            <span>{user.username}</span>
                        </div>
                        <div className="profile-item">
                            <label>Email:</label>
                            <span>{user.email}</span>
                        </div>
                    </div>
                ) : (
                    <p>User not found</p>
                )}

                <div className="button-group">
                    <button onClick={() => navigate('/home')} className="btn-back">
                        Back to Home
                    </button>
                    <button onClick={handleLogout} className="btn-logout">
                        Logout
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Profile;
