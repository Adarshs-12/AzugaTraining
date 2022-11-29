package org.example;

//import org.json.JSONObject;

import org.json.JSONObject;

import java.sql.*;

public class CRUD {
    public String select() {
        String q = "select * from MTable";
        StringBuilder sb = new StringBuilder("[{");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training", "root", "Adarshsahu@007");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rmd = rs.getMetaData();
            int temp = 0;
            while (rs.next()) {
                temp++;
                sb.append("\"objectID\":").append(rs.getInt(1))
                        .append(", \"isHighlight\":").append("\"").append(rs.getString(2)).append("\"")
                        .append(", \"accessionNumber\":").append("\"").append(rs.getString(3)).append("\"").
                        append(", \"accessionYear\":").append("\"").append(rs.getInt(4)).append("\"")
                        .append(", \"isPublicDomain\":").append("\"").append(rs.getString(5)).append("\"")
                        .append(", \"primaryImage\":").append("\"").append(rs.getString(6)).append("\"")
                        .append(", \"primaryImageSmall\":").append("\"").append(rs.getString(7)).append("\"")
                        .append(", \"department\":").append("\"").append(rs.getString(8)).append("\"")
                        .append(", \"objectName\":").append("\"").append(rs.getString(9)).append("\"")
                        .append(", \"title\":").append("\"").append(rs.getString(10)).append("\"")
                        .append(", \"culture\":").append("\"").append(rs.getString(11)).append("\"")
                        .append(", \"period\":").append("\"").append(rs.getString(12)).append("\"")
                        .append(", \"dynasty\":").append("\"").append(rs.getString(13)).append("\"")
                        .append(", \"reign\":").append("\"").append(rs.getString(14)).append("\"")
                        .append(", \"portfolio\":").append("\"").append(rs.getString(15)).append("\"")
                        .append(", \"artistRole\":").append("\"").append(rs.getString(16)).append("\"")
                        .append(", \"artistPrefix\":").append("\"").append(rs.getString(17)).append("\"")
                        .append(", \"artistDisplayName\":").append("\"").append(rs.getString(18)).append("\"")
                        .append(", \"artistDisplayBio\":").append("\"").append(rs.getString(19)).append("\"")
                        .append(", \"artistSuffix\":").append("\"").append(rs.getString(20)).append("\"")
                        .append(", \"artistAlphaSort\":").append("\"").append(rs.getString(21)).append("\"")
                        .append(", \"artistNationality\":").append("\"").append(rs.getString(22)).append("\"")
                        .append(", \"artistBeginDate\":").append("\"").append(rs.getString(23)).append("\"")
                        .append(", \"artistEndDate\":").append("\"").append(rs.getString(24)).append("\"")
                        .append(", \"artistGender\":").append("\"").append(rs.getString(25)).append("\"")
                        .append(", \"artistWikidata_URL\":").append("\"").append(rs.getString(26)).append("\"")
                        .append(", \"artistULAN_URL\":").append("\"").append(rs.getString(27)).append("\"")
                        .append(", \"objectDate\":").append("\"").append(rs.getString(28)).append("\"")
                        .append(", \"objectBeginDate\":").append("\"").append(rs.getInt(29)).append("\"")
                        .append(", \"objectEndDate\":").append("\"").append(rs.getInt(30)).append("\"")
                        .append(", \"medium\":").append("\"").append(rs.getString(31)).append("\"")
                        .append(", \"dimensions\":").append("\"").append(rs.getString(32)).append("\"")
                        .append(", \"creditLine\":").append("\"").append(rs.getString(33)).append("\"")
                        .append(", \"geographyType\":").append("\"").append(rs.getString(34)).append("\"")
                        .append(", \"city\":").append("\"").append(rs.getString(35)).append("\"")
                        .append(", \"state\":").append("\"").append(rs.getString(36)).append("\"")
                        .append(", \"county\":").append("\"").append(rs.getString(37)).append("\"")
                        .append(", \"country\":").append("\"").append(rs.getString(38)).append("\"")
                        .append(", \"region\":").append("\"").append(rs.getString(39)).append("\"")
                        .append(", \"subregion\":").append("\"").append(rs.getString(40)).append("\"")
                        .append(", \"locale\":").append("\"").append(rs.getString(41)).append("\"")
                        .append(", \"locus\":").append("\"").append(rs.getString(42)).append("\"")
                        .append(", \"excavation\":").append("\"").append(rs.getString(43)).append("\"")
                        .append(", \"river\":").append("\"").append(rs.getString(44)).append("\"")
                        .append(", \"classification\":").append("\"").append(rs.getString(45)).append("\"")
                        .append(", \"rightsAndReproduction\":").append("\"").append(rs.getString(46)).append("\"")
                        .append(", \"linkResource\":").append("\"").append(rs.getString(47)).append("\"")
                        .append(", \"metadataDate\":").append("\"").append(rs.getString(48)).append("\"")
                        .append(", \"repository\":").append("\"").append(rs.getString(49)).append("\"")
                        .append(", \"objectURL\":").append("\"").append(rs.getString(50)).append("\"")
                        .append(", \"objectWikidata_URL\":").append("\"").append(rs.getString(51)).append("\"")
                        .append(", \"isTimelineWork\":").append("\"").append(rs.getString(52)).append("\"")
                        .append(", \"GalleryNumber\":").append("\"").append(rs.getString(53)).append("\"");
                if (!rs.isLast()) {
                    sb.append("},{");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error" + e);
        }
        return String.valueOf(sb + "}]");
    }

    public void update( int objectId , String s) {

        JSONObject jsonObject=new JSONObject(s);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training", "root", "Adarshsahu@007");
            //  String q = "update " + tablename + " set  object_name = 'new name' where object_id= " + condition;

            PreparedStatement pstmt = con.prepareStatement("UPDATE MTable SET objectID =?,isHighlight = ?," +
                    "accessionNumber = ?,accessionYear = ?,isPublicDomain =? WHERE objectID ="+objectId );

            pstmt.setInt(1, Integer.parseInt(String.valueOf(jsonObject.get("objectID"))));
            pstmt.setString(2, (String) jsonObject.get("isHighlight"));
            pstmt.setString(3, (String) jsonObject.get("accessionNumber"));
            pstmt.setString(4, (String) jsonObject.get("accessionYear"));
            pstmt.setString(5, (String) jsonObject.get("isPublicDomain"));

            pstmt.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error" + e);
        }
        // return "successfully updated";
    }

    private void create(String tableName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training", "root", "Adarshsahu@007");
            String q = "create table " + tableName + "(objectID int primary key, isHighlight text, accessionNumber varchar(20),accessionYear varchar(10),\n" +
                    "isPublicDomain text,primaryImage varchar(256),primaryImageSmall varchar(256),additionalImages varchar(500),\n" +
                    "constituents varchar(500),department varchar(256),objectName varchar(256),title varchar(256),\n" +
                    "culture varchar(256), period varchar(256), dynasty varchar(256),reign varchar(256), \n" +
                    "portfolio varchar(256), artistRole varchar(256),artistPrefix varchar(256), artistDisplayName varchar(256), \n" +
                    "artistDisplayBio varchar(256),artistSuffix varchar(256), artistAlphaSort varchar(256),artistNationality varchar(256), \n" +
                    "artistBeginDate varchar(10),artistEndDate varchar(10),artistGender varchar(20),artistWikidata_URL varchar(256),\n" +
                    "artistULAN_URL varchar(256),objectDate varchar(50),objectBeginDate int, objectEndDate int,medium varchar(200),\n" +
                    "dimensions varchar(100),measurements varchar(500),creditLine varchar(256),geographyType varchar(256),city varchar(100),\n" +
                    "state varchar(50),county varchar(50), country varchar(50),region varchar(50),subregion varchar(50),locale varchar(50),\n" +
                    "locus varchar(50),excavation varchar(256),river varchar(100),classification varchar(100),rightsAndReproduction varchar(256),\n" +
                    "linkResource varchar(256),metadataDate varchar(50),repository varchar(100),objectURL varchar(256),tags varchar(500),\n" +
                    "objectWikidata_URL varchar(256),isTimelineWork text,galleryNumber varchar(100))";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("error" + e);
        }
    }


    public String delete(String objectId) {

        try {
            int id = Integer.parseInt(objectId);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Training", "root", "Adarshsahu@007");
            String q = "delete from MTable where objectID= " + id;
            Statement stmt = con.createStatement();
//            stmt.executeUpdate(q);
            int result=stmt.executeUpdate(q);
            if (result!=0){
                return "Success";
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error" + e);
        }
        return "{\'messgae\': \'Data is not present\'}";
//        return {"message" : "Data is not present"};
    }


    public String insert(String s) {

        JSONObject jsonObject=new JSONObject(s);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Training", "root", "Adarshsahu@007");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MTable values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, Integer.parseInt(String.valueOf(jsonObject.get("objectID"))));
            pstmt.setString(2, (String) jsonObject.get("isHighlight"));
            pstmt.setString(3, (String) jsonObject.get("accessionNumber"));
            pstmt.setString(4, (String) jsonObject.get("accessionYear"));
            pstmt.setString(5, (String) jsonObject.get("isPublicDomain"));
            pstmt.setString(6, (String) jsonObject.get("primaryImage"));
            pstmt.setString(7, (String) jsonObject.get("primaryImageSmall"));
            pstmt.setString(8, (String) jsonObject.get("department"));
            pstmt.setString(9, (String) jsonObject.get("objectName"));
            pstmt.setString(10, (String) jsonObject.get("title"));
            pstmt.setString(11, (String) jsonObject.get("culture"));
            pstmt.setString(12, (String) jsonObject.get("period"));
            pstmt.setString(13, (String) jsonObject.get("dynasty"));
            pstmt.setString(14, (String) jsonObject.get("reign"));
            pstmt.setString(15, (String) jsonObject.get("portfolio"));
            pstmt.setString(16, (String) jsonObject.get("artistRole"));
            pstmt.setString(17, (String) jsonObject.get("artistPrefix"));
            pstmt.setString(18, (String) jsonObject.get("artistDisplayName"));
            pstmt.setString(19, (String) jsonObject.get("artistDisplayBio"));
            pstmt.setString(20, (String) jsonObject.get("artistSuffix"));
            pstmt.setString(21, (String) jsonObject.get("artistAlphaSort"));
            pstmt.setString(22, (String) jsonObject.get("artistNationality"));
            pstmt.setString(23, (String) jsonObject.get("artistBeginDate"));
            pstmt.setString(24, (String) jsonObject.get("artistEndDate"));
            pstmt.setString(25, (String) jsonObject.get("artistGender"));
            pstmt.setString(26, (String) jsonObject.get("artistWikidata_URL"));
            pstmt.setString(27, (String) jsonObject.get("artistULAN_URL"));
            pstmt.setString(28, (String) jsonObject.get("objectDate"));
            pstmt.setInt(29, Integer.parseInt(String.valueOf(jsonObject.get("objectBeginDate"))));
            pstmt.setInt(30, Integer.parseInt(String.valueOf(jsonObject.get("objectEndDate"))));
            pstmt.setString(31, (String) jsonObject.get("medium"));
            pstmt.setString(32, (String) jsonObject.get("dimensions"));
            pstmt.setString(33, (String) jsonObject.get("creditLine"));
            pstmt.setString(34, (String) jsonObject.get("geographyType"));
            pstmt.setString(35, (String) jsonObject.get("city"));
            pstmt.setString(36, (String) jsonObject.get("state"));
            pstmt.setString(37, (String) jsonObject.get("county"));
            pstmt.setString(38, (String) jsonObject.get("country"));
            pstmt.setString(39, (String) jsonObject.get("region"));
            pstmt.setString(40, (String) jsonObject.get("subregion"));
            pstmt.setString(41, (String) jsonObject.get("locale"));
            pstmt.setString(42, (String) jsonObject.get("locus"));
            pstmt.setString(43, (String) jsonObject.get("excavation"));
            pstmt.setString(44, (String) jsonObject.get("river"));
            pstmt.setString(45, (String) jsonObject.get("classification"));
            pstmt.setString(46, (String) jsonObject.get("rightsAndReproduction"));
            pstmt.setString(47, (String) jsonObject.get("linkResource"));
            pstmt.setString(48, (String) jsonObject.get("metadataDate"));
            pstmt.setString(49, (String) jsonObject.get("repository"));
            pstmt.setString(50, (String) jsonObject.get("objectURL"));
            pstmt.setString(51, (String) jsonObject.get("objectWikidata_URL"));
            pstmt.setString(52, (String) jsonObject.get("isTimelineWork"));
            pstmt.setString(53, (String) jsonObject.get("GalleryNumber"));
            int result=pstmt.executeUpdate();
            if (result!=0){
                return "Success";
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error" + e);
        }
        return "{\'messgae\': \'Duplicate Entries\'}";
//        return "Duplicate Entries";
    }


}
