<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý - PTTK Cinema</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f5f5f5;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .header-content {
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            font-size: 24px;
        }
        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }
        .btn-logout {
            background: rgba(255,255,255,0.2);
            color: white;
            border: 1px solid white;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.3s;
        }
        .btn-logout:hover {
            background: rgba(255,255,255,0.3);
        }
        .container {
            max-width: 1200px;
            margin: 30px auto;
            padding: 0 20px;
        }
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }
        .menu-card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
            transition: transform 0.3s, box-shadow 0.3s;
            cursor: pointer;
            text-decoration: none;
            color: inherit;
        }
        .menu-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 20px rgba(0,0,0,0.15);
        }
        .menu-card h2 {
            color: #667eea;
            margin-bottom: 10px;
        }
        .menu-card p {
            color: #666;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="header-content">
            <h1>Trang quản lý - PTTK Cinema</h1>
            <div class="user-info">
                <span>Xin chào, <strong>${sessionScope.username}</strong></span>
                <a href="${pageContext.request.contextPath}/logout" class="btn-logout">Đăng xuất</a>
            </div>
        </div>
    </div>

    <div class="container">
        <h2 style="margin-bottom: 20px; color: #333;">Chức năng quản lý</h2>
        
        <div class="menu-grid">
            <a href="${pageContext.request.contextPath}/movie" class="menu-card">
                <h2>🎬 Quản lý phim</h2>
                <p>Xem, thêm, sửa, xóa phim</p>
            </a>
            
            <div class="menu-card">
                <h2>🎭 Quản lý suất chiếu</h2>
                <p>Quản lý lịch chiếu phim</p>
            </div>
            
            <div class="menu-card">
                <h2>🎫 Quản lý vé</h2>
                <p>Xem và quản lý đơn đặt vé</p>
            </div>
            
            <div class="menu-card">
                <h2>👥 Quản lý khách hàng</h2>
                <p>Thông tin khách hàng</p>
            </div>
        </div>
    </div>
</body>
</html>

