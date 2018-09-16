/* Experimentelle Regeln zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/p/preatorapoc1.pdf
*/

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class APOPraetorSkyKillerAerialSuppressionForce extends Eintrag {

      RuestkammerStarter[] r = new RuestkammerStarter[5];

      public APOPraetorSkyKillerAerialSuppressionForce() {
           name = "Praetor 'Sky Killer' Aerial Suppression Force";
           grundkosten = 75;
           überschriftSetzen = true;

           add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));

           r[0] = new RuestkammerStarter(ID, randAbstand, cnt, "IGPraetorArmouredAssaultLauncherKammer", "Praetor Befehlsfahrzeug\n");
           r[0].initKammer();
           r[0].setButtonText("Praetor Befehlsfahrzeug");
           r[0].setUeberschriftTrotzNullKostenAusgeben(true);
           add(r[0]);

           
           for(int i=1;i<r.length;i++) {
               seperator();

               r[i] = new RuestkammerStarter(ID, randAbstand, cnt, "IGPraetorArmouredAssaultLauncherKammer", "Praetor\n");
               r[i].initKammer();
               r[i].setButtonText("Praetor");
               r[i].setUeberschriftTrotzNullKostenAusgeben(true);
               add(r[i]);
           }


           complete();

      }

      public void refreshen() {
          
          for(int i=0;i<2;i++) {
              r[i].setAbwaehlbar(false);
          }
          
          for(int i=2;i<r.length;i++) {
              r[i].setAktiv(r[i-1].isSelected());
          }
          
          for(int i=1;i<r.length;i++) {
              relocate(r[i], r[i-1], 10);
          }
      }
  
      private void relocate(RuestkammerStarter r1, RuestkammerStarter r2, int seperator) {
          r1.getPanel().setLocation(r1.getPanel().getX(), r2.getPanel().getY() + r2.getPanel().getHeight() + seperator);
      }
}
