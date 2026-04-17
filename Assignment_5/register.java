import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class Register extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Served at: ")
                .append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String book_id = request.getParameter("book_id");
        String book_title = request.getParameter("book_title");
        String book_author = request.getParameter("book_author");
        String book_price = request.getParameter("book_price");
        String quantity = request.getParameter("quantity");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BookDB",
                    "root",
                    "root"
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ebookshop VALUES (?, ?, ?, ?, ?)"
            );

            ps.setString(1, book_id);
            ps.setString(2, book_title);
            ps.setString(3, book_author);
            ps.setString(4, book_price);
            ps.setString(5, quantity);

            int i = ps.executeUpdate();

            if (i > 0) {
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM ebookshop");
                ResultSet rs = ps1.executeQuery();

                out.println("<html><head><title>Book Inventory</title>");
                out.println("<style>");
                out.println("table {border-collapse: collapse; width: 100%;}");
                out.println("th, td {padding: 8px;}");
                out.println("th {background-color: #4CAF50; color: white;}");
                out.println("</style>");
                out.println("</head><body>");

                out.println("<h2 align='center'>Book Inventory</h2>");
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("book_id") + "</td>");
                    out.println("<td>" + rs.getString("book_title") + "</td>");
                    out.println("<td>" + rs.getString("book_author") + "</td>");
                    out.println("<td>" + rs.getString("book_price") + "</td>");
                    out.println("<td>" + rs.getString("quantity") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("<h3 align='center' style='color:red;'>Data stored successfully</h3>");
                out.println("</body></html>");

                rs.close();
                ps1.close();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}