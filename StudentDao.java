import java.sql.*;

public class StudentDao implements StudentDaoInterface{
    
    @Override
    public boolean insert(Student s){
        boolean flag = false;

        try{
            Connection con = DBConnection.createConnection();
            String query   = "insert into student_details(sname,clgname,city,percentage)"
                             +" values(?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,s.getName());
            pst.setString(2,s.getClgName());
            pst.setString(3,s.getCity());
            pst.setDouble(4, s.getPercentage());
            pst.executeUpdate();
            flag  = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(int roll){
        return false;
    }
    
    public boolean update(int roll,String update,int ch,Student s){
        return false;
    }
    
    public void showAllStudent(){
        try{
            Connection con = DBConnection.createConnection();
            String query = "select * from student_details";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                System.out.println("Roll No : "+rs.getInt(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("College : "+rs.getString(3));
                System.out.println("City : "+rs.getString(4));
                System.out.println("Percentage "+rs.getDouble(5));
                System.out.println("----------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public boolean showStudentById(int roll){
        return false;
    }
    
}
