package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Vehicles;

public class VehiclesDao {
  
   private Connection connection;
   private final String GET_VEHICLES_QUERY = "SELECT * FROM vehicles";
   private final String GET_VEHICLE_BY_ID_QUERY = "SELECT * FROM vehicles WHERE id = ?";
   private final String CREATE_NEW_VEHICLE_QUERY = "INSERT INTO vehicles (vehicle_type, make, model) VALUES (?, ?, ?)";
   private final String UPDATE_VEHICLE_QUERY = "UPDATE vehicles SET vehicle_type = ?, make = ?, model = ? WHERE id = ?";
   private final String DELETE_VEHICLE_QUERY = "DELETE FROM vehicles WHERE id = ?";
   
   public VehiclesDao() {
     connection = DBConnection.getConnection();
   }

   public List<Vehicles> getVehicles() throws SQLException {
     ResultSet rs = connection.prepareStatement(GET_VEHICLES_QUERY).executeQuery();
         List<Vehicles> vehicles = new ArrayList<Vehicles>();

         while (rs.next()) {
             vehicles.add(generateVehiclesItem(rs));
         }

         return vehicles;
     }

     public Vehicles getVehiclesdById(int id) throws SQLException {
         PreparedStatement ps = connection.prepareStatement(GET_VEHICLE_BY_ID_QUERY);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
             return generateVehiclesItem(rs);
         }

         return new Vehicles(0, "", "", "");
     }

     public void createNewVehicles(String vehicletype, String make, String model) throws SQLException {
         PreparedStatement ps = connection.prepareStatement(CREATE_NEW_VEHICLE_QUERY);
         ps.setString(1, vehicletype);
         ps.setString(2, make);
         ps.setString(3, model);
         ps.executeUpdate();
     }

     public void updateVehicles (Vehicles vehicleItem) throws SQLException {
         PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLE_QUERY);

         ps.setString(1, vehicleItem.getVehicleType());
         ps.setString(2, vehicleItem.getMake());
         ps.setString(3, vehicleItem.getModel());
         ps.setInt(4, vehicleItem.getVehiclesId());

         ps.executeUpdate();
     }

     public void deleteVehicles(int id) throws SQLException {
         PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_QUERY);
         ps.setInt(1, id);

         ps.executeUpdate();
     }

     private Vehicles generateVehiclesItem(ResultSet rs) throws SQLException {

         return new Vehicles(
                 rs.getInt(1),
                 rs.getString(2),
                 rs.getString(3),
                 rs.getString(4)
         );
  
   }

    public void updateVehicles(int id) {

      
    }
}
