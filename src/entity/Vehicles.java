package entity;

public class Vehicles {
  
  private int vehiclesId;
  private String vehicleType;
  private String make;
  private String model;
  
  public Vehicles(int vehiclesId, String vehicleType, String make, String model) {
    this.setVehiclesId(vehiclesId);
    this.setVehicleType(vehicleType);
    this.setMake(make);
    this.setModel(model);
  }

  public int getVehiclesId() {
    return vehiclesId;
  }

  public void setVehiclesId(int vehiclesId) {
    this.vehiclesId = vehiclesId;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  } 
 }
   

