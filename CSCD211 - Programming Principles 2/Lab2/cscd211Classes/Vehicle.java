package cscd211Classes;

import java.util.*;
import java.io.*;
import cscd211Enums.*;
import cscd211Comparators.*;

public class Vehicle implements Comparable<Vehicle>
{
   private Integer cylinders;
   private double liters;
   private VehicleManufacturers manufacturer;
   private String model;
   
   public Vehicle(final VehicleManufacturers manufacturer, final String model, final double liters, final Integer cylinders)
   {
      // Preconditions
      if(model == null || model.isEmpty() || liters < 1 || cylinders == null || cylinders <= 0)
         throw new IllegalArgumentException("bad Vehicle parameters");
         
      this.manufacturer = manufacturer;
      this.model = model;
      this.liters = liters;
      this.cylinders = cylinders;
   }
   
   public Vehicle(final VehicleManufacturers manufacturer, final String model, final Integer cylinders, final double liters)
   {     
      this(manufacturer, model, liters, cylinders);
   }
   
   public int compareTo(final Vehicle anotherVehicle)
   {
      // Preconditions
      if(anotherVehicle == null)
         throw new IllegalArgumentException("bad Vehicle compareTo param");
         
      int res = this.manufacturer.compareTo(anotherVehicle.manufacturer);
      if(res != 0)
         return res;
         
      res = this.model.compareTo(anotherVehicle.model);
      if(res != 0)
         return res;
         
      res = this.cylinders.compareTo(anotherVehicle.cylinders);
      if(res != 0)
         return res;
         
      return Double.compare(this.liters, anotherVehicle.liters);
   }
   
   public VehicleManufacturers getManufacturer()
   {
      return this.manufacturer;
   }
   
   public String getModel()
   {
      return this.model;
   }
   
   @Override
   public String toString()
   {
      return "Your " + this.manufacturer + " " + this.model + " is a " + this.cylinders + " banger with a " + this.liters + " liter engine.";
   }
}