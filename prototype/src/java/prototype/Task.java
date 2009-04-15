/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prototype;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.*;

/**
 *
 * @author nwelch
 */
@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long startDate;
    private Long dueDate;
    private String what;

    Connection conn = DriverManager.getConnection("jdbc:sqlite://home/vgerdin/db/ToDo.db");
    Statement stat = conn.createStatement();
    PreparedStatement prep = conn.prepareStatement("SELECT id, startDate, dueDate, what FROM tasks WHERE id = ?;");
    ResultSet rs;
    
    public Task (Long id){
        prep.setLong(1,id);
        
        conn.setAutoCommit(false);
        rs = prep.executeQuery();
        conn.setAutoCommit(true);
        
        if(rs.next()){
            this.id = id;
            this.startDate = rs.getLong("startDate");
            this.dueDate = rs.getLong("dueDate");
            this.what = rs.getString("what");
        }
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prototype.Task[id=" + id + "]";
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

}
