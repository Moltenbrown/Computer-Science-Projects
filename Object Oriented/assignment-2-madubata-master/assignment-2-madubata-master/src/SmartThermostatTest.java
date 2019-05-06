import static org.junit.Assert.*;

import org.junit.Assert;

public class SmartThermostatTest {
  private Bedroom bedroom;
  private Bathroom bathroom;
  private LivingRooms livingRooms;
  private SmartThermostat smartThermostat;
  private SmartThermostat lowSmartThermostat;
  private SmartThermostat highSmartThermostat;
  private SmartThermostat flipItThermostat;

  @org.junit.Before
  public void setUp() throws Exception {
    this.bedroom = new Bedroom(64, 60, 68);
    this.bathroom = new Bathroom(66,58, 70);
    this.livingRooms = new LivingRooms(64, 60,72);
    this.smartThermostat = new SmartThermostat(bedroom, bathroom, livingRooms,
        false, new Integer(64));
    this.lowSmartThermostat = this.smartThermostat.setHouseTemp(new Integer(60));
    this.highSmartThermostat = this.lowSmartThermostat.setHouseTemp(new Integer(75));
    this.flipItThermostat =
        this.smartThermostat.changeHouseSetting().setHouseTemp(new Integer(75));
  }

  @org.junit.Test
  public void getBedroomTemperature() {
    Assert.assertEquals(64, this.smartThermostat.getBedroomTemperature());
  }

  @org.junit.Test
  public void getBathroomTemperature() {
    Assert.assertEquals(66, this.smartThermostat.getBathroomTemperature());
  }

  @org.junit.Test
  public void getLivingRoomsTemperature() {
    Assert.assertEquals(64, this.smartThermostat.getLivingRoomsTemperature());
  }

  @org.junit.Test
  public void isSetting() {
    Assert.assertEquals(false, this.smartThermostat.isSetting());
  }

  @org.junit.Test
  public void getCurrentTemperatureSetting() {
    Assert.assertEquals(64, this.smartThermostat.getCurrentTemperatureSetting().intValue());
  }

  @org.junit.Test
  public void setHouseTemp() {
    Assert.assertEquals(60, this.lowSmartThermostat.getBedroomTemperature());
    Assert.assertEquals(60, this.lowSmartThermostat.getBathroomTemperature());
    Assert.assertEquals(60, this.lowSmartThermostat.getLivingRoomsTemperature());

    Assert.assertEquals(68, this.highSmartThermostat.getBedroomTemperature());
    Assert.assertEquals(70, this.highSmartThermostat.getBathroomTemperature());
    Assert.assertEquals(72, this.highSmartThermostat.getLivingRoomsTemperature());

    Assert.assertEquals(75, this.flipItThermostat.getBedroomTemperature());
    Assert.assertEquals(75, this.flipItThermostat.getBathroomTemperature());
    Assert.assertEquals(75, this.flipItThermostat.getLivingRoomsTemperature());
  }

  @org.junit.Test
  public void changeHouseSetting(){
    Assert.assertEquals(true, this.smartThermostat.changeHouseSetting().isSetting());
  }
}