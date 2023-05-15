package exercise.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.User;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<User> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/users.json");

        List<User> users = objectMapper.readValue(inputStream, new TypeReference<List<User>>() {});
        inputStream.close();

        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<User> users = getUsers();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>List of Users</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Full Name</th>");
        out.println("</tr>");

        for (User user : users) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td><a href=\"/users/" + user.getId() + "\">" + user.getFullName() + "</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");

        out.close();
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        User user = null;
        for (User u : getUsers()) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Details</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>User Details</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>First Name</th>");
        out.println("<th>Last Name</th>");
        out.println("<th>Email</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + user.getId() + "</td>");
        out.println("<td>" + user.getFirstName() + "</td>");
        out.println("<td>" + user.getLastName() + "</td>");
        out.println("<td>" + user.getEmail() + "</td>");
        out.println("</tr>");

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        out.close();
        // END
    }
}
