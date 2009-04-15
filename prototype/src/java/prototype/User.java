/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prototype;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.*;

/**
 *
 * @author vgerdin
 */
//@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;

    Connection conn = DriverManager.getConnection("jdbc:sqlite://home/vgerdin/db/ToDo.db");
    Statement stat = conn.createStatement();
    PreparedStatement prep = conn.prepareStatement("SELECT id, name, email FROM users WHERE id = ?;");
    ResultSet rs;
    
    public User (Long id) throws SQLException{

        prep.setLong(1, id);
      
        
        conn.setAutoCommit(false);
        rs = prep.executeQuery();
        conn.setAutoCommit(true);
        
        if(rs.next()){
            this.id = id;
            this.name = rs.getString("name");
            this.email = rs.getString("email");
        }
        
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prototype.User[id=" + id + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
