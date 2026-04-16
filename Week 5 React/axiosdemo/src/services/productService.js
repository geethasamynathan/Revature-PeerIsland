import api from "../api/axiosInstance";

export const getProducts = async () => {
  try {
    const response = await api.get("/users");
    return response.data.users;
  } catch (error) {
    console.error("Error fetching Products", error);
    throw error;
  }
};
