# Contact Organizer (Java Swing) (In Development) 

![Java](https://img.shields.io/badge/Java-17-blue)
![Swing](https://img.shields.io/badge/GUI-Swing-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![License](https://img.shields.io/badge/License-MIT-green)

A Java Swing application for managing contacts with MySQL database integration. Currently in development with core CRUD functionality implemented.

## ✨ Current Features
- **Add Contacts**: Store contact details (ID, name, address, phone)
- **Form Validation**: Mandatory field checks and error handling
- **Database Integration**: MySQL backend for data persistence
- **Nimbus Look-and-Feel**: Modern Swing interface

## 🚧 Planned Features
- Complete Update/Delete functionality
- Advanced search capabilities
- Contact list view with sorting
- Export/Import options

## 🛠️ Technical Stack
- **Frontend**: Java Swing (Nimbus theme)
- **Backend**: Java JDBC
- **Database**: MySQL
- **Architecture**: MVC pattern

## 📦 Database Schema
```sql
CREATE TABLE contacts (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
    phone VARCHAR(15)
);
```

## 📬 Contact
**Developer**: A.S. Dinushka Tharidu  
**Email**: [asdinushkatharidu@gmail.com](mailto:asdinushkatharidu@gmail.com)  
**LinkedIn**: [Dinushka Tharidu](https://www.linkedin.com/in/dinushka-tharidu-b3a1a1253)  

## License
MIT License - See [LICENSE](LICENSE) for details

##
Developed to practice Java Swing and OOP

