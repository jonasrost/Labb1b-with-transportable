import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tester {
    @Test
    public void testGetNumberOfDoorsVolvoOK() {
        Volvo240 volvo = new Volvo240();

        int nrDoors = volvo.getNrDoors();

        assertTrue(nrDoors == 4);
    }

    @Test
    public void testGetNumberOfDoorsSaabOK() {
        Saab95 saab = new Saab95();

        int nrDoors = saab.getNrDoors();

        assertTrue(nrDoors == 2);
    }

    @Test
    public void testMoveOK() {
        Saab95 saab = new Saab95();
        double speedBefore = saab.getCurrentSpeed();
        saab.gas(0.7);
        double currSpeed = saab.getCurrentSpeed();

        saab.move();

        assertTrue(currSpeed >= speedBefore);
    }

    @Test
    public void testChangeSpeedWhileTruckBedLiftedNotOk() {
        Scania scania = new Scania();
        scania.increaseAngleOfTruckBedTo(50);
        scania.gas(0.5);
        assertTrue(scania.getCurrentSpeed() == 0);
    }

    @Test
    public void loadAndUnloadCarsFromLorryOk() {
        ArticulatedLorry testLorry = new ArticulatedLorry();
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo = new Volvo240();

        testLorry.setDownRamp();
        testLorry.loadCarOnLorry(saab);
        testLorry.loadCarOnLorry(saab2);
        testLorry.loadCarOnLorry(volvo);

        testLorry.unloadCarsFromLorry(2);
        assertTrue(testLorry.getCarsOnLorry().remove(0).equals(saab));
    }

    @Test
    public void loadAndUnloadCarsFromFerryOK() {
        CarFerry testFerry = new CarFerry();
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo = new Volvo240();

        testFerry.loadCarOnFerry(saab);
        testFerry.loadCarOnFerry(saab2);
        testFerry.loadCarOnFerry(volvo);

        testFerry.unloadCarsFromFerry(2);

        assertTrue(testFerry.getCarsOnFerry().remove(0).equals(volvo));

    }

    public void testWorkshopCanNotAddDuplicateOK() {
        Workshop<Car> carWorkshop = new Workshop<>();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        carWorkshop.putVehicleInWorkshop(saab);
        carWorkshop.putVehicleInWorkshop(volvo);
        carWorkshop.putVehicleInWorkshop(saab);




    }

}
