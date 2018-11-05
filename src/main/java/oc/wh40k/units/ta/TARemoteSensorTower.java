package oc.wh40k.units.ta;



import oc.Eintrag;



public class TARemoteSensorTower extends Eintrag {



    public TARemoteSensorTower() {



        name = "Remote Sensor Tower";



        grundkosten = getPts("Remote Sensor Tower") + getPts("High intensity markerlight");



        complete();



    }



    //@OVERRIDE

    public void refreshen() {

        power = 2;

    }

}