package gmail.fatihmergunqa.utils;

public class API {
    // BASE URI
    public static final String BASE_URI = "https://neo-api.azurewebsites.net";

    // Endpoints
    public static final String GENERATE_TOKEN = "/api/TokenAuth/Authenticate";
    public static final String GET_ALL_STUDENTS = "/api/services/app/Student/GetAll";
    public static final String GET_ONE_CLASS = "/api/services/app/Class/Get/{Id}";
}
