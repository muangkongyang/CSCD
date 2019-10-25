package cscd211Enums;

public enum VehicleManufacturers
{
   FORD,
   CHRYSLER,
   VOLKSWAGON,
   MERCEDES,
   TOYOTA,
   HONDA,
   NISSAN;
   
   @Override
   public String toString()
   {
      return name().substring(0,1) + name().substring(1).toLowerCase();
   }
}