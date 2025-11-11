## PTTK_Cinema (JSP/Servlet)

Dự án quản lý rạp chiếu phim với module đăng nhập và quản lý phim.

### Cấu trúc dự án

- `src/main/webapp`
  - `index.jsp` - Trang chủ (redirect đến đăng nhập)
  - `WEB-INF/web.xml` - Cấu hình web app
  - `WEB-INF/views/` - Các JSP views
    - `GDDangNhap.jsp` - Trang đăng nhập
    - `ManagerView.jsp` - Màn hình quản lý chính
    - `ManageMovieView.jsp` - Quản lý danh sách phim
    - `AddMovieView.jsp` - Thêm phim mới
- `src/main/java/com/pttk/cinema`
  - `controller/` - Servlets xử lý request
    - `LoginController` - Xử lý đăng nhập
    - `ManagerController` - Trang quản lý
    - `MovieController` - Quản lý phim
    - `LogoutController` - Đăng xuất
  - `dao/` - Data Access Objects
    - `BaseDAO` - Base class cho database connection
    - `UserDAO` - Xử lý user
    - `MovieDAO` - Xử lý phim
  - `model/` - Model classes
    - `User.java` - Model người dùng
    - `Movie.java` - Model phim

### Cài đặt Database

1. Tạo database MySQL:
```bash
mysql -u root -p < database/schema.sql
```

Hoặc chạy thủ công:
- Tạo database `pttk_cinema`
- Chạy script SQL trong `database/schema.sql`

2. Cấu hình kết nối database trong `BaseDAO.java`:
   - Sửa `DB_URL`, `DB_USER`, `DB_PASSWORD` nếu cần

### Tài khoản mẫu

- **Quản lý**: 
  - Username: `admin`
  - Password: `admin123`
- **Người dùng**: 
  - Username: `user`
  - Password: `user123`

### Chạy ứng dụng

#### Chạy nhanh bằng Jetty

```bash
mvn clean jetty:run
```

Mặc định app chạy ở `http://localhost:8080/`.

#### Chạy trên IntelliJ IDEA

1. File > New > Project from Existing Sources... chọn thư mục dự án này.
2. IntelliJ nhận diện Maven tự động (pom.xml).
3. Cấu hình Application Server (Tomcat 10+ hoặc Jetty 11):
   - Run > Edit Configurations
   - Add > Tomcat Server (Local)
   - Deploy artifact: `PTTK_Cinema:war exploded`
   - Context path: `/`
4. Chạy ứng dụng

### Các trang chính

- `/` hoặc `/login` - Trang đăng nhập
- `/manager` - Trang quản lý chính (yêu cầu đăng nhập với role manager)
- `/manager/movies` - Quản lý danh sách phim
- `/manager/movies/add` - Thêm phim mới
- `/logout` - Đăng xuất

### Ghi chú

- Dùng Jakarta Servlet 5 (phù hợp Tomcat 10+ hoặc Jetty 11).
- Nếu bạn dùng Tomcat 9 trở xuống, cần chuyển namespaces về `javax.*`.
- Đảm bảo MySQL đã được cài đặt và chạy trước khi start ứng dụng.


