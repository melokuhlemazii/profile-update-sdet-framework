package API;

/**
 * API Endpoints configuration class
 * Add your actual endpoint URLs here
 */
public class APIEndpoints {
    public static final String BASE_URL = "https://ndosisimplifiedautomation.vercel.app";

    // Authentication Endpoints
    public static final String LOGIN_ENDPOINT = "/api/login";
    public static final String LOGOUT_ENDPOINT = "/api/logout";

    // Profile Endpoints
    public static final String GET_PROFILE_ENDPOINT = "/api/profile";
    public static final String UPDATE_PROFILE_ENDPOINT = "/api/profile/update";
    public static final String UPLOAD_PROFILE_PICTURE_ENDPOINT = "/api/profile/upload";

    // User Endpoints
    public static final String GET_USER_ENDPOINT = "/api/user";
    public static final String UPDATE_USER_ENDPOINT = "/api/user/update";

    // Dashboard Endpoints
    public static final String GET_DASHBOARD_DATA_ENDPOINT = "/api/dashboard";

    // Menu Endpoints
    public static final String GET_MENU_ENDPOINT = "/api/menu";
}
