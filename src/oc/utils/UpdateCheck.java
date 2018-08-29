package oc.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import oc.OnlineCodex;
import oc.Version;

/**
 * Check for program updates by evaluating the OnlineCodex forum news feed.
 * Show update info window if new version was found.
 *
 * @author Stefan Oswald
 */
public class UpdateCheck implements Runnable {

    private String game = "";

    public UpdateCheck(int game) {
        if(game == OnlineCodex.WH40K) this.game = "Wh40k";
        else if(game == OnlineCodex.WH40K_FANDEX) this.game = "FanDex40k";
        else if(game == OnlineCodex.WHFB) this.game = "WHFB";
        else if(game == OnlineCodex.NECROMUNDA) this.game = "Necro";
    }

    @Override
    public void run() {
		Calendar release = Calendar.getInstance();
		release.setTimeInMillis(0);
		release.set(Calendar.YEAR, Version.getInstance().getYear());
		release.set(Calendar.MONTH, Version.getInstance().getMonth() - 1);
		release.set(Calendar.DAY_OF_MONTH, Version.getInstance().getDay());
		release.set(Calendar.HOUR_OF_DAY, Version.getInstance().getHour());
		release.set(Calendar.MINUTE, Version.getInstance().getMinute());

        ArrayList<RSSItem> newsItems = RSSReader.getInstance().readFeed();

        // Check if any news item is more recent than the release timestamp.
        // If so, show the update info window. Otherwise, do nothing.
        for(int i=0; i<newsItems.size(); i++) {
            // Check if
            String title = newsItems.get(i).getTitle();
            if(!title.contains(this.game) || !title.startsWith("Update")) continue;

            Date newsDate = newsItems.get(i).getDate();
            if(newsDate.getTime() > release.getTimeInMillis()) {
                UpdateNotifier.getInstance();
            }
        }
    }

}
