import javax.swing.ListCellRenderer;

/**
 * Represents a Smart Thermostat with its details--the this.bedroom,
 * the this.bathroom, the living rooms, what the thermostat setting is,
 * where true means it's set to manual and false means it's set to automatic,
 * and what the current temperature setting of the house is.
 *
 * @author Goch
 */
public class SmartThermostat {
  private Bedroom bedroom;
  private Bathroom bathroom;
  private LivingRooms livingRooms;
  private boolean setting;
  private Integer currentTemperatureSetting;

  /**
   * Creates a new smart thermostat given a bedroom as a bedroom,
   * a bathroom as a bathroom, the living rooms as living rooms,
   * whether the thermostat is set to automatic or manual as a boolean,
   * and the current temperature setting as an integer.
   *
   * @param bedroom the bedroom's current temperature, low temperature limit,
   * and high temperature limit
   * @param bathroom the bathroom's current temperature, low temperature limit,
   * and high temperature limit
   * @param livingRooms the living rooms' current temperature, low temperature limit,
   * and high temperature limit
   * @param setting the smart thermostat's current setting, either manual or automatic
   * @param currentTemperatureSetting the smart thermostat's current temperature setting
   */
  public SmartThermostat(Bedroom bedroom, Bathroom bathroom,
      LivingRooms livingRooms, boolean setting, Integer
      currentTemperatureSetting){
    this.bedroom = bedroom;
    this.bathroom = bathroom;
    this.livingRooms = livingRooms;
    this.setting = setting;
    this.currentTemperatureSetting = currentTemperatureSetting;
  }


  /**
   * Returns the bedroom's current temperature
   * @return the bedroom's current temperature
   */
  public int getBedroomTemperature() {
    return this.bedroom.getCurrentTemp();
  }

  /**
   * Returns the bathroom's current temperature
   * @return the bathroom's current temperature
   */
  public int getBathroomTemperature() {
    return this.bathroom.getCurrentTemp();
  }

  /**
   * Returns the living rooms' current temperature
   * @return the living rooms' current temperature
   */
  public int getLivingRoomsTemperature() {
    return this.livingRooms.getCurrentTemp();
  }

  /**
   * Returns the thermostat setting
   * @return the thermostat setting
   */
  public boolean isSetting() {
    return setting;
  }

  /**
   * Returns the current house temperature setting
   * @return the current temperature setting
   */
  public Integer getCurrentTemperatureSetting() {
    return currentTemperatureSetting;
  }


  /**
   * Given a temperature as an Integer, if the smart thermostat setting is automatic
   * and the temperature is either above or below any of the ranges of any room,
   * those rooms will be set to either to their individual bottom or top limits based on the
   * temperature. Otherwise, the rooms will be set to the temperature. If the setting is manual,
   * then all the rooms, regardless of the limits, will be set to the temperature. A new Smart
   * Thermostat is generated using the new rooms, the current status of the thermostat and the
   * new temperature setting.
   * @param temperature
   * @return a new updated smart thermostat
   */

  Bedroom newBedroom = new Bedroom(0,0,0);
  Bathroom newBathroom = new Bathroom(0,0,0);
  LivingRooms newLivingRooms = new LivingRooms(0,0,0);

  public SmartThermostat setHouseTemp(Integer temperature){

    if(isSetting() == false){
      if(temperature.intValue() > this.bedroom.getHighTempLimit()
          || temperature.intValue() < this.bedroom.getLowTempLimit()){
        if(temperature.intValue() > this.bedroom.getHighTempLimit()){
          newBedroom = new Bedroom(this.bedroom.getHighTempLimit(),
              this.bedroom.getLowTempLimit(), this.bedroom.getHighTempLimit());
        }

        else {
          newBedroom = new Bedroom(this.bedroom.getLowTempLimit(),
              this.bedroom.getLowTempLimit(), this.bedroom.getHighTempLimit());
        }
      }

      if(temperature.intValue() > this.bathroom.getHighTempLimit()
          || temperature.intValue() < this.bathroom.getLowTempLimit()){
        if(temperature.intValue() > this.bathroom.getHighTempLimit()){
          newBathroom = new Bathroom(this.bathroom.getHighTempLimit(),
              this.bathroom.getLowTempLimit(), this.bathroom.getHighTempLimit());
        }

        else{
          newBathroom = new Bathroom(this.bathroom.getLowTempLimit(),
              this.bathroom.getLowTempLimit(), this.bathroom.getHighTempLimit());
        }
      }

      if(temperature.intValue() > this.livingRooms.getHighTempLimit()
          || temperature.intValue() < this.livingRooms.getLowTempLimit()){
        if(temperature.intValue() > this.livingRooms.getHighTempLimit()){
          newLivingRooms = new LivingRooms(this.livingRooms.getHighTempLimit(),
              this.livingRooms.getLowTempLimit(), this.livingRooms.getHighTempLimit());
        }

        else{
         newLivingRooms = new LivingRooms(this.livingRooms.getLowTempLimit(),
              this.livingRooms.getLowTempLimit(), this.livingRooms.getHighTempLimit());
        }
      }

      else{
        newBedroom = new Bedroom(temperature.intValue(), this.bedroom.getLowTempLimit(),
            this.bedroom.getHighTempLimit());
        newBathroom = new Bathroom(temperature.intValue(), this.bathroom.getLowTempLimit(),
            this.bathroom.getHighTempLimit());
        newLivingRooms = new LivingRooms(temperature.intValue(),
            this.livingRooms.getLowTempLimit(), this.livingRooms.getHighTempLimit());
      }

      return new SmartThermostat(newBedroom, newBathroom,
          newLivingRooms, setting, temperature);
    }

  else{
      newBedroom = new Bedroom(temperature.intValue(), this.bedroom.getLowTempLimit(),
          this.bedroom.getHighTempLimit());
      newBathroom = new Bathroom(temperature.intValue(), this.bathroom.getLowTempLimit(),
          this.bathroom.getHighTempLimit());
      newLivingRooms = new LivingRooms(temperature.intValue(),
          this.livingRooms.getLowTempLimit(), this.livingRooms.getHighTempLimit());

      return new SmartThermostat(newBedroom, newBathroom, newLivingRooms,
          this.setting, temperature);

    }
  }

  /**
   * Returns updated Smart Thermostat where the setting is switched true if it was originally
   * false and visa versa.
   * @return an updated smart thermostat
   */
  public SmartThermostat changeHouseSetting(){
    if(setting == false){
      return new SmartThermostat(this.bedroom, this.bathroom, this.livingRooms, true, currentTemperatureSetting);
    }

    else{
      return new SmartThermostat(this.bedroom, this.bathroom, this.livingRooms, false, currentTemperatureSetting);
    }
  }
}
