package oc.utils;

import java.util.Date;

/**
 * Entity class representing an RSS feed item
 * 
 * @author Stefan Oswald
 */
public class RSSItem {

    private String title = null;
    private String description = null;
    private Date date = null;

    public RSSItem() {

    }

    public RSSItem(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // remove images
        description = description.replaceAll("/<img.?/>/i", "");
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>");
        sb.append(getTitle());
        sb.append("</h2>");

        sb.append("<p>");
        sb.append(getDescription());
        sb.append("</p>");

        return sb.toString();
    }

}
