package dao;

import support.DBConn;
import bean.*;
import java.util.Vector;
import java.sql.*;

public class Dao {
    public Dao() {
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void insert(SongBean songB) {
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement("insert into songinfo values(?,?,?,0)");
            ps.setString(1, songB.getSongName());
            ps.setString(2, songB.getSongPath());
            ps.setString(3, songB.getSongSize());
           ps.executeUpdate();           
        } catch (SQLException ex) {
            new Exception(); //抛出异常表示此歌曲存在，不用添加数据库,可用continue跨过此歌;
        } finally {
            DBConn.close(conn, ps, null);
        }
    }

//查询
    public Vector getWhatyouWant(String key) {
        Vector v = new Vector();
        conn = DBConn.getConn();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(
                    "select * from songinfo where songName like '%" + key +
                    "%' order by songHot DESC");
            while (rs.next()) {
                SongBean sb = new SongBean();
                sb.setSongName(rs.getString("songName"));
                sb.setSongPath(rs.getString("songPath"));
                sb.setSongSize(rs.getString("songSize"));
                sb.setSongHot(rs.getInt("songHot"));
                v.addElement(sb);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConn.close(conn, stmt, rs);
        }
        return v;
    }

//取出数据库中所有歌曲并按热度，名称排序
    public Vector getDate() {
        Vector v = new Vector();
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement(
                    "select * from songinfo order by songHot DESC");
            rs = ps.executeQuery();
            while (rs.next()) {
                SongBean songBean = new SongBean(rs.getString("songName"),
                                                 rs.getString("songPath"),
                                                 rs.getString("songSize"),
                                                 rs.getInt("songHot"));
                v.addElement(songBean);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConn.close(conn, ps, rs);
        }
        return v;
    }
    public Vector getDateOrDerByName(){
        Vector v = new Vector();
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement(
                    "select * from songinfo order by songName");
            rs = ps.executeQuery();
            while (rs.next()) {
                SongBean songBean = new SongBean(rs.getString("songName"),
                                                 rs.getString("songPath"),
                                                 rs.getString("songSize"),
                                                 rs.getInt("songHot"));
                v.addElement(songBean);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConn.close(conn, ps, rs);
        }
        return v;

    }

//删除
    public boolean del(String what) {
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement(
                    "delete from songinfo where songName = ?");
            ps.setString(1, what);
            int i = ps.executeUpdate();
            if (i > 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBConn.close(conn, ps, null);
        }
    }

    //清空数据库
    public boolean delAll() {
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement("delete from songinfo");
            int i = ps.executeUpdate();
            if (i > 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBConn.close(conn, ps, null);
        }
    }

    //增加热度
    public void updateHot(String name) {
        conn = DBConn.getConn();
        try {
            ps = conn.prepareStatement(
                    "update songinfo set songHot = (songHot+1) where songName = ?");
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConn.close(conn, ps, null);
        }
    }

}
