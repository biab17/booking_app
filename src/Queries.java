public  class Queries {


    public static final String INSERT_USERS_QUERY = "INSERT INTO users (email, password, full_name, phone_number,user_type) VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT_ADMINS_QUERY = "INSERT INTO admins () VALUES ()";
    public static final String INSERT_AUTHORS_QUERY = "INSERT INTO authors () VALUES ()";
    public static final String INSERT_BOOKS_QUERY = "INSERT INTO books (title, stock,author_id) VALUES (?, ?, ?)";
    public static final String INSERT_CLIENTS_QUERY = "INSERT INTO clients () VALUES ()";
    public static final String INSERT_FEEDBACK_QUERY = "INSERT INTO feedback (author_id, ) VALUES (?, ?, ?, ?)";
    public static final String INSERT_ORDERS_QUERY = "INSERT INTO orders (client_id, book_id, order_date) VALUES (?, ?, ?)";

}

