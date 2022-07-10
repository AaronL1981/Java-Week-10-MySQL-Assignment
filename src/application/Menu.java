package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.VehiclesDao;
import entity.Vehicles;

public class Menu {
  
  private VehiclesDao vehiclesDao = new VehiclesDao();
  private Scanner scanner = new Scanner(System.in);
  private List<String> options = Arrays.asList(
          "Display Vehicles",
          "Display a Vehicle",
          "Create a New Vehicle",
          "Update Vehicle Information",
          "Delete a Vehicle");
  
  public void start() {
    String selection = "";
    
    do {
          printMenu();
          selection = scanner.nextLine();
          
          try {
               if (selection.equals("1")) {
                   displayVehicles();
               }else if (selection.equals("2")) {
                   displayVehicle();
               }else if (selection.equals("3")) {
                   createVehicle();
               }else if (selection.equals("4")) {
                   updateVehicle();
               }else if (selection.equals("5")) {
                   deleteVehicle();
               }
          }catch (SQLException e) {
            e.printStackTrace();
          }
          
          System.out.println("Press enter to continue....");
          scanner.nextLine();
    } while(!selection.equals("-1"));
  }

  private void printMenu() {
    System.out.println("Select an Option:\n-------------------------");
    for(int i = 0; i < options.size(); i++) {
      System.out.println(i + 1 + ") " + options.get(i));
    }
  }
  private void displayVehicles() throws SQLException {
    List<Vehicles> vehicles = vehiclesDao.getVehicles();
    for (Vehicles vehicle : vehicles) {
      System.out.println(vehicle.getVehiclesId() + ": " + vehicle.getVehicleType() + "| "
                         + vehicle.getMake() + "| " + vehicle.getModel());
    }
  }
  private void displayVehicle() throws SQLException {
    System.out.println("Enter Vehicle ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    Vehicles vehicle = vehiclesDao.getVehiclesdById(id);
    System.out.println(vehicle.getVehiclesId() + ": " + vehicle.getVehicleType() + ", "
        + vehicle.getMake() + ", " + vehicle.getModel());  
  }
  private void createVehicle() throws SQLException {
    System.out.print("Enter new vehicle type:");
    String vehicleType = scanner.nextLine();
    System.out.print("Enter make of vehicle:");
    String make = scanner.nextLine();
    System.out.print("Enter model of vehicle:");
    String model = scanner.nextLine();
    vehiclesDao.createNewVehicles(vehicleType, make, model);
    
   }
  private void updateVehicle() throws SQLException {
    System.out.println("Enter vehicle ID:");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter vehicle type:");
    String vehicleType = scanner.nextLine();
    System.out.print("Enter make of vehicle:");
    String make = scanner.nextLine();
    System.out.print("Enter model of vehicle:");
    String model = scanner.nextLine();
    vehiclesDao.updateVehicles(id);
   }
  private void deleteVehicle() throws SQLException {
   System.out.print("Enter vehicle id to delete:");
   int id = Integer.parseInt(scanner.nextLine());
   vehiclesDao.deleteVehicles(id);
   
  }
}
